package lk.ac.ucsc.webArc.assgnment.doctor.api;

import lk.ac.ucsc.webArc.assgnment.doctor.api.beans.Doctor;
import lk.ac.ucsc.webArc.assgnment.doctor.api.beans.LoginProfile;
import lk.ac.ucsc.webArc.assgnment.doctor.api.exceptions.DoctorException;


import java.util.List;

/**
 * This is the service interface to manage all the doctors related information.
 * All the doctors related operations should be done through this interface.
 * <p/>
 * User: Hetti

 * Time: 12:27 PM
 */
public interface DoctorManager {


    Doctor getDoctorByDoctorNumber(String doctorNumber) throws DoctorException;

    Doctor getDoctorByLoginNameOrAlias(String loginName) throws DoctorException;

    long addDoctor(Doctor doctor) throws DoctorException;

    void updateDoctor(Doctor doctor) throws DoctorException;

    void markDoctorAsDeleted(String doctorNumber) throws DoctorException;

    List<Doctor> getAllDoctors() ;

    Doctor getEmptyDoctor(String doctorNumber);

    LoginProfile getEmptyLoginProfile();

    void validateDoctor(Doctor doctor) throws DoctorException;

    List<Doctor> getDoctorByLastName(String lastName);

    List<Doctor> getDoctorBySpeciality(String speciality);
}

