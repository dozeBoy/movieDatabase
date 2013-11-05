//
//    MOVIEDATABASEGUI alpha 0.1
//    Mads Thomsen
//
//    GUI class for MovieDatabase
//
//    Has support for adding and editing Movies. 
//    Will save database of movies whenever movie is added or edited
//
//    TODO:
//        Deleting movies
//        Support for changing database
//        Adding actors
//        Adding more directors
//        Searching   
//        Sorting (implements comparable?)
//        Better menu (Complete functionality in menu)
//        JTables are ugly - list view and seperate pane for movie would be nice. JSplitPane maybe?


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import java.awt.event.ItemEvent;
//import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;

// import javax.swing.table.AbstractTableModel;
import javax.swing.ListSelectionModel;
// import javax.swing.event.ListSelectionEvent;

import java.util.ArrayList;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import javax.swing.JList;

public class GUI implements  ActionListener

{
    // Creating the controller object
    Controller control = new Controller();

    // Fields for initial frame
   
    // JButtons for Main Window
    private JButton newMovie;
    private JButton editMovie;
    
    // JTable for Main Window - to display movies
    private JTable table;


    //JScrollPane for attaching our table to
    private JScrollPane scrollPane;

    // Fields for menubar
    private JMenuBar menuBar;
    private JMenu menuFile;
    private JMenu menuHelp;
    private JMenuItem menuFileNewMovie;
    private JMenuItem menuFileNewDatabase;
    private JMenuItem menuFileOpenDatabase;


    // Jpanels for composite layout of Main window
    
    private JPanel west;
    private JPanel south;
    private JPanel center;

    private JTextArea txtarea;

    // Fields for newMovie Frame
    private JFrame newMovieFrame;

    // JLabels for newMovieFrame
    private JLabel newMovieTitleLabel;
    private JLabel newMovieGenreLabel;
    private JLabel newMovieYearLabel;
    private JLabel newMovieRatingLabel;
    private JLabel newMovieDirectorLabel;
    private JLabel newMovieDurationLabel;
   
    // JtextFields for newMovieFrame
    private JTextField newMovieTitleTextField;
    private JTextField newMovieGenreTextField;
    private JTextField newMovieYearTextField;
    private JTextField newMovieRatingTextField;
    private JTextField newMovieDirectorTextField;
    private JTextField newMovieDurationTextField;

    //Jbuttons for newMovieFrame
    private JButton newMovieAddMovieButton;
    private JButton newMovieCancelButton;

    // Jpanels for newMovieFrame
    private JPanel newMovieWest;
    private JPanel newMovieEast;
    private JPanel newMovieSouth;

    

    // Fields for editMovie Frame
    private JFrame editMovieFrame;

    // JLabels for editMovieFrame
    private JLabel editMovieIdLabel;
    private JLabel editMovieTitleLabel;
    private JLabel editMovieGenreLabel;
    private JLabel editMovieYearLabel;
    private JLabel editMovieRatingLabel;
    private JLabel editMovieDirectorLabel;
    private JLabel editMovieDurationLabel;
   
    // JtextFields for editMovieFrame
    private JLabel editMovieIdShowLabel;
    private JTextField editMovieTitleTextField;
    private JTextField editMovieGenreTextField;
    private JTextField editMovieYearTextField;
    private JTextField editMovieRatingTextField;
    private JTextField editMovieDirectorTextField;
    private JTextField editMovieDurationTextField;

    //Jbuttons for editMovieFrame
    private JButton editMovieButton;
    private JButton editMovieCancelButton;

    // Jpanels for editMovieFrame
    private JPanel editMovieWest;
    private JPanel editMovieEast;
    private JPanel editMovieSouth;

    //Fields for newDatabaseFrame
    private JFrame newDatabaseFrame;
    private JPanel newDatabaseWest;
    private JPanel newDatabaseEast;
    private JPanel newDatabaseSouth;
    private JLabel newDatabaseLabel;
    private JTextField newDatabaseTextField;

    private JButton newDatabaseAddButton;
    private JButton newDatabaseCancelButton;


    // Fields for openDatabaseFrame
    private JFrame openDatabaseFrame;

    private JPanel openDatabaseNorth;
    private JPanel openDatabaseSouth;

    private JList openDatabaseList;

    private JButton openDatabaseOpenButton;
    private JButton openDatabaseCancelButton;
   
    // Main loop
    public static void main(String[] args)
    {
	new GUI();

    }

    public GUI()
    {
	
	//Setup of initial frame
	final JFrame frame = new JFrame();
	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLayout(new BorderLayout());
	//	frame.setSize(new Dimension(500, 500));
	frame.setTitle("Movie Database");
	//frame.setBorder(new EmptyBorder(5, 5, 5, 5));

	menuBar = new JMenuBar();
	menuFile = new JMenu("File");
	menuFileNewMovie = new JMenuItem("New Movie");
	menuFileNewMovie.addActionListener(this);

	menuFileNewDatabase = new JMenuItem("New Database");
	menuFileNewDatabase.addActionListener(this);
	menuFileOpenDatabase = new JMenuItem("Open Database");
	menuFileOpenDatabase.addActionListener(this);

	// Add the menu items to the menu
	menuFile.add(menuFileNewMovie);
	menuFile.add(menuFileNewDatabase);
	menuFile.add(menuFileOpenDatabase);
	menuBar.add(menuFile);


	frame.setJMenuBar(menuBar);
	// Creating the JTable
	DefaultTableModel model = new DefaultTableModel();
	table = new JTable(model);
	table.getTableHeader().setReorderingAllowed(false);
	table.setRowSelectionAllowed(true);
	table.setColumnSelectionAllowed(false);
	
	// Attaching the JTable to the JScrollpane
        scrollPane = new JScrollPane(table);
	west = new JPanel(new GridLayout(1, 1));
	west.setBorder(new EmptyBorder(15, 15, 15, 15));
	south = new JPanel(new FlowLayout());
	south.setBorder(new EmptyBorder(15, 15, 15, 15));
	center = new JPanel(new BorderLayout());
	center.setBorder(new EmptyBorder(15, 15, 15, 15));
	// Displays the entire moviedatabase in the JTable
	updateJTable();

	// Adding the button to update our list of movies
	//	updateTable = new JButton("Fetch Database");
	//	updateTable.addActionListener(this);

	// Adding new movie button
	newMovie = new JButton("New Movie");
	newMovie.addActionListener(this);

	// Adding edit movie button
	editMovie = new JButton("Edit Movie");
        editMovie.addActionListener(this);

	//Adding Scrollpane and Jtable to the north part of the layout
	west.add(scrollPane, BorderLayout.CENTER);
	// Adding buttons to south part of layout
	//	south.add(updateTable);
	south.add(newMovie);
	south.add(editMovie);

	txtarea = new JTextArea(10, 20);
	JScrollPane sp2 = new JScrollPane(txtarea);
        center.add(sp2);
	// Adding south and north panels to the JFrame
	frame.add(west, BorderLayout.WEST);
	frame.add(south, BorderLayout.SOUTH);
	frame.add(center, BorderLayout.CENTER);
	frame.setLocationRelativeTo(null);
	frame.pack();

	frame.setVisible(true);

	// Creating the frame for adding new movies
	// Default close operation is hide, so not set on purpose
	newMovieFrame = new JFrame();
	newMovieFrame.setLayout(new BorderLayout());
	newMovieFrame.setTitle("Add new movie");
	newMovieFrame.setResizable(false);
	newMovieFrame.setLocationRelativeTo(frame);

	//	newMovieFrame.setSize(250, 500);
	// Creating the JLabels for west-part of add-movie frame
	//	newMovieIdLabel = new JLabel("    Id:");
	newMovieTitleLabel = new JLabel("Title:");
	newMovieGenreLabel = new JLabel("Genre:");
	newMovieYearLabel = new JLabel("Year:");
	newMovieRatingLabel = new JLabel("Rating:");
	newMovieDirectorLabel = new JLabel("Director:");
	newMovieDurationLabel = new JLabel("Duration:");
	// Creating the JPanel for the labels
	newMovieWest = new JPanel(new GridLayout(6, 1));
	newMovieWest.setBorder(new EmptyBorder(10, 10, 10, 10));

	//Adding the JLabels to the west JPanel
	//	newMovieWest.add(newMovieIdLabel);
	newMovieWest.add(newMovieTitleLabel);
	newMovieWest.add(newMovieGenreLabel);
	newMovieWest.add(newMovieYearLabel);
	newMovieWest.add(newMovieRatingLabel);
	newMovieWest.add(newMovieDirectorLabel);
	newMovieWest.add(newMovieDurationLabel);
	newMovieFrame.add(newMovieWest, BorderLayout.WEST);


	// Creating the JTextFields for the east-part of add-movie frame
	//	newMovieIdTextField = new JTextField(10);
	newMovieTitleTextField = new JTextField(10);
	newMovieGenreTextField = new JTextField(10);
	newMovieYearTextField = new JTextField(10);
	newMovieRatingTextField = new JTextField(10);
	newMovieDirectorTextField = new JTextField(10);
	newMovieDurationTextField = new JTextField(10);
	
 	// Creating the east JPanel
	newMovieEast = new JPanel(new GridLayout(6,1));
	newMovieEast.setBorder(new EmptyBorder(10, 10, 10, 10));

	// Adding the textfield to the east JPanel
	//	newMovieEast.add(newMovieIdTextField);
	newMovieEast.add(newMovieTitleTextField);
	newMovieEast.add(newMovieGenreTextField);
	newMovieEast.add(newMovieYearTextField);
	newMovieEast.add(newMovieRatingTextField);
	newMovieEast.add(newMovieDirectorTextField);
	newMovieEast.add(newMovieDurationTextField);

	newMovieFrame.add(newMovieEast, BorderLayout.EAST);

	// Creating the JButtons
	newMovieAddMovieButton = new JButton("Save Movie");
	newMovieAddMovieButton.addActionListener(this);

	newMovieCancelButton = new JButton("Cancel");
	newMovieCancelButton.addActionListener(this);
	// Creating the south panel
	newMovieSouth = new JPanel(new FlowLayout());

	//Adding buttons to south panel
	newMovieSouth.add(newMovieAddMovieButton);
	newMovieSouth.add(newMovieCancelButton);
	newMovieFrame.add(newMovieSouth, BorderLayout.SOUTH);
	newMovieFrame.pack();

	// Creating the frame for editing movies
	// Default close operation is hide, so not set on purpose
	editMovieFrame = new JFrame();
	editMovieFrame.setLayout(new BorderLayout());
	editMovieFrame.setTitle("Edit movie");
	editMovieFrame.setResizable(false);
	editMovieFrame.setLocationRelativeTo(frame);

	//	newMovieFrame.setSize(250, 500);
	// Creating the JLabels for west-part of add-movie frame
	//	newMovieIdLabel = new JLabel("    Id:");
	editMovieIdLabel = new JLabel("Id:");
	editMovieTitleLabel = new JLabel("Title:");
	editMovieGenreLabel = new JLabel("Genre:");
	editMovieYearLabel = new JLabel("Year:");
	editMovieRatingLabel = new JLabel("Rating:");
	editMovieDirectorLabel = new JLabel("Director:");
	editMovieDurationLabel = new JLabel("Duration:");
	// Creating the JPanel for the labels
	editMovieWest = new JPanel(new GridLayout(7, 1));


	//Adding the JLabels to the west JPanel
	//	newMovieWest.add(newMovieIdLabel);
	editMovieWest.add(editMovieIdLabel);
	editMovieWest.add(editMovieTitleLabel);
	editMovieWest.add(editMovieGenreLabel);
	editMovieWest.add(editMovieYearLabel);
	editMovieWest.add(editMovieRatingLabel);
	editMovieWest.add(editMovieDirectorLabel);
	editMovieWest.add(editMovieDurationLabel);
	editMovieFrame.add(editMovieWest, BorderLayout.WEST);

	// Creating the JTextFields for the east-part of add-movie frame
	//	newMovieIdTextField = new JTextField(10);

	editMovieIdShowLabel = new JLabel("");
	editMovieTitleTextField = new JTextField(10);
	editMovieGenreTextField = new JTextField(10);
	editMovieYearTextField = new JTextField(10);
	editMovieRatingTextField = new JTextField(10);
	editMovieDirectorTextField = new JTextField(10);
	editMovieDurationTextField = new JTextField(10);
	
 	// Creating the east JPanel
	editMovieEast = new JPanel(new GridLayout(7,1));

	// Adding the textfield to the east JPanel
	//	newMovieEast.add(newMovieIdTextField);
	editMovieEast.add(editMovieIdShowLabel);
	editMovieEast.add(editMovieTitleTextField);
	editMovieEast.add(editMovieGenreTextField);
	editMovieEast.add(editMovieYearTextField);
	editMovieEast.add(editMovieRatingTextField);
	editMovieEast.add(editMovieDirectorTextField);
	editMovieEast.add(editMovieDurationTextField);

	editMovieFrame.add(editMovieEast, BorderLayout.EAST);

	// Creating the JButtons
	editMovieButton = new JButton("Save Movie");
	editMovieButton.addActionListener(this);

	editMovieCancelButton = new JButton("Cancel");
	editMovieCancelButton.addActionListener(this);
	// Creating the south panel
	editMovieSouth = new JPanel(new FlowLayout());

	//Adding buttons to south panel
	editMovieSouth.add(editMovieButton);
	editMovieSouth.add(editMovieCancelButton);
	editMovieFrame.add(editMovieSouth, BorderLayout.SOUTH);
	editMovieFrame.pack();

	// Setup for newDatabaseFrame
	newDatabaseFrame = new JFrame("New Database");
	newDatabaseFrame.setLayout(new BorderLayout());

	newDatabaseWest = new JPanel(new GridLayout(1,1));
	newDatabaseWest.setBorder(new EmptyBorder(10, 10, 10, 10));
        newDatabaseEast = new JPanel(new GridLayout(1,1));
	newDatabaseEast.setBorder(new EmptyBorder(10, 10, 10, 10));
	newDatabaseSouth = new JPanel(new FlowLayout());
	newDatabaseSouth.setBorder(new EmptyBorder(10, 10, 10, 10));

	newDatabaseLabel = new JLabel("Name of Database: ");
	newDatabaseTextField = new JTextField(10);
	newDatabaseAddButton = new JButton("Add Database");
	newDatabaseAddButton.addActionListener(this);
	newDatabaseCancelButton = new JButton("Cancel");
	newDatabaseCancelButton.addActionListener(this);
	newDatabaseWest.add(newDatabaseLabel);
	newDatabaseEast.add(newDatabaseTextField);
	newDatabaseSouth.add(newDatabaseAddButton);
	newDatabaseSouth.add(newDatabaseCancelButton);
	newDatabaseFrame.add(newDatabaseWest, BorderLayout.WEST);
	newDatabaseFrame.add(newDatabaseEast, BorderLayout.EAST);
	newDatabaseFrame.add(newDatabaseSouth, BorderLayout.SOUTH);
	newDatabaseFrame.setLocationRelativeTo(frame);
	newDatabaseFrame.pack();
	//	newDatabaseFrame.setVisible(true);

	//Setup for openDatabaseFrame
	openDatabaseFrame = new JFrame("Open Database");
	openDatabaseFrame.setLayout(new BorderLayout());
	openDatabaseFrame.setResizable(false);
	openDatabaseFrame.setLocationRelativeTo(frame);
	openDatabaseNorth = new JPanel();
	openDatabaseNorth.setLayout(new GridLayout(2, 1));
	openDatabaseNorth.setBorder(new EmptyBorder(15, 15, 15, 15));

	openDatabaseSouth = new JPanel();
	openDatabaseSouth.setLayout(new FlowLayout());
	openDatabaseSouth.setBorder(new EmptyBorder(15, 15, 15, 15));
	
	String[] listData = new String[control.getAllDatabases().size()];
	for (int i = 0; i < control.getAllDatabases().size(); i++)
	    {
		listData[i] = control.getAllDatabases().get(i).getName();
	    }

	openDatabaseList = new JList<String>(listData);
	    
	// Buttons for openDatabaseFrame
	openDatabaseOpenButton = new JButton("Open Database");
	openDatabaseOpenButton.addActionListener(this);
	
	openDatabaseCancelButton = new JButton("Cancel");
	openDatabaseCancelButton.addActionListener(this);


	openDatabaseNorth.add(openDatabaseList);
	openDatabaseSouth.add(openDatabaseOpenButton);
	
	openDatabaseSouth.add(openDatabaseCancelButton);

	openDatabaseFrame.add(openDatabaseNorth, BorderLayout.NORTH);
	openDatabaseFrame.add(openDatabaseSouth, BorderLayout.SOUTH);
	
	openDatabaseFrame.pack();
	//	openDatabaseFrame.setVisible(true);

    }
    
    public void updateJTable()
    {
	DefaultTableModel model = new DefaultTableModel() 
        {
	    @Override
	    public boolean isCellEditable(int row, int column) {
		return false;
	    }
        };
	
	ListSelectionModel lsm = table.getSelectionModel();
	lsm.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	ArrayList<Movie>moviedb = control.getDB();
	model.setColumnIdentifiers(new String[] { "Id", "Title","Genre", "Year Released","Rating", "Director", "Duration" });
	model.setRowCount(moviedb.size());
	int row = 0;
	for (Movie m: moviedb)
	{
	    model.setValueAt(m.getId(), row, 0);
	    model.setValueAt(m.getTitle(), row, 1);
	    model.setValueAt(m.getGenre(), row, 2);
	    model.setValueAt(m.getYear(), row, 3);
	    model.setValueAt(m.getRating(), row, 4);
	    model.setValueAt(m.getDirector(), row, 5);
	    model.setValueAt(m.getDuration() + " minutes", row, 6);
	    row++;
	}
	table.setModel(model);
	
    }
    
    public void hideNewMovieWindow()
    {
	    // Hides the JFrame and resets all JTextFields
	    newMovieFrame.setVisible(false);
	    newMovieTitleTextField.setText("");
	    newMovieGenreTextField.setText("");
	    newMovieYearTextField.setText("");
	    newMovieRatingTextField.setText("");
	    newMovieDirectorTextField.setText("");
	    newMovieDurationTextField.setText("");

    }
public void hideEditMovieWindow()
    {
	    // Hides the JFrame and resets all JTextFields
	    editMovieFrame.setVisible(false);
	    editMovieIdShowLabel.setText("");
	    editMovieTitleTextField.setText("");
	    editMovieGenreTextField.setText("");
	    editMovieYearTextField.setText("");
	    editMovieRatingTextField.setText("");
	    editMovieDirectorTextField.setText("");
	    editMovieDurationTextField.setText("");

    }

    
    public void getMovieToEdit()
    {
	int row = table.getSelectedRow();
	if (row >= 0)
	    {
		
		Object id = GetData(table, row, 0);
		editMovieIdShowLabel.setText("" + id);
		Object obj1 = GetData(table, row, 1);
		editMovieTitleTextField.setText("" + obj1);
		Object obj2 = GetData(table, row, 2);
		editMovieGenreTextField.setText("" + obj2);
		Object obj3 = GetData(table, row, 3);
		editMovieYearTextField.setText("" + obj3);
		Object obj4 = GetData(table, row, 4);
		editMovieRatingTextField.setText("" + obj4);
		Object obj5 = GetData(table, row, 5);
		editMovieDirectorTextField.setText("" + obj5);
		Object obj6 = GetData(table, row, 6);
		
		editMovieDurationTextField.setText("" + obj6);
		String[] durationField = editMovieDurationTextField.getText().split(" ");
		editMovieDurationTextField.setText("" + durationField[0]);
		
		editMovieFrame.setVisible(true);
		 
	    }
	else 
	    {
		JOptionPane.showMessageDialog(null, "Please select a movie to edit!");
		return;
		
	    }
    }

    public Object GetData(JTable table, int row_index, int col_index){
	return table.getModel().getValueAt(row_index, col_index);
    }  
    public void actionPerformed(ActionEvent action)
    {

	// User presses new movie button and system shows newMovieFrame
	if (action.getSource() == newMovie)
        {
	    newMovieFrame.setVisible(true);
	}
	// User selects a movie, presses edit and system fetches moviedata and fills up fields 
	// In editMovieFrame with moviedata

	if (action.getSource() == editMovie)
	{
	    getMovieToEdit();
	    //	    editMovieFrame.setVisible(true);
	}

	// Methods for newMovieFrame
	if (action.getSource() == newMovieAddMovieButton)
	{
	    //Adding a movie to the db by fetching info from fields. Needs Error checking in controller.java! 
	    control.addMovieToDB( 
	    			 newMovieTitleTextField.getText(), 
	    			 newMovieGenreTextField.getText(), 
	    			 Integer.parseInt(newMovieYearTextField.getText()), 
	    			 Integer.parseInt(newMovieRatingTextField.getText()), 
	    			 control.director, 
	    			 Integer.parseInt(newMovieDurationTextField.getText()) );
	    
	    // Updates JTable with new movie, making me "kategori 1+" ;-)
	    updateJTable();
	    // Saves to disk
	    control.saveToDisk();
	    //Hides the window and resets the fields
	    hideNewMovieWindow();
	}
	if (action.getSource() == newMovieCancelButton)
	{
	    // Hides the window and resets the fields
	    hideNewMovieWindow();
	}
	if (action.getSource() == editMovieButton)
	    {
		int id = Integer.parseInt(editMovieIdShowLabel.getText());
	        String title = editMovieTitleTextField.getText();
		String genre = editMovieGenreTextField.getText();
		int year = Integer.parseInt(editMovieYearTextField.getText());
	        int rating = Integer.parseInt(editMovieRatingTextField.getText());
	    
		int duration = Integer.parseInt(editMovieDurationTextField.getText());
	

		control.editMovie(id, title, genre, year, rating, control.director, duration);
		updateJTable();
		control.saveToDisk();
		hideEditMovieWindow();
	    }

		
	if (action.getSource() == editMovieCancelButton)
        {
	    hideEditMovieWindow();
	}
	
	if (action.getSource() == menuFileNewMovie)
	{
	    newMovieFrame.setVisible(true);
	}
	
	if (action.getSource() == menuFileNewDatabase)
	    {
	        newDatabaseFrame.setVisible(true);
	    }

	if (action.getSource() == menuFileOpenDatabase)
	    {
		openDatabaseFrame.setVisible(true);
	    }

	// When user presses Add Database in the newDatabaseFrame
	if (action.getSource() == newDatabaseAddButton)
	    {
	
		control.addDatabase(newDatabaseTextField.getText());
		newDatabaseTextField.setText("");
	        newDatabaseFrame.setVisible(false);
	    }
	if (action.getSource() == newDatabaseCancelButton)
	{
	    newDatabaseTextField.setText("");
	    newDatabaseFrame.setVisible(false);
	}


	if (action.getSource() == openDatabaseOpenButton)
	{
	    //	    openDatabaseList.getSelection();
	    
	}
	if (action.getSource() == openDatabaseCancelButton)
	    {
		openDatabaseFrame.setVisible(false);
	    }
    }
	
}
