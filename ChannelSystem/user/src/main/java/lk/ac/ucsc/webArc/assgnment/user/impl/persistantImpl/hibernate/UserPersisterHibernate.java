package lk.ac.ucsc.webArc.assgnment.user.impl.persistantImpl.hibernate;




import lk.ac.ucsc.webArc.assgnment.user.api.beans.User;
import lk.ac.ucsc.webArc.assgnment.user.api.exceptions.UserException;
import lk.ac.ucsc.webArc.assgnment.user.impl.beans.UserBean;
import lk.ac.ucsc.webArc.assgnment.user.impl.persistantImpl.UserPersister;
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
 * This is hibernate implementation of the persistent api of the user module
 * User: Hetti

 * Time: 3:07 PM
 */
public class UserPersisterHibernate implements UserPersister {
    private static final int BATCH_SIZE = 20;
    private static Logger logger = LoggerFactory.getLogger(UserPersisterHibernate.class);
    private static Date lastUpdateTime;
    private SessionFactory sessionFactory;

    /**
     * set the real time and history session factories
     */
    public UserPersisterHibernate(SessionFactory sessionFactory) {

        this.sessionFactory =sessionFactory;
    }



    /**
     * set the search session factory for dealer related user searches
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
    public void update(UserBean co) throws UserException {
        Transaction tx;
        Session session = sessionFactory.openSession();
        try {
            if (co == null) {
                logger.error("User bean can't be null");
                throw new UserException("User bean can't be null");
            }
            logger.debug("updating the User bean: {}", co);
            tx = session.beginTransaction();
            session.update(co);
            tx.commit();
            logger.debug("updating finished");
        } catch (Exception e) {
            logger.error("User bean can't update", e);
            throw new UserException("User bean can't update", e);
        } finally {
            session.close();
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void insert(UserBean co) throws UserException {
        Transaction tx;
        Session session = sessionFactory.openSession();
        try {
            logger.debug("Inserting the User bean:{} ", co);
            if (co == null) {
                logger.error("User bean can't be null");
                throw new UserException("User bean can't be null");
            }
            tx = session.beginTransaction();
            session.save(co);
            tx.commit();
            logger.debug("Inserting User bean finished");
        } catch (Exception e) {
            logger.error("problem in adding user", e);
            throw new UserException("problem in adding user", e);
        } finally {
            session.close();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserBean load(String userNumber) throws UserException {
        UserBean userBean = null;
        Session session = sessionFactory.openSession();
        try {

            logger.info("Loading the user with user code:{} ", userNumber);
            if (userNumber == null || "".equals(userNumber)) {
                logger.warn("User info provided not enough to load from DB");
                throw new UserException("User bean can't be null");
            }
            String hql = "FROM lk.ac.ucsc.oms.user.implGeneral.beans.user.UserBean C WHERE C.userNumber = :user";
            Query query = session.createQuery(hql);
            query.setParameter("user", userNumber);
            userBean = (UserBean) query.uniqueResult();

            logger.info("Loaded User:{}", userBean);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new UserException("Error in executing Hibernate Query for loading user", e);
        } finally {
            session.close();
        }
        return userBean;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> loadAll() {
        logger.info("Loading all the User from DB");
        List<User> cashObjectLst = new ArrayList<>();
        Session session = sessionFactory.openSession();
        try {
            String hql = "FROM lk.ac.ucsc.oms.user.implGeneral.beans.user.UserBean";
            Query query = session.createQuery(hql);
            List results = query.list();

            for (Object cgb : results) {
                UserBean userBean = (UserBean) cgb;
                cashObjectLst.add(userBean);
            }
            logger.debug("Loaded Users list of size:{} and list:{}", cashObjectLst.size(), cashObjectLst);
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
    public void deleteFromDB(UserBean user) throws UserException {
        logger.info("Deleting User bean ");
        Transaction tx;
        Session session = sessionFactory.openSession();
        try {
            if (user == null) {
                throw new UserException("The User to remove can't be null");
            }
            logger.debug("Deleting the User bean: {}", user);
            tx = session.beginTransaction();
            session.delete(user);
            tx.commit();
            logger.info("Deleting finished");
        } catch (Exception e) {
            logger.error("User bean can't delete", e);
            throw new UserException("Error in Removing User From DB", e);
        } finally {
            session.close();
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getLastUserId() throws UserException {
        logger.info("Loading all the User codes from DB");
        Session session = sessionFactory.openSession();
        try {
            String hql = "select max(C.userId) FROM lk.ac.ucsc.oms.user.implGeneral.beans.user.UserBean C ";
            Query query = session.createQuery(hql);

            Long results = (Long) query.uniqueResult();
            if (results != null) {
                return results.toString();
            } else {
                return "0";
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new UserException("Error in Getting Last User Id", e);
        } finally {
            session.close();
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserBean loadByUserNumber(String userNumber) throws UserException {
        UserBean userBean;
        Session session = sessionFactory.openSession();
        try {
            logger.info("Loading the user with user Id:{} ", userNumber);
            String hql = "FROM lk.ac.ucsc.oms.user.implGeneral.beans.user.UserBean C WHERE C.userNumber = :userNumber";
            Query query = session.createQuery(hql);
            query.setParameter("userNumber", userNumber);
            userBean = (UserBean) query.uniqueResult();

            logger.info("Loaded User:{}", userBean);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new UserException("Error in Getting User from User Number", e);
        } finally {
            session.close();
        }
        return userBean;
    }





}
