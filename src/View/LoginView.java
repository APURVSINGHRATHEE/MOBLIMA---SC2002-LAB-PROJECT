package View;

import Controller.IDController;
import Model.User.*;
import java.util.Scanner;

/**
 * View for user to log in
 */
public class LoginView {
    /**
     * The login singleton
     */
    private static LoginView instance = null;
    
    /**
     * The username inputted
     */
    private String usernameInput;
    
    /**
     * The password inputted
     */
    private String passwordInput;
    
    /**
     * The ID object of the validated user
     */
    private ID validatedID;
    
    /**
     * Creates a new Login View
     */
    protected LoginView() {
        usernameInput = null;
        passwordInput = null;
    }
    
    public void login() {
        Scanner sc = new Scanner(System.in);
            
        while(true) {
            System.out.println("Please enter your username"
                    + ", type quit to exit application:");
            usernameInput = sc.nextLine();
            
            if ("quit".equals(usernameInput)) {
                return;
            }
            
            System.out.println("Please enter your password:");
            passwordInput = sc.nextLine();
        
            validatedID = IDController.getInstance().getUser(
                usernameInput);

            
            
            if (validatedID != null 
                && validatedID.getloginPass().equals(passwordInput) ) {
                
                if (validatedID.getClass() == Staff.class) {
                    StaffMainView.getInstance().homeView((Staff) validatedID);
                }
                else {
                   MovieGoerMainView.getInstance().mainView(
                           (MovieGoerMenu) validatedID);
                }
            } else {
                System.out.println("You have either entered wrong username or wrong password. Please try again.");
            }
        }
    }
    
    /**
     * Get the Login View instance
     * @return the Login View instance
     */
    public static  LoginView getInstance() {
        if(instance==null) {
            instance = new LoginView();
        }
        return instance;
    }
}
