package lk.ac.ucsc.webArc.assgnment.doctor.impl.persistantImpl.hibernate;

import lk.ac.ucsc.webArc.assgnment.doctor.api.beans.Doctor;
import lk.ac.ucsc.webArc.assgnment.doctor.api.exceptions.DoctorException;
import lk.ac.ucsc.webArc.assgnment.doctor.impl.beans.DoctorBean;
import lk.ac.ucsc.webArc.assgnment.doctor.impl.persistantImpl.DoctorPersister;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This is hibernate implementation of the persistent api of the doctors module
 * User: Hetti

 * Time: 3:07 PM
 */
public class DoctorPersisterHibernate implements DoctorPersister {
    private static final int BATCH_SIZE = 20;
    private static Logger logger = LoggerFactory.getLogger(DoctorPersisterHibernate.class);
    private static Date lastUpdateTime;
    private SessionFactory sessionFactory;

    /**
     * set the real time and history session factories
     */
    public DoctorPersisterHibernate(SessionFactory sessionFactory) {

        this.sessionFactory =sessionFactory;
    }



    /**
     * set the search session factory for dealer related doctors searches
     *
     * @param searchSessionFactory
     */
    public void setSearchSessionFactory(SessionFactory searchSessionFactory) {
        this.sessionFactory = searchSessionFactory;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(DoctorBean co) throws DoctorException {
        Transaction tx;
        Session session = sessionFactory.openSession();
        try {
            if (co == null) {
                logger.error("Doctor bean can't be null");
                throw new DoctorException("Doctor bean can't be null");
            }
            logger.debug("updating the Doctor bean: {}", co);
            tx = session.beginTransaction();
            session.update(co);
            tx.commit();
            logger.debug("updating finished");
        } catch (Exception e) {
            logger.error("Doctor bean can't update", e);
            throw new DoctorException("Doctor bean can't update", e);
        } finally {
            session.close();
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void insert(DoctorBean co) throws DoctorException {
        Transaction tx;
        Session session = sessionFactory.openSession();
        try {
            logger.debug("Inserting the Doctor bean:{} ", co);
            if (co == null) {
                logger.error("Doctor bean can't be null");
                throw new DoctorException("Doctor bean can't be null");
            }
            tx = session.beginTransaction();
            session.save(co);
            tx.commit();
            logger.debug("Inserting Doctor bean finished");
        } catch (Exception e) {
            logger.error("problem in adding doctor", e);
            throw new DoctorException("problem in adding doctor", e);
        } finally {
            session.close();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DoctorBean load(String doctorNumber) throws DoctorException {
        DoctorBean doctorBean = null;
        Session session = sessionFactory.openSession();
        try {

            logger.info("Loading the doctor with doctor code:{} ", doctorNumber);
            if (doctorNumber == null || "".equals(doctorNumber)) {
                logger.warn("Doctor info provided not enough to load from DB");
                throw new DoctorException("Doctor bean can't be null");
            }
            String hql = "FROM lk.ac.ucsc.webArc.assgnment.doctor.impl.beans.DoctorBean C WHERE C.doctorNumber = :doctor";
            Query query = session.createQuery(hql);
            query.setParameter("doctor", doctorNumber);
            doctorBean = (DoctorBean) query.uniqueResult();

            logger.info("Loaded Doctor:{}", doctorBean);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new DoctorException("Error in executing Hibernate Query for loading doctor", e);
        } finally {
            session.close();
        }
        return doctorBean;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Doctor> loadAll() {
        logger.info("Loading all the Doctor from DB");
        List<Doctor> cashObjectLst = new ArrayList<>();
        Session session = sessionFactory.openSession();
        try {
            String hql = "FROM lk.ac.ucsc.webArc.assgnment.doctor.impl.beans.DoctorBean";
            Query query = session.createQuery(hql);
            List results = query.list();

            for (Object cgb : results) {
                DoctorBean doctorBean = (DoctorBean) cgb;
                cashObjectLst.add(doctorBean);
            }
            logger.debug("Loaded Doctors list of size:{} and list:{}", cashObjectLst.size(), cashObjectLst);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            session.close();
        }
        return cashObjectLst;
    }




    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteFromDB(DoctorBean doctor) throws DoctorException {
        logger.info("Deleting Doctor bean ");
        Transaction tx;
        Session session = sessionFactory.openSession();
        try {
            if (doctor == null) {
                throw new DoctorException("The Doctor to remove can't be null");
            }
            logger.debug("Deleting the Doctor bean: {}", doctor);
            tx = session.beginTransaction();
            session.delete(doctor);
            tx.commit();
            logger.info("Deleting finished");
        } catch (Exception e) {
            logger.error("Doctor bean can't delete", e);
            throw new DoctorException("Error in Removing Doctor From DB", e);
        } finally {
            session.close();
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getLastDoctorId() throws DoctorException {
        logger.info("Loading all the Doctor codes from DB");
        Session session = sessionFactory.openSession();
        try {
            String hql = "select max(C.doctorId) FROM lk.ac.ucsc.webArc.assgnment.doctor.impl.beans.DoctorBean C ";
            Query query = session.createQuery(hql);

            Long results = (Long) query.uniqueResult();
            if (results != null) {
                return results.toString();
            } else {
                return "0";
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new DoctorException("Error in Getting Last Doctor Id", e);
        } finally {
            session.close();
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DoctorBean loadByDoctorNumber(String doctorNumber) throws DoctorException {
        DoctorBean doctorBean;
        Session session = sessionFactory.openSession();
        try {
            logger.info("Loading the doctor with doctor Id:{} ", doctorNumber);
            String hql = "FROM lk.ac.ucsc.webArc.assgnment.doctor.impl.beans.DoctorBean C WHERE C.doctorNumber = :doctorNumber";
            Query query = session.createQuery(hql);
            query.setParameter("doctorNumber", doctorNumber);
            doctorBean = (DoctorBean) query.uniqueResult();

            logger.info("Loaded Doctor:{}", doctorBean);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new DoctorException("Error in Getting Doctor from Doctor Number", e);
        } finally {
            session.close();
        }
        return doctorBean;
    }


    @Override
    public List<Doctor> getDoctorByLastName(String lastName) {
        List<Doctor> doctorList=new ArrayList<>();
        Session session = sessionFactory.openSession();
        try {
            logger.info("Loading the doctor with lastName:{} ", lastName);
            String hql = "FROM lk.ac.ucsc.webArc.assgnment.doctor.impl.beans.DoctorBean C WHERE C.lastName = :lastName";
            Query query = session.createQuery(hql);
            query.setParameter("lastName", lastName);
            doctorList = query.list();

            logger.info("Loaded Doctor:{}", doctorList);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            session.close();
        }
        return doctorList;
    }

    @Override
    public List<Doctor> getDoctorBySpeciality(String speciality) {
        List<Doctor> doctorList=new ArrayList<>();
        Session session = sessionFactory.openSession();
        try {
            logger.info("Loading the doctor with speciality:{} ", speciality);
            String hql = "FROM lk.ac.ucsc.webArc.assgnment.doctor.impl.beans.DoctorBean C WHERE C.speciality = :speciality";
            Query query = session.createQuery(hql);
            query.setParameter("speciality", speciality);
            doctorList = query.list();

            logger.info("Loaded Doctor:{}", doctorList);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);

        } finally {
            session.close();
        }
        return doctorList;
    }
}
