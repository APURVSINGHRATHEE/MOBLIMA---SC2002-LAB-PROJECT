package Helpful;
import java.io.*;


public class Serialize {
    public static void serialize(Object dataObject,String dataName) throws IOException {
        
        FileOutputStream fileOut = new FileOutputStream(
                "storage/"+dataName+".ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(dataObject);
        out.close();
    }
}
