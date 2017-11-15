package chatbot.view;

import chatbot.controller.*;
import javax.swing.*;

public class ChatFrame extends JFrame {
	private ChatbotController app;
	private ChatPanel appPanel;
	public ChatFrame(ChatbotController app) {
		super();
		this.app = app;
		appPanel = new ChatPanel(app);
		setupFrame();
	}
	private void setupFrame() {
		this.setContentPane(appPanel);
		this.setTitle("Chatbot");
		this.setSize(500, 500);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public ChatbotController getBaseController() {
		return app;
	}
}
