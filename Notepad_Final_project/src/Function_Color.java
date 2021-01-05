import java.awt.Color;

public class Function_Color {
	Gui_1 gui;

	public Function_Color(Gui_1 gui) {
		this.gui = gui;
	}

	public void changeColor(String color) {
		switch (color) {
		case "White":
			gui.Notepad.getContentPane().setBackground(Color.white);
			gui.textArea.setBackground(Color.white);
			gui.textArea.setForeground(Color.black);
			break;
		case "Black":
			gui.Notepad.getContentPane().setBackground(Color.black);
			gui.textArea.setBackground(Color.black);
			gui.textArea.setForeground(Color.white);
			break;
		case "Blue":
			gui.Notepad.getContentPane().setBackground(Color.blue);
			gui.textArea.setBackground(Color.blue);
			gui.textArea.setForeground(Color.white);
			break;

		case "Yellow":
			gui.Notepad.getContentPane().setBackground(Color.yellow);
			gui.textArea.setBackground(Color.yellow);
			gui.textArea.setForeground(Color.black);
			break;

		case "Pink":
			gui.Notepad.getContentPane().setBackground(Color.pink);
			gui.textArea.setBackground(Color.pink);
			gui.textArea.setForeground(Color.black);
			break;

		case "Red":
			gui.Notepad.getContentPane().setBackground(Color.red);
			gui.textArea.setBackground(Color.red);
			gui.textArea.setForeground(Color.white);
			break;

		}
	}

}
