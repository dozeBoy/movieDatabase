import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class FileWrapper
{
    public FileWrapper()
    {
    }
    

    public void writeToFile(Object movies, String filename) throws IOException
    {
	try
	{
	    FileOutputStream outputFile = new FileOutputStream(filename + ".ctlg");
	    ObjectOutputStream outputStream = new ObjectOutputStream(outputFile);
	    outputStream.writeObject(movies);
	    outputStream.close();
	}
	catch(FileNotFoundException e)
	{
	    System.out.println("File not found");
	}
    }

    public Object getObject(String filename) throws IOException, FileNotFoundException, ClassNotFoundException
    {
	Object list = null;
	FileInputStream inputFile = new FileInputStream(filename + ".ctlg");
	ObjectInputStream inputStream = new ObjectInputStream(inputFile);
	list =  inputStream.readObject();
	return list;
    }
}
