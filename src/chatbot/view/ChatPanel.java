package chatbot.view;

import chatbot.controller.*;
import chatbot.model.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.Font;

public class ChatPanel extends JPanel{
	//Panel to display Chatbot in fancy way :)
	private ChatbotController app;
	private Chatbot chatbot;
	private ChatFrame frame;
	private JButton chatButton;
	private JButton randButton;
	private JButton numButton;
	private JTextField inputField;
	private static JTextArea chatArea;
	private SpringLayout appLayout;
	private JTextArea textArea;
	
	public ChatPanel(ChatbotController app) {
		super();
		this.app = app;
		chatArea = new JTextArea(10, 25);
		chatButton = new JButton("Chat");
		inputField = new JTextField(20);
		randButton = new JButton("Random");
		numButton = new JButton("Number");
		textArea = new JTextArea(0, 0);
		appLayout = new SpringLayout();
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	private void setupPanel() {
		this.setBackground(Color.RED);
		this.setLayout(appLayout);
		this.add(chatArea);
		this.add(inputField);
		this.add(chatButton);
		this.add(randButton);
		this.add(numButton);
		this.add(textArea);
	}
	private void setupLayout() {
		chatArea.setText("Hello, I am Chabot. What would you like to talk about? \n");
		chatArea.setToolTipText("Chatbot Response Shows Up Here");
		chatArea.setWrapStyleWord(true);
		chatArea.setLineWrap(true);
		chatArea.setFont(new Font("Times", Font.BOLD | Font.ITALIC, 15));
		chatArea.setBackground(Color.LIGHT_GRAY);
		chatArea.setEnabled(false);
		chatArea.setEditable(false);
		appLayout.putConstraint(SpringLayout.NORTH, chatArea, 60, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.EAST, chatArea, -60, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, chatArea, -20, SpringLayout.NORTH, inputField);
		appLayout.putConstraint(SpringLayout.WEST, chatArea, 60, SpringLayout.WEST, this);
		
		chatButton.setToolTipText("Press This Button To Send Your Input To Chatbot");
		chatButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		appLayout.putConstraint(SpringLayout.NORTH, inputField, 200, SpringLayout.NORTH, chatArea);
		appLayout.putConstraint(SpringLayout.EAST, inputField, -100, SpringLayout.EAST, chatArea);
		appLayout.putConstraint(SpringLayout.WEST, inputField, 0, SpringLayout.WEST, chatArea);
		
		inputField.setToolTipText("Your Input Goes Here");
		appLayout.putConstraint(SpringLayout.NORTH, chatButton, 0, SpringLayout.NORTH, inputField);
		appLayout.putConstraint(SpringLayout.EAST, chatButton, 0, SpringLayout.EAST, chatArea);
		appLayout.putConstraint(SpringLayout.SOUTH, chatButton, 0, SpringLayout.SOUTH, inputField);
		appLayout.putConstraint(SpringLayout.WEST, chatButton, -100, SpringLayout.EAST, chatArea);
		
		randButton.setToolTipText("Press This Button To Say Something Really Random");
		randButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		appLayout.putConstraint(SpringLayout.NORTH, randButton, 5, SpringLayout.SOUTH, inputField);
		appLayout.putConstraint(SpringLayout.EAST, randButton, 190, SpringLayout.WEST, chatArea);
		appLayout.putConstraint(SpringLayout.WEST, randButton, 0, SpringLayout.WEST, chatArea);
		
		numButton.setToolTipText("Press This Button  To Display A Number");
		numButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		appLayout.putConstraint(SpringLayout.NORTH, numButton, 5, SpringLayout.SOUTH, inputField);
		appLayout.putConstraint(SpringLayout.EAST, numButton, 0, SpringLayout.EAST, chatArea);
		appLayout.putConstraint(SpringLayout.WEST, numButton, -190, SpringLayout.EAST, chatArea);
		
		textArea.setTabSize(0);
		textArea.setToolTipText("");
		textArea.setFont(new Font("Times", Font.BOLD | Font.ITALIC, 15));
		textArea.setEnabled(false);
		textArea.setEditable(false);
		textArea.setBackground(Color.BLACK);
		appLayout.putConstraint(SpringLayout.NORTH, textArea, -10, SpringLayout.NORTH, chatArea);
		appLayout.putConstraint(SpringLayout.WEST, textArea, -10, SpringLayout.WEST, chatArea);
		appLayout.putConstraint(SpringLayout.SOUTH, textArea, 10, SpringLayout.SOUTH, chatArea);
		appLayout.putConstraint(SpringLayout.EAST, textArea, 10, SpringLayout.EAST, chatArea);
	}
	private void setupListeners() {
		chatButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				String userText = inputField.getText();
				String displayText = app.interactWithChatbot(userText);
				chatArea.append(displayText);
				inputField.setText("");
			}
		});
		randButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				
			}
		});
		numButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				
			}
		});
	}
	public static JTextArea getChatArea() {
		return chatArea;
	}
}
