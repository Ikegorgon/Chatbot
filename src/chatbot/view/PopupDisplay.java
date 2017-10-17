package chatbot.view;

import javax.swing.JOptionPane;

public class PopupDisplay {
	public void displayText (String sample) {
		JOptionPane.showMessageDialog(null, sample);
	}
	public String getResponse (String sample) {
		String response = "";
		response += JOptionPane.showInputDialog(null, sample);
		return response;
	}
}
