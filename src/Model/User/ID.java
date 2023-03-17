package Model.User;

import Helpful.Body;

/**
 * Class that represents the accounts that can log in to the system
 */

public class ID extends Body {

    private static final long serialVersionUID = 12324134119L;
    
    /**
     *  username of Account;
     */
    protected String loginName;

    /**
     *  password of Account;
     */
    protected String loginPass;

    /**
     * Create a account with loginName and loginPass
     * @param loginName The loginName of the account
     * @param loginPass The loginPass of the account
     */

    public ID(String loginName, String loginPass) {
             this.loginName = loginName;
             this.loginPass = loginPass;
    }

    /**
     * Sets the loginName of the account
     * @param loginName the loginName to be set to
     */

    public void setloginName(String loginName) {
            this.loginName = loginName;
    }

    /**
     * Sets the loginPass of the account
     * @param loginPass the loginPass to be set to
     */

    public void setloginPass(String loginPass) {
            this.loginPass = loginPass;
    }

    /**
     * Gets the loginName of the account
     * @return the loginName of the account
     */

    public String getloginName() {
            return loginName;
    }

    /**
     * Gets the loginPass of the account
     * @return loginPass of the account
     */

    public String getloginPass() {
            return loginPass;
    }
}
