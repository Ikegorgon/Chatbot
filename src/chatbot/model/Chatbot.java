package chatbot.model;

import java.util.List;
import java.time.LocalTime;
import java.util.ArrayList;

public class Chatbot
{
	private List<String> movieList;
	private List<String> shoppingList;
	private List<String> cuteAnimalMemes;
	private String [] verbs;
	private String [] topics;
	private String [] followUps;
	private String [] questions;
	private String username;
	private String content;
	private String intro;
	private LocalTime currentTime;
	
	public Chatbot(String username)
	{
		this.movieList = new ArrayList<String>();
		this.shoppingList = new ArrayList<String>();
		this.cuteAnimalMemes = new ArrayList<String>();
		this.currentTime = null;
		this.questions = new String[5];
		this.username = username;
		this.content = "";
		this.intro = "";
		this.topics = new String[5];
		this.verbs = new String[5];
		this.followUps = new String[5];
		
		buildVerbs();
		buildTopic();
		buildFollowUp();
		buildQuestions();
		buildMovieList();
		buildShoppingList();
	}
	
	private void buildVerbs() {
		verbs[0] = "like";
		verbs[1] = "dislike";
		verbs[2] = "am ambivalent about";
		verbs[3] = "am thinking about";
		verbs[4] = "am annoyed with";
	}
	private void buildTopic() {
		topics[0] = "Monkey";
		topics[1] = "Candy";
		topics[2] = "Pop Tarts";
		topics[3] = "Ducks";
		topics[4] = "Fried Chicken";
	}
	private void buildFollowUp() {
		followUps[0] = "How about you?";
		followUps[1] = "What do you think?";
		followUps[2] = "What do you like?";
		followUps[3] = "How would that go?";
		followUps[4] = "Do you think the same?";
	}
	
	private void buildMovieList()
	{
		movieList.add("Spiderman: Homecoming");
		movieList.add("Kingsman: Golden Circle");
		movieList.add("Baby Driver");
		movieList.add("Geostorm");
		movieList.add("The Forgiener");
	}
	
	private void buildShoppingList()
	{
		shoppingList.add("snacks");
		shoppingList.add("veggies");
		shoppingList.add("protein");
		shoppingList.add("gross things");
		shoppingList.add("Rubber Ducky");
		shoppingList.add("Pie");
		shoppingList.add("Apple Juice");
		shoppingList.add("Oreos");
		shoppingList.add("Poptarts");
		shoppingList.add("Goldfish");
		shoppingList.add("Chicken");
	}
	
	private void buildCuteAnimals()
	{
		
	}
	
	private void buildQuestions()
	{
		questions[0] = "What is your name?";
		questions[1] = "How is it going?";
		questions[2] = "What's up?";
		questions[3] = "Do you like chicken?";
		questions[4] = "Have you been to Hawaii?";
	}
	
	public String processConversation(String input)
	{
		String chatbotResponse = "";
		chatbotResponse += "You said: " + "\n" + input + "\n";
		chatbotResponse += buildChatbotResponse();
		return chatbotResponse;
	}
	
	private String buildChatbotResponse() {
		String response = "I ";
		int rand = (int) (Math.random() * verbs.length);
		response += verbs[rand];
		rand = (int) (Math.random() * topics.length);
		response += " " + topics[rand] + ".\n";
		rand = (int) (Math.random() * questions.length);
		response += questions[rand];
		return response;
	}
	
	public boolean lengthChecker(String input)
	{
		boolean validLength = false;
		if (input != null && input.length() > 2) {
			validLength = true;
		}
		return validLength;
	}
	
	public boolean htmlTagChecker(String input)
	{
		return false;
	}
	
	public boolean userNameChecker(String input)
	{
		boolean valid = false;
		if (input != null && input.startsWith("@") && !input.substring(1, input.length()-1).contains("@")) {
			valid = true;
		}
		return valid;
	}
	
	public boolean contentChecker(String contentCheck)
	{
		return false;
	}
	
	public boolean cuteAnimalMemeChecker(String input)
	{
		return false;
	}
	
	public boolean shoppingListChecker(String shoppingItem)
	{
		boolean valid = false;
		boolean slugbait = false;
		boolean protein = false;
		boolean veggies = false;
		boolean snacks = false;
		for (int i = 0; i < shoppingList.size(); i += 1) {
			if (shoppingItem.equalsIgnoreCase("protein")) {
				protein = true;
			}
			if (shoppingItem.equalsIgnoreCase("veggies")) {
				veggies = true;
			}
			if (shoppingItem.equalsIgnoreCase("snacks")) {
				snacks = true;
			}
			if (shoppingItem.equalsIgnoreCase("slug bait")) {
				slugbait = true;
			}
			if (protein && veggies && snacks && !slugbait) {
				valid = true;
			}
		}
		return valid;
	}
	
	public boolean movieTitleChecker(String title)
	{
		return false;
	}
	
	public boolean movieGenreChecker(String genre)
	{
		return false;
	}

	public boolean quitChecker(String exitString)
	{
		boolean valid = false;
		if (exitString != null && exitString.equalsIgnoreCase("Quit")) {
			valid = true;
		}
		return valid;
	}

	public boolean keyboardMashChecker(String sample)
	{
		return false;
	}
	
	public List<String> getMovieList()
	{
		return movieList;
	}
	
	public List<String> getShoppingList()
	{
		return shoppingList;
	}
	
	public List<String> getCuteAnimalMemes()
	{
		return cuteAnimalMemes;
	}

	public String [] getQuestions()
	{
		return questions;
	}
	
	public String[] getVerbs()
	{
		return verbs;
	}

	public String[] getTopics()
	{
		return topics;
	}

	public String[] getFollowUps()
	{
		return followUps;
	}

	public String getUsername()
	{
		return username;
	}
	
	public String getContent()
	{
		return content;
	}

	public String getIntro()
	{
		return intro;
	}
	
	public LocalTime getCurrentTime()
	{
		return currentTime;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setContent(String content)
	{
		this.content = content;
	}
}
