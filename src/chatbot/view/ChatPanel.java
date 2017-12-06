package chatbot.view;

import chatbot.controller.*;
import chatbot.model.*;
import javax.swing.*;
import java.util.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.Font;

public class ChatPanel extends JPanel{
	//Panel to display Chatbot in fancy way :)
	private ChatbotController app;
	private Chatbot chatbot;
	private ChatFrame frame;
	private JButton chatButton;
	private JButton useButton;
	private JButton numButton;
	private JTextField inputField;
	private static JTextArea chatArea;
	private SpringLayout appLayout;
	private JTextArea textArea;
	private JScrollPane chatScrollPane;
	public ChatPanel(ChatbotController app) {
		super();
		this.app = app;
		chatArea = new JTextArea(10, 25);
		chatButton = new JButton("Chat");
		inputField = new JTextField(20);
		useButton = new JButton("Check");
		numButton = new JButton("Number");
		textArea = new JTextArea(0, 0);
		appLayout = new SpringLayout();
		frame = new ChatFrame();
		chatScrollPane = new JScrollPane();
		
		setupScrollPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	private void setupScrollPane() {
		chatScrollPane.setViewportView(chatArea);
		chatScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		chatScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		chatScrollPane.setBackground(Color.LIGHT_GRAY);
	}
	private void setupPanel() {
		this.setBackground(Color.RED);
		this.setLayout(appLayout);
		this.add(chatScrollPane);
		this.add(inputField);
		this.add(chatButton);
		this.add(useButton);
		this.add(numButton);
		this.add(textArea);
	}
	private void setupLayout() {
		chatArea.setText("Hello, I am Chabot. What would you like to talk about? \n");
		chatScrollPane.setToolTipText("Chatbot Response Shows Up Here");
		chatArea.setWrapStyleWord(true);
		chatArea.setLineWrap(true);
		chatScrollPane.setFont(new Font("Times", Font.BOLD | Font.ITALIC, 15));
		chatArea.setBackground(Color.LIGHT_GRAY);
		chatScrollPane.setEnabled(false);
		chatArea.setEditable(false);
		appLayout.putConstraint(SpringLayout.NORTH, chatScrollPane, 60, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.EAST, chatScrollPane, -60, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, chatScrollPane, -20, SpringLayout.NORTH, inputField);
		appLayout.putConstraint(SpringLayout.WEST, chatScrollPane, 60, SpringLayout.WEST, this);
		

		inputField.setToolTipText("Your Input Goes Here");
		appLayout.putConstraint(SpringLayout.NORTH, inputField, 200, SpringLayout.NORTH, chatScrollPane);
		appLayout.putConstraint(SpringLayout.EAST, inputField, -100, SpringLayout.EAST, chatScrollPane);
		appLayout.putConstraint(SpringLayout.WEST, inputField, 0, SpringLayout.WEST, chatScrollPane);
		
		chatButton.setToolTipText("Press This Button To Send Your Input To Chatbot");
		chatButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		appLayout.putConstraint(SpringLayout.NORTH, chatButton, 0, SpringLayout.NORTH, inputField);
		appLayout.putConstraint(SpringLayout.EAST, chatButton, 0, SpringLayout.EAST, chatScrollPane);
		appLayout.putConstraint(SpringLayout.SOUTH, chatButton, 0, SpringLayout.SOUTH, inputField);
		appLayout.putConstraint(SpringLayout.WEST, chatButton, -100, SpringLayout.EAST, chatScrollPane);
		
		useButton.setToolTipText("Press This Button To Check For Special Cases");
		useButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		appLayout.putConstraint(SpringLayout.NORTH, useButton, 5, SpringLayout.SOUTH, inputField);
		appLayout.putConstraint(SpringLayout.EAST, useButton, 190, SpringLayout.WEST, chatScrollPane);
		appLayout.putConstraint(SpringLayout.WEST, useButton, 0, SpringLayout.WEST, chatScrollPane);
		
		numButton.setToolTipText("Press This Button  To Display A Number");
		numButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		appLayout.putConstraint(SpringLayout.NORTH, numButton, 5, SpringLayout.SOUTH, inputField);
		appLayout.putConstraint(SpringLayout.EAST, numButton, 0, SpringLayout.EAST, chatScrollPane);
		appLayout.putConstraint(SpringLayout.WEST, numButton, -190, SpringLayout.EAST, chatScrollPane);
		
		textArea.setTabSize(0);
		textArea.setToolTipText("");
		textArea.setFont(new Font("Times", Font.BOLD | Font.ITALIC, 15));
		textArea.setEnabled(false);
		textArea.setEditable(false);
		textArea.setBackground(Color.BLACK);
		appLayout.putConstraint(SpringLayout.NORTH, textArea, -10, SpringLayout.NORTH, chatScrollPane);
		appLayout.putConstraint(SpringLayout.WEST, textArea, -10, SpringLayout.WEST, chatScrollPane);
		appLayout.putConstraint(SpringLayout.SOUTH, textArea, 10, SpringLayout.SOUTH, chatScrollPane);
		appLayout.putConstraint(SpringLayout.EAST, textArea, 10, SpringLayout.EAST, chatScrollPane);
	}
	private void setupListeners() {
		chatButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				String userText = inputField.getText();
				String displayText = app.interactWithChatbot(userText);
				chatArea.append(displayText);
				inputField.setText("");
				chatArea.setCaretPosition(chatArea.getDocument().getLength());
			}
		});
		useButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				String userText = inputField.getText();
				String displayText = app.useCheckers(userText);
				chatArea.append(displayText);
				inputField.setText("");
				chatArea.setCaretPosition(chatArea.getDocument().getLength());
			}
		});
		numButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				Random rand = new Random();
				int n = rand.nextInt(999999999);
				String num = n + "\n";
				chatArea.append(num);
				chatArea.setCaretPosition(chatArea.getDocument().getLength());
			}
		});
		inputField.addActionListener(new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				String userText = inputField.getText();
				String displayText = app.interactWithChatbot(userText);
				chatArea.append(displayText);
				inputField.setText("");
				chatArea.setCaretPosition(chatArea.getDocument().getLength());
			}
		});
	}
	public static JTextArea getChatArea() {
		return chatArea;
	}
}
