import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class Gui_1 implements ActionListener {
	JFrame Notepad;
	// TEXT AREA
	static JTextArea textArea;
	// ScrollPane
	JScrollPane scrollpane;
	// Word wrap
	boolean wordWrapOn = false;
	// TOP MENU BAR
	JMenuBar menuBar;
	JMenu MFile, MEdit, MFormat, MColor, MHelp;
	// FILE MENU
	JMenuItem INew, IOpen, ISave, ISaveAs, IExit;
	// FORMAT MENU
	// Font ANd Size Menu
	JMenu menuFont, menuFontSize;
	// Font ANd Size Menu Items
	JMenuItem iWrap, iFontArial, iFontCSMS, iFontTNR, iFontCalibri, iFontSize8, iFontSize12, iFontSize16, iFontSize20,
			iFontSize24, iFontSize28, iFontSize30, iFontSize32, iFontSize38;
	// Color Menu
	JMenuItem icolor1, icolor2, icolor3, icolor4, icolor5, icolor6;
	// Edit Menu
	JMenuItem iSearch, iUndo, iRedo, iPredict;
	// Help Menu
	JMenuItem iAbout;

	// Classes
	Function_File function_file = new Function_File(this);
	Function_Edit function_Edit = new Function_Edit(this);
	Function_Format format = new Function_Format(this);
	Function_Color color = new Function_Color(this);
	Function_Edit Edit = new Function_Edit(this);
	KeyHandler KeyHandler = new KeyHandler(this);
	Word_highlight word_highlight = new Word_highlight(this);
	About about;
	string s = new string();
	UndoManager um = new UndoManager();

	// Main Method
	public static void main(String[] args) {
		new Gui_1();
	}

	// Constructor
	public Gui_1() {
		createNotepad();
		createTextArea();
		createMenuBar();
		createFileMenu();
		createFormatMenu();
		createColorMenu();
		createEditMenu();
		createHelpMenu();
		// Default Font
		format.selectedFont = "Arial";
		// Default Font Size
		format.createFont(16);
		// Default format
		format.wordWrap();
		// Default Color
		color.changeColor("White");
		Notepad.setVisible(true);
	}

	// Creating Notepad
	public void createNotepad() {
		Notepad = new JFrame("Notepad");
		Notepad.setBackground(Color.WHITE);
		Notepad.setSize(800, 600);
		Notepad.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// Creating Text Area
	public void createTextArea() {
		textArea = new JTextArea();
		textArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
			public void undoableEditHappened(UndoableEditEvent e) {
				um.addEdit(e.getEdit());
			}
		});
		textArea.setFont(format.arial);
		textArea.addKeyListener(KeyHandler);
		scrollpane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollpane.setBorder(BorderFactory.createEmptyBorder());
		Notepad.getContentPane().add(scrollpane);
	}

	// Creating File Menu
	public void createFileMenu() {
		INew = new JMenuItem("New	 Ctrl+N");
		INew.addActionListener(this);
		INew.setActionCommand("New");
		MFile.add(INew);

		IOpen = new JMenuItem("Open  Ctrl+O");
		IOpen.addActionListener(this);
		IOpen.setActionCommand("Open");
		MFile.add(IOpen);

		ISave = new JMenuItem("Save  Ctrl+S");
		ISave.addActionListener(this);
		ISave.setActionCommand("Save");
		MFile.add(ISave);

		ISaveAs = new JMenuItem("SaveAs  Shift+Ctrl+S");
		ISaveAs.addActionListener(this);
		ISaveAs.setActionCommand("Save as");
		MFile.add(ISaveAs);

		IExit = new JMenuItem("Exit  Ctrl+E");
		IExit.addActionListener(this);
		IExit.setActionCommand("Exit");
		MFile.add(IExit);
	}

//Creating  Menu Bar
	public void createMenuBar() {
		menuBar = new JMenuBar();
		Notepad.setJMenuBar(menuBar);

		MFile = new JMenu("File");
		menuBar.add(MFile);

		MEdit = new JMenu("Edit");
		menuBar.add(MEdit);

		MFormat = new JMenu("Format");
		menuBar.add(MFormat);

		MColor = new JMenu("Color");
		menuBar.add(MColor);

		MHelp = new JMenu("Help");
		menuBar.add(MHelp);
	}

	// Creating Format Menu
	public void createFormatMenu() {
		iWrap = new JMenuItem("Word Wrap: OFF");
		iWrap.addActionListener(this);
		iWrap.setActionCommand("Word Wrap");
		MFormat.add(iWrap);
		menuFont = new JMenu("Font");
		MFormat.add(menuFont);

		iFontArial = new JMenuItem("Arial");
		iFontArial.addActionListener(this);
		iFontArial.setActionCommand("Arial");
		menuFont.add(iFontArial);

		iFontCSMS = new JMenuItem("Comic Sans MS");
		iFontCSMS.addActionListener(this);
		iFontCSMS.setActionCommand("Comic Sans MS");
		menuFont.add(iFontCSMS);

		iFontTNR = new JMenuItem("Times New Roman");
		iFontTNR.addActionListener(this);
		iFontTNR.setActionCommand("Times New Roman");
		menuFont.add(iFontTNR);

		iFontCalibri = new JMenuItem("Calibri");
		iFontCalibri.addActionListener(this);
		iFontCalibri.setActionCommand("Calibri");
		menuFont.add(iFontCalibri);

		menuFontSize = new JMenu("Font Size");
		MFormat.add(menuFontSize);

		iFontSize8 = new JMenuItem("8");
		iFontSize8.addActionListener(this);
		iFontSize8.setActionCommand("Size 8");
		menuFontSize.add(iFontSize8);

		iFontSize12 = new JMenuItem("12");
		iFontSize12.addActionListener(this);
		iFontSize12.setActionCommand("Size 12");
		menuFontSize.add(iFontSize12);

		iFontSize16 = new JMenuItem("16");
		iFontSize16.addActionListener(this);
		iFontSize16.setActionCommand("Size 16");
		menuFontSize.add(iFontSize16);

		iFontSize20 = new JMenuItem("20");
		iFontSize20.addActionListener(this);
		iFontSize20.setActionCommand("Size 20");
		menuFontSize.add(iFontSize20);

		iFontSize24 = new JMenuItem("24");
		iFontSize24.addActionListener(this);
		iFontSize24.setActionCommand("Size 24");
		menuFontSize.add(iFontSize24);

		iFontSize28 = new JMenuItem("28");
		iFontSize28.addActionListener(this);
		iFontSize28.setActionCommand("Size 28");
		menuFontSize.add(iFontSize28);

		iFontSize30 = new JMenuItem("30");
		iFontSize30.addActionListener(this);
		iFontSize30.setActionCommand("Size 3028");
		menuFontSize.add(iFontSize30);

		iFontSize32 = new JMenuItem("32");
		iFontSize32.addActionListener(this);
		iFontSize32.setActionCommand("Size 32");
		menuFontSize.add(iFontSize32);

		iFontSize38 = new JMenuItem("38");
		iFontSize38.addActionListener(this);
		iFontSize38.setActionCommand("Size 38");
		menuFontSize.add(iFontSize38);
	}

	// Creating Color Menu
	public void createColorMenu() {
		icolor1 = new JMenuItem("White");
		icolor1.addActionListener(this);
		icolor1.setActionCommand("White");
		MColor.add(icolor1);

		icolor2 = new JMenuItem("Black");
		icolor2.addActionListener(this);
		icolor2.setActionCommand("Black");
		MColor.add(icolor2);

		icolor3 = new JMenuItem("Blue");
		icolor3.addActionListener(this);
		icolor3.setActionCommand("Blue");
		MColor.add(icolor3);

		icolor4 = new JMenuItem("Yellow");
		icolor4.addActionListener(this);
		icolor4.setActionCommand("Yellow");
		MColor.add(icolor4);

		icolor5 = new JMenuItem("Pink");
		icolor5.addActionListener(this);
		icolor5.setActionCommand("Pink");
		MColor.add(icolor5);

		icolor6 = new JMenuItem("Red");
		icolor6.addActionListener(this);
		icolor6.setActionCommand("Red");
		MColor.add(icolor6);

	}

	// Creating Edit Menu
	public void createEditMenu() {
		iUndo = new JMenuItem("Undo	   Ctrl+Z");
		iUndo.addActionListener(this);
		iUndo.setActionCommand("Undo");
		MEdit.add(iUndo);

		iRedo = new JMenuItem("Redo	   Ctrl+Y");
		iRedo.addActionListener(this);
		iRedo.setActionCommand("Redo");
		MEdit.add(iRedo);

		iSearch = new JMenuItem("Search   Alt+S");
		iSearch.addActionListener(this);
		iSearch.setActionCommand("Search");
		MEdit.add(iSearch);
		// iPredict
		iPredict = new JMenuItem("Predict   Ctrl+P ");
		iPredict.addActionListener(this);
		iPredict.setActionCommand("Predict");
		MEdit.add(iPredict);
	}

	// Creating Help Menu
	public void createHelpMenu() {
		iAbout = new JMenuItem("About");
		iAbout.addActionListener(this);
		iAbout.setActionCommand("About");
		MHelp.add(iAbout);
	}

	// Creating Search Area
	public void searchArea() {
		final JTextField field = new JTextField("", 10);
		JButton b = new JButton("Search");
		JFrame f = new JFrame("Search Here");
		f.setSize(300, 150);
		f.getContentPane().setBackground(Color.white);
		f.getContentPane().setLayout(new FlowLayout());
		f.getContentPane().add(field);
		f.getContentPane().add(b);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				word_highlight.highlight(textArea, field.getText());
				;
			}
		});
		f.setVisible(true);
	}

	// Action Events
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		switch (command) {
		case "New":
			function_file.newFile();
			break;
		case "Open":
			function_file.openFile();
			break;
		case "Save":
			function_file.saveFile();
			break;
		case "SaveAs":
			function_file.saveAsFile();
			break;
		case "Exit":
			function_file.exitFile();
			break;
		case "Word Wrap":
			format.wordWrap();
			break;
		case "Arial":
			format.setFont(command);
			break;
		case "Comic Sans MS":
			format.setFont(command);
			break;
		case "Time New Roman":
			format.setFont(command);
			break;
		case "Calibri":
			format.setFont(command);
			break;
		case "Size 8":
			format.createFont(8);
			break;
		case "Size 12":
			format.createFont(12);
			break;
		case "Size 16":
			format.createFont(16);
			break;
		case "Size 20":
			format.createFont(20);
			break;
		case "Size 24":
			format.createFont(24);
			break;
		case "Size 28":
			format.createFont(28);
			break;
		case "Size 30":
			format.createFont(30);
			break;
		case "Size 32":
			format.createFont(32);
			break;
		case "Size 38":
			format.createFont(38);
			break;
		case "White":
			color.changeColor(command);
			break;
		case "Black":
			color.changeColor(command);
			break;
		case "Blue":
			color.changeColor(command);
			break;
		case "Yellow":
			color.changeColor(command);
			break;
		case "Pink":
			color.changeColor(command);
			break;
		case "Red":
			color.changeColor(command);
			break;
		case "About":
			new About().setVisible(true);
			break;
		case "Search":
			searchArea();
			break;
		case "Predict":
			string.Predict_Words();
			break;
		case "Redo":
			function_Edit.Redo();
			break;
		case "Undo":
			function_Edit.Undo();
			break;
		}
	}
}
