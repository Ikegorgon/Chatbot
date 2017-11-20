package chatbot.model;

import java.util.List;
import java.time.LocalTime;
import java.util.ArrayList;
import chatbot.model.Movie;

public class Chatbot
{
	//Chatbot Object
	private List<Movie> movieList;
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
		this.movieList = new ArrayList<Movie>();
		this.shoppingList = new ArrayList<String>();
		this.cuteAnimalMemes = new ArrayList<String>();
		this.currentTime = LocalTime.now();
		this.questions = new String[11];
		this.username = username;
		this.content = "Content";
		this.intro = "Intro";
		this.topics = new String[5];
		this.verbs = new String[5];
		this.followUps = new String[5];
		buildVerbs();
		buildTopic();
		buildFollowUps();
		buildMovieList();
		buildShoppingList();
		buildCuteAnimals();
		buildQuestions();
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
	private void buildFollowUps() {
		followUps[0] = "How about you?";
		followUps[1] = "What do you think?";
		followUps[2] = "What do you like?";
		followUps[3] = "How would that go?";
		followUps[4] = "Do you think the same?";
	}
	
	private void buildMovieList()
	{
		movieList.add(new Movie("Spiderman"));
		movieList.add(new Movie("Kingsman: Golden Circle"));
		movieList.add(new Movie("Baby Driver"));
		movieList.add(new Movie("Geostorm"));
		movieList.add(new Movie("The Forgiener"));
		movieList.add(new Movie("Hidden Figures"));
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
		shoppingList.add("eggs");
		shoppingList.add("protein");
		shoppingList.add("hot peppers");
		shoppingList.add("onions");
		shoppingList.add("snacks");
		shoppingList.add("bagel");
		shoppingList.add("crunchy peanut butter");
		shoppingList.add("hot sauce");
		shoppingList.add("juice");
	}
	
	private void buildCuteAnimals()
	{
		cuteAnimalMemes.add("Panda Bear");
		cuteAnimalMemes.add("Baby Panda Bear");
		cuteAnimalMemes.add("Huskey");
		cuteAnimalMemes.add("Elephant");
		cuteAnimalMemes.add("Chameleon");
		cuteAnimalMemes.add("Duckling");
		cuteAnimalMemes.add("Hedgehog");
		cuteAnimalMemes.add("Otter");
		cuteAnimalMemes.add("Floofer");
		cuteAnimalMemes.add("Kittie");
		cuteAnimalMemes.add("Pupper");
	}
	
	private void buildQuestions()
	{
		questions[0] = "What is your name?";
		questions[1] = "How is it going?";
		questions[2] = "What's up?";
		questions[3] = "Do you like chicken?";
		questions[4] = "Have you been to Hawaii?";
		questions[5] = "Do you know who?";
		questions[6] = "What's a fun game?";
		questions[7] = "Have you been on a roller coaster?";
		questions[8] = "Have you ever eaten alligator?";
		questions[9] = "What's up with your family?";
		questions[10] = "Do you think I am cool?";
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
		rand = (int) (Math.random() * 2);
		rand = (int) (Math.random() * questions.length);
		response += questions[rand] + "\n";
		if (rand % 2 == 0) {
			rand = (int) (Math.random() * movieList.size());
			response += movieList.get(rand).getTitle() + " is a good movie. \n";
		}
		return response;
	}
	
	public boolean lengthChecker(String input)
	{
		boolean validLength = false;
		if (input != null && input.length() > 0) {
			validLength = true;
		}
		return validLength;
	}
	
	public boolean htmlTagChecker(String input)
	{
		boolean valid = false;
		int len = input.length();
		int one = input.indexOf("<") + 1;
		int two = input.indexOf(">");
		int three = input.indexOf("<" + "/") + 2;
		String temp = input;
		temp = temp.replaceFirst(">", " ");
		int four = temp.indexOf(">");
		if (len > 3 && three > one && four > two && input.toLowerCase().substring(one, two)
				.contains(input.toLowerCase().substring(three, four))) {
			valid = true;
		}
		if (input.substring(one, two).equalsIgnoreCase("p") 
				|| input.substring(one, two).equalsIgnoreCase("br")) {
			valid = true;
		}
		String a = input.toLowerCase().substring(one, two);
		if (a.contains("a href")) {
			if (!a.contains("a href=") && !a.contains("a href =")) {
				valid = false;
			}
		}
		return valid;
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
		boolean valid = false;
		if (contentCheck.contains(content)) {
			valid = true;
		}
		return valid;
	}
	
	public String toString () {
		//??????????????????????
		String description = "";
		return description;
	}
	
	public boolean cuteAnimalMemeChecker(String input)
	{
		boolean valid = false;
		for (String meme : cuteAnimalMemes) {
			if (input.equalsIgnoreCase(meme)) {
				valid = true;
			}
		}
		return valid;
	}
	
	public boolean shoppingListChecker(String shoppingItem)
	{
		boolean valid = false;
//		boolean slugbait = false;
//		boolean protein = false;
//		boolean veggies = false;
//		boolean snacks = false;
////		for (int i = 0; i < shoppingList.size(); i += 1) {
//			if (shoppingList.contains("protein")) {
//				protein = true;
//			}
//			if (shoppingList.contains("veggies")) {
//				veggies = true;
//			}
//			if (shoppingList.contains("snacks")) {
//				snacks = true;
//			}
//			if (shoppingList.contains("slug bait")) {
//				slugbait = true;
//			}
//			if (protein && veggies && snacks && !slugbait) {
//				valid = true;
//			}
////			if(shoppingList.contains(shoppingItem)) {
////				valid = true;
////			}
////		}
		for (String item : shoppingList) {
			if (shoppingItem.contains(item)) {
				valid = true;
			}
		}
		return valid;
	}
	
	public boolean movieTitleChecker(String title)
	{
		boolean valid = false;
		for (Movie movie : movieList) {
			if (movie.getTitle().equals(title) && !movie.getGenre().equals("")) {
				valid = true;
			}
		}
		return valid;
	}
	
	public boolean movieGenreChecker(String genre)
	{
		boolean valid = false;
		if (!genre.equals("")) {
			valid = true;
		}
		return valid;
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
		boolean valid = false;
		String[] Mash = new String[] {"sdf", "dfg", "cvb", "kjh", ",./"};
		for (String mash : Mash) {
			if (mash.equalsIgnoreCase(sample)) {
				valid = true;
			}
		}
		return valid;
	}
	
	public List<Movie> getMovieList()
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
