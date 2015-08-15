package lk.ac.ucsc.webArc.assgnment.medicalInfo.impl.persistantImpl.hibernate;

import lk.ac.ucsc.webArc.assgnment.medicalInfo.api.beans.MedicalInfo;
import lk.ac.ucsc.webArc.assgnment.medicalInfo.api.exceptions.MedicalInfoException;
import lk.ac.ucsc.webArc.assgnment.medicalInfo.impl.beans.MedicalInfoBean;
import lk.ac.ucsc.webArc.assgnment.medicalInfo.impl.persistantImpl.MedicalInfoPersister;

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
 * This is hibernate implementation of the persistent api of the medicalInfo module
 * User: Hetti

 * Time: 3:07 PM
 */
public class MedicalInfoPersisterHibernate implements MedicalInfoPersister {
    private static final int BATCH_SIZE = 20;
    private static Logger logger = LoggerFactory.getLogger(MedicalInfoPersisterHibernate.class);
    private static Date lastUpdateTime;
    private SessionFactory sessionFactory;

    /**
     * set the real time and history session factories
     */
    public MedicalInfoPersisterHibernate(SessionFactory sessionFactory) {

        this.sessionFactory =sessionFactory;
    }



    /**
     * set the search session factory for dealer related medicalInfo searches
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
    public void update(MedicalInfoBean co) throws MedicalInfoException {
        Transaction tx;
        Session session = sessionFactory.openSession();
        try {
            if (co == null) {
                logger.error("Customer bean can't be null");
                throw new MedicalInfoException("Customer bean can't be null");
            }
            logger.debug("updating the Customer bean: {}", co);
            tx = session.beginTransaction();
            session.update(co);
            tx.commit();
            logger.debug("updating finished");
        } catch (Exception e) {
            logger.error("Customer bean can't update", e);
            throw new MedicalInfoException("Customer bean can't update", e);
        } finally {
            session.close();
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void insert(MedicalInfoBean co) throws MedicalInfoException {
        Transaction tx;
        Session session = sessionFactory.openSession();
        try {
            logger.debug("Inserting the Customer bean:{} ", co);
            if (co == null) {
                logger.error("Customer bean can't be null");
                throw new MedicalInfoException("Customer bean can't be null");
            }
            tx = session.beginTransaction();
            session.save(co);
            tx.commit();
            logger.debug("Inserting Customer bean finished");
        } catch (Exception e) {
            logger.error("problem in adding customer", e);
            throw new MedicalInfoException("problem in adding customer", e);
        } finally {
            session.close();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MedicalInfoBean load(String medicalInfoId) throws MedicalInfoException {
        MedicalInfoBean medicalInfoBean = null;
        Session session = sessionFactory.openSession();
        try {

            logger.info("Loading the medicalInfo with medicalInfo code:{} ", medicalInfoId);
            if (medicalInfoId == null || "".equals(medicalInfoId)) {
                logger.warn("Customer info provided not enough to load from DB");
                throw new MedicalInfoException("Customer bean can't be null");
            }
            String hql = "FROM lk.ac.ucsc.webArc.assgnment.medicalInfo.impl.beans.MedicalInfoBean C WHERE C.medicalInfoId = :chanInId";
            Query query = session.createQuery(hql);
            query.setParameter("chanInId", medicalInfoId);
            medicalInfoBean = (MedicalInfoBean) query.uniqueResult();

            logger.info("Loaded Customer:{}", medicalInfoBean);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new MedicalInfoException("Error in executing Hibernate Query for loading medicalInfo", e);
        } finally {
            session.close();
        }
        return medicalInfoBean;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<MedicalInfo> loadAll() {
        logger.info("Loading all the Customer from DB");
        List<MedicalInfo> cashObjectLst = new ArrayList<>();
        Session session = sessionFactory.openSession();
        try {
            String hql = "FROM lk.ac.ucsc.webArc.assgnment.medicalInfo.impl.beans.MedicalInfoBean";
            Query query = session.createQuery(hql);
            List results = query.list();

            for (Object cgb : results) {
                MedicalInfoBean medicalInfoBean = (MedicalInfoBean) cgb;
                cashObjectLst.add(medicalInfoBean);
            }
            logger.debug("Loaded channnelInfo list of size:{} and list:{}", cashObjectLst.size(), cashObjectLst);
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
    public void deleteFromDB(MedicalInfoBean medicalInfo) throws MedicalInfoException {
        logger.info("Deleting Customer bean ");
        Transaction tx;
        Session session = sessionFactory.openSession();
        try {
            if (medicalInfo == null) {
                throw new MedicalInfoException("The Customer to remove can't be null");
            }
            logger.debug("Deleting the Customer bean: {}", medicalInfo);
            tx = session.beginTransaction();
            session.delete(medicalInfo);
            tx.commit();
            logger.info("Deleting finished");
        } catch (Exception e) {
            logger.error("Customer bean can't delete", e);
            throw new MedicalInfoException("Error in Removing Customer From DB", e);
        } finally {
            session.close();
        }

    }

    @Override
    public List<MedicalInfo> getMedicineInfoForCustomer(String customerNumber) {
        List<MedicalInfo> cashObjectLst = new ArrayList<>();
        Session session = sessionFactory.openSession();
        try {
            String hql = "FROM lk.ac.ucsc.webArc.assgnment.medicalInfo.impl.beans.MedicalInfoBean C where C.patientNumber=:cusNum";
            Query query = session.createQuery(hql);
            query.setParameter("cusNum",customerNumber);
            List results = query.list();

            for (Object cgb : results) {
                MedicalInfoBean medicalInfoBean = (MedicalInfoBean) cgb;
                cashObjectLst.add(medicalInfoBean);
            }
            logger.debug("Loaded channnelInfo list of size:{} and list:{}", cashObjectLst.size(), cashObjectLst);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            session.close();
        }
        return cashObjectLst;
    }

    @Override
    public MedicalInfo getMedicalInfoForAppointment(String channelId) {
        MedicalInfo medicalInfo=null;
        Session session = sessionFactory.openSession();
        try {
            String hql = "FROM lk.ac.ucsc.webArc.assgnment.medicalInfo.impl.beans.MedicalInfoBean C where C.channelId =: chanId";
            Query query = session.createQuery(hql);
            query.setParameter("chanId",channelId);
            medicalInfo = (MedicalInfoBean)query.uniqueResult();

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            session.close();
        }
        return medicalInfo;
    }

    @Override
    public List<MedicalInfo> getMedicineInfoForDoctor(String doctorNumber) {
        List<MedicalInfo> cashObjectLst = new ArrayList<>();
        Session session = sessionFactory.openSession();
        try {
            String hql = "FROM lk.ac.ucsc.webArc.assgnment.medicalInfo.impl.beans.MedicalInfoBean C where C.doctorNumber=:docNum";
            Query query = session.createQuery(hql);
            query.setParameter("docNum",doctorNumber);
            List results = query.list();

            for (Object cgb : results) {
                MedicalInfoBean medicalInfoBean = (MedicalInfoBean) cgb;
                cashObjectLst.add(medicalInfoBean);
            }
            logger.debug("Loaded channnelInfo list of size:{} and list:{}", cashObjectLst.size(), cashObjectLst);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            session.close();
        }
        return cashObjectLst;
    }



	@Override
	public List<MedicalInfo> getMedicineInfoForCustomer(String customerNumber,
			String from, String to) {
		List<MedicalInfo> cashObjectLst = new ArrayList<>();
        Session session = sessionFactory.openSession();
        try {
            String hql = "FROM lk.ac.ucsc.webArc.assgnment.medicalInfo.impl.beans.MedicalInfoBean C where C.patientNumber=:cusNum and C.createDate BETWEEN :fromDate AND :toDate ";
            Query query = session.createQuery(hql);
            query.setParameter("cusNum",customerNumber);
            query.setParameter("fromDate",from);
            query.setParameter("toDate",to);
            List results = query.list();

            for (Object cgb : results) {
                MedicalInfoBean medicalInfoBean = (MedicalInfoBean) cgb;
                cashObjectLst.add(medicalInfoBean);
            }
            logger.debug("Loaded channnelInfo list of size:{} and list:{}", cashObjectLst.size(), cashObjectLst);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            session.close();
        }
        return cashObjectLst;

	}
}
