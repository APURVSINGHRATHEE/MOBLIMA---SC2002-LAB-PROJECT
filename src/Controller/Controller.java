package Controller;

import Helpful.Deserialize;
import Helpful.Serialize;
import java.io.File;
import java.io.IOException;

/**
 * Superclass to store common methods between the controllers
 */
public abstract class Controller {
    /**
     * Update the list
     */
    protected final void updateStoredList(Object list, String listName) {
        try {
            Serialize.serialize(list, listName);
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Retrieve the list
     */
    protected final Object getStoredList(String listName) {
        try {
            return Deserialize.deserialize(listName);
        }
        catch(IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
        
    }
    
    
    /**
     * Check if the serialized list exists
     * @param storedListName the name of the serialized file
     * @return true if exist, false otherwise
     */
    protected final boolean checkStoredListExist(String storedListName) {
        File tmpFile = new File("Storage/"+storedListName+".ser");
        return tmpFile.exists() && tmpFile.isFile();
    }
    
    /**
     * Reset the stored list
     */
    public abstract void resetList();
    
}
