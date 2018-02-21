package chatbot.view;

import chatbot.controller.*;
import chatbot.model.*;
import javax.swing.*;
import java.util.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.Font;

public class ChatPanel extends JPanel{
	private static final long serialVersionUID = 1L;
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
	private JButton saveButton;
	private JButton loadButton;
	private JButton searchButton;
	private JButton tweetButton;
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
		saveButton = new JButton("Save", new ImageIcon(getClass().getResource("/chatbot/view/images/save.png")));
		loadButton = new JButton("Load", new ImageIcon(getClass().getResource("/chatbot/view/images/load.png")));
		searchButton = new JButton("Search", new ImageIcon(getClass().getResource("/chatbot/view/images/search.png")));
		tweetButton = new JButton("Tweet", new ImageIcon(getClass().getResource("/chatbot/view/images/tweet.png")));
		
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
		this.add(saveButton);
		this.add(loadButton);
		this.add(searchButton);
		this.add(tweetButton);
	}
	private void setupLayout() {
		loadButton.setFont(new Font("Times New Roman", Font.BOLD, 13));
		appLayout.putConstraint(SpringLayout.NORTH, loadButton, 0, SpringLayout.NORTH, saveButton);
		appLayout.putConstraint(SpringLayout.WEST, loadButton, 0, SpringLayout.EAST, saveButton);
		appLayout.putConstraint(SpringLayout.WEST, searchButton, 1, SpringLayout.EAST, loadButton);
		appLayout.putConstraint(SpringLayout.EAST, searchButton, 98, SpringLayout.EAST, loadButton);
		searchButton.setFont(new Font("Times New Roman", Font.BOLD, 13));
		appLayout.putConstraint(SpringLayout.NORTH, searchButton, 0, SpringLayout.NORTH, saveButton);
		appLayout.putConstraint(SpringLayout.WEST, tweetButton, 0, SpringLayout.EAST, searchButton);
		appLayout.putConstraint(SpringLayout.EAST, tweetButton, 98, SpringLayout.EAST, searchButton);
		tweetButton.setFont(new Font("Times New Roman", Font.BOLD, 13));
		appLayout.putConstraint(SpringLayout.NORTH, tweetButton, 0, SpringLayout.NORTH, saveButton);
		saveButton.setFont(new Font("Times New Roman", Font.BOLD, 13));
		appLayout.putConstraint(SpringLayout.NORTH, saveButton, 5, SpringLayout.SOUTH, useButton);
		appLayout.putConstraint(SpringLayout.EAST, loadButton, 98, SpringLayout.EAST, saveButton);
		appLayout.putConstraint(SpringLayout.WEST, useButton, -5, SpringLayout.WEST, inputField);
		appLayout.putConstraint(SpringLayout.EAST, numButton, 0, SpringLayout.EAST, chatButton);
		appLayout.putConstraint(SpringLayout.EAST, chatButton, -5, SpringLayout.EAST, textArea);
		appLayout.putConstraint(SpringLayout.WEST, inputField, 5, SpringLayout.WEST, textArea);
		appLayout.putConstraint(SpringLayout.NORTH, useButton, 5, SpringLayout.SOUTH, inputField);
		appLayout.putConstraint(SpringLayout.NORTH, inputField, 260, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, saveButton, 5, SpringLayout.WEST, useButton);
		appLayout.putConstraint(SpringLayout.EAST, saveButton, 98, SpringLayout.WEST, useButton);
		
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
		appLayout.putConstraint(SpringLayout.EAST, inputField, -100, SpringLayout.EAST, chatScrollPane);
		
		chatButton.setToolTipText("Press This Button To Send Your Input To Chatbot");
		chatButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		appLayout.putConstraint(SpringLayout.NORTH, chatButton, 0, SpringLayout.NORTH, inputField);
		appLayout.putConstraint(SpringLayout.SOUTH, chatButton, 0, SpringLayout.SOUTH, inputField);
		appLayout.putConstraint(SpringLayout.WEST, chatButton, -100, SpringLayout.EAST, chatScrollPane);
		
		useButton.setToolTipText("Press This Button To Check For Special Cases");
		useButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		appLayout.putConstraint(SpringLayout.EAST, useButton, 190, SpringLayout.WEST, chatScrollPane);
		
		numButton.setToolTipText("Press This Button  To Display A Number");
		numButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		appLayout.putConstraint(SpringLayout.NORTH, numButton, 5, SpringLayout.SOUTH, inputField);
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
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				String userText = inputField.getText();
				String displayText = app.interactWithChatbot(userText);
				chatArea.append(displayText);
				inputField.setText("");
				chatArea.setCaretPosition(chatArea.getDocument().getLength());
			}
		});
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				
			}
		});
		loadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				
			}
		});
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				
			}
		});
		tweetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				app.tweet(inputField.getText());
				inputField.setText("");
			}
		});
	}
	public static JTextArea getChatArea() {
		return chatArea;
	}
	public void errorClear() {
		frame.getClass();
		chatbot.getClass();
	}
}
