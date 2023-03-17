package Model.User;

/**
 * Class that represents Staff account
 */

public class Staff extends ID {
    
    private static final long serialVersionUID = 12324134119L;
    
    /**
     * Create a Staff account with a user name and loginPass
     * @param loginName The user name of the person
     * @param loginPass The loginPass of the person
     */

    public Staff(String loginName, String loginPass) {
            super(loginName, loginPass);
    }

}
