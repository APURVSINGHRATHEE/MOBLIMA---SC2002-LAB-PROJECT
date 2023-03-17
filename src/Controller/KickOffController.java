package Controller;

import Model.Cineplex.Cinema;
import Model.Cineplex.SeatType;
import Model.Movie.MovieMain;
import Model.Movie.Type;
import Model.KickOff.*;
import Model.User.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Class that controls the showtime entity
 */
public class KickOffController extends Controller {
    /**
     * The Showtime controller singleton
     */
    private static KickOffController instance = null;
    
    /**
     * The Hashtable of Movie and Showtime
     */
    protected Hashtable<MovieMain,ArrayList<KickOff>> kickOffList;
    
    /**
     * Sets date format as dd/M/yyyy
     */
    SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
    SimpleDateFormat sdf2 = new SimpleDateFormat("dd/M/yyyy HH:mm:ss");
    
    /**
     * Creates a new calendar instance
     */
    private Calendar c = Calendar.getInstance();
	
    /**
     * Creates a array list of holidays(customizable)
     */
    private ArrayList<Date> holidayDates = new ArrayList<>();
    
    /**
     * The list of ticket type
     */
    private ArrayList<TicketType> ticketTypeList = new ArrayList<>();

    public KickOffController() {
        if (checkStoredListExist("KickOffList")) {
            kickOffList = 
                    (Hashtable<MovieMain,ArrayList<KickOff>>) getStoredList(
                            "KickOffList");
            holidayDates = 
                    (ArrayList<Date>) getStoredList(
                            "holidayDates");
        }
        else {
            kickOffList = new Hashtable<>();
            holidayDates = new ArrayList<>();
        }
    }
    
    /**
     * Get the KickOff Controller
     * @return the KickOff Controller
     */
    public static KickOffController getInstance() {
        if(instance==null) {
            instance = new KickOffController();
        }
        return instance;
    }
    
    /**
     * Reset the stored list
     */
    @Override
    public void resetList() {
        kickOffList = new Hashtable<>();
        holidayDates = new ArrayList<Date>();
    }
    
    /**
     * Checks if the input date is a holiday (Weekends or in Holiday Dates)
     * @param stringDate Date of the showDate in String format ("dd/M/yyyy")
     * @return true if date is holiday, false otherwise
     * @exception ParseException used to throw an exception if String is in wrong format
     */
    public boolean checkHoliday(String stringDate) throws ParseException {
        Date showDate = sdf.parse(stringDate);
        c.setTime(showDate);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
            switch (dayOfWeek) {
                case Calendar.SATURDAY:
                    return true;
                case Calendar.SUNDAY:
                    return true;
                default:
                    for (int i=0; i<holidayDates.size(); i++){
                        if (holidayDates.get(i).equals(showDate))
                            return true;
                    }
                    return false; // only returns if all other returns are not reached
            }
    }
	
    /**
     * Adds a new holiday into the list of holidays
     * @param stringDate Date of the showDate in String format ("dd/M/yyyy")
     */
    public boolean addHoliday(String stringDate) {
        try {
            Date showDate = sdf.parse(stringDate);
            holidayDates.add(showDate);
            super.updateStoredList(holidayDates,"HolidayDates");
            return true;
        }
        catch (ParseException e) {
            return false;
        }
        
    }
	
    /**
     * Remove a holiday from the list of holidays
     * @param stringDate Date of the showDate in String format ("dd/M/yyyy")
     * @return true if successful, false otherwise
     */
    public boolean removeHoliday(String stringDate) {
        int i;
        
        try {
            Date showDate = sdf.parse(stringDate);
            for (i=0;i<holidayDates.size();i++){
                if (holidayDates.get(i).equals(showDate)){
                    holidayDates.remove(i);
                    super.updateStoredList(holidayDates,"HolidayDates");
                    return true;
                }
            }   
            return false;
        }
        catch(ParseException e){
            return false;
        }
    }
    
    /**
     * Get the list of holiday dates
     * @return the list of holiday dates
     */
    public ArrayList<Date> getHolidays() {
        return holidayDates;
    }
    
    /**
     * Add new Ticket Type to list
     * @param ticketName The name of ticket
     * @param movieType The movie type of ticket
     * @param isHoliday Whether it is Public Holiday or Weekend Ticket
     * @param seatType The seat type of ticket (eg. Couple seat, platinum..)
     * @param movieGoerType The Movie Goer Type (eg. Elderly, Student..)
     * @param price The price of ticket
     * @return returns the newly added ticket type if successful, null otherwise
     */
    public TicketType addTicketType(String ticketName, Type movieType, 
            boolean isHoliday, SeatType seatType, MovieGoerType movieGoerType, 
            float price) {
        
        TicketType tempTicketType = new TicketType(ticketName,movieType, isHoliday, 
                seatType, movieGoerType, price);
        
        ticketTypeList.add(tempTicketType);
        super.updateStoredList(ticketTypeList,"TicketTypeList");
        return tempTicketType;
    }
    
    /**
     * Get the array list of ticket types   
     * @return the array list of ticket types   
     */
    public ArrayList<TicketType> getAllTicketTypes(){
        return ticketTypeList;
    }
    
    /**
     * Get Ticket type of specific ticketName
     * @param ticketName the name of ticket
     * @return the ticket type of the ticket, null if ticket type cannot be found
     */
    public TicketType getTicketType (String ticketName){
        int i;
        for (i=0;i<ticketTypeList.size();i++){
            if (ticketTypeList.get(i).getTicketName().equals(ticketName)){
                return ticketTypeList.get(i);
            }
        }
        return null;
    }
    
    /**
     * Returns the ticket type of the movie ticket based on the parameters
     * @param movieType movie type of the ticket
     * @param isHoliday whether ticket is on holidays
     * @param seatType seat type of ticket
     * @param movieGoerType movie goer type of ticket
     * @return the ticket type of the movie ticket
     */
    public TicketType getTicketTypeFromCombination(Type movieType, 
            boolean isHoliday, SeatType seatType, MovieGoerType movieGoerType) {
        int i;
        
        for (TicketType ticketType: ticketTypeList) {
            if (ticketType.gettype().equals(movieType)) {
                
            }
        }
        return null;
    }
    
    /**
     * Edit Ticket Pricing of specific ticketName
     * @param ticketName The name of ticket
     * @param price The price of ticket
     * @return returns true if successful, false otherwise
     */
    public boolean editTicketPricing (String ticketName, float price){
        int i;
        for (i=0;i<ticketTypeList.size();i++){
            if (ticketTypeList.get(i).getTicketName().equals(ticketName)){
                ticketTypeList.get(i).setPrice(price);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Remove Specified Ticket Type from List
     * @param ticketName The name of ticket
     * @return return true if success, false otherwise
     */
    public boolean removeTicketType (String ticketName){
        int i;
        for (i=0;i<ticketTypeList.size();i++){
            if (ticketTypeList.get(i).getTicketName().equals(ticketName)){
                ticketTypeList.remove(i);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Add showtime (using string)
     * @param cinema the cinema to be used
     * @param movie the movie to be screened
     * @param startDateTime the start date and time of the movie
     * @return true if success, false otherwise
     */
    public KickOff addKickOff(Cinema cinema, MovieMain movie,String startDateTime) {
        ArrayList<KickOff> tempArray;
        KickOff tempKickOff;
        
        try {
            Date parsedDateTime = sdf2.parse(startDateTime);
            tempKickOff = new KickOff(cinema,movie,parsedDateTime);
        }
        catch (IllegalArgumentException | ParseException e) {
            return null;
        }

        if (!(kickOffList.containsKey(movie))) {
            tempArray = new ArrayList<>();
            tempArray.add(tempKickOff);
            kickOffList.put(movie,tempArray);
            return tempKickOff;
        }
        else {
            tempArray = kickOffList.get(movie);
            tempArray.add(tempKickOff);
            return tempKickOff;
        }
    }
    
    /**
     * Add showtime (using date object)
     * @param cinema the cinema to be used
     * @param movie the movie to be screened
     * @param startDateTime the start date and time of the movie
     * @return newly added showtime object if successful, null otherwise
     */
    public KickOff addKickOff(Cinema cinema, MovieMain movie,Date startDateTime) {
        ArrayList<KickOff> tempArray;
        KickOff tempKickOff;
        
        tempKickOff = new KickOff(cinema,movie,startDateTime);
        
        if (!(kickOffList.containsKey(movie))) {
            tempArray = new ArrayList<>();
            tempArray.add(tempKickOff);
            kickOffList.put(movie,tempArray);
            return tempKickOff;
        }
        else {
            tempArray = kickOffList.get(movie);
            tempArray.add(tempKickOff);
            return tempKickOff;
        }
    }
    
    /**
     * Remove Showtime based on combination of parameters
     * @param cinema the cinema used
     * @param movie the movie screened
     * @param startDateTime the start time of the showtime
     * @return true if success, false otherwise
     */
    public boolean removeKickOff(Cinema cinema, MovieMain movie
            , String startDateTime) {
                KickOff tempShowtime = getKickOff(cinema,movie,startDateTime);
        if(tempShowtime != null) {
            kickOffList.get(movie).remove(tempShowtime);
            return true;
        }
        return false;
    }
    
    /**
     * Get the showtime with the combination provided (using string)
     * @param cinema the cinema used
     * @param movie the movie screened
     * @param startDateTime the start time of the showtime
     * @return the showtime if true, null otherwise
     */
    public KickOff getKickOff(Cinema cinema, MovieMain movie
            , String startDateTime) {
        if (!(kickOffList.containsKey(movie))) {
            return null;
        }
        else {
            for (KickOff KickOff: kickOffList.get(movie)) {
                try {
                    if (KickOff.getCinema().equals(cinema) &&
                        KickOff.getStartDateTime().equals(
                                sdf2.parse(startDateTime))) {
                        return KickOff;
                    } else {
                        return null;
                    }
                }
                catch (ParseException e) {
                    return null;
                }
            }
            return null;
        }
    }
    
    /**
     * Get the showtime with the combination provided (using date)
     * @param cinema the cinema used
     * @param movie the movie screened
     * @param startDateTime the start time of the showtime
     * @return the showtime if true, null otherwise
     */
    public KickOff getKickOff(Cinema cinema, MovieMain movie
            , Date startDateTime) {
        if (!(kickOffList.containsKey(movie))) {
            return null;
        }
        else {
            for (KickOff showtime: kickOffList.get(movie)) {
                if (showtime.getCinema().equals(cinema) &&
                    showtime.getStartDateTime().equals(
                            startDateTime)) {
                    return showtime;
                } else {
                    return null;
                }
            }
        }
        return null;
    }
    
    
    /**
     * Book the seat in the showtime
     * @param movieGoer the booker of the seat
     * @param KickOff the KickOff to book
     * @param row the row of the seat to book
     * @param col the column of the seat to book
     * @return true if successful, false otherwise
     */
    public boolean bookSeat(MovieGoerMenu movieGoer, KickOff KickOff
            , int row, int col) {
        SeatBooking tempSeat, tempSeatPair;
        
        tempSeat = KickOff.checkSeat(row, col);
        if(tempSeat!=null) {
            KickOff.bookSeat(movieGoer, row, col);
            KickOff.getMovie().addTicketsales();
            movieGoer.addBookingHistory(KickOff, tempSeat);
            tempSeatPair = KickOff.checkSeat(row, col).getPairSeat();
            if (tempSeatPair != null) {
                KickOff.getMovie().addTicketsales();
                movieGoer.addBookingHistory(KickOff, tempSeatPair);
            }
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Get the Hashtable of movies and their showtimes
     * @return the Hashtable of movies and their showtimes
     */
    public Hashtable<MovieMain, ArrayList<KickOff>> getKickOff() {
        return kickOffList;
    }
    
    /**
     * Get the Hashtable of movies and their showtimes
     * @param movie the movie to search showtime for
     * @return list of showtimes
     */
    public ArrayList<KickOff> getKickOffForMovie(
            MovieMain movie) {
        return kickOffList.get(movie);
    }
}