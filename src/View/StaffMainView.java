package View;

import Model.Movie.MovieMain;
import Model.User.*;
import java.util.Scanner;

/**
 * View for staff to navigate admin options
 */
public class StaffMainView extends MovieMain{
    /**
     * The staff home view
     */
    private static StaffMainView instance = null;
    
    /**
     * The logged in staff
     */
    private Staff validatedStaff;
    
    protected StaffMainView() {
        validatedStaff = null; 
    }
    
    /**
     * Get the staff Home View instance
     * @return the staff Home View instance
     */
    public static StaffMainView getInstance() {
        if(instance==null) {
            instance = new StaffMainView();
        }
        return instance;
    }
    
    public void homeView(Staff validatedStaff) {
        this.validatedStaff = validatedStaff;
        Scanner sc = new Scanner(System.in);
        int choice;
        
        while (true) {
            System.out.println("Select your option:"
                + "\n(1) - Create/Modify Movie Listing"
                + "\n(2) - Create/Modify Cinema Showtimes"
                + "\n(3) - Configure System Settings"
                + "\n(0) - Log out");
            
            while (!sc.hasNextInt()) sc.next();
            choice = sc.nextInt();
            
            switch(choice) {
                case 1:
                    StaffMovieListingView.getInstance().movieListingView();
                    break;
                case 2:
                    StaffKickOffView.getInstance().KickOffiew();
                    break;
                case 3:
                    StaffSystemSettingsView.getInstance().systemSettingsView();
                    break;
                case 0:default:
                    return;
            }
        }
    }
}
