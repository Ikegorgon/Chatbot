package chatbot.controller;

import javax.swing.JTextArea;

import chatbot.model.*;
import chatbot.view.*;

public class ChatbotController {
	//Controller
	Chatbot chatbot = new Chatbot("");
	PopupDisplay display = new PopupDisplay();
	ChatFrame appFrame = new ChatFrame(this);

//	private ChatFrame appFrame;

	public void start() {
		close();
//		String response = display.getResponse("What do you want to talk about?");
//		while (chatbot.lengthChecker(response) && !chatbot.quitChecker(response)) {
//			response = popupChat(response);
//			response = display.getResponse(response);
//		}
	}
	public String interactWithChatbot(String input) {
		String response = "";
		if (chatbot.quitChecker(input)) {
			response += "\n GoodBye! :(";
		} else {
			response += chatbot.processConversation(input);
		}
		return response;
	}
	public void close() {
		JTextArea chatArea = ChatPanel.getChatArea();
		while (true) {
			if (chatArea.getText().endsWith("GoodBye! :(")) {
				try {
					Thread.sleep(1000);
				} catch(InterruptedException ex) {
					Thread.currentThread().interrupt();
				}
				System.exit(0);
			}
		}
	}
	public String popupChat(String chat) {
		String chatbotSays = "";
		chatbotSays += chatbot.processConversation(chat);
		return chatbotSays;
	}
	public String useCheckers(String text) {
		String response = "";
		if (chatbot.contentChecker(text)) {
			response += "This text matches the special content.\n";
		}
		if (chatbot.cuteAnimalMemeChecker(text)) {
			response += "This text has a cute animal.\n";
		}
		if (chatbot.keyboardMashChecker(text)) {
			response += "This text has keyboard mashing.\n";
		}
		if (chatbot.movieGenreChecker(text)) {
			response += "This text has a movie genre.\n";
		}
		if (chatbot.movieTitleChecker(text)) {
			response += "This text has a movie title.\n";
		}
		if (chatbot.shoppingListChecker(text)) {
			response += "This text has a shopping item.\n";
		}
		if (chatbot.userNameChecker(text)) {
			response += "This text has a username.\n";
		}
		return response;
	}
	public void handleError(Exception error) {
		display.displayText(error.getMessage());
	}
	public Chatbot getChatbot() {
		return chatbot;
	}
	public PopupDisplay getDisplay() {
		return display;
	}
	public ChatFrame getChatFrame() {
		return appFrame;
	}
}
