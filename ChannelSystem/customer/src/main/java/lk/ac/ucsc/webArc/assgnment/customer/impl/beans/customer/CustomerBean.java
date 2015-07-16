package lk.ac.ucsc.webArc.assgnment.customer.impl.beans.customer;

import lk.ac.ucsc.webArc.assgnment.customer.api.beans.customer.Customer;
import lk.ac.ucsc.webArc.assgnment.customer.api.beans.customer.LoginProfile;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

import javax.persistence.Id;

/**
 * User: Hetti
 * Date: 12/26/12
 * Time: 9:27 AM
 * <p>
 * implementation fo channelInfo interface with relevant variables
 */
@Indexed
public class CustomerBean implements Customer {
    private static final int HASH_CODE_GENERATE_MULTIPLIER = 31;
    private static final int HASH_CODE_COMPARATOR = 32;
    @Id
    @Field
    private long customerId;
    @Field
    private String customerNumber;
    @Field
    private String title;
    @Field
    private String firstName;
    @Field
    private String gender;
    @Field
    private String officeTele;
    @Field
    private String mobile;
    @Field
    private String email;
    @Field
    private String lastName;
    @Field
    private String idCardNumber;
    @Field
    private String address;
    @IndexedEmbedded
    private LoginProfileBean loginProfile = new LoginProfileBean();


    /**
     * default constructor of channelInfo bean
     */
    public CustomerBean() {
    }

    /**
     * constructor with channelInfo number provided
     *
     * @param customerNumber
     */
    public CustomerBean(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LoginProfile getLoginProfile() {
        return loginProfile;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setLoginProfile(LoginProfile loginProfile) {
        this.loginProfile = (LoginProfileBean) loginProfile;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public String getCustomerNumber() {
        return customerNumber;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long getCustomerId() {
        return customerId;
    }

    /**
     * set channelInfo id of the bean
     *
     * @param customerId of the bean
     */
    @Override
    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }


    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String getOfficeTele() {
        return officeTele;
    }

    @Override
    public void setOfficeTele(String officeTele) {
        this.officeTele = officeTele;
    }

    @Override
    public String getMobile() {
        return mobile;
    }

    @Override
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getIdCardNumber() {
        return idCardNumber;
    }

    @Override
    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public void setLoginProfile(LoginProfileBean loginProfile) {
        this.loginProfile = loginProfile;
    }
}
