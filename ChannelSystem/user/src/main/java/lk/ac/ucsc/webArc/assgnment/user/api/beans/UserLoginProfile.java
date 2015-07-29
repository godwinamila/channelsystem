package lk.ac.ucsc.webArc.assgnment.user.api.beans;


import java.util.Date;

/**
 * User: Hetti
 * Time: 12:21 PM
 */

/**
 * this interface contains definitions of getters and setters of variables of login profile bean
 */
public interface UserLoginProfile {


    String getPassword();

    void setPassword(String password);

    String getLoginName();

    void setLoginName(String loginName);

    long getUserId();

    void setUserId(long userId);

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