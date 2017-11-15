package chatbot.test;

import static org.junit.Assert.*;

import java.awt.Component;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import chatbot.controller.ChatbotController;
import chatbot.view.ChatPanel;

public class PanelTest
{
	private ChatPanel testedPanel;
	
	@Before
	public void setUp() throws Exception
	{
		testedPanel = new ChatPanel(new ChatbotController());
	}

	@After
	public void tearDown() throws Exception
	{
		testedPanel = null;
	}

	@Test
	public void testSetupListeners()
	{
		assertTrue("Minimum components not met", testedPanel.getComponents().length >= 3);
		for(Component currentGUIComponent : testedPanel.getComponents())
		{
			if(currentGUIComponent instanceof JButton)
			{
				assertNotNull("Listener not installed for JButton",((JButton) currentGUIComponent).getActionListeners()[0]);
				assertTrue("Correct type of listener not installed", ((JButton) currentGUIComponent).getActionListeners()[0] instanceof ActionListener);
			}
		}
		
	}
	
	@Test
	public void testSetupPanel()
	{
		assertTrue("Minimum number of JComponents not met", testedPanel.getComponents().length >= 5);
		assertTrue("Layout manager should be a SpringLayout", testedPanel.getLayout() instanceof SpringLayout);
		for(Component currentGUIComponent : testedPanel.getComponents())
		{
		 	if(currentGUIComponent instanceof JTextArea)
			{
				assertFalse("Text area should not be enabled", currentGUIComponent.isEnabled());
				assertFalse("Text area should not be editable", ((JTextArea) currentGUIComponent).isEditable());
			}
		}
	}
}
