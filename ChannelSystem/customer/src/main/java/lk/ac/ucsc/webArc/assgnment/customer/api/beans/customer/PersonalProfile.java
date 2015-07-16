package lk.ac.ucsc.webArc.assgnment.customer.api.beans.customer;

/**
 * User: Hetti
 * Date: 12/26/12
 * Time: 12:24 PM
 */

/**
 * this interface contains getter setter definitions for variable declarations personal profile bean
 */
public interface PersonalProfile {

    /**
     * get the email of the channelInfo
     *
     * @return String
     */
    String getEmail();

    /**
     * set the email of the channelInfo
     *
     * @param email
     */
    void setEmail(String email);

    /**
     * get the mobile number of the channelInfo
     *
     * @return  String
     */
    String getMobile();

    /**
     * set the mobile number of the channelInfo
     *
     * @param mobile
     */
    void setMobile(String mobile);

    /**
     * get the office telephone number of the channelInfo
     *
     * @return  String
     */
    String getOfficeTele();

    /**
     * set the office telephone number of the channelInfo
     *
     * @param officeTele
     */
    void setOfficeTele(String officeTele);

    /**
     * get the nationality of the channelInfo
     *
     * @return   String
     */
    String getNationality();

    /**
     * set the nationality of the channelInfo
     *
     * @param nationality
     */
    void setNationality(String nationality);

    /**
     * get the gender of the channelInfo
     *
     * @return String
     */
    String getGender();

    /**
     * set the gender of the channelInfo
     *
     * @param gender
     */
    void setGender(String gender);

    /**
     * get the name of the channelInfo this assume as the full name taken from back office
     *
     * @return  String
     */
    String getFirstName();

    /**
     * set the name of the channelInfo.
     *
     * @param name
     */
    void setFirstName(String name);

    /**
     * get the title of the channelInfo
     *
     * @return title
     */
    String getTitle();

    /**
     * set the title of the channelInfo
     *
     * @param title
     */
    void setTitle(String title);

    /**
     * get the primary key of the channelInfo
     *
     * @return channelInfo Id
     */
    long getCustomerId();

    /**
     * set the primary key of the channelInfo
     *
     * @param customerId
     */
    void setCustomerId(long customerId);

    /**
     * get the channelInfo last name
     *
     * @return last name
     */
    String getLastName();

    /**
     * set the channelInfo last name
     *
     * @param lastName
     */
    void setLastName(String lastName);

    /**
     * set the channelInfo gcc type
     *
     * @param gccCustomer
     */
    void setGccCustomer(boolean gccCustomer);



}
