package chatbot.controller;

import chatbot.model.*;
import chatbot.view.*;

public class ChatbotController {
	Chatbot chatbot = new Chatbot("");
	PopupDisplay display = new PopupDisplay();
//	private ChatFrame appFrame;

	public void start() {
		String response = display.getResponse("What do you want to talk about?");
		while (chatbot.lengthChecker(response) && !chatbot.quitChecker(response)) {
			response = popupChat(response);
			response = display.getResponse(response);
		}
	}
	public String interactWithChatbot(String input) {
		String response = "Hello there, I am chatbot. Will you be my friend?";
		return response;
	}
	public String popupChat(String chat) {
		String chatbotSays = "";
		chatbotSays += chatbot.processConversation(chat);
		return chatbotSays;
	}
	public Chatbot getChatbot() {
		return chatbot;
	}
	public PopupDisplay getDisplay() {
		return display;
	}
//	public ChatFrame getChatFrame() {
//		return appFrame;
//	}
}
