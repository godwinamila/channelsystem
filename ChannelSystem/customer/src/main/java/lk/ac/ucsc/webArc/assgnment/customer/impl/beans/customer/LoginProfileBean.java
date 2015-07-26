package lk.ac.ucsc.webArc.assgnment.customer.impl.beans.customer;

import lk.ac.ucsc.webArc.assgnment.customer.api.beans.customer.LoginProfile;
import org.hibernate.search.annotations.Field;

import javax.persistence.Id;
import java.util.Date;

/**
 * User: Hetti

 * Time: 9:49 AM
 * <p/>
 * this class has the implementations of method declarations in login profile interface with relevant variables
 */

public class LoginProfileBean implements LoginProfile {

    @Id
    @Field
    private long customerId;
    @Field
    private String loginName;
    @Field
    private String password;
    @Field
    private int failedAttemptCount;
    @Field
    private Date passwordExpDate;
    @Field
    private String smsPinNumber;
    @Field
    private Date lastLoginDate;
    @Field
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
    public long getCustomerId() {
        return customerId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setCustomerId(long customerId) {
        this.customerId = customerId;
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
