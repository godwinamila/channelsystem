package lk.ac.ucsc.webArc.assgnment.customer.api.beans.customer;

/**
 * User: Hetti

 * Time: 12:24 PM
 */

/**
 * this interface contains getter setter definitions for variable declarations personal profile bean
 */
public interface PersonalProfile {

    /**
     * get the email of the customer
     *
     * @return String
     */
    String getEmail();

    /**
     * set the email of the customer
     *
     * @param email
     */
    void setEmail(String email);

    /**
     * get the mobile number of the customer
     *
     * @return  String
     */
    String getMobile();

    /**
     * set the mobile number of the customer
     *
     * @param mobile
     */
    void setMobile(String mobile);

    /**
     * get the office telephone number of the customer
     *
     * @return  String
     */
    String getOfficeTele();

    /**
     * set the office telephone number of the customer
     *
     * @param officeTele
     */
    void setOfficeTele(String officeTele);

    /**
     * get the nationality of the customer
     *
     * @return   String
     */
    String getNationality();

    /**
     * set the nationality of the customer
     *
     * @param nationality
     */
    void setNationality(String nationality);

    /**
     * get the gender of the customer
     *
     * @return String
     */
    String getGender();

    /**
     * set the gender of the customer
     *
     * @param gender
     */
    void setGender(String gender);

    /**
     * get the name of the customer this assume as the full name taken from back office
     *
     * @return  String
     */
    String getFirstName();

    /**
     * set the name of the customer.
     *
     * @param name
     */
    void setFirstName(String name);

    /**
     * get the title of the customer
     *
     * @return title
     */
    String getTitle();

    /**
     * set the title of the customer
     *
     * @param title
     */
    void setTitle(String title);

    /**
     * get the primary key of the customer
     *
     * @return customer Id
     */
    long getCustomerId();

    /**
     * set the primary key of the customer
     *
     * @param customerId
     */
    void setCustomerId(long customerId);

    /**
     * get the customer last name
     *
     * @return last name
     */
    String getLastName();

    /**
     * set the customer last name
     *
     * @param lastName
     */
    void setLastName(String lastName);

    /**
     * set the customer gcc type
     *
     * @param gccCustomer
     */
    void setGccCustomer(boolean gccCustomer);



}
