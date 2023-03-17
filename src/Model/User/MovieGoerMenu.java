package Model.User;

import Model.KickOff.SeatBooking;
import Model.KickOff.KickOff;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Class that represents MovieGoer account
 */

public class MovieGoerMenu extends ID{
    
    private static final long serialVersionUID = 12324134119L;
    
    /**
     * Type of the MovieGoer
     */
    private MovieGoerType type;
    
    /**
     * Name of the MovieGoer
     */
    private String name;
    
    /**
     * MobileNumber of the MovieGoer
     */
    private int mobileNumber;
    
    /**
     * Email of the MovieGoer
     */
    private String email;
    
    /**
     * The booking history of the user
     */
    private Hashtable<KickOff,ArrayList<SeatBooking>> bookingHistory;
    
    /**
     * Create a MovieGoer account with a user name and loginPass
     * @param loginName The user name of the MovieGoer
     * @param loginPass The loginPass of the MovieGoer
     * @param type The type of the MovieGoer
     * @param name The name of the MovieGoer
     * @param mobileNumber The mobile number of the MovieGoer
     * @param email The email of the MovieGoer
     */
    public MovieGoerMenu (String loginName,String loginPass, MovieGoerType type
            ,String name, int mobileNumber, String email){
        super(loginName, loginPass);
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.type = type;
        this.bookingHistory = new Hashtable<>();
    }
    
    /**'
     * Sets age of MovieGoer
     * @param type type of the MovieGoer
     */
    public void setType(MovieGoerType type) {
    	this.type = type;
    }
    
    /**
     * Gets age of MovieGoer
     * @return the type of this MovieGoer
     */
    public MovieGoerType getType() {
    	return type;
    }
    
    /**
     * Gets name of MovieGoer
     * @return the name of the MovieGoer
     */
    public String getName() {
        return name;
    }
    
    /**
     * Add booking history to user
     */
    public void addBookingHistory(KickOff kickOff
            , SeatBooking seatbooking) {
    	ArrayList<SeatBooking> tempList;
        
        if(bookingHistory.containsKey(kickOff)) {
            bookingHistory.get(kickOff).add(seatbooking);
        }
        else {
            tempList = new ArrayList<>();
            tempList.add(seatbooking);
            bookingHistory.put(kickOff, tempList);
        }
    }
}

