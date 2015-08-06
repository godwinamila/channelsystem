package lk.ac.ucsc.webArc.assgnment.doctor.impl.facade;


import lk.ac.ucsc.webArc.assgnment.doctor.api.DoctorManager;

import lk.ac.ucsc.webArc.assgnment.doctor.api.beans.Doctor;
import lk.ac.ucsc.webArc.assgnment.doctor.api.beans.LoginProfile;

import lk.ac.ucsc.webArc.assgnment.doctor.api.exceptions.DoctorException;
import lk.ac.ucsc.webArc.assgnment.doctor.impl.beans.DoctorBean;
import lk.ac.ucsc.webArc.assgnment.doctor.impl.beans.LoginProfileBean;

import lk.ac.ucsc.webArc.assgnment.doctor.impl.persistantImpl.DoctorPersister;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * DoctorManagerFacade class implements all the services defined in the DoctorManager interface.
 * This class has a reference to the DoctorCacheFacade class that provides all the cache and physical storage related operations.
 * All the operations are done through DoctorCacheFacade.
 * <p/>
 * User: Hetti

 * Time: 2:34 PM
 */
public class DoctorManagerFacade implements DoctorManager {
    private static Logger logger = LoggerFactory.getLogger(DoctorManagerFacade.class);


    private DoctorPersister doctorPersister;

    public DoctorPersister getDoctorPersister() {
        return doctorPersister;
    }

    public void setDoctorPersister(DoctorPersister doctorPersister) {
        this.doctorPersister = doctorPersister;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Doctor getDoctorByDoctorNumber(String doctorNumber) throws DoctorException {
        logger.info("Getting the doctor with doctor number - {}", doctorNumber);
        if (doctorNumber == null || "".equalsIgnoreCase(doctorNumber)) {
            throw new DoctorException("Doctor Number Can't be Null or Empty");
        }
        return doctorPersister.loadByDoctorNumber(doctorNumber);
    }



    /**
     * {@inheritDoc}
     */
    @Override
    public Doctor getDoctorByLoginNameOrAlias(String loginName) throws DoctorException {
        logger.info("Getting the doctor with login name - {}", loginName);
        if (loginName == null || "".equalsIgnoreCase(loginName)) {
            throw new DoctorException("Doctor Login Name Can't be Null or Empty" );
        }

        try {
            return doctorPersister.loadByDoctorNumber(loginName);
        } catch (DoctorException e) {
            logger.debug("Error in getting doctor using login name or alias", e);
            throw new DoctorException("Error in getting doctor using login name or alias", e);
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long addDoctor(Doctor doctor) throws DoctorException {
        logger.info("Adding the doctor -{} to cache", doctor);
        if (doctor == null) {
            throw new DoctorException("Doctor can't be null");
        }
        validateDoctor(doctor);

        doctor.getLoginProfile().setDoctorId(doctor.getDoctorId());

        doctorPersister.insert((DoctorBean) doctor);
        logger.debug("Adding doctor process finished");
        return doctor.getDoctorId();

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateDoctor(Doctor doctor) throws DoctorException {
        logger.info("Update the doctor {}", doctor);
        if (doctor == null) {
            throw new DoctorException("doctor can't be null");
        }
        validateDoctor(doctor);

        doctorPersister.update((DoctorBean) doctor);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void markDoctorAsDeleted(String doctorNumber) throws DoctorException {
        logger.info("markDoctorAsDeleted : doctorNumber : ", doctorNumber);
        if (doctorNumber == null || "".equalsIgnoreCase(doctorNumber)) {
            throw new DoctorException("Doctor Number is Empty");
        }
        Doctor doctor =getDoctorByDoctorNumber(doctorNumber);
        doctorPersister.deleteFromDB((DoctorBean)doctor);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Doctor> getAllDoctors()  {
        logger.info("Getting All the Doctors");
        return doctorPersister.loadAll();
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Doctor getEmptyDoctor(String doctorNumber) {
        return new DoctorBean(doctorNumber);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public LoginProfile getEmptyLoginProfile() {
        return new LoginProfileBean();
    }



    /**
     * validate doctors number for null or empty
     *
     * @param doctor
     * @throws DoctorException
     */
    @Override
    public void validateDoctor(Doctor doctor) throws DoctorException {
        if (doctor.getDoctorNumber() == null || "".equals(doctor.getDoctorNumber())) {
            throw new DoctorException("Doctor Number Can't be Null or Empty" );
        }
    }

    @Override
    public List<Doctor> getDoctorByLastName(String lastName) {
        return doctorPersister.getDoctorByLastName(lastName);
    }

    @Override
    public List<Doctor> getDoctorBySpeciality(String speciality) {
        return doctorPersister.getDoctorBySpeciality(speciality);
    }
}
