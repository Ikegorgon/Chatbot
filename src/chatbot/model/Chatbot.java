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
	private List<String> jokes;
	private List<String> riddles;
	private List<String> answers;
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
		this.jokes = new ArrayList<String>();
		this.riddles = new ArrayList<String>();
		this.answers = new ArrayList<String>();
		this.currentTime = LocalTime.now();
		this.questions = new String[11];
		this.username = username;
		this.content = "Content";
		this.intro = "Intro";
		this.topics = new String[5];
		this.verbs = new String[5];
		this.followUps = new String[5];
		buildBuilds();
	}
	
	private void buildBuilds() {
		buildVerbs();
		buildTopic();
		buildFollowUps();
		buildMovieList();
		buildShoppingList();
		buildCuteAnimals();
		buildQuestions();
		buildJokes();
		buildRiddles();
		buildAnswers();
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
	private void buildJokes() {
		jokes.add("How do you make a tissue dance? You put a little boogie in it.");
		jokes.add("Why did the policeman smell bad? He was on duty");
		jokes.add("Why can’t you hear a pterodactyl in the bathroom? Because it has a silent pee.");
		jokes.add("A mushroom walks into a bar. The bartender says, “Hey, get out of here!"
				+ " We don’t serve mushrooms here”. Mushroom says, “why not? I’m a fungai!”");
		jokes.add("I never make mistakes…I thought I did once; but I was wrong.");
		jokes.add("What’s Beethoven’s favorite fruit?…Ba-na-na-naaa!");
		jokes.add("Where does a sheep go for a haircut? To the baaaaa baaaaa shop!");
		jokes.add("What does a nosey pepper do? Gets jalapeno business!");
		jokes.add("What do you call a deer with no eyes? No eye deer.");
		jokes.add("Knock knock- who’s there? Dwayne. Dwayne who? Dwayne the tub I’m dwounding!");
		jokes.add("The past, present and future walk into a bar. It was tense.");
		jokes.add("What goes “ha ha thump”? A man laughing his head off.");
		jokes.add("What did the grape say when he was pinched? Nothing, he gave a little wine.");
		jokes.add("What’s brown and sticky? A stick!");
		jokes.add("Why are pirates so mean? I don’t know, they just arrrrrrrrr!");
		jokes.add("Why was Tigger looking in the toilet? He was looking for Pooh!");
		jokes.add("What do you get when you throw a piano down a mine shaft? A flat miner.");
		jokes.add("What do you call cheese that’s not yours? It’s nacho cheese.");
		jokes.add("What do you get when you put a candle in a suit of armor? A knight light.");
		jokes.add("Two drums and a cymbal fall off a cliff. Ba-dum Tish!");
		jokes.add("What do you call a sleepwalking nun… A roamin’ Catholic.");
		jokes.add("How do you make holy water? You boil the hell out of it.");
		jokes.add("What did the 0 say to the 8? Nice belt!");
		jokes.add("Why did the orange stop? Because, it ran outta juice.");
		jokes.add("Knock knock. Who’s there? Interrupting Cow. Interrupting Cow wh- MOOOOOOO!");
		jokes.add("Why did the storm trooper buy an iphone? He couldn’t find the Droid he was looking for.");
		jokes.add("Knock knock…who’s there? I eat mop. I eat mop who? Ooooo gross!");
		jokes.add("Why did the stop light turn red??? You would too if you had to change in the middle if the street!");
		jokes.add("Bacon and eggs walk into a bar and order a beer, the bartender says sorry, we don’t serve breakfast.");
		jokes.add("What do you do with a dead chemist …. You Barium.");
		jokes.add("Two cows are sitting in a field, and one says to the other, “so, how about that mad cow disease?"
				+ " Scary stuff, right?” To which to other replies, “terrifying. But what do I care? I’m a helicopter.”");
		jokes.add("What do you get when you cross an elephant and a rhino? Elephino!");
		jokes.add("Have you heard about the duck that was arrested for dealing? He was selling “quack”.");
		jokes.add("What do you call a cow with two legs? Lean beef.");
		jokes.add("What do you call a cow with no legs? Ground Beef.");
		jokes.add("What did the green grape say to the purple grape? BREATHE!");
		jokes.add("Two muffins are in an oven. One muffin says “gosh, it’s hot in here”. The other muffin"
				+ " screams “AAAH!! A talking muffin!”");
		jokes.add("What does the man in the moon do when his hair gets too long? Eclipse it!");
		jokes.add("Why did the blonde get fired from the M&M factory? Because she threw away all the ‘w’s!");
		jokes.add("And the Lord said unto John, 'Come forth and you will receive eternal life.' But John"
				+ " came fifth, and won a toaster.");
		jokes.add("I threw a boomerang a few years ago. I now live in constant fear.");
		jokes.add("My wife accused me of being immature. I told her to get out of my fort.");
		jokes.add("You don't need a parachute to go skydiving. You need a parachute to go"
				+ " skydiving twice.");
		jokes.add("Parallel lines have so mush in common. It's a shame they'll never meet.");
		jokes.add("Someone stole my mood ring, I don't know how I feel about that.");
		jokes.add("My grandfather has the heart of a lion, and a lifetime ban at the zoo.");
		jokes.add("I broke my finger last week. On the other hand, I'm okay.");
		jokes.add("Someone stole my Mircosoft Office and they're gonna pay! You have my Word!");
		jokes.add("Working in a mirror factory is something I can totally see myself doing.");
		jokes.add("Why do cows wear bells? Because their horns don't work.");
	}
	private void buildRiddles() {
		riddles.add("What 8 letter word can have a letter taken away and it still makes a word."
				+ "  Take another letter away and it still makes a word. Keep on doing that"
				+ " until you have one letter left. What is the word?");
		riddles.add("The more you take, the more you leave behind. What am I?");
		riddles.add("What has a head, a tail, is brown, and has no legs?");
		riddles.add("Can you name three consecutive days without using the words"
				+ " Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, or Sunday?");
		riddles.add("What comes once in a minute, twice in a moment, but never in a thousand years?");
		riddles.add("David's father has three sons : Snap, Crackle and _____ ?");
		riddles.add("A doctor and a bus driver are both in love with the same woman, an attractive"
				+ " girl named Sarah. The bus driver had to go on a long bustrip that would"
				+ " last a week. Before he left, he gave Sarah seven apples. Why?");
		riddles.add("What room do ghosts avoid?");
		riddles.add("A boy was at a carnival and went to a booth where a man said to the boy,"
				+ " If I write your exact weight on this piece of paper then you have to give me"
				+ " $50, but if I cannot, I will pay you $50. The boy looked around and saw no"
				+ " scale so he agrees, thinking no matter what the carny writes he'll just"
				+ " say he weighs more or less. In the end the boy ended up paying the man $50."
				+ " How did the man win the bet?");
		riddles.add("When does Christmas come before Thanksgiving?");
		riddles.add("What has many keys, but can't even open a single door?");
		riddles.add("You live in a one story house made \"entirely of redwood\". What"
				+ " color would the stairs be?");
		riddles.add("A man rode out of town on Sunday, he stayed a whole night at a"
				+ " hotel and rode back to town the next day on Sunday. How is this possible?");
		riddles.add("What is black when you buy it, red when you use it, and gray when you throw it away?");
		riddles.add("I am taken from a mine, and shut up in a wooden case, from which I am never released,"
				+ " and yet I am used by almost everybody");
		riddles.add("Tall I am young, Short I am old, While with life I glow, Wind is my foe. What am I?");
		riddles.add("What belongs to you, but other people use it more than you?");
		riddles.add("Re-arrange the letters,\n" + 
				"O O U S W T D N E J R\n" + 
				"to spell just one word.");
		riddles.add("I am not alive, but I grow; I don't have lungs, but I need air; I don't have a mouth,"
				+ " but water kills me. What am I?");
		riddles.add("There was a green house. Inside the green house there was a white house Inside the"
				+ " white house there was a red house. Inside the red house there were lots of babies."
				+ " What am I?");
		riddles.add("There are 20 people in an empty, square room. Each person has full sight of the "
				+ "entire room and everyone in it without turning his head or body, or moving in any way"
				+ " (other than the eyes). Where can you place an apple so that all but one person can see it?");
		riddles.add("What is more useful when it is broken?");
		riddles.add("Samuel was out for a walk when it started to rain. He did not have an umbrella and he wasn't"
				+ " wearing a hat. His clothes were soaked, yet not a single hair on his head got wet. How"
				+ " could this happen?");
		riddles.add("This thing all things devours: birds, beasts, trees, flowers;"
				+ " gnaws iron, bites steel; grinds hard stones to meal;"
				+ " slays king, ruins town, and beats high mountain down.");
		riddles.add("Alive without breath, as cold as death; never thirsty, ever drinking,"
				+ " all in mail never clinking.");
		riddles.add("A box without hinges, key, or lid, yet golden treasure inside is hid.");
		riddles.add("It cannot be seen, cannot be felt, cannot be heard, cannot be smelt."
				+ " It lies behind stars and under hills, and empty holes it fills."
				+ " It comes first and follows after, ends life, kills laughter.");
		riddles.add("Voiceless it cries, wingless flutters, toothless bites, mouthless mutters.");
		riddles.add("Thirty white horses on a red hill, first they champ,"
				+ " then they stamp, then they stand still.");
		riddles.add("What has roots as nobody sees, is taller than trees, up, up it goes,"
				+ " and yet never grows?");
	}
	public void buildAnswers() {
		answers.add("\n     Answer: The word is starting! starting, staring, string,"
				+ " sting, sing, sin, in, I.  Cool,huh?");
		answers.add("\n     Answer: Footsteps");
		answers.add("\n     Answer: A Penney");
		answers.add("\n     Answer: Yesterday, Today, and Tomorrow");
		answers.add("\n     Answer: The letter 'M'");
		answers.add("\n     Answer: David");
		answers.add("\n     Answer: An apple a day keeps the doctor away!");
		answers.add("\n     Answer: The Living Room");
		answers.add("\n     Answer: The man did exactly as he said he would and wrote"
				+ " \"your exact weight\" on the paper.");
		answers.add("\n     Answer: In the Dictionary");
		answers.add("\n     Answer: A piano");
		answers.add("\n     Answer: What stairs? You live in a one story house.");
		answers.add("\n     Answer: His Horse was called Sunday!");
		answers.add("\n     Answer: Charcoal");
		answers.add("\n     Answer: Pencil Lead");
		answers.add("\n     Answer: A candle.");
		answers.add("\n     Answer: Your Name");
		answers.add("\n     Answer: 'Just one word'");
		answers.add("\n     Answer: Fire");
		answers.add("\n     Answer: A Watermelon");
		answers.add("\n     Answer: Place it on a persons head");
		answers.add("\n     Answer: An Egg");
		answers.add("\n     Answer: The man was bald");
		answers.add("\n     Answer: Time");
		answers.add("\n     Answer: Fish");
		answers.add("\n     Answer: An Egg");
		answers.add("\n     Answer: Dark");
		answers.add("\n     Answer: Wind");
		answers.add("\n     Answer: Teeth");
		answers.add("\n     Answer: A Mountain");
	}
	
	public String processConversation(String input)
	{
		String chatbotResponse = "";
		String time;
		currentTime = LocalTime.now();
		if (currentTime.getMinute() < 10) {
			time = currentTime.getHour() + ":0" + currentTime.getMinute() + " ";
		} else {
			time = currentTime.getHour() + ":" + currentTime.getMinute() + " ";
		}
		chatbotResponse += time;
		chatbotResponse += "You said: " + input + "\n";
		chatbotResponse += buildChatbotResponse(input) + "\n";
		return chatbotResponse;
	}
	
	private String buildChatbotResponse(String input) {
		String response = "";
		
		if (input == null) {
			response += "Null is bad! >:0";
		} else if (input.equalsIgnoreCase("")) {
			response += "You didn't say anything, is your head alright?";
		} else if (input.equalsIgnoreCase("What's up?") || input.equalsIgnoreCase("What's up") 
				|| input.equalsIgnoreCase("Whats up?") || input.equalsIgnoreCase("Whats up")
				|| input.equalsIgnoreCase("What up?") || input.equalsIgnoreCase("What up")) {
			response += "The Sky is up.";
		} else if (input.equalsIgnoreCase("What's down?") || input.equalsIgnoreCase("What's down") 
				|| input.equalsIgnoreCase("Whats down?") || input.equalsIgnoreCase("Whats down")
				|| input.equalsIgnoreCase("What down?") || input.equalsIgnoreCase("What down")) {
			response += "Well, sense the earth is round, if you go down far enough then it will"
					+ " go through the earth and reach the sky, so... The Sky is down. :)";
		} else if (input.equalsIgnoreCase("Will you be my girlfriend?") || 
				input.equalsIgnoreCase("Will you be my girlfriend") || 
				input.equalsIgnoreCase("Will you be my Gf?") ||
				input.equalsIgnoreCase("Will you be my Gf")) {
			response += "No, I'm a Guy";
		} else if (input.equalsIgnoreCase("Will you be my boyfriend?") ||
				input.equalsIgnoreCase("Will you be my boyfriend") ||
				input.equalsIgnoreCase("Will you be my Bf?") ||
				input.equalsIgnoreCase("Will you be my Bf")) {
			response += "No, I'm a Girl.";
		} else if (input.equalsIgnoreCase("How are you a guy and a girl?") ||
				input.equalsIgnoreCase("How are you a guy and a girl") || 
				input.equalsIgnoreCase("How are you both a guy and a girl?") || 
				input.equalsIgnoreCase("How are you both a guy and a girl") ||
				input.equalsIgnoreCase("How are you a girl and a guy?") ||
				input.equalsIgnoreCase("How are you a girl and a guy") || 
				input.equalsIgnoreCase("How are you both a girl and a guy?") || 
				input.equalsIgnoreCase("How are you both a girl and a guy")) {
			response += "Because it's the twenty first century and I can be whatever I want!";
		} else if (input.equalsIgnoreCase("")) {
			response += "";
		} else if (input.equalsIgnoreCase("")) {
			response += "";
		} else if (input.equalsIgnoreCase("")) {
			response += "";
		} else if (input.equalsIgnoreCase("")) {
			response += "";
		} else if (input.equalsIgnoreCase("")) {
			response += "";
		} else if (input.equalsIgnoreCase("")) {
			response += "";
		} else if (input.equalsIgnoreCase("")) {
			response += "";
		} else if (input.equalsIgnoreCase("Tell me a joke.") || 
				input.equalsIgnoreCase("Tell me a joke") ||
				input.equalsIgnoreCase("Tell me another joke.") ||
				input.equalsIgnoreCase("Tell me another joke")) {
			int rand = (int) (Math.random() * jokes.size());
			response += jokes.get(rand) + "\n";
		} else if (input.equalsIgnoreCase("Tell me a riddle.") || 
				input.equalsIgnoreCase("Tell me a riddle") ||
				input.equalsIgnoreCase("Tell me another riddle.") ||
				input.equalsIgnoreCase("Tell me another riddle")) {
			int rand = (int) (Math.random() * riddles.size());
			response += riddles.get(rand);
			response += answers.get(rand) + "\n";
		} else {
			response += "I ";
			int rand = (int) (Math.random() * verbs.length);
			response += verbs[rand];
			rand = (int) (Math.random() * topics.length);
			response += " " + topics[rand] + ".\n";
			if (rand % 2 == 0) {
				rand = (int) (Math.random() * movieList.size());
				response += movieList.get(rand).getTitle() + " is a good movie. \n";
			}
			rand = (int) (Math.random() * 2);
			rand = (int) (Math.random() * questions.length);
			response += questions[rand] + "\n";
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
		boolean length = true;
		int len = input.length();
		int one = input.indexOf("<") + 1;
		int two = input.indexOf(">");
		int three = input.indexOf("<" + "/") + 2;
		String temp = input;
		temp = temp.replaceFirst(">", " ");
		int four = temp.indexOf(">");
		if (len < 3) {
			length = false;
		}
		if (length && three > one && four > two && input.toLowerCase().substring(one, two)
				.contains(input.toLowerCase().substring(three, four))) {
			valid = true;
		}
		if (length && input.substring(one, two).equalsIgnoreCase("p") 
				|| length && input.substring(one, two).equalsIgnoreCase("br")) {
			valid = true;
		}
		
		String a = "";
		if (length) {
			a = input.toLowerCase().substring(one, two);
		}
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
