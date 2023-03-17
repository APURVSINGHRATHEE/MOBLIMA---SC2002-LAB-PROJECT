package Model.KickOff;
import Model.Movie.Type;
import Model.Cineplex.SeatType;
import Model.User.MovieGoerType;
import Helpful.Body;

/**
 * Class that represents the Ticket Type
 */

public class TicketType extends Body{
    
    private static final long serialVersionUID = 12324134119L;
    
    /**
     *  Name of Ticket Type;
     */
    private String ticketName;
    
    /**
     *  Name of Movie Type;
     */
    private Type type;
    
    /**
     *  Boolean of whether is it Holiday or Weekend;
     */
    private boolean isHoliday;
    
    /**
     *  Name of SeatType;
     */
    private SeatType seatType;
    
    /**
     *  Name of SeatType;
     */
    private MovieGoerType movieGoerType;
    
    /**
     * Price of Ticket Type;
     */
    private float price;
    
    /**
     * Create a TicketType
     * @param ticketName The name of ticket
     * @param type The movie type of ticket
     * @param isHoliday Whether it is Public Holiday or Weekend Ticket
     * @param seatType The seat type of ticket (eg. Couple seat, platinum..)
     * @param movieGoerType The Movie Goer Type (eg. Elderly, Student..)
     * @param price The price of ticket
     */
    public TicketType(String ticketName, Type type, boolean isHoliday
            , SeatType seatType,MovieGoerType movieGoerType, float price) {
        this.ticketName = ticketName;
        this.type = type;
        this.isHoliday = isHoliday;
        this.seatType = seatType;
        this.movieGoerType = movieGoerType;
        this.price = price;
    }

    
    /**
     * Returns the price of movie ticket
     * @return price of movie ticket
     */
    public float getPrice() {
        return price;
    }

    /**
     * @return the ticketName
     */
    public String getTicketName() {
        return ticketName;
    }

    /**
     * @param ticketName the ticketName to set
     */
    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

    /**
     * @return the movieType
     */
    public Type gettype() {
        return type;
    }

    /**
     * @param type the movieType to set
     */
    public void setMovieType(Type type) {
        this.type = type;
    }

    /**
     * @return the isHoliday
     */
    public boolean isIsHoliday() {
        return isHoliday;
    }

    /**
     * @param isHoliday the isHoliday to set
     */
    public void setIsHoliday(boolean isHoliday) {
        this.isHoliday = isHoliday;
    }

    /**
     * @return the SeatType
     */
    public String getSeatType() {
        return seatType.toString();
    }

    /**
     * @param SeatType the SeatType to set
     */
    public void setSeatType(SeatType SeatType) {
        this.seatType = SeatType;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * @return the movieGoerType
     */
    public MovieGoerType getMovieGoerType() {
        return movieGoerType;
    }

    /**
     * @param movieGoerType the movieGoerType to set
     */
    public void setMovieGoerType(MovieGoerType movieGoerType) {
        this.movieGoerType = movieGoerType;
    }
}
