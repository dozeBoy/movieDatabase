import java.io.Serializable;

public abstract class Person implements Serializable
{

   private String firstName;
    //   private String lastName;
    //private int age;
      
   public Person(String firstName)
   {
      setFirstName(firstName);
   }
   
   public void setFirstName(String firstName)
   {
      this.firstName = firstName;
   }
   
   public String getFirstName()
   {
      return this.firstName;
   }
    /*  Not yet implemented! 
   public void setLastName(String lastName)
   {
      this.lastName = lastName;
   }
   
   public String getLastName()
   {
      return this.lastName;
   }
   
   public int getAge()
   {
      return this.age;
   }  
   
   public void setAge(int age)
   {
      this.age = age;
   }
 */

   public String toString()
   {
       return getFirstName();
   }

}
