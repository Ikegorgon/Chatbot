package chatbot.test;

import static org.junit.Assert.*;

import java.time.LocalTime;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import chatbot.model.Chatbot;

public class ChatbotTest
{
	private Chatbot testedChatbot;
	
	@Before
	public void setUp() throws Exception
	{
		testedChatbot = new Chatbot("Sample");
	}

	@After
	public void tearDown() throws Exception
	{
		testedChatbot = null;
	}

	@Test
	public void testChatbot()
	{
		assertNotNull("Special content must be initialized in constructor", testedChatbot.getContent());
		
	}
	
	@Test
	public void testBuildListsAndArray()
	{
		assertNotNull("MovieList must be created", testedChatbot.getMovieList());
		assertFalse("MovieList is too small", testedChatbot.getMovieList().size() < 6);
		assertNotNull("ShoppingList must be created", testedChatbot.getShoppingList());
		assertTrue("ShoppingList is too small", testedChatbot.getShoppingList().size() > 10);
		assertNotNull("Questions must be created", testedChatbot.getQuestions());
		assertFalse("Questions array is too small", testedChatbot.getQuestions().length < 6);
		
		
	}

	@Test
	public void testProcessConversation()
	{
		assertNotNull("Method should never return null", testedChatbot.processConversation(""));
		assertNotNull("Method should never return null", testedChatbot.processConversation(null));
		assertTrue("Method must provide a decent sized response", testedChatbot.processConversation("").length() > 5);
	}

	@Test
	public void testLengthChecker()
	{
		assertTrue("Supplying null should not break the application or return true", !testedChatbot.lengthChecker(null));
		assertFalse("A blank string should not return true", testedChatbot.lengthChecker(""));
		assertTrue("Text greater than 2 characters should return true", testedChatbot.lengthChecker("jdsfhjka hjkfdfl jsdhfjk ahk sj"));
	}

	@Test
	public void testHtmlTagChecker()
	{
		assertFalse("Invalid tag fail", testedChatbot.htmlTagChecker("<>"));
		assertFalse("Invalid tag fail", testedChatbot.htmlTagChecker("< >"));
		assertTrue("Valid tag fail", testedChatbot.htmlTagChecker("<B>  </B>"));
		assertFalse("Incomplete tag fail - closing tag not found", testedChatbot.htmlTagChecker("<B>  "));
		assertTrue("Valid tag fail", testedChatbot.htmlTagChecker("<I> sdadas </i>"));
		assertTrue("Valid tag fail - no closing P needed", testedChatbot.htmlTagChecker("<P>"));
		assertTrue("Valid tag fail", testedChatbot.htmlTagChecker("<A HREF=\"sdfs.html\"> </a>"));
		assertFalse("Incomplete tag fail - no = for the linked file", testedChatbot.htmlTagChecker("<A HREF> </a>"));
	}

	@Test
	public void testUserNameChecker()
	{
		assertTrue("Valid user name should pass", testedChatbot.userNameChecker("@codyhenrichse"));
		assertFalse("User names will start with an @ symbol", testedChatbot.userNameChecker("codyhenrichsen"));
		assertFalse("Blank submissions do not return true", testedChatbot.userNameChecker(""));
		assertFalse("Null submissions do not return true", testedChatbot.userNameChecker(null));
		assertFalse("Only one @ sign in a username", testedChatbot.userNameChecker("@@codyhenrichsen"));
		assertFalse("Email addresses are not user names", testedChatbot.userNameChecker("cody.henrichsen@gmail.com"));
	}

	@Test
	public void testContentChecker()
	{
		assertTrue("Default content should be acceptable", testedChatbot.contentChecker(testedChatbot.getContent()));
		String newContent = "adasffadga";
		testedChatbot.setContent(newContent);
		assertTrue("Changed content should also work", testedChatbot.contentChecker("adasffadga sfd sdf sdsdf "));
		
	}

	@Test
	public void testCuteAnimalMemeChecker()
	{
		assertFalse("Racist memes aren't cute", testedChatbot.cuteAnimalMemeChecker("pepe"));
		assertTrue("Required cuteness missing - pupper", testedChatbot.cuteAnimalMemeChecker("pupper"));
		assertTrue("Required cuteness missing - otter", testedChatbot.cuteAnimalMemeChecker("otter"));
		assertTrue("Required cuteness missing - kittie", testedChatbot.cuteAnimalMemeChecker("kittie"));
	}

	@Test
	public void testShoppingListChecker()
	{
		assertTrue("Required to eat occaisonally", testedChatbot.shoppingListChecker("protein"));
		assertFalse("Gross, I don't shop for that", testedChatbot.shoppingListChecker("slug bait"));
		assertTrue("Veggies are yummy", testedChatbot.shoppingListChecker("veggies"));
		assertTrue("I like to eat snacks", testedChatbot.shoppingListChecker("snacks"));
	}

	@Test
	public void testMovieTitleChecker()
	{
		assertFalse("Movie titles are not blank", testedChatbot.movieTitleChecker(""));
		assertTrue("Spiderman came out this year", testedChatbot.movieTitleChecker("Spiderman"));
		assertTrue("Hidden Figures is a class movie", testedChatbot.movieTitleChecker("Hidden Figures"));
	}

	@Test
	public void testMovieGenreChecker()
	{
		assertFalse("No blanks in genre", testedChatbot.movieGenreChecker(""));
		assertTrue("Documentaries are fun", testedChatbot.movieGenreChecker("Documentary"));
		assertTrue("Intense movie", testedChatbot.movieGenreChecker("Thriller"));
	}

	@Test
	public void testQuitChecker()
	{
		assertFalse("Blank does not mean quit", testedChatbot.quitChecker(""));
		assertFalse("Null does not mean quit", testedChatbot.quitChecker(null));
		assertFalse("Exit does not mean quit", testedChatbot.quitChecker("exit"));
		assertTrue("Quit does mean quit", testedChatbot.quitChecker("Quit"));
		assertTrue("QUIT also means quit", testedChatbot.quitChecker("QUIT"));
		assertFalse("Quit with other words does not mean quit", testedChatbot.quitChecker("Is it time to quit?"));
		
	}

	@Test
	public void testGetMovieList()
	{
		assertNotNull("Movie list can't be null", testedChatbot.getMovieList());
		assertTrue("Minimum movies not met", testedChatbot.getMovieList().size() > 4);
	}

	@Test
	public void testGetShoppingList()
	{
		assertNotNull("Shopping list can't be null", testedChatbot.getShoppingList());
		assertTrue("Minimum shopping items not met", testedChatbot.getShoppingList().size() > 4);
	}

	@Test
	public void testGetCuteAnimalMemes()
	{
		int otterCount = 0;
		int flooferCount = 0;
		int kittieCount = 0;
		for (String cute : testedChatbot.getCuteAnimalMemes())
		{
			if (cute.toLowerCase().contains("otter"))
			{
				otterCount += 1;
			}
			if (cute.toUpperCase().contains("FLOOFER"))
			{
				flooferCount += 1;
			}
			if (cute.toLowerCase().indexOf("kittie") > -1)
			{
				kittieCount += 1;
			}
		}
		
		assertTrue("You must have at least one otter in your list", otterCount > 0 );
		assertTrue("You must have at least one floofer in your list", flooferCount > 0 );
		assertTrue("You must have at least one kittie in your list", kittieCount > 0 );
	}
	
	@Test
	public void testGetQuestions()
	{
		assertNotNull("Questions array must exist", testedChatbot.getQuestions());
		assertTrue("Questions array size must be 10", testedChatbot.getQuestions().length == 10);
		assertTrue("First question should ask the users name", testedChatbot.getQuestions()[0].contains("name"));
		for(String question : testedChatbot.getQuestions())
		{
			assertNotNull("All questions must be initialized", question);
			assertTrue("All questions must end with a ?", question.lastIndexOf("?") == question.length() - 1);
		}
	}
	
	@Test
	public void testGetUsername()
	{
		assertNotNull("Username must be initialized.", testedChatbot.getUsername());
		assertTrue("Username must be at least 4 letters long.", testedChatbot.getUsername().length() > 3);
	}

	@Test
	public void testGetContent()
	{
		assertNotNull("You must return a valid String.", testedChatbot.getContent());
		assertTrue("Special topic must have more than six letters.", testedChatbot.getContent().length() > 5);
		String content = "some words";
		testedChatbot.setContent(content);
		assertFalse("Check blank failed", testedChatbot.contentChecker(" "));
		assertFalse("Check partial failed", testedChatbot.contentChecker("words"));
		assertFalse("Check partial failed", testedChatbot.contentChecker("some"));
		assertTrue("Check match failed", testedChatbot.contentChecker(content));
		assertTrue("Check match plus failed", testedChatbot.contentChecker("content " + content));
		assertTrue("Opposite check match failed", testedChatbot.contentChecker(content + " other content"));
	}
	
	@Test
	public void testKeyboardMashChecker()
	{
		assertFalse("Mash incorrectly detected", testedChatbot.keyboardMashChecker("S.D.F."));
		assertFalse("Mash incorrectly detected", testedChatbot.keyboardMashChecker("derf"));
		assertTrue("Keyboard mashing not detected", testedChatbot.keyboardMashChecker("sdf"));
		assertTrue("Keyboard mashing not detected", testedChatbot.keyboardMashChecker("SDF"));
		assertTrue("Keyboard mashing not detected", testedChatbot.keyboardMashChecker("dfg"));
		assertTrue("Keyboard mashing not detected", testedChatbot.keyboardMashChecker("cvb"));
		assertTrue("Keyboard mashing not detected", testedChatbot.keyboardMashChecker(",./"));
		assertTrue("Keyboard mashing not detected", testedChatbot.keyboardMashChecker("kjh"));
		assertTrue("Keyboard mashing not detected", testedChatbot.keyboardMashChecker("DFG"));
		assertTrue("Keyboard mashing not detected", testedChatbot.keyboardMashChecker("CVB"));
		assertTrue("Keyboard mashing not detected", testedChatbot.keyboardMashChecker("KJH"));
	}

	@Test
	public void testSetUsername()
	{
		testedChatbot.setUsername("chatbot user");
		assertTrue("Setters need to work as designed.", testedChatbot.getUsername().equals("chatbot user"));
	}

	@Test
	public void testSetContent()
	{
		testedChatbot.setContent("Chat topics");
		assertTrue("A setter should replace a value properly", testedChatbot.getContent().equals("Chat topics"));
	}

	@Test
	public void testToString()
	{
		assertFalse("No @ sign should be in the toString", testedChatbot.toString().indexOf("@") >= 0);
	}
	
	@Test
	public void testGetCurrentTime()
	{
		assertNotNull("The time needs to exist.", testedChatbot.getCurrentTime());
		assertTrue("The time needs to be now", testedChatbot.getCurrentTime().getHour() == LocalTime.now().getHour());
	}

}
