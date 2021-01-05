import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyledDocument;

public class string {
	static String input;
	static String[] words = new String[10002];
	static String[] w = new String[100];
	static int b = 0;
	static boolean flag = false;
	static int a = 0;
	static String str1 = null;
	static String str2;
	static String str = "";

	public static void Predict_Words() {

		final JTextField field = new JTextField("", 10);
		field.setBounds(10, 22, 159, 23);
		JTextArea area = new JTextArea();
		JButton b1 = new JButton("Predict");

		b1.setBounds(179, 22, 96, 23);
		JFrame f = new JFrame("Search Here");
		f.setSize(301, 377);
		f.getContentPane().setBackground(Color.white);
		f.getContentPane().setLayout(null);

		f.getContentPane().add(field);

		f.getContentPane().add(b1);

		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setForeground(new Color(0, 0, 0));
		textPane.setBackground(Color.WHITE);
		textPane.setBounds(10, 45, 159, 280);
		f.getContentPane().add(textPane);
		try {
			File Fr = new File("words.txt");
			Scanner sc = new Scanner(Fr);
			while (sc.hasNextLine()) {
				str = sc.next();
				words[a] = str;
				a += 1;
			}
		} catch (IOException e1) {
			System.out.print(e1.getMessage());
		}
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input = field.getText();

				str2 = words[0];

				str1 = input;

				// compare strings
				try {
					for (int j = 0; j < words.length - 1; j++) {
						if (str2.contains(str1)) {
							for (int i = 0; i < str1.length(); i++) {
								if (str1.charAt(i) == str2.charAt(i)) {
									flag = true;
								} else {
									flag = false;
								}

							}
							if (flag) {

								w[b] = str2;
								b++;
								System.out.println(str2);
							}
						}
						str2 = words[j];
					}
				} catch (Exception NullPointerException) {
				}
				try {
					int k = 1;
					String p = "";

					while (w[k] != null) {
						p = p + w[k] + "\n";
						textPane.setText(p);

						k++;
					}
				} catch (Exception e1) {
					System.out.println(e1);
				}
			}

		});
		f.setVisible(true);
	}

	public static void main(String args[]) {
		Predict_Words();
	}
}
