package chatbot.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import chatbot.controller.ChatbotController;
import chatbot.model.Chatbot;
import chatbot.view.*;

public class ControllerTest
{
	private ChatbotController testedController;
	
	@Before
	public void setUp() throws Exception
	{
		testedController = new ChatbotController();
	}

	@After
	public void tearDown() throws Exception
	{
		testedController = null;
	}

	@Test
	public void testChatbotController()
	{
		assertNotNull("Chatbot should be initialized in constructor", testedController.getChatbot());
		assertNotNull("PopupDisplay should be initialized in constructor", testedController.getDisplay());
	}

	@Test
	public void testStart()
	{
		assertTrue("This test should alway pass.", true);
	}

	@Test
	public void testInteractWithChatbot()
	{
		assertNotNull("Interact method should not return null", testedController.interactWithChatbot(""));
		assertNotNull("Interact method should not return null still", testedController.interactWithChatbot(null));
		assertTrue("Interact method should always return a String longer than 5", testedController.interactWithChatbot("").length() > 5);
		
	}

	@Test
	public void testGetChatbot()
	{
		assertNotNull("For some reason the chatbot needs to exist.", testedController.getChatbot());
		assertTrue("This method should return an instance of Chatbot", testedController.getChatbot() instanceof Chatbot);
	}

	@Test
	public void testGetDisplay()
	{
		assertNotNull("Popup must be initialized.", testedController.getDisplay());
		assertTrue("Popup display type should be used.", testedController.getDisplay() instanceof PopupDisplay);
	}
	
	public void testGetChatFrame()
	{
		assertNotNull("ChatFrame must be initialized.", testedController.getChatFrame());
		assertTrue("Chatframe needs to be returned", testedController.getChatFrame() instanceof ChatFrame);
	}

}
