package lk.ac.ucsc.webArc.assgnment.doctor.impl.facade;


import lk.ac.ucsc.webArc.assgnment.doctor.api.DoctorLoginManager;
import lk.ac.ucsc.webArc.assgnment.doctor.api.DoctorManager;


import lk.ac.ucsc.webArc.assgnment.doctor.api.beans.Doctor;
import lk.ac.ucsc.webArc.assgnment.doctor.api.beans.LoginProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @author Hetti
 * @author AmilaS
 *         Date: 1/8/13
 *         Time: 5:02 PM
 *         this manager facade has the implementations of methods declared in doctorLoginManager interface along
 *         with facade objects needed in performing declared actions
 */
public class DoctorLoginManagerFacade implements DoctorLoginManager {
    private static Logger logger = LoggerFactory.getLogger(DoctorLoginManagerFacade.class);

    private static long count = 0;

    private DoctorManager doctorManagerFacade;
    private int allowedFailedAttempt;


    /**
     * set doctors manager facade for this login manager
     *
     * @param doctorManagerFacade of this class
     */
    public void setDoctorManagerFacade(DoctorManager doctorManagerFacade) {
        this.doctorManagerFacade = doctorManagerFacade;
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
    public String loginDoctor(String loginName, String password) {
        String reply=null;

        //validating loginName, password, channel, version for null and empty
        if (loginName == null || "".equals(loginName) || password == null || "".equals(password)) {
            logger.info("Login failed due to insufficient login information");
            reply ="Invalid Request";
            return reply;
        }
        logger.debug("Input parameter validation finished");
        String doctorNumber = "";
        try {
            Doctor doctor = doctorManagerFacade.getDoctorByDoctorNumber(loginName);
            logger.debug("loginDoctor : doctor : ", doctor);
            if (doctor == null) {
                logger.warn("Not able to find a doctor number for the given alias. Check whether doctor number appear at the" +
                        "alias column for the doctor without separate login alias");
                reply ="Invalid Request - Doctor Not Found";
                return reply;
            }


            doctorNumber = doctor.getDoctorNumber();
            LoginProfile loginProfile = doctor.getLoginProfile();

            logger.debug("Check the expiry date of the password");
            if (loginProfile.getPasswordExpDate() != null && loginProfile.getPasswordExpDate().before(new Date())) {
                logger.info("Password has expired");
                reply ="Invalid Login - Password expired";
                return reply;
            }
            logger.debug("check the status of the login profile");
            if (loginProfile.getStatus() != 1) {
                logger.info("doctor account has " + loginProfile.getStatus());
                reply ="Invalid Login - Inactive doctor";
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
                    reply ="Invalid Login - Inactive doctor";
                }
                doctor.setLoginProfile(loginProfile);
                doctorManagerFacade.updateDoctor(doctor);
                logger.debug("loginDoctor : doctor : ", doctor);
                return reply;
            } else {
                logger.info("Login success");
                loginProfile.setFailedAttemptCount(0);
                loginProfile.setLastLoginDate(new Date());
                reply ="SUCCESS";
                doctor.setLoginProfile(loginProfile);
                doctorManagerFacade.updateDoctor(doctor);
            }
        } catch (Exception e) {
            logger.warn("problem in loading doctor login profile", e);
            reply ="SYSTEM ERROR";
            return reply;
        } finally {
            logger.info("Store the login request with the status to DB");

        }
        return reply;
    }

    /**
     * @param smsPin
     * @param doctorNumber
     * @return
     */
    @Override
    public String isValidSMSPin(String smsPin, String doctorNumber) {
        logger.info("Validate the SMS pin -{} for doctor -{}", smsPin, doctorNumber);
        if (doctorNumber == null || "".equals(doctorNumber)) {
            return "-1";
        }

        try {
            Doctor doctor = doctorManagerFacade.getDoctorByDoctorNumber(doctorNumber);
            logger.debug("isValidSMSPin : doctor : ", doctor);
            if (doctor == null) {
                return "-1";
            }
            if (doctor.getLoginProfile().getSmsPinNumber() != null &&
                    doctor.getLoginProfile().getSmsPinNumber().trim().equals(smsPin.trim())) {
                return "-1";
            }
        } catch (Exception e) {
            logger.warn("problem in loading the doctor", e);
               return "-1";
        }
         return "1";
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public String changePassword(String doctorNumber, String oldPassword, String newPassword) {
        //check the change password type
        //if the type is to change Login Password only call the changeLoginPassword method
        //else for change the trading password do call the changeTradingPassword method

        //below is to validate the doctors change both login and trading passwords
        if (doctorNumber == null || "".equals(doctorNumber)) {    //check whether doctorNumber is null or empty
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
            Doctor doctor = doctorManagerFacade.getDoctorByDoctorNumber(doctorNumber);
            logger.debug("changePassword : doctor : ", doctor);
            if (doctor == null) {
                return "-1";
            }
            LoginProfile loginProfile = doctor.getLoginProfile();
            logger.debug("changePassword : loginProfile : ", loginProfile);
            if (!validatePassword(loginProfile.getPassword(), oldPassword)) {
                logger.debug("changePassword : invalid password");
                return "-1";
            }

            loginProfile.setPassword(newPassword);
            doctor.setLoginProfile(loginProfile);
            doctorManagerFacade.updateDoctor(doctor);
            return "1";
        } catch (Exception e) {
            logger.warn("Doctor not found with the given data");
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
            Doctor doctor = doctorManagerFacade.getDoctorByDoctorNumber(userName);
            if (doctor == null) {
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
