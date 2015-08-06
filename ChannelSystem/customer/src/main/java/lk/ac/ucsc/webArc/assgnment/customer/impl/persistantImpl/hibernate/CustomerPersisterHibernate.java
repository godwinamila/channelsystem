package lk.ac.ucsc.webArc.assgnment.customer.impl.persistantImpl.hibernate;




import lk.ac.ucsc.webArc.assgnment.customer.api.beans.customer.Customer;
import lk.ac.ucsc.webArc.assgnment.customer.api.exceptions.CustomerException;
import lk.ac.ucsc.webArc.assgnment.customer.impl.beans.customer.CustomerBean;
import lk.ac.ucsc.webArc.assgnment.customer.impl.persistantImpl.CustomerPersister;
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
 * This is hibernate implementation of the persistent api of the customer module
 * User: Hetti

 * Time: 3:07 PM
 */
public class CustomerPersisterHibernate implements CustomerPersister {
    private static final int BATCH_SIZE = 20;
    private static Logger logger = LoggerFactory.getLogger(CustomerPersisterHibernate.class);
    private static Date lastUpdateTime;
    private SessionFactory sessionFactory;

    /**
     * set the real time and history session factories
     */
    public CustomerPersisterHibernate(SessionFactory sessionFactory) {

        this.sessionFactory =sessionFactory;
    }



    /**
     * set the search session factory for dealer related customer searches
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
    public void update(CustomerBean co) throws CustomerException {
        Transaction tx;
        Session session = sessionFactory.openSession();
        try {
            if (co == null) {
                logger.error("Customer bean can't be null");
                throw new CustomerException("Customer bean can't be null");
            }
            logger.debug("updating the Customer bean: {}", co);
            tx = session.beginTransaction();
            session.update(co);
            tx.commit();
            logger.debug("updating finished");
        } catch (Exception e) {
            logger.error("Customer bean can't update", e);
            throw new CustomerException("Customer bean can't update", e);
        } finally {
            session.close();
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void insert(CustomerBean co) throws CustomerException {
        Transaction tx;
        Session session = sessionFactory.openSession();
        try {
            logger.debug("Inserting the Customer bean:{} ", co);
            if (co == null) {
                logger.error("Customer bean can't be null");
                throw new CustomerException("Customer bean can't be null");
            }
            tx = session.beginTransaction();
            session.save(co);
            tx.commit();
            logger.debug("Inserting Customer bean finished");
        } catch (Exception e) {
            logger.error("problem in adding customer", e);
            throw new CustomerException("problem in adding customer", e);
        } finally {
            session.close();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CustomerBean load(String customerNumber) throws CustomerException {
        CustomerBean customerBean = null;
        Session session = sessionFactory.openSession();
        try {

            logger.info("Loading the customer with customer code:{} ", customerNumber);
            if (customerNumber == null || "".equals(customerNumber)) {
                logger.warn("Customer info provided not enough to load from DB");
                throw new CustomerException("Customer bean can't be null");
            }
            String hql = "FROM lk.ac.ucsc.webArc.assgnment.customer.impl.beans.customer.CustomerBean C WHERE C.customerNumber = :customer";
            Query query = session.createQuery(hql);
            query.setParameter("customer", customerNumber);
            customerBean = (CustomerBean) query.uniqueResult();

            logger.info("Loaded Customer:{}", customerBean);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new CustomerException("Error in executing Hibernate Query for loading customer", e);
        } finally {
            session.close();
        }
        return customerBean;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Customer> loadAll() {
        logger.info("Loading all the Customer from DB");
        List<Customer> cashObjectLst = new ArrayList<>();
        Session session = sessionFactory.openSession();
        try {
            String hql = "FROM lk.ac.ucsc.webArc.assgnment.customer.impl.beans.customer.CustomerBean";
            Query query = session.createQuery(hql);
            List results = query.list();

            for (Object cgb : results) {
                CustomerBean customerBean = (CustomerBean) cgb;
                cashObjectLst.add(customerBean);
            }
            logger.debug("Loaded Customers list of size:{} and list:{}", cashObjectLst.size(), cashObjectLst);
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
    public void deleteFromDB(CustomerBean customer) throws CustomerException {
        logger.info("Deleting Customer bean ");
        Transaction tx;
        Session session = sessionFactory.openSession();
        try {
            if (customer == null) {
                throw new CustomerException("The Customer to remove can't be null");
            }
            logger.debug("Deleting the Customer bean: {}", customer);
            tx = session.beginTransaction();
            session.delete(customer);
            tx.commit();
            logger.info("Deleting finished");
        } catch (Exception e) {
            logger.error("Customer bean can't delete", e);
            throw new CustomerException("Error in Removing Customer From DB", e);
        } finally {
            session.close();
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long getLastCustomerId() throws CustomerException {
        logger.info("Loading all the Customer codes from DB");
        Session session = sessionFactory.openSession();
        try {
            String hql = "select max(C.customerId) FROM lk.ac.ucsc.webArc.assgnment.customer.impl.beans.customer.CustomerBean C ";
            Query query = session.createQuery(hql);

            Long results = (Long) query.uniqueResult();
            if (results != null) {
                return results;
            } else {
                return 1;
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new CustomerException("Error in Getting Last Customer Id", e);
        } finally {
            session.close();
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CustomerBean loadByCustomerNumber(String customerNumber) throws CustomerException {
        CustomerBean customerBean;
        Session session = sessionFactory.openSession();
        try {
            logger.info("Loading the customer with customer Id:{} ", customerNumber);
            String hql = "FROM lk.ac.ucsc.webArc.assgnment.customer.impl.beans.customer.CustomerBean C WHERE C.customerNumber = :customerNumber";
            Query query = session.createQuery(hql);
            query.setParameter("customerNumber", customerNumber);
            customerBean = (CustomerBean) query.uniqueResult();

            logger.info("Loaded Customer:{}", customerBean);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new CustomerException("Error in Getting Customer from Customer Number", e);
        } finally {
            session.close();
        }
        return customerBean;
    }





}
