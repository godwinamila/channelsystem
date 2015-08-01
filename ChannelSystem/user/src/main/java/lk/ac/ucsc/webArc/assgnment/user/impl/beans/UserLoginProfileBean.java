package lk.ac.ucsc.webArc.assgnment.user.impl.beans;

import lk.ac.ucsc.webArc.assgnment.user.api.beans.UserLoginProfile;

import org.hibernate.search.annotations.Field;

import javax.persistence.Id;
import java.util.Date;

/**
 * User: Hetti

 * Time: 9:49 AM
 * <p/>
 * this class has the implementations of method declarations in login profile interface with relevant variables
 */

public class UserLoginProfileBean implements UserLoginProfile {


    private long userId;
    
    private String loginName;
    
    private String password;
    
    private int failedAttemptCount;
    
    private Date passwordExpDate;
    
    private String smsPinNumber;
    
    private Date lastLoginDate;
    
    private int status;

    /**
     * {@inheritDoc}
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPassword(String password) {
        this.password = password;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public String getLoginName() {
        return loginName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long getUserId() {
        return userId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setUserId(long userId) {
        this.userId = userId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getFailedAttemptCount() {
        return failedAttemptCount;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setFailedAttemptCount(int failedAttemptCount) {
        this.failedAttemptCount = failedAttemptCount;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date getPasswordExpDate() {
        return passwordExpDate;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPasswordExpDate(Date passwordExpDate) {
        this.passwordExpDate = passwordExpDate;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public String getSmsPinNumber() {
        return smsPinNumber;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setSmsPinNumber(String smsPinNumber) {
        this.smsPinNumber = smsPinNumber;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }


    @Override
    public int getStatus() {
        return status;
    }

    @Override
    public void setStatus(int status) {
        this.status = status;
    }
}
