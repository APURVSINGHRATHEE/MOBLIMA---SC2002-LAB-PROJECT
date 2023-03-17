package View;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;

import Controller.CineplexController;
import Controller.KickOffController;
import Model.Cineplex.Cinema;
import Model.Cineplex.CinemaBase;
import Model.Cineplex.CinemaBlock;
import Model.Movie.MovieMain;
import Model.Movie.Genre;
import Model.Movie.ShowingStatus;
import Model.KickOff.KickOff;

/**
 * View for staff to add showtime
 */
public class StaffKickOffView {
    /**
     * The staff show time view
     */
    private static StaffKickOffView instance = null;
    
    /**
     * The Hashtable of Movie and KickOff
     */
    protected Hashtable<MovieMain,ArrayList<KickOff>> KickOffList;
    
    /**
     * Get the staff show time instance
     * @return the staff show time instance
     */
    public static StaffKickOffView getInstance() {
        if(instance==null) {
            instance = new StaffKickOffView();
        }
        return instance;
    }
    
    /**
     * Ask for user choice at the staff 
     * show time view
     */
    public void KickOffiew() {
        KickOffList = KickOffController.getInstance().getKickOff();
    	int choice;

        Scanner sc = new Scanner(System.in);

        do {
                System.out.println("\n\n" +
                                "(1) View all Existing Show Times\r\n" +
                                "(2) Add Show Time for Existing Movie\r\n" + 
                                "(3) Add Show Time for New Movie\r\n" + 
                                "(4) Remove Show Time\r\n" + 
                                "(0) Back");
                System.out.print("Enter the number of your choice:");
        
         choice = sc.nextInt();
        switch(choice) {
            case 1: viewKickOff();
                    break;

            case 2: addKickOffExistingMovie();
                    break;

            case 3: addKickOffNewMovie();    		
                    break;

            case 4: removeShowtime();
                    break;

            default: return;
            }			
            }while(choice > 0 && choice <3);
            System.out.println("You have exited.");
            sc.close();
    }
		
    /**
     * Prints all the movies with their show times and cinema
     */
    public void viewKickOff() {
        int i = 0;
        Set<MovieMain> movies = KickOffList.keySet();
        for (MovieMain movie: movies) {
                System.out.println((i+1) + ". Movie title: " + movie.getMovieTitle());
                System.out.println("KickOff: ");
                for (KickOff KickOff: KickOffList.get(movie)) {
                        System.out.println("\t" + KickOff.getStartDateTime() + KickOff.getCinema().getCinemaCode());
                }
                i++;
        }
      
    }
	
    /**
     * Add show times to an existing movie at a given cinema
     */
    public void addKickOffExistingMovie() {
        int i = 0, j = 0;
        int choice;
        String input;
        Cinema cinema;
        Set<MovieMain> movies = KickOffList.keySet();
        ArrayList<MovieMain> movies2 = new ArrayList<MovieMain>();
        System.out.println(movies);
        Scanner sc2 = new Scanner(System.in);
        for (MovieMain movie: movies) {
                movies2.add(movie);
                System.out.println((i+1) + ". Movie title: " + movie.getMovieTitle());
                i++;
        }
        do{
                System.out.print("Enter the number of your choice:");
                choice = sc2.nextInt()-1;
        } while (choice < movies.size());

        MovieMain movie = movies2.get(choice);

        ArrayList<KickOff> movieKickOff = KickOffList.get(movie);

        System.out.println("Showtimes: ");
        for (KickOff KickOff: movieKickOff) {
                System.out.println((j+1) + ". " + KickOff.getStartDateTime() + " at " + KickOff.getCinema().getCinemaCode());
                j++;
        }
        do {
                System.out.print("Enter the cinema code: ");
                input = sc2.nextLine();
                cinema = CineplexController.getInstance().getCinemaByCode(input);
        } while (cinema != null);

        do {
                System.out.print("Enter the show time (/end to stop): (dd/M/yyyy HH:mm:ss)");
                input = sc2.nextLine();
                KickOffController.getInstance().addKickOff(cinema, movie, input);
        } while (input != "/end");

        KickOffList = KickOffController.getInstance().getKickOff();
        sc2.close();
		
    }
	
    /**
     * Add a new movie and it's show times at a given cinema
     */
    public void addKickOffNewMovie() {
        String input;
        Cinema cinema = new Cinema("B01", CinemaBase.LARGE);
        Scanner sc3 = new Scanner(System.in);
        MovieMain movie = new MovieMain();
        KickOff KickOff;
        for (int a=1; a<=6; a++) {
                StaffMovieListingView.getInstance().editMovieField(sc3, a, movie);
        }

        do {
                System.out.print("Enter the cinema code: ");
                input = sc3.nextLine();
                cinema = CineplexController.getInstance().getCinemaByCode(input);
        } while (cinema == null);

        // do {
                System.out.print("Enter the show time (/end to stop): (dd/M/yyyy HH:mm:ss)");
                input = sc3.nextLine();
                KickOffController.getInstance().addKickOff(cinema, movie, input);
        // } while (input != "/end");

        KickOffList = KickOffController.getInstance().getKickOff();
        sc3.close();
    }


    /**
     * Remove a show time of a movie in a cinema
     */
    public void removeShowtime() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy HH:mm:ss");
        int i = 0, j = 0;
        int choice;
        KickOff KickOff;
        MovieMain[] movies = (MovieMain[]) KickOffList.keySet().toArray();
        Scanner sc2 = new Scanner(System.in);
        for (MovieMain movie: movies) {
                System.out.println((i+1) + ". Movie title: " + movie.getMovieTitle());
                i++;
        }
        do{
                System.out.print("Enter the number of your choice:");
                choice = sc2.nextInt()-1;
        } while (choice > movies.length);

        MovieMain movie = movies[choice];

        ArrayList<KickOff> movieKickOff = KickOffList.get(movie);

        System.out.println("KickOff: ");
        for (KickOff show: movieKickOff) {
                System.out.println((j+1) + ". " + show.getStartDateTime() + " at " + show.getCinema().getCinemaCode());
                j++;
        }
        do {
                System.out.print("Enter the number of your choice: ");
                choice = sc2.nextInt()-1;
        } while (choice > movieKickOff.size());

        KickOff = movieKickOff.get(choice);


        KickOffController.getInstance().removeKickOff(KickOff.getCinema(), movie, sdf.format(movieKickOff.get(choice).getStartDateTime()));

        KickOffList = KickOffController.getInstance().getKickOff();
        sc2.close();
    }
	
	
    /**
     * Get the hashtable of movies and their showtimes
     * @return the hashtable of movies and their showtimes
     */
    public Hashtable<MovieMain, ArrayList<KickOff>> getShowtimeList() {
        return KickOffList;
    }
}
