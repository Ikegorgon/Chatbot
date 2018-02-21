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
		try {
			chatbotTwitter.updateStatus(textToTweet + " @ChatbotCTEC");
		} catch(TwitterException tweetError) {
			appController.handleError(tweetError);
		} catch(Exception otherError) {
			appController.handleError(otherError);
		}
	}
}
