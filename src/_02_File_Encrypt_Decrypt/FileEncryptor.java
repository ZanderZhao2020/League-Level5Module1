package _02_File_Encrypt_Decrypt;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

public class FileEncryptor {
	/*
	 * Encryption is the process of encoding a message or information
	 * in such a way that only authorized parties can access it and
	 * those who are not authorized cannot.
	 *
	 * A simple shift cipher works by shifting the letters of a message
	 * down based on a key. If our key is 4 then:
	 * 
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 * 
	 * becomes:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 * 
	 * "Hello World" changes to "Lipps Asvph"
	 *
	 * Create a program that takes a message and a key from the user.
	 * Use the key to shift each letter in the users input and save the final result to a file.
	 */
	public static void main(String[] args) {
		String Final = "";
		String KeyS = JOptionPane.showInputDialog("Enter the key (only 1 character long):");
		if (KeyS.length() != 1) {
			JOptionPane.showMessageDialog(null, "Length is not 1");
			System.exit(0);
		}
		int Key = KeyS.charAt(0);
		for (char Char : JOptionPane.showInputDialog("Enter string:").toCharArray()) {
			Final += (char) (Character.getNumericValue(Char) + Key);
		}
		JFrame Frame = new JFrame();
		JPanel Panel = new JPanel();
		JButton Button = new JButton("Copy to clipboard...");
		JTextPane Label = new JTextPane();
		Label.setText(Final);
		Label.setEditable(false);
		Button.addActionListener(S -> {
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(Label.getText()), null);
		});
		Panel.add(Label);
		Panel.add(Button);
		Frame.add(Panel);
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Frame.pack();
		Frame.setVisible(true);
		Frame.setSize(500, 250);
	}
}
