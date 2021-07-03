package _02_File_Encrypt_Decrypt;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class FileDecryptor {
	/*
	 * Decryption is the process of taking encoded or encrypted text or other data
	 * and converting it back into text that you or the computer can read and understand.
	 *
	 * The shift cipher is decrypted by using using the key and shifting back up,
	 * at the end of our encryption example we had our alphabet as:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 *
	 * If we shift it back up by 4 based on the key we used the alphabet is decrypted:
	 *
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 *
	 * "Lipps Asvph" returns to "Hello World"
	 * 
	 * Create a program that opens the file created by FileEncryptor and decrypts
	 * the message, then display it to the user in a JOptionPane.
	 */
	public static void main(String[] args) {
		String Final = "";
		String KeyS = JOptionPane.showInputDialog("Enter the key (only 1 character long):");
		if (KeyS.length() != 1) {
			JOptionPane.showMessageDialog(null, "Length is not 1");
			System.exit(0);
		}
		int Key = KeyS.charAt(0);
		for (char Char : JOptionPane.showInputDialog("Enter encrypted string:").toCharArray()) {
			Final += (char) (Character.getNumericValue(Char) - Key);
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
