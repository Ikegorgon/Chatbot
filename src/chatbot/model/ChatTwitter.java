package chatbot.model;

import chatbot.controller.*;
import twitter4j.*;
import java.util.*;
import java.text.*;

public class ChatTwitter {
	private ChatbotController appController;
	private Twitter chatbotTwitter;
	private List<Status> searchedTweets;
	private List<String> tweetedWords;
	private long totalWordCount;
	private HashMap<String, Integer> wordsAndCount;
	
	public ChatTwitter(ChatbotController appController) {
		this.appController = appController;
		this.chatbotTwitter = TwitterFactory.getSingleton();
		this.searchedTweets = new ArrayList<Status>();
		this.tweetedWords = new ArrayList<String>();
		this.totalWordCount = 0;
		this.wordsAndCount = new HashMap<String, Integer>();
	}
	public void sendTweet(String textToTweet) {
		try {
			chatbotTwitter.updateStatus(textToTweet + " @ChatbotCTEC");
		} catch(TwitterException tweetError) {
			appController.handleError(tweetError);
		} catch(Exception otherError) {
			appController.handleError(otherError);
		}
	}
	public String getMostCommonWord(String username) {
		String mostCommon = "";
		collectTweets(username);
		turnStatusesToWords();
		totalWordCount = tweetedWords.size();
		String [] boring = createIgnoredWordArray();
		trimTheBoringWords(boring);
		removeBlanks();
		generateWordCount();
		ArrayList<Map.Entry<String, Integer>> sorted = sortHashMap();
		String mostCommonWord = sorted.get(0).getKey();
		int maxWord = 0;
		int maxword = sorted.get(0).getValue();
		mostCommon = "The most ommon word in " + username + "'s " + searchedTweets.size()
		+ " tweets is " + mostCommonWord + ", and it was used " + maxWord + " times.\nThis is "
		+ (DecimalFormat.getPercentInstance().format(((double) maxword)/totalWordCount)) + 
		" of total words:  " + totalWordCount + " and is " + 
		(DecimalFormat.getPercentInstance().format(((double) maxWord)/wordsAndCount.size())) +
		" of the unique words: " + wordsAndCount.size();
		return mostCommon;
	}
	private void collectTweets(String username) {
		searchedTweets.clear();
		tweetedWords.clear();
		Paging statusPage = new Paging(1,100);
		int page = 1;
		long lastID = Long.MAX_VALUE;
		while (page <= 10) {
			statusPage.setPage(page);
			try {
				ResponseList<Status> listedTweets = 
						chatbotTwitter.getUserTimeline(username, statusPage);
				for(Status current : listedTweets) {
					if(current.getId() < lastID) {
						searchedTweets.add(current);
						lastID = current.getId();
					}
				}
			} catch (TwitterException searchTweetError) {
				appController.handleError(searchTweetError);
			}
			page++;
		}
	}
	private void turnStatusesToWords() {
		for (Status currentStatus : searchedTweets) {
			String tweetText = currentStatus.getText().toLowerCase();
			tweetText = tweetText.replace("\n", " ");
			String [] tweetWords = tweetText.split(" ");
			for (int index = 0; index < tweetWords.length; index++) {
				tweetedWords.add(removePunctuation(tweetWords[index]).trim());
			}
		}
			
	}
	private String removePunctuation(String currentString) {
		String punctuation = ".,'?!:;\"() {}[]^<>-";
		String scrubbedString = "";
		for (int i = 0; i < currentString.length(); i++) {
			if (punctuation.indexOf(currentString.charAt(i)) == -1) {
				scrubbedString += currentString.charAt(i);
			}
		}
		return scrubbedString;
	}
	private void removeBlanks() {
		for (int i = tweetedWords.size() - 1; i >= 0; i--) {
			if (tweetedWords.get(i).trim().length() == 0) {
				tweetedWords.remove(this);
			}
		}
	}
	private void generateWordCount() {
		for (String word : tweetedWords) {
			if (!wordsAndCount.containsKey(word.toLowerCase())) {
				wordsAndCount.put(word.toLowerCase(), 1);
			} else {
				wordsAndCount.replace(word.toLowerCase(), wordsAndCount.get(word.toLowerCase() + 1));
			}
		}
	}
	private ArrayList<Map.Entry<String, Integer>> sortHashMap() {
		ArrayList<Map.Entry<String, Integer>> entries = new ArrayList<Map.Entry<String, Integer>>(wordsAndCount.entrySet());
		entries.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
		return entries;
	}
	private String [] createIgnoredWordArray() {
		String results = "";
		String [] boringWords;
		String fileText = IOController.loadFromFile(appController, "commonWords.txt");
		int wordCount = 0;
		Scanner wordScanner = new Scanner(fileText);
		while (wordScanner.hasNextLine()) {
			wordScanner.nextLine();
			wordCount++;
		}
		boringWords = new String [wordCount];
		wordScanner.close();
		wordScanner = new Scanner(this.getClass().getResourceAsStream("data/commonWords.txt"));
		for (int i = 0; i < boringWords.length; i++) {
			boringWords[i] = wordScanner.nextLine();
		}
		wordScanner.close();
		return boringWords;
	}
	private void trimTheBoringWords(String [] boringWords) {
		for (int i = tweetedWords.size()-1; i >= 0; i--) {
				for (int removeIndex = 0; removeIndex < boringWords.length; removeIndex++) {
					if (tweetedWords.get(i).equalsIgnoreCase(boringWords[removeIndex])) {
						tweetedWords.remove(i);
						removeIndex = boringWords.length;
					}
				}
		}
	}
}
