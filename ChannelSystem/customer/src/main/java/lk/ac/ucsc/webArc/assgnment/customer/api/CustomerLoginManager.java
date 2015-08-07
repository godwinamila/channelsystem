package lk.ac.ucsc.webArc.assgnment.customer.api;



/**
 * Service API use for managing the customer login
 * User: Hetti
 * Date: 1/8/13
 * Time: 3:48 PM
 */
public interface CustomerLoginManager {



    /**
     * Method used to login a customer.
     *
     * @param loginName       is the login name.  this can be login alias or customer number
     * @param password        is the password
     * @return LoginReply
     */
    String loginCustomer(String loginName, String password);


    String isValidSMSPin(String smsPin, String customerNumber);

    /**
     * Method used to change the customer password and trading password
     *
     * @param customerNumber
     * @param oldPassword
     * @param newPassword
     * @return status
     */
    String changePassword(String customerNumber, String oldPassword, String newPassword);


    /**
     * method used to logout a customer
     *
     * @param userName of the customer
     * @return true if success false otherwise
     */
    boolean logOut(String userName);

    void setFailCount(String userName);
}
