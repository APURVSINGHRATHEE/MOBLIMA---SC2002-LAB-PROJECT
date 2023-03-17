package Model.KickOff;
import java.util.*;

import Model.Cineplex.*;
import Model.Movie.*;
import Model.User.MovieGoerMenu;
import Helpful.Copy;
import Helpful.Body;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Class representing the kickoff of a particular
 * movie in a particular cinema
 */
public class KickOff extends Body {

    private static final long serialVersionUID = 12324134119L;
    
    /**
     * The cinema which shows the movie
     */
    protected Cinema cinema;
	
    /**
     * The movie being shown
     */
    protected MovieMain movie;
	
    /**
     * Hashtable to be referenced in order to build the booking layout
     */
    protected Hashtable<Integer, SeatRow> referenceLayout;
	
    /**
     * A Hashtable of seat booking layout for each row 
     */
    protected Hashtable<Integer, SeatBooking[]> bookingLayout;
    
    /**
     * List of ticket sold in this kickoff
     */
    protected ArrayList<Tickets> ticketSold;
    
    /**
     * Start time of the show time
     */
    private Date startDateTime;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy HH:mm:ss");
	
    /**
     * Create a Showtime for a movie in a cinema.
     * @param cinema    cinema where movie is showing
     * @param movie     movie being shown
     * @param startDateTime start date and time of the kickoff
     */
    public KickOff(Cinema cinema, MovieMain movie,Date startDateTime) throws
            IllegalArgumentException{
        try {
            this.referenceLayout 
                = (Hashtable<Integer, SeatRow>) Copy.copy(
                        cinema.getformat());
        
        }
        catch (IOException | ClassNotFoundException e) {
            throw new IllegalArgumentException(
                    "Check cinema if there is layout");
        }
        this.cinema = cinema;
        this.movie = movie;
        this.startDateTime = startDateTime;
        this.bookingLayout = generateLayout();
        this.ticketSold = new ArrayList<>();
    }
    
    /**
     * Create a Showtime for a movie in a cinema.
     * @param cinema    cinema where movie is showing
     * @param movie     movie being shown
     * @param startDateTime start date and time of the kickoff
     * @throws java.text.ParseException startDateTime string is incorrect
     */
    public KickOff(Cinema cinema, MovieMain movie,String startDateTime) throws
            IllegalArgumentException, ParseException{
        try {
            this.referenceLayout 
                = (Hashtable<Integer, SeatRow>) Copy.copy(
                        cinema.getformat());
        
        }
        catch (IOException | ClassNotFoundException e) {
            throw new IllegalArgumentException(
                    "Check cinema if there is layout");
        }
        this.cinema = cinema;
        this.movie = movie;
        this.startDateTime = sdf.parse(startDateTime);
        this.bookingLayout = generateLayout();
        this.ticketSold = new ArrayList<>();
    }
	
    /**
     * Create a seat booking layout, based on the 
     * reference layout.
     * @return layout of seat booking
     */
    private Hashtable<Integer, SeatBooking[]> generateLayout() {
        int i;
        
        Seat tempSeat,tempPairedSeat;
        Hashtable<Integer, SeatBooking[]> tempLayout = new Hashtable<>();
        Set<Integer> keys = referenceLayout.keySet();
        SeatRow seatrow;
        SeatBooking[] seatBooking;

	for (Integer key: keys) {
            seatrow = referenceLayout.get(key);
            seatBooking = new SeatBooking[seatrow.getWidth()];
            i = 0;
            
            for (CinemaBlock block: seatrow.getRow()) {
                if (block.getClass() == Seat.class) {
                    tempSeat = (Seat) block;
                    seatBooking[i] = new SeatBooking(
                            tempSeat.getSeatType());
                    if((tempSeat.getPairedSeat()!=null
                            && tempSeat.getPairedSeat().getXCoordinates()<i)){
                        seatBooking[i].setPairSeat(seatBooking[i-1]);
                        seatBooking[i-1].setPairSeat(seatBooking[i]);
                    }
                } 
                else {
                    seatBooking[i] = null;
                }
                i++;
            }
            tempLayout.put(key, seatBooking);
        }
        return tempLayout;
    }
	
    /**
     * Assigns a movie-goer to a particular seat.
     * @param booker    movie-goer to be assigned
     * @param row       row number of seat
     * @param col       column number of seat
     */
    public void bookSeat(MovieGoerMenu booker, int row, int col) {
        this.bookingLayout.get(row)[col].setMovieGoer(booker);
        this.bookingLayout.get(row)[col].getSeatType();

        if (this.bookingLayout.get(row)[col].getPairSeat() != null) {
                this.bookingLayout.get(row)[col].getPairSeat().setMovieGoer(booker);
        }
    }
	
    /**
     * Removes a movie-goer from a particular seat.
     * @param row     row number of seat
     * @param col     column number of seat
     */
    public void cancelSeat(int row, int col) {
        this.bookingLayout.get(row)[col].removeMovieGoer();

        if (this.bookingLayout.get(row)[col].getPairSeat() != null) {
                this.bookingLayout.get(row)[col].getPairSeat()
                        .removeMovieGoer();
        }
    }
    
    /**
     * Check if seat can be booked; checks if seat exists and if it is available
     * @param row     row number of seat
     * @param col     column number of seat
     * @return SeatBooking object of the chosen seat, null otherwise
     */
    public SeatBooking checkSeat(int row, int col) {
        
    	if (row >= bookingLayout.size() || col >= bookingLayout.get(row).length ||bookingLayout.get(row)[col].getMovieGoer()!=null) {
            return null;
        }
        else {
            return bookingLayout.get(row)[col];
        }
    }
	
    /**
     * Returns a Hashtable of booking layout.
     * @return Hashtable of booking layout
     */
    public Hashtable<Integer, SeatBooking[]> getBookingLayout() {
        return this.bookingLayout;
    }
    
    /**
     * Prints the booking layout for the KickOff
     * @param kickOff kickoff to print booking layout from
     */
    public static void printBookingLayout(KickOff kickOff) {
        SeatBooking[] tempBookingRow;
        Hashtable<Integer,SeatBooking[]> tempLayout 
                = kickOff.getBookingLayout();
        Set<Integer> keys = tempLayout.keySet();
        
        for (Integer key: keys) {
            tempBookingRow = tempLayout.get(key);
            for (SeatBooking seatBooking: tempBookingRow) {
                if(seatBooking != null) {
                    System.out.print(seatBooking.getSeatType().toIcon());
                }
                else {
                    System.out.print("   ");
                }
                
            }
            System.out.print("\n");
        }
    }
    
    /**
     * Prints the booking layout provided
     * @param bookingLayout bookingLayout to print
     */
    public static void printBookingLayout(
        Hashtable<Integer,SeatBooking[]> bookingLayout) {
        SeatBooking[] tempBookingRow;
        Hashtable<Integer,SeatBooking[]> tempLayout 
                = bookingLayout;
        Set<Integer> keys = tempLayout.keySet();
        
        for (Integer key: keys) {
            tempBookingRow = tempLayout.get(key);
            for (SeatBooking seatBooking: tempBookingRow) {
                if(seatBooking != null) {
                    System.out.print(seatBooking.getSeatType().toIcon());
                }
                else {
                    System.out.print("   ");
                }
                
            }
            System.out.print("\n");
        }
    }
    
    /**
     * Return the movie showing in this kickoff
     * @return movie showing in this kickoff
     */
    public MovieMain getMovie() {
        return movie;
    }
    
    /**
     * Return the cinema used by this kickoff
     * @return cinema used
     */
    public Cinema getCinema() {
        return cinema;
    }
    
    /**
     * Return the start date and time of the kickoff
     * @return start date and time of the kickoff
     */
    public Date getStartDateTime() {
        return startDateTime;
    }

    /**
     * @param cinema the cinema to set
     */
    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    /**
     * @param movie the movie to set
     */
    public void setMovie(MovieMain movie) {
        this.movie = movie;
    }
}
