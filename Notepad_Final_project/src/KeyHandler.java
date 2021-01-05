import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
	Gui_1 gui;
	string s;
	public KeyHandler(Gui_1 gui) {
		this.gui=gui;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_N) {
			gui.function_file.newFile();
		}
		if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_O) {
			gui.function_file.openFile();
		}
		if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_P) {
			gui.s.Predict_Words();
		}
		if(e.isAltDown()&&e.getKeyCode()==KeyEvent.VK_S) {
			gui.searchArea();
		}
		if(e.isControlDown()&&e.getKeyCode()==KeyEvent.VK_S) {
			gui.function_file.saveFile();
		}
		if(e.isShiftDown()&&e.isControlDown()&&e.getKeyCode()==KeyEvent.VK_S) {
			gui.function_file.saveAsFile();
		}
		if(e.isControlDown()&&e.getKeyCode()==KeyEvent.VK_E) {
			gui.function_file.exitFile();
		}
		if(e.isAltDown()&&e.getKeyCode()==KeyEvent.VK_F) {
			gui.MFile.doClick();
		}
		if(e.isAltDown()&&e.getKeyCode()==KeyEvent.VK_E) {
			gui.MEdit.doClick();
		}
		if(e.isShiftDown()&&e.getKeyCode()==KeyEvent.VK_F) {
			gui.MFormat.doClick();
		}
		if(e.isAltDown()&&e.getKeyCode()==KeyEvent.VK_C) {
			gui.MColor.doClick();
		}
		if(e.isAltDown()&&e.getKeyCode()==KeyEvent.VK_H) {
			gui.MHelp.doClick();
		}
		if(e.isControlDown()&&e.getKeyCode()==KeyEvent.VK_Z) {
			gui.function_Edit.Undo();
		}
		if(e.isControlDown()&&e.getKeyCode()==KeyEvent.VK_Y) {
			gui.function_Edit.Redo();
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
		
	}

}
