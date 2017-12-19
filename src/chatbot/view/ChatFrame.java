package chatbot.view;

import chatbot.controller.*;
import javax.swing.*;

public class ChatFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	//Basic Frame to hold Panel
	private ChatbotController app;
	private ChatPanel appPanel;
	public ChatFrame(ChatbotController app) {
		super();
		this.app = app;
		appPanel = new ChatPanel(app);
		setupFrame();
	}
	public ChatFrame() {
		
	}
	private void setupFrame() {
		this.setContentPane(appPanel);
		this.setTitle("Chatbot");
		this.setSize(500, 500);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public ChatbotController getBaseController() {
		return app;
	}
}
