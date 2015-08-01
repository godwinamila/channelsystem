package lk.ac.ucsc.webArc.assgnment.user.impl.beans;

import lk.ac.ucsc.webArc.assgnment.user.api.beans.User;
import lk.ac.ucsc.webArc.assgnment.user.api.beans.UserLoginProfile;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

import javax.persistence.Id;

/**
 * User: Hetti

 * Time: 9:27 AM
 * <p>
 * implementation fo user interface with relevant variables
 */
public class UserBean implements User {

    
    private long userId;
    
    private String userNumber;
    private int userType;
    
    private String title;
    
    private String firstName;
    
    private String gender;
    
    private String officeTele;
    
    private String mobile;
    
    private String email;
    
    private String lastName;
    
    private String idCardNumber;
    
    private String address;
    private UserLoginProfile loginProfile = new UserLoginProfileBean();


    /**
     * default constructor of user bean
     */
    public UserBean() {
    }

    /**
     * constructor with user number provided
     *
     * @param userNumber
     */
    public UserBean(String userNumber) {
        this.userNumber = userNumber;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserLoginProfile getLoginProfile() {
        return loginProfile;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setLoginProfile(UserLoginProfile loginProfile) {
        this.loginProfile = (UserLoginProfileBean) loginProfile;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public String getUserNumber() {
        return userNumber;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long getUserId() {
        return userId;
    }

    /**
     * set user id of the bean
     *
     * @param userId of the bean
     */
    @Override
    public void setUserId(long userId) {
        this.userId = userId;
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
    public int getUserType() {
        return userType;
    }

    @Override
    public void setUserType(int userType) {
        this.userType = userType;
    }
}
