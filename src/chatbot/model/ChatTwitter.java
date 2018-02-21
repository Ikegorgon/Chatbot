package chatbot.model;

import chatbot.controller.*;
import twitter4j.*;

public class ChatTwitter {
	private ChatbotController appController;
	private Twitter chatbotTwitter;
	
	public ChatTwitter(ChatbotController appController) {
		this.appController = appController;
		this.chatbotTwitter = TwitterFactory.getSingleton();
		
	}
	public void sendTweet(String textToTweet) {
		
	}
}
