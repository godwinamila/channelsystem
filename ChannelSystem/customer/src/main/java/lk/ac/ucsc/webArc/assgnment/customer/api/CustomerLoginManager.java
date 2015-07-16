package lk.ac.ucsc.webArc.assgnment.customer.api;



/**
 * Service API use for managing the channelInfo login
 * User: Hetti
 * Date: 1/8/13
 * Time: 3:48 PM
 */
public interface CustomerLoginManager {



    /**
     * Method used to login a channelInfo.
     *
     * @param loginName       is the login name.  this can be login alias or channelInfo number
     * @param password        is the password
     * @return LoginReply
     */
    String loginCustomer(String loginName, String password);


    String isValidSMSPin(String smsPin, String customerNumber);

    /**
     * Method used to change the channelInfo password and trading password
     *
     * @param customerNumber
     * @param oldPassword
     * @param newPassword
     * @return status
     */
    String changePassword(String customerNumber, String oldPassword, String newPassword);


    /**
     * method used to logout a channelInfo
     *
     * @param userName of the channelInfo
     * @return true if success false otherwise
     */
    boolean logOut(String userName);
}
