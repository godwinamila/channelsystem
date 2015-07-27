package lk.ac.ucsc.webArc.assgnment.doctor.api;



/**
 * Service API use for managing the doctors login
 * User: Hetti
 * Date: 1/8/13
 * Time: 3:48 PM
 */
public interface DoctorLoginManager {



    /**
     * Method used to login a doctors.
     *
     * @param loginName       is the login name.  this can be login alias or doctors number
     * @param password        is the password
     * @return LoginReply
     */
    String loginDoctor(String loginName, String password);


    String isValidSMSPin(String smsPin, String doctorNumber);

    /**
     * Method used to change the doctors password and trading password
     *
     * @param doctorNumber
     * @param oldPassword
     * @param newPassword
     * @return status
     */
    String changePassword(String doctorNumber, String oldPassword, String newPassword);


    /**
     * method used to logout a doctors
     *
     * @param userName of the doctors
     * @return true if success false otherwise
     */
    boolean logOut(String userName);
}
