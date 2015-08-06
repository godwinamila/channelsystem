package lk.ac.ucsc.webArc.assgnment.doctor.impl.persistantImpl;


import lk.ac.ucsc.webArc.assgnment.doctor.api.beans.Doctor;
import lk.ac.ucsc.webArc.assgnment.doctor.api.exceptions.DoctorException;
import lk.ac.ucsc.webArc.assgnment.doctor.impl.beans.DoctorBean;

import java.util.List;

/**
 * User: Hetti

 * Time: 3:10 PM
 *
 * here are method definitions for doctors persister,
 * method to delete doctors from database,
 * get last doctors id from database for the usage of sequence generator etc
 */
public interface DoctorPersister  {

    void update(DoctorBean co) throws DoctorException;

    void insert(DoctorBean co) throws DoctorException;

    DoctorBean load(String doctorNumber) throws DoctorException;

    List<Doctor> loadAll();

    void deleteFromDB(DoctorBean doctor) throws DoctorException;

    String getLastDoctorId() throws DoctorException;

    DoctorBean loadByDoctorNumber(String doctorNumber) throws DoctorException;

    List<Doctor> getDoctorByLastName(String lastName);

    List<Doctor> getDoctorBySpeciality(String speciality);
}
