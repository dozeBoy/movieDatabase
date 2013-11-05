import java.util.ArrayList;

public class MovieDatabase
{
   private String name;
   private ArrayList<Movie>myDatabase = new ArrayList<Movie>();
   
   public MovieDatabase(String name)
   {
      this.setName(name);
      
   }
   public String getName()
   {
      return this.name;
   }
   
   public void setName(String name)
   {
      this.name = name;
   }
   
    public int getSize()
    {
	return myDatabase.size();
    }
   
   
   // Methods for adding, editing and returning movies
   public void addMovie(Movie m)
   {
      myDatabase.add(m);
   }
   
   public Movie getMovie(int i)
   {
      return myDatabase.get(i);
   }
   
    public void editMovie(int id, String title, String genre, int year, int rating, Director director, int duration)
   {
       Movie m = getById(id);
       m.setTitle(title);
       m.setGenre(genre);
       m.setYear(year);
       m.setRating(rating);
       m.setDirector(director);
       m.setDuration(duration);
   }
    
   public ArrayList<Movie> getAllMovies()
   {
      return myDatabase;
   }
   
   public ArrayList<Movie> getAllGenre(String genre)
   {
      if (!myDatabase.isEmpty())
      {
         ArrayList<Movie>allOfGenre = new ArrayList<Movie>();
         for (Movie m: myDatabase)
         {
            if (m.getGenre().equalsIgnoreCase(genre))
            {
               allOfGenre.add(m);
            }
         }   
         return allOfGenre;
      }
      else { return myDatabase;}
   }
   
   public Movie getById(int id)
   {
       for (Movie m: myDatabase)
       {
	   if (m.getId() == id)
	   {
	       return myDatabase.get(myDatabase.indexOf(m));
	   }
       }
       return getMovie(id);
   }
   public ArrayList<Movie> getTitle(String title)
   {
      ArrayList<Movie>allOfTitle = new ArrayList<Movie>();
      for (Movie m: myDatabase)
      {
         if (m.getTitle().equalsIgnoreCase(title))
         {
            allOfTitle.add(m);
         }
      }
      return allOfTitle;
   }
}
