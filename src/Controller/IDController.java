package Controller;

import java.util.ArrayList;
import Model.User.*;

/**
 * Class that Control the Accounts
 */

public class IDController extends Controller{
    private ArrayList<ID> IDList;
    
    /**
     * The movie controller singleton
     */
    private static IDController instance = null;
    
    /**
     * Creates a new movie controller
     */
    protected IDController() {
        if (checkStoredListExist("IDList")) {
            IDList = (ArrayList<ID>) getStoredList("IDList");
        }
        else {
            IDList = new ArrayList<>();
        }
    }
    
    /**
     * Reset the stored list
     */
    @Override
    public void resetList() {
        IDList = new ArrayList<>();
    }
    
    
    /**
     * Get the movie controller instance
     * @return the movie controller
     */
    public static IDController getInstance() {
        if(instance==null) {
            instance = new IDController();
        }
        return instance;
    }
    
    /**
     * Add new MovieGoer to system
     * @param loginName loginName of movie goer
     * @param loginPass loginPass of movie goer
     * @param type the type of movie goer
     * @param name name of the movie goer
     * @param mobileNumber mobile number of the movie goer
     * @param email email of the movie goer
     */
    public void addMovieGoer(String loginName, String loginPass,
            MovieGoerType type, String name, int mobileNumber, String email){
       IDList.add(new MovieGoerMenu(loginName, loginPass, 
               type, name, mobileNumber, email));
       super.updateStoredList(IDList,"IDList");
    }
    
    /**
     * Add new staff to the system
     * @param loginName loginName of staff
     * @param loginPass loginPass of staff
     */
    public void addStaff(String loginName, String loginPass){
       IDList.add(new Staff(loginName, loginPass));
       super.updateStoredList(IDList,"IDList");
    }
    
    /**
     * Remove account from system
     * @param loginName The loginName of Movie
     * @return returns true if success, false otherwise
     */
    public boolean removeAccount(String loginName){
        int i;
        for (i=0;i<IDList.size();i++){
            if (IDList.get(i).getloginName().equals(loginName)){
            	IDList.remove(i);
                super.updateStoredList(IDList,"IDList");
                return true;
            }
        }
        return false;
    }
    
    /**
     * Get Account Object
     * @param loginName the name of the user
     * @return the account object
     */
    public ID getUser(String loginName){
        int i;
        for (i=0;i<IDList.size();i++){
            if (IDList.get(i).getloginName().equals(loginName)){
            	return IDList.get(i);
            }
        }
        return null;
    }

}
    
    