package lk.ac.ucsc.webArc.assgnment.user.impl.facade;


import lk.ac.ucsc.webArc.assgnment.user.api.UserLoginManager;
import lk.ac.ucsc.webArc.assgnment.user.api.UserManager;
import lk.ac.ucsc.webArc.assgnment.user.api.beans.User;
import lk.ac.ucsc.webArc.assgnment.user.api.beans.UserLoginProfile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @author Hetti
 * @author AmilaS
 *         Date: 1/8/13
 *         Time: 5:02 PM
 *         this manager facade has the implementations of methods declared in userLoginManager interface along
 *         with facade objects needed in performing declared actions
 */
public class UserLoginManagerFacade implements UserLoginManager {
    private static Logger logger = LoggerFactory.getLogger(UserLoginManagerFacade.class);

    private static long count = 0;

    private UserManager userManagerFacade;
    private int allowedFailedAttempt;


    /**
     * set user manager facade for this login manager
     *
     * @param userManagerFacade of this class
     */
    public void setUserManagerFacade(UserManager userManagerFacade) {
        this.userManagerFacade = userManagerFacade;
    }

    /**
     * set allowed failed attempt in this manager facade
     *
     * @param allowedFailedAttempt of this class
     */
    public void setAllowedFailedAttempt(int allowedFailedAttempt) {
        this.allowedFailedAttempt = allowedFailedAttempt;
    }




    /**
     * {@inheritDoc}
     */
    @Override
    public String loginUser(String loginName, String password) {
        String reply=null;

        //validating loginName, password, channel, version for null and empty
        if (loginName == null || "".equals(loginName) || password == null || "".equals(password)) {
            logger.info("Login failed due to insufficient login information");
            reply ="Invalid Request";
            return reply;
        }
        logger.debug("Input parameter validation finished");
        String userNumber = "";
        try {
            User user = userManagerFacade.getUserByUserNumber(loginName);
            logger.debug("loginUser : user : ", user);
            if (user == null) {
                logger.warn("Not able to find a user number for the given alias. Check whether user number appear at the" +
                        "alias column for the user without separate login alias");
                reply ="Invalid Request - User Not Found";
                return reply;
            }


            userNumber = user.getUserNumber();
            UserLoginProfile loginProfile = user.getLoginProfile();

            logger.debug("Check the expiry date of the password");
            if (loginProfile.getPasswordExpDate() != null && loginProfile.getPasswordExpDate().before(new Date())) {
                logger.info("Password has expired");
                reply ="Invalid Login - Password expired";
                return reply;
            }
            logger.debug("check the status of the login profile");
            if (loginProfile.getStatus() != 1) {
                logger.info("user account has " + loginProfile.getStatus());
                reply ="Invalid Login - Inactive user";
                return reply;
            }


            logger.debug("validate the password");
            if (!validatePassword(loginProfile.getPassword(), password)) {
                logger.info("password does not match");
                loginProfile.setFailedAttemptCount(loginProfile.getFailedAttemptCount() + 1);
                if (loginProfile.getFailedAttemptCount() >= allowedFailedAttempt) {
                    logger.info("Maximum failed count exceed hence lock the account");
                    reply ="Invalid Login - Accout Lock";
                    return reply;
                } else {
                    reply ="Invalid Login - Inactive user";
                }
                user.setLoginProfile(loginProfile);
                userManagerFacade.updateUser(user);
                logger.debug("loginUser : user : ", user);
                return reply;
            } else {
                logger.info("Login success");
                loginProfile.setFailedAttemptCount(0);
                loginProfile.setLastLoginDate(new Date());
                reply ="SUCCESS";
                user.setLoginProfile(loginProfile);
                userManagerFacade.updateUser(user);
            }
        } catch (Exception e) {
            logger.warn("problem in loading user login profile", e);
            reply ="SYSTEM ERROR";
            return reply;
        } finally {
            logger.info("Store the login request with the status to DB");

        }
        return reply;
    }

    /**
     * @param smsPin
     * @param userNumber
     * @return
     */
    @Override
    public String isValidSMSPin(String smsPin, String userNumber) {
        logger.info("Validate the SMS pin -{} for user -{}", smsPin, userNumber);
        if (userNumber == null || "".equals(userNumber)) {
            return "-1";
        }

        try {
            User user = userManagerFacade.getUserByUserNumber(userNumber);
            logger.debug("isValidSMSPin : user : ", user);
            if (user == null) {
                return "-1";
            }
            if (user.getLoginProfile().getSmsPinNumber() != null &&
                    user.getLoginProfile().getSmsPinNumber().trim().equals(smsPin.trim())) {
                return "-1";
            }
        } catch (Exception e) {
            logger.warn("problem in loading the user", e);
               return "-1";
        }
         return "1";
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public String changePassword(String userNumber, String oldPassword, String newPassword) {
        //check the change password type
        //if the type is to change Login Password only call the changeLoginPassword method
        //else for change the trading password do call the changeTradingPassword method

        //below is to validate the user change both login and trading passwords
        if (userNumber == null || "".equals(userNumber)) {    //check whether userNumber is null or empty
            return "-1";
        }
        if (oldPassword == null || "".equals(oldPassword)) { //validate oldPassword for null or empty
            return "-1";
        }
        if (newPassword == null || "".equals(newPassword)) { //validate newPassword for null or empty
            return "-1";
        }

        if (oldPassword.equals(newPassword)) {  //check whether oldPassword equals newPassword
            return "-1";
        }
        try {
            User user = userManagerFacade.getUserByUserNumber(userNumber);
            logger.debug("changePassword : user : ", user);
            if (user == null) {
                return "-1";
            }
            UserLoginProfile loginProfile = user.getLoginProfile();
            logger.debug("changePassword : loginProfile : ", loginProfile);
            if (!validatePassword(loginProfile.getPassword(), oldPassword)) {
                logger.debug("changePassword : invalid password");
                return "-1";
            }

            loginProfile.setPassword(newPassword);
            user.setLoginProfile(loginProfile);
            userManagerFacade.updateUser(user);
            return "1";
        } catch (Exception e) {
            logger.warn("User not found with the given data");
            return "-1";
        }

    }



    /**
     * generates SMSPin with with random number and given size as string
     *
     * @param size
     * @return
     */
    private static String generateSMSPin(long size) {
        double val = Math.random();
        long lRet = Math.round(val * size);
        return String.valueOf(lRet);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean logOut(String userName) {
        logger.info("Logging out the user with userName -{}", userName);
        if (userName == null || "".equals(userName)) {
            return false;
        }
        try {
            User user = userManagerFacade.getUserByUserNumber(userName);
            if (user == null) {
                return false;
            }

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean validatePassword(String ourPassword, String theirPassword) {
        boolean result = ourPassword.equalsIgnoreCase(theirPassword);    // todo: review MD5 hash comparison
        return result;
    }

}
