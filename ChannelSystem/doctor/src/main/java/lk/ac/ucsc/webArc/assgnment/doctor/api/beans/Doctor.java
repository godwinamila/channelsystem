package lk.ac.ucsc.webArc.assgnment.doctor.api.beans;

import lk.ac.ucsc.webArc.assgnment.doctor.impl.beans.LoginProfileBean;

/**
 * This is the service api which used to set and get the doctors related information
 *
 * User: Hetti

 * Time: 12:19 PM
 */
public interface Doctor {


    LoginProfile getLoginProfile();

    void setLoginProfile(LoginProfile loginProfile);

    String getDoctorNumber();

    void setDoctorNumber(String doctorNumber);

    long getDoctorId();

    void setDoctorId(long doctorId);

    String getTitle();

    void setTitle(String title);

    String getFirstName();

    void setFirstName(String firstName);

    String getGender();

    void setGender(String gender);

    String getOfficeTele();

    void setOfficeTele(String officeTele);

    String getMobile();

    void setMobile(String mobile);

    String getEmail();

    void setEmail(String email);

    String getLastName();

    void setLastName(String lastName);

    String getIdCardNumber();

    void setIdCardNumber(String idCardNumber);

    String getAddress();

    void setAddress(String address);

    void setLoginProfile(LoginProfileBean loginProfile);

    String getSpeciality();

    void setSpeciality(String speciality);
}
