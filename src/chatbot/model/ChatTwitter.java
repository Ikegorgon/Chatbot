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
		
		mostCommon += "\n\n" + sortedWords();
		
		return mostCommon;
	}
	private String sortedWords() {
		String allWords = "";
		String [] words = new String [wordsAndCount.size()];
				ArrayList<String> wordList = new ArrayList<String>(wordsAndCount.keySet());
		for (int i = 0; i < wordsAndCount.size(); i++) {
			words[i] = wordList.get(i);
		}
		for (int i = 0; i < words.length - 1; i++) {
			int maxIndex = i;
			for (int inner = i + 1; inner < words.length; inner++) {
				if (words[inner].compareTo(words[maxIndex]) > 0) {
					maxIndex = inner;
				}
			}
			String tempMax = words[maxIndex];
			words[maxIndex] = words[i]; 
			words[i] = tempMax;
		}
		for (String word : words) {
			allWords += word + ", ";
		}
		return allWords;
	}
	private void collectTweets(String username) {
		searchedTweets.clear();
		tweetedWords.clear();
		Paging statusPage = new Paging(1,100);
		int page = 1;
		long lastID = Long.MAX_VALUE;
		while (page <= 100) {
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
		String punctuation = ".,'‘?!:;\"“() {}[]^<>-";
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
	public String analyzeTwitterForTopic(String topic) {
		String results = "";
		searchedTweets.clear();
		Query twitterQuery = new Query(topic);
		int resultMax = 750;
		long lastId = Long.MAX_VALUE;
		double radius = 30.5;
		twitterQuery.setGeoCode( new GeoLocation(latitude, longitude), radius, Query.KILOMETERS);
		ArrayList<Status> matchingTweets = new ArrayList<Status>();
		while (searchedTweets.size() < resultMax) {
			try {
				QueryResult resultingTweets = chatbotTwitter.search(twitterQuery);
				for(Status currentTweet : resultingTweets.getTweets()) {
					if (currentTweet.getId() < lastId) {
						matchingTweets.add(currentTweet);
						lastId = currentTweet.getId();
					}
				}
			} catch (TwitterException error) {
				appController.handleError(error);
			}
			twitterQuery.setMaxId(lastId - 1);
		}
		results += "Talk about the search results ";
		results += "Find a tweet that will pass one of the checkers in chatbot ";
		int randomTweet = (int) (Math.random() * matchingTweets.size());
		results += matchingTweets.get(randomTweet);
		return results;
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
