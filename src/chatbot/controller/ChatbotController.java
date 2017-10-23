package chatbot.controller;

import chatbot.model.*;
import chatbot.view.*;

public class ChatbotController {
	Chatbot chatbot = new Chatbot("");
	PopupDisplay display = new PopupDisplay();
	public void start() {
		display.getResponse("Test");
	}
}
