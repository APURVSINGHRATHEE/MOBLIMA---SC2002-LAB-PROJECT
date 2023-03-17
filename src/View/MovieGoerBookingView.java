package View;

import Controller.KickOffController;
import Model.Cineplex.SeatRow;
import Model.Movie.*;
import Model.KickOff.SeatBooking;
import Model.KickOff.KickOff;

import Model.User.MovieGoerMenu;
import Model.User.MovieGoerType;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;

/**
 * Class that represents the Booking view for movie goers
 */
public class MovieGoerBookingView {
    /**
     * The Booking View Singleton
     */
    private static MovieGoerBookingView instance = null;
    
    /**
     * KickOff controller, essential for booking purposes
     */
    private static KickOffController KickOffController;
    
    
    /**
     * The moviegoer object
     */
    private static MovieGoerMenu moviegoer;
    
    /**
     * The movie object
     */
    private static MovieMain viewedMovie;
    
    /**
     * Sets date format as dd/M/yyyy
     */
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    
    /**
     * The list of showtimes for the currently viewed movie;
     */
    private static ArrayList<KickOff> viewedKickOff;
    
    /**
     * Creates a new Movie Goer View
     */
    protected MovieGoerBookingView() {
        MovieGoerType moviegoer = MovieGoerType.NORMAL;
        KickOffController = Controller.KickOffController.getInstance();
    }
    
    /**
     * Get the MovieGoerBookingView instance
     * @return the MovieGoerBookingView instance
     */
    public static MovieGoerBookingView getInstance() {
        if(instance==null) {
            instance = new MovieGoerBookingView();
        }
        return instance;
    }
    
    public void mainView(MovieMain viewedMovie) {
        int i, choice;
        Scanner sc = new Scanner(System.in);
        viewedKickOff = KickOffController
                .getKickOffForMovie(viewedMovie);
        
        if(viewedKickOff == null) {
            System.out.println("No showtimes for such movie!");
            return;
        }
        
        i = 0;
        while(true) {
             do {
            for (KickOff KickOff: viewedKickOff) {
            System.out.println("("+ i+1 +") " 
                    + KickOff.getCinema().getCinemaCode() 
                    + ", "
                    + sdf.format(KickOff.getStartDateTime()));
            System.out.println("(0) Back");
            }
            while (!sc.hasNextInt()) sc.next();
            choice = sc.nextInt();
            
            }while (choice < 0 || choice > i );

            if (choice == 0) {
                return;
            }
            
            seatformatBooking(viewedKickOff.get(i-1));
        }
    }
    
    public void seatformatBooking(KickOff KickOff) {
        Hashtable<Integer,SeatBooking[]> tempformat 
                = KickOff.getBookingLayout();
        SeatBooking[] tempBookingRow;
        Set<Integer> keys = tempformat.keySet();
        int cinemaSize = tempformat.get(0).length;
        int i;
        
        System.out.print(" ");
        for (i=0;i<cinemaSize;i++) {
            System.out.print(i);
        }
        
        for (Integer key: keys) {
            tempBookingRow = tempformat.get(key);
            System.out.print(SeatRow.intToRowLabel(key)+" ");
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
    
}
