import java.awt.Font;

public class Function_Format {

	Gui_1 gui;
	Font arial, comicSansMS, timesNewRoman, calibri;
	String selectedFont;

	public Function_Format(Gui_1 gui) {
		this.gui = gui;
	}

	public void wordWrap() {

		if (gui.wordWrapOn == false) {
			gui.wordWrapOn = true;
			gui.textArea.setLineWrap(true);
			gui.textArea.setWrapStyleWord(true);
			gui.iWrap.setText("Word Wrap: ON");
		}

		else if (gui.wordWrapOn = true) {
			gui.wordWrapOn = false;
			gui.textArea.setLineWrap(false);
			gui.textArea.setWrapStyleWord(false);
			gui.iWrap.setText("Word Wrap: OFF");
		}
	}

	public void createFont(int fontSize) {
		arial = new Font("Arial", Font.PLAIN, fontSize);
		comicSansMS = new Font("Comic Sans MS", Font.PLAIN, fontSize);
		timesNewRoman = new Font("Times New Roman", Font.PLAIN, fontSize);
		calibri = new Font("calibri", Font.PLAIN, fontSize);

		setFont(selectedFont);

	}

	public void setFont(String font) {

		selectedFont = font;

		switch (selectedFont) {

		case "Arial":
			gui.textArea.setFont(arial);
			break;

		case "Comic Sans MS":
			gui.textArea.setFont(comicSansMS);
			break;

		case "Times New Roman":
			gui.textArea.setFont(timesNewRoman);
			break;

		case "Calibri":
			gui.textArea.setFont(calibri);
			break;

		}
	}

}
