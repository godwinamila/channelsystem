package lk.ac.ucsc.webArc.assgnment.user.api;



/**
 * Service API use for managing the user login
 * User: Hetti
 * Date: 1/8/13
 * Time: 3:48 PM
 */
public interface UserLoginManager {



    /**
     * Method used to login a user.
     *
     * @param loginName       is the login name.  this can be login alias or user number
     * @param password        is the password
     * @return LoginReply
     */
    String loginUser(String loginName, String password);


    String isValidSMSPin(String smsPin, String userNumber);

    /**
     * Method used to change the user password and trading password
     *
     * @param userNumber
     * @param oldPassword
     * @param newPassword
     * @return status
     */
    String changePassword(String userNumber, String oldPassword, String newPassword);


    /**
     * method used to logout a user
     *
     * @param userName of the user
     * @return true if success false otherwise
     */
    boolean logOut(String userName);
}
