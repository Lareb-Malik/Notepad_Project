import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class About extends JFrame implements ActionListener {
	Gui_1 Gui;
	JButton b1;

	About() {
		getContentPane().setBackground(Color.WHITE);
		setBounds(600, 200, 547, 342);
		getContentPane().setLayout(null);
		JLabel l3 = new JLabel("<html>**************************Notepad**************************"
				+ "<br><br>Notepad is a simple text editor for basic text-editing program"
				+ "<br>which enables computer users to create documents. "
				+ "<br>This notepad helps user to the create, store, and edittext files. "
				+ "<br>It also helps the user to get latest word predictions"
				+ "<br>that will help users to write documents more rapidly.</html>");
		l3.setFont(new Font("SAN_SERIF", Font.ITALIC, 18));
		l3.setBounds(56, 11, 432, 281);
		getContentPane().add(l3);
		b1 = new JButton("OK");
		b1.setBounds(580, 500, 80, 25);
		b1.addActionListener(this);
		getContentPane().add(b1);
	}

	public void actionPerformed(ActionEvent ae) {
		this.setVisible(false);
	}

	public static void main(String[] args) {
	}
}
