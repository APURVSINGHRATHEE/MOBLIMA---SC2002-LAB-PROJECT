package Helpful;
import java.io.*;

public class Deserialize {
    public static Object deserialize(String dataObjectName) throws IOException
            , ClassNotFoundException{
            FileInputStream fileIn = 
                new FileInputStream("storage/" 
                        + dataObjectName + ".ser");
            
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Object readDataObject = in.readObject();
            
            in.close();
            fileIn.close();
            
            return readDataObject;
    }
}