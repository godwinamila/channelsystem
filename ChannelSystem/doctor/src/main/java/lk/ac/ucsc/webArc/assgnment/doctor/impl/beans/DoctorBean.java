package lk.ac.ucsc.webArc.assgnment.doctor.impl.beans;

import lk.ac.ucsc.webArc.assgnment.doctor.api.beans.Doctor;
import lk.ac.ucsc.webArc.assgnment.doctor.api.beans.LoginProfile;


/**
 * User: Hetti

 * Time: 9:27 AM
 * <p>
 * implementation fo doctors interface with relevant variables
 */
public class DoctorBean implements Doctor {
  

    private long doctorId;
   
    private String doctorNumber;
   
    private String title;
   
    private String firstName;
   
    private String gender;
   
    private String officeTele;
   
    private String mobile;
   
    private String email;
   
    private String lastName;
   
    private String idCardNumber;
   
    private String address;

    private String speciality;

    private LoginProfileBean loginProfile = new LoginProfileBean();


    /**
     * default constructor of doctors bean
     */
    public DoctorBean() {
    }

    /**
     * constructor with doctors number provided
     *
     * @param doctorNumber
     */
    public DoctorBean(String doctorNumber) {
        this.doctorNumber = doctorNumber;
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
    public String getDoctorNumber() {
        return doctorNumber;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setDoctorNumber(String doctorNumber) {
        this.doctorNumber = doctorNumber;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long getDoctorId() {
        return doctorId;
    }

    /**
     * set doctors id of the bean
     *
     * @param doctorId of the bean
     */
    @Override
    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
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

    @Override
    public String getSpeciality() {
        return speciality;
    }

    @Override
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
