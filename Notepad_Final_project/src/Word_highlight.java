import java.awt.Color;

import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;

public class Word_highlight extends javax.swing.JFrame {
	Gui_1 Gui;

	public Word_highlight(Gui_1 gui) {
		this.Gui = gui;

	}

	class MyHighlighterPainter extends DefaultHighlighter.DefaultHighlightPainter {
		public MyHighlighterPainter(Color c) {
			super(c);
		}

	}

	Highlighter.HighlightPainter myHighlightPainter = new MyHighlighterPainter(Color.yellow);

	public void highlight(JTextComponent textComp, String pattern) {
		removeHighlights(textComp);
		try {
			Highlighter H_Light = textComp.getHighlighter();
			Document doc = textComp.getDocument();
			String text = doc.getText(0, doc.getLength());
			int pos = 0;
			while ((pos = text.toUpperCase().indexOf(pattern.toUpperCase(), pos)) >= 0) {
				H_Light.addHighlight(pos, pos + pattern.length(), myHighlightPainter);
				pos += pattern.length();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void removeHighlights(JTextComponent textComp) {

		Highlighter H_Light = textComp.getHighlighter();
		Highlighter.Highlight[] H_Lights = H_Light.getHighlights();

		for (int i = 0; i < H_Lights.length; i++) {
			if (H_Lights[i].getPainter() instanceof MyHighlighterPainter) {
				H_Light.removeHighlight(H_Lights[i]);
			}
		}
	}

	public static void main(String[] args) {

	}
}
