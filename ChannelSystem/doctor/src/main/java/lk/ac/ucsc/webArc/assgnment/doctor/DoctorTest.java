package lk.ac.ucsc.webArc.assgnment.doctor;

import lk.ac.ucsc.webArc.assgnment.doctor.api.DoctorFactory;
import lk.ac.ucsc.webArc.assgnment.doctor.api.DoctorManager;
import lk.ac.ucsc.webArc.assgnment.doctor.api.beans.Doctor;
import lk.ac.ucsc.webArc.assgnment.doctor.api.beans.LoginProfile;

import java.util.Date;

/**
 * Created by chamindah on 7/27/2015.
 */
public class DoctorTest {
    public static void main(String[] args) {
        try {
            DoctorFactory doctorFactory = DoctorFactory.getInstance();
            DoctorManager doctorManager = doctorFactory.getDoctorManager();
            Doctor doctor = doctorManager.getEmptyDoctor("Cus_00001");
            doctor.setAddress("634/38, Govinna Road, Athurugiriya");
            doctor.setDoctorId(1);
            doctor.setEmail("chamhetti@gmail.com");
            doctor.setFirstName("Chaminda");
            doctor.setGender("M");
            doctor.setIdCardNumber("79163686v");
            doctor.setLastName("Hettigoda");
            doctor.setMobile("0722308043");
            doctor.setOfficeTele("011234563");
            doctor.setTitle("Mr.");
            doctor.setSpeciality("Surgeon");
            LoginProfile loginProfile = doctorManager.getEmptyLoginProfile();
            loginProfile.setDoctorId(doctor.getDoctorId());
            loginProfile.setFailedAttemptCount(0);
            loginProfile.setLoginName(doctor.getEmail());
            loginProfile.setPassword("123");
            loginProfile.setPasswordExpDate(new Date());
            loginProfile.setSmsPinNumber("");
            loginProfile.setStatus(1);
            doctor.setLoginProfile(loginProfile);
            doctorManager.addDoctor(doctor);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
