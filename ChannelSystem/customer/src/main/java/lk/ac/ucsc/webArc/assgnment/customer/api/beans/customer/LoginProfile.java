package lk.ac.ucsc.webArc.assgnment.customer.api.beans.customer;


import java.util.Date;

/**
 * User: Hetti

 * Time: 12:21 PM
 */

/**
 * this interface contains definitions of getters and setters of variables of login profile bean
 */
public interface LoginProfile {


    String getPassword();

    void setPassword(String password);

    String getLoginName();

    void setLoginName(String loginName);

    long getCustomerId();

    void setCustomerId(long customerId);

    int getFailedAttemptCount();

    void setFailedAttemptCount(int failedAttemptCount);

    Date getPasswordExpDate();

    void setPasswordExpDate(Date passwordExpDate);

    String getSmsPinNumber();

    void setSmsPinNumber(String smsOPTGenerateTime);

    Date getLastLoginDate();

    void setLastLoginDate(Date lastLoginDate);

    int getStatus();

    void setStatus(int status);
}