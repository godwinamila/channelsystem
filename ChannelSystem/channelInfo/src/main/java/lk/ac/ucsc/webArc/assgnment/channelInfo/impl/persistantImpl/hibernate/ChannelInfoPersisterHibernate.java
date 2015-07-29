package lk.ac.ucsc.webArc.assgnment.channelInfo.impl.persistantImpl.hibernate;

import lk.ac.ucsc.webArc.assgnment.channelInfo.api.beans.ChannelInfo;
import lk.ac.ucsc.webArc.assgnment.channelInfo.api.exceptions.ChannelInfoException;
import lk.ac.ucsc.webArc.assgnment.channelInfo.impl.beans.ChannelInfoBean;
import lk.ac.ucsc.webArc.assgnment.channelInfo.impl.persistantImpl.ChannelInfoPersister;

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
 * This is hibernate implementation of the persistent api of the channelInfo module
 * User: Hetti

 * Time: 3:07 PM
 */
public class ChannelInfoPersisterHibernate implements ChannelInfoPersister {
    private static final int BATCH_SIZE = 20;
    private static Logger logger = LoggerFactory.getLogger(ChannelInfoPersisterHibernate.class);
    private static Date lastUpdateTime;
    private SessionFactory sessionFactory;

    /**
     * set the real time and history session factories
     */
    public ChannelInfoPersisterHibernate(SessionFactory sessionFactory) {

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

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(ChannelInfoBean co) throws ChannelInfoException {
        Transaction tx;
        Session session = sessionFactory.openSession();
        try {
            if (co == null) {
                logger.error("ChannelInfo bean can't be null");
                throw new ChannelInfoException("ChannelInfo bean can't be null");
            }
            logger.debug("updating the ChannelInfo bean: {}", co);
            tx = session.beginTransaction();
            session.update(co);
            tx.commit();
            logger.debug("updating finished");
        } catch (Exception e) {
            logger.error("ChannelInfo bean can't update", e);
            throw new ChannelInfoException("ChannelInfo bean can't update", e);
        } finally {
            session.close();
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void insert(ChannelInfoBean co) throws ChannelInfoException {
        Transaction tx;
        Session session = sessionFactory.openSession();
        try {
            logger.debug("Inserting the ChannelInfo bean:{} ", co);
            if (co == null) {
                logger.error("ChannelInfo bean can't be null");
                throw new ChannelInfoException("ChannelInfo bean can't be null");
            }
            tx = session.beginTransaction();
            session.save(co);
            tx.commit();
            logger.debug("Inserting ChannelInfo bean finished");
        } catch (Exception e) {
            logger.error("problem in adding channelInfo", e);
            throw new ChannelInfoException("problem in adding channelInfo", e);
        } finally {
            session.close();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ChannelInfoBean load(String channelInfoId) throws ChannelInfoException {
        ChannelInfoBean channelInfoBean = null;
        Session session = sessionFactory.openSession();
        try {

            logger.info("Loading the channelInfo with channelInfo code:{} ", channelInfoId);
            if (channelInfoId == null || "".equals(channelInfoId)) {
                logger.warn("ChannelInfo info provided not enough to load from DB");
                throw new ChannelInfoException("ChannelInfo bean can't be null");
            }
            String hql = "FROM lk.ac.ucsc.webArc.assgnment.channelInfo.impl.beans.ChannelInfoBean C WHERE C.channelInfoId = :chanInId";
            Query query = session.createQuery(hql);
            query.setParameter("chanInId", channelInfoId);
            channelInfoBean = (ChannelInfoBean) query.uniqueResult();

            logger.info("Loaded ChannelInfo:{}", channelInfoBean);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ChannelInfoException("Error in executing Hibernate Query for loading channelInfo", e);
        } finally {
            session.close();
        }
        return channelInfoBean;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ChannelInfo> loadAll() {
        logger.info("Loading all the ChannelInfo from DB");
        List<ChannelInfo> cashObjectLst = new ArrayList<>();
        Session session = sessionFactory.openSession();
        try {
            String hql = "FROM lk.ac.ucsc.webArc.assgnment.channelInfo.impl.beans.ChannelInfoBean";
            Query query = session.createQuery(hql);
            List results = query.list();

            for (Object cgb : results) {
                ChannelInfoBean channelInfoBean = (ChannelInfoBean) cgb;
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




    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteFromDB(ChannelInfoBean channelInfo) throws ChannelInfoException {
        logger.info("Deleting ChannelInfo bean ");
        Transaction tx;
        Session session = sessionFactory.openSession();
        try {
            if (channelInfo == null) {
                throw new ChannelInfoException("The ChannelInfo to remove can't be null");
            }
            logger.debug("Deleting the ChannelInfo bean: {}", channelInfo);
            tx = session.beginTransaction();
            session.delete(channelInfo);
            tx.commit();
            logger.info("Deleting finished");
        } catch (Exception e) {
            logger.error("ChannelInfo bean can't delete", e);
            throw new ChannelInfoException("Error in Removing ChannelInfo From DB", e);
        } finally {
            session.close();
        }

    }







}
