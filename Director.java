import java.io.Serializable;
import java.util.ArrayList;

public class Director extends Person implements Serializable
{
    //private ArrayList<Movie>directedMovies = new ArrayList<Movie>();
   
   public Director(String firstName)
   {
      super(firstName);
   }
   
    // public void addDirectedMovie(Movie m)
    //{
    // directedMovies.add(m);
    // }
   
}
