package lk.ac.ucsc.webArc.assgnment.customer.impl.facade;


import lk.ac.ucsc.webArc.assgnment.customer.api.CustomerLoginManager;
import lk.ac.ucsc.webArc.assgnment.customer.api.CustomerManager;
import lk.ac.ucsc.webArc.assgnment.customer.api.beans.customer.Customer;
import lk.ac.ucsc.webArc.assgnment.customer.api.beans.customer.LoginProfile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @author Hetti
 * @author AmilaS
 *         Date: 1/8/13
 *         Time: 5:02 PM
 *         this manager facade has the implementations of methods declared in customerLoginManager interface along
 *         with facade objects needed in performing declared actions
 */
public class CustomerLoginManagerFacade implements CustomerLoginManager {
    private static Logger logger = LoggerFactory.getLogger(CustomerLoginManagerFacade.class);

    private static long count = 0;

    private CustomerManager customerManagerFacade;
    private int allowedFailedAttempt;


    /**
     * set customer manager facade for this login manager
     *
     * @param customerManagerFacade of this class
     */
    public void setCustomerManagerFacade(CustomerManager customerManagerFacade) {
        this.customerManagerFacade = customerManagerFacade;
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
    public String loginCustomer(String loginName, String password) {
        String reply=null;

        //validating loginName, password, channel, version for null and empty
        if (loginName == null || "".equals(loginName) || password == null || "".equals(password)) {
            logger.info("Login failed due to insufficient login information");
            reply ="Invalid Request";
            return reply;
        }
        logger.debug("Input parameter validation finished");
        String customerNumber = "";
        try {
            Customer customer = customerManagerFacade.getCustomerByCustomerNumber(loginName);
            logger.debug("loginCustomer : customer : ", customer);
            if (customer == null) {
                logger.warn("Not able to find a customer number for the given alias. Check whether customer number appear at the" +
                        "alias column for the customer without separate login alias");
                reply ="Invalid Request - Customer Not Found";
                return reply;
            }


            customerNumber = customer.getCustomerNumber();
            LoginProfile loginProfile = customer.getLoginProfile();

            logger.debug("Check the expiry date of the password");
            if (loginProfile.getPasswordExpDate() != null && loginProfile.getPasswordExpDate().before(new Date())) {
                logger.info("Password has expired");
                reply ="Invalid Login - Password expired";
                return reply;
            }
            logger.debug("check the status of the login profile");
            if (loginProfile.getStatus() != 2) {
                logger.info("customer account has " + loginProfile.getStatus());
                reply ="Invalid Login - Inactive customer";
                return reply;
            }


            logger.debug("validate the password");
            if (!validatePassword(loginProfile.getPassword(), password)) {
                logger.info("password does not match");
                loginProfile.setFailedAttemptCount(loginProfile.getFailedAttemptCount() + 1);
                if (loginProfile.getFailedAttemptCount() >= allowedFailedAttempt) {
                    logger.info("Maximum failed count exceed hence lock the account");
                    reply ="Invalid Login - Account Lock";
                    return reply;
                } else {
                    reply ="Invalid Login - Inactive customer";
                }
                customer.setLoginProfile(loginProfile);
                customerManagerFacade.updateCustomer(customer);
                logger.debug("loginCustomer : customer : ", customer);
                return reply;
            } else {
                logger.info("Login success");
                loginProfile.setFailedAttemptCount(0);
                loginProfile.setLastLoginDate(new Date());
                reply ="SUCCESS";
                customer.setLoginProfile(loginProfile);
                customerManagerFacade.updateCustomer(customer);
            }
        } catch (Exception e) {
            logger.warn("problem in loading customer login profile", e);
            reply ="SYSTEM ERROR";
            return reply;
        } finally {
            logger.info("Store the login request with the status to DB");

        }
        return reply;
    }

    /**
     * @param smsPin
     * @param customerNumber
     * @return
     */
    @Override
    public String isValidSMSPin(String smsPin, String customerNumber) {
        logger.info("Validate the SMS pin -{} for customer -{}", smsPin, customerNumber);
        if (customerNumber == null || "".equals(customerNumber)) {
            return "-1";
        }

        try {
            Customer customer = customerManagerFacade.getCustomerByCustomerNumber(customerNumber);
            logger.debug("isValidSMSPin : customer : ", customer);
            if (customer == null) {
                return "-1";
            }
            if (customer.getLoginProfile().getSmsPinNumber() != null &&
                    customer.getLoginProfile().getSmsPinNumber().trim().equals(smsPin.trim())) {
                return "-1";
            }
        } catch (Exception e) {
            logger.warn("problem in loading the customer", e);
               return "-1";
        }
         return "1";
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public String changePassword(String customerNumber, String oldPassword, String newPassword) {
        //check the change password type
        //if the type is to change Login Password only call the changeLoginPassword method
        //else for change the trading password do call the changeTradingPassword method

        //below is to validate the customer change both login and trading passwords
        if (customerNumber == null || "".equals(customerNumber)) {    //check whether customerNumber is null or empty
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
            Customer customer = customerManagerFacade.getCustomerByCustomerNumber(customerNumber);
            logger.debug("changePassword : customer : ", customer);
            if (customer == null) {
                return "-1";
            }
            LoginProfile loginProfile = customer.getLoginProfile();
            if(loginProfile.getStatus()!=1){
                return "Account is not Active";
            }
            logger.debug("changePassword : loginProfile : ", loginProfile);
            if (!validatePassword(loginProfile.getPassword(), oldPassword)) {
                logger.debug("changePassword : invalid password");
                return "-1";
            }

            loginProfile.setPassword(newPassword);
            customer.setLoginProfile(loginProfile);
            customerManagerFacade.updateCustomer(customer);
            return "1";
        } catch (Exception e) {
            logger.warn("Customer not found with the given data");
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
            Customer customer = customerManagerFacade.getCustomerByCustomerNumber(userName);
            if (customer == null) {
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

    @Override
    public void setFailCount(String userName) {
        try {
            Customer customer = customerManagerFacade.getCustomerByCustomerNumber(userName);
            if (customer == null) {
                return ;
            }
            LoginProfile loginProfile =customer.getLoginProfile();
            loginProfile.setFailedAttemptCount(loginProfile.getFailedAttemptCount()+1);
            if(loginProfile.getFailedAttemptCount()>3){
                loginProfile.setStatus(3);
            }
            customer.setLoginProfile(loginProfile);
            customerManagerFacade.updateCustomer(customer);
            return ;
        } catch (Exception e) {
            return ;
        }
    }
}
