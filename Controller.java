import java.util.ArrayList;
//import java.io.Serializable;

public class Controller
{
    private ArrayList<MovieDatabase>allDatabases = new ArrayList<MovieDatabase>();
    private MovieDatabase db;
    private FileWrapper fw;
    public Director director = new Director("Steven Spielberg");
  
    public Controller()
    {
	// Creates Database, fileWrapper, loads database with same name from HD and adds the db to the list of db's
	// support for multiple db's not yet implemented
	setDB(new MovieDatabase("db"));
	fw = new FileWrapper();
	getFromDisk();
	allDatabases.add(this.db);
	//	allDatabases.add(new MovieDatabase("test"));
	
    }
    
    public void setDB(MovieDatabase db)
    {
	this.db = db;
    }

    public void addDatabase(String name)
    {
	allDatabases.add(new MovieDatabase(name));
    }

    public ArrayList<MovieDatabase> getAllDatabases()
    {
	return allDatabases;
    }

    public MovieDatabase getDatabase()
    {
	return this.db;
    }

    public ArrayList<Movie> getDB()
    {
	return db.getAllMovies();
    }

    public void addMovieToDB(String title, String genre, int year, int rating, Director director, int duration)
    {
	db.addMovie(new Movie(db.getSize(), title, genre, year, rating, director, duration));
	
    }
    public void editMovie(int id, String title, String genre, int year, int rating, Director director, int duration)
    {
	db.editMovie(id, title, genre, year, rating, this.director, duration);
    }

    public void saveToDisk()
    {
	try
	{
	    fw.writeToFile(getDB(), db.getName());
	}
	catch (Exception e)
	{
	    System.out.println("Error is:\n" + e.getMessage());
	}
    }
    public void getFromDisk()
    {
	try
	{
	   
	    Object o = fw.getObject(db.getName());
	    @SuppressWarnings("unchecked")
	    ArrayList<Movie> existingMovies = (ArrayList<Movie>) o;
	    	    if (existingMovies.isEmpty() == false)
		    {
		    for (Movie m: existingMovies)
			{
			    int id = m.getId();
			    String title = m.getTitle();
			    String genre = m.getGenre();
			    int year = m.getYear();
			    int rating = m.getRating();
			    Director director = this.director;
			    int duration = m.getDuration();
			    addMovieToDB(title, genre, year, rating, director, duration);
			}
		}
	}
	catch (Exception e)
	{
	    System.out.println("Error is in getFromDisk():\n" + e.getMessage());
	}
    }


}


