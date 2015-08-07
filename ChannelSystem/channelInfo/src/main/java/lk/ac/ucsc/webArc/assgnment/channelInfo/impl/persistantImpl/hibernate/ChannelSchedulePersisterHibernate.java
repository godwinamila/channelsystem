package lk.ac.ucsc.webArc.assgnment.channelInfo.impl.persistantImpl.hibernate;

import lk.ac.ucsc.webArc.assgnment.channelInfo.api.beans.ChannelSchedule;
import lk.ac.ucsc.webArc.assgnment.channelInfo.api.exceptions.ChannelScheduleException;
import lk.ac.ucsc.webArc.assgnment.channelInfo.impl.beans.ChannelScheduleBean;
import lk.ac.ucsc.webArc.assgnment.channelInfo.impl.persistantImpl.ChannelSchedulePersister;
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
 * Created by chamindah on 8/6/2015.
 */
public class ChannelSchedulePersisterHibernate implements ChannelSchedulePersister {
    private static final int BATCH_SIZE = 20;
    private static Logger logger = LoggerFactory.getLogger(ChannelSchedulePersisterHibernate.class);
    private static Date lastUpdateTime;
    private SessionFactory sessionFactory;

    /**
     * set the real time and history session factories
     */
    public ChannelSchedulePersisterHibernate(SessionFactory sessionFactory) {

        this.sessionFactory =sessionFactory;
    }

    /**
     * set the search session factory for dealer related channelInfo searches
     *
     * @param searchSessionFactory
     */
    public void setSearchSessionFactory(SessionFactory searchSessionFactory) {
        this.sessionFactory = searchSessionFactory;
    }

    @Override
    public long insert(ChannelScheduleBean channelSchedule) {
        Transaction tx;
        Session session = sessionFactory.openSession();
        try {
            logger.debug("Inserting the channelSchedule bean:{} ", channelSchedule);
            if (channelSchedule == null) {
                logger.error("channelSchedule bean can't be null");
                throw new ChannelScheduleException("channelSchedule bean can't be null");
            }
            tx = session.beginTransaction();
            session.save(channelSchedule);
            tx.commit();
            logger.debug("Inserting channelSchedule bean finished");
        } catch (Exception e) {
            logger.error("problem in adding channelSchedule", e);
        } finally {
            session.close();
        }
        return channelSchedule.getChanScheId();
    }

    @Override
    public void update(ChannelScheduleBean channelSchedule) {
        Transaction tx;
        Session session = sessionFactory.openSession();
        try {
            if (channelSchedule == null) {
                logger.error("channelSchedule bean can't be null");
                throw new ChannelScheduleException("channelSchedule bean can't be null");
            }
            logger.debug("updating the ChannelSchedule bean: {}", channelSchedule);
            tx = session.beginTransaction();
            session.update(channelSchedule);
            tx.commit();
            logger.debug("updating finished");
        } catch (Exception e) {
            logger.error("ChannelSchedule bean can't update", e);
        } finally {
            session.close();
        }
    }

    @Override
    public void deleteFromDB(ChannelScheduleBean channelSchedule) {
        logger.info("Deleting channelSchedule bean ");
        Transaction tx;
        Session session = sessionFactory.openSession();
        try {
            if (channelSchedule == null) {
                throw new ChannelScheduleException("The channelSchedule to remove can't be null");
            }
            logger.debug("Deleting the channelSchedule bean: {}", channelSchedule);
            tx = session.beginTransaction();
            session.delete(channelSchedule);
            tx.commit();
            logger.info("Deleting finished");
        } catch (Exception e) {
            logger.error("channelSchedule bean can't delete", e);
        } finally {
            session.close();
        }
    }

    @Override
    public ChannelSchedule load(String channelScheduleId) {
        ChannelScheduleBean channelScheduleBean = null;
        Session session = sessionFactory.openSession();
        try {

            logger.info("Loading the channelSchedule with channelSchedule code:{} ", channelScheduleId);
            if (channelScheduleId == null || "".equals(channelScheduleId)) {
                logger.warn("ChannelSchedule info provided not enough to load from DB");
                throw new ChannelScheduleException("ChannelSchedule bean can't be null");
            }
            String hql = "FROM lk.ac.ucsc.webArc.assgnment.channelInfo.impl.beans.ChannelScheduleBean C WHERE C.chanScheId = :chanInId";
            Query query = session.createQuery(hql);
            query.setParameter("chanInId", channelScheduleId);
            channelScheduleBean = (ChannelScheduleBean) query.uniqueResult();

            logger.info("Loaded ChannelSchedule:{}", channelScheduleBean);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            session.close();
        }
        return channelScheduleBean;
    }

    @Override
    public List<ChannelSchedule> getChannelScheduleForDoctor(String doctorNumber) {
        logger.info("Loading all the ChannelSchedule from DB");
        List<ChannelSchedule> cashObjectLst = new ArrayList<>();
        Session session = sessionFactory.openSession();
        try {
            String hql = "FROM lk.ac.ucsc.webArc.assgnment.channelInfo.impl.beans.ChannelScheduleBean C where C.doctorNumber=:doctorNum";
            Query query = session.createQuery(hql);
            query.setParameter("doctorNum",doctorNumber);
            List results = query.list();

            for (Object cgb : results) {
                ChannelScheduleBean channelInfoBean = (ChannelScheduleBean) cgb;
                cashObjectLst.add(channelInfoBean);
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
    public List<ChannelSchedule> loadAll() {
        logger.info("Loading all the ChannelSchedule from DB");
        List<ChannelSchedule> cashObjectLst = new ArrayList<>();
        Session session = sessionFactory.openSession();
        try {
            String hql = "FROM lk.ac.ucsc.webArc.assgnment.channelInfo.impl.beans.ChannelScheduleBean";
            Query query = session.createQuery(hql);
            List results = query.list();

            for (Object cgb : results) {
                ChannelScheduleBean channelInfoBean = (ChannelScheduleBean) cgb;
                cashObjectLst.add(channelInfoBean);
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
