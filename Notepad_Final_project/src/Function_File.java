import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Function_File {
	Gui_1 Gui;
	String fileName, fileAddress;

	public Function_File(Gui_1 gui) {
		this.Gui = gui;
	}

	public void newFile() {

		Gui.textArea.setText("");
		Gui.Notepad.setTitle("Untitled");
		fileName = null;
		fileAddress = null;
	}

	public void openFile() {
		FileDialog FD = new FileDialog(Gui.Notepad, "Open", FileDialog.LOAD);
		FD.setVisible(true);
		if (FD.getFile() != null) {
			fileName = FD.getFile();
			fileAddress = FD.getDirectory();
			Gui.Notepad.setTitle(fileName);
		}
		try {
			BufferedReader BR = new BufferedReader(new FileReader(fileName + fileAddress));
			Gui.textArea.setText("");
			String line = null;
			while ((line = BR.readLine()) != null) {
				Gui.textArea.append(line + "\n");
			}
			BR.close();
		}

		catch (Exception e) {
			System.out.println(e);
		}
	}

	public void saveFile() {
		if (fileName == null) {
			saveAsFile();
		} else {
			try {
				FileWriter FW = new FileWriter(fileAddress + fileName);
				FW.write(Gui.textArea.getText());
				Gui.Notepad.setTitle(fileName);
				FW.close();
			} catch (Exception e) {
				System.out.println("Something Wrong!!!");
			}
		}
	}

	public void saveAsFile() {

		FileDialog FD = new FileDialog(Gui.Notepad, "Save", FileDialog.SAVE);
		FD.setVisible(true);

		if (FD.getFile() != null) {
			fileName = FD.getFile();
			fileAddress = FD.getDirectory();
			Gui.Notepad.setTitle(fileName);
		}
		try {
			FileWriter FW = new FileWriter(fileAddress + fileName);
			FW.write(Gui.textArea.getText());
			FW.close();
		} catch (Exception e) {
			System.out.println("Something Wronrg!!!!");
		}
	}

	public void exitFile() {
		System.exit(0);
	}

}
