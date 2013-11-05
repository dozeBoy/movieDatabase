//import java.util.ArrayList;
import java.io.Serializable;

public class Movie implements Serializable
{
   private int id;
   private String title;
   private String genre;
   private int year;
   private int rating;
   private Director director;
   private int duration;
   private String plot;

//   private ArrayList<Actor> actorsInMovie;
   
   public Movie(int id, String title, int rating)
   {
      this.setId(id);
      this.setTitle(title);
      this.setRating(rating);
   }
   public Movie(int id, String title, String genre, int year, int rating, Director director, int duration)
   {
      this.setId(id);
      this.setTitle(title);
      this.setGenre(genre);
      this.setYear(year);
      this.setRating(rating);
      this.setDirector(director);
      this.setDuration(duration);
      //      this.actorsInMovie = new ArrayList<Actor>(); 
      this.plot = "";
   }
   
   public int getId()
   {
      return this.id;
   }
   
   public void setId(int id)
   {
      this.id = id;
   }
   
   public String getTitle()
   {
      return this.title;
   }
   
   public void setTitle(String title)
   {
      this.title = title;
   }
   
   public String getGenre()
   {
      return this.genre;
   }
   
   public void setGenre(String genre)
   {
      this.genre = genre;
   }
   
   public int getYear()
   {
      return this.year;
   }
   
   public void setYear(int year)
   {
      this.year = year;
   }
   
   
      
   public int getRating()
   {
      return this.rating;
   }
   
   public void setRating(int rating)
   {
      this.rating = rating;
   }
   
   public int getDuration()
   {
      return this.duration;
   }
  
   public void setDuration(int duration)
   {
      this.duration = duration;
   }
    
   public Director getDirector()
   {
      return this.director;
   }
   public void setDirector(Director director)
   {
      this.director = director;
   }
   
    public String getPlot()
    {
	return this.plot;
    }

    public void setPlot(String plot)
    {
	this.plot = plot;
    }

    /*   public void addActor(Actor actor)
   {
       this.actorsInMovie.add(actor);
   }
   
    public Actor getActor(int i)
    {
     return actorsInMovie.get(i);
    }
    */
            
   public String toString()
   {
    
      return "ID: " + getId() + "\nTitle: " + getTitle() + "\nGenre: " +  getGenre() + "\nRating: " + getRating() + "\nYear: " + getYear() + "\nDirector: " + getDirector() + "\nDuration: " + getDuration() +  "\n\n";
   }
   
}
