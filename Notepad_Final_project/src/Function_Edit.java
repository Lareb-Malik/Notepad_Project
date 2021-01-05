
public class Function_Edit {

	Gui_1 gui;

	public Function_Edit(Gui_1 gui) {
		this.gui = gui;
	}

	public void Undo() {
		gui.um.undo();
	}

	public void Redo() {
		gui.um.redo();
	}

}
