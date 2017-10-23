package chatbot.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import chat.controller.ChatbotController;
import chat.view.ChatFrame;
import chat.view.ChatPanel;

public class FrameTest
{
	private ChatFrame testedFrame;

	@Before
	public void setUp() throws Exception
	{
		testedFrame = new ChatFrame(new ChatbotController());
	}

	@After
	public void tearDown() throws Exception
	{
		testedFrame = null;
	}

	@Test
	public void testChatFrame()
	{
		assertNotNull("Controller data member needs to be initialized", testedFrame.getBaseController());
		assertTrue("Controller must be an instance of ChatbotController", testedFrame.getBaseController() instanceof ChatbotController);
	}
	
	@Test
	public void testSetupFrame()
	{
		assertNotNull("Frame needs a ChatPanel initialized", testedFrame.getContentPane());
		assertTrue("Panel needs to be a ChatPanel", testedFrame.getContentPane() instanceof ChatPanel);
		assertTrue("Application needs a title with more than 5 letters", testedFrame.getTitle().length() > 5);
		assertTrue("Application size must be at least 500 pixels wide", testedFrame.getWidth() >= 500);
		assertTrue("Application size must be at least 500 pixels high", testedFrame.getHeight() >= 500);
		assertFalse("The chatbot application should not be resizable", testedFrame.isResizable());
	}
}
