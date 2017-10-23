package chatbot.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class PopupDisplay {
	private ImageIcon icon;
	private String windowTitle;
	public PopupDisplay() {
		icon = new ImageIcon(getClass().getResource("images/trump.png"));
		windowTitle = "Chatbot says ";
	}
	public void displayText (String sample) {
		JOptionPane.showMessageDialog(null, sample);
	}
	public String getResponse (String sample) {
		String response = "";
		response += JOptionPane.showInputDialog(null, sample);
		return response;
	}
}
