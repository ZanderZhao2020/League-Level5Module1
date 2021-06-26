package _01_File_Recorder;

import java.io.File;
import java.io.FileWriter;

import javax.swing.JOptionPane;

public class FileRecorder {
	// Create a program that takes a message from the user and saves it to a file.
	public static void main(String[] args) {
		try {
			String Name = "src/_01_File_Recorder/" + JOptionPane.showInputDialog("Enter name:") + ".txt";
			FileWriter FW = new FileWriter(Name, new File(Name).exists());
			FW.write(JOptionPane.showInputDialog("Enter message:") + "\n");
			FW.close();
		} catch (Exception E) {
		}
	}
}
