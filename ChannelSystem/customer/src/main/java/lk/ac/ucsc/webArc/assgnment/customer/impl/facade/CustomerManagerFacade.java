package lk.ac.ucsc.webArc.assgnment.customer.impl.facade;


import lk.ac.ucsc.webArc.assgnment.customer.api.CustomerManager;

import lk.ac.ucsc.webArc.assgnment.customer.api.beans.customer.Customer;
import lk.ac.ucsc.webArc.assgnment.customer.api.beans.customer.LoginProfile;

import lk.ac.ucsc.webArc.assgnment.customer.api.exceptions.CustomerException;
import lk.ac.ucsc.webArc.assgnment.customer.impl.beans.customer.CustomerBean;
import lk.ac.ucsc.webArc.assgnment.customer.impl.beans.customer.LoginProfileBean;

import lk.ac.ucsc.webArc.assgnment.customer.impl.persistantImpl.CustomerPersister;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * CustomerManagerFacade class implements all the services defined in the CustomerManager interface.
 * This class has a reference to the CustomerCacheFacade class that provides all the cache and physical storage related operations.
 * All the operations are done through CustomerCacheFacade.
 * <p/>
 * User: Hetti

 * Time: 2:34 PM
 */
public class CustomerManagerFacade implements CustomerManager {
    private static Logger logger = LoggerFactory.getLogger(CustomerManagerFacade.class);


    private CustomerPersister customerPersister;

    public CustomerPersister getCustomerPersister() {
        return customerPersister;
    }

    public void setCustomerPersister(CustomerPersister customerPersister) {
        this.customerPersister = customerPersister;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Customer getCustomerByCustomerNumber(String customerNumber) throws CustomerException {
        logger.info("Getting the customer with customer number - {}", customerNumber);
        if (customerNumber == null || "".equalsIgnoreCase(customerNumber)) {
            throw new CustomerException("Customer Number Can't be Null or Empty");
        }
        return customerPersister.loadByCustomerNumber(customerNumber);
    }



    /**
     * {@inheritDoc}
     */
    @Override
    public Customer getCustomerByLoginNameOrAlias(String loginName) throws CustomerException {
        logger.info("Getting the customer with login name - {}", loginName);
        if (loginName == null || "".equalsIgnoreCase(loginName)) {
            throw new CustomerException("Customer Login Name Can't be Null or Empty" );
        }

        try {
            return customerPersister.loadByCustomerNumber(loginName);
        } catch (CustomerException e) {
            logger.debug("Error in getting customer using login name or alias", e);
            throw new CustomerException("Error in getting customer using login name or alias", e);
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long addCustomer(Customer customer) throws CustomerException {
        logger.info("Adding the customer -{} to cache", customer);
        if (customer == null) {
            throw new CustomerException("Customer can't be null");
        }
        validateCustomer(customer);

        customer.getLoginProfile().setCustomerId(customer.getCustomerId());

        customerPersister.insert((CustomerBean) customer);
        logger.debug("Adding customer process finished");
        return customer.getCustomerId();

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateCustomer(Customer customer) throws CustomerException {
        logger.info("Update the customer {}", customer);
        if (customer == null) {
            throw new CustomerException("customer can't be null");
        }
        validateCustomer(customer);

        customerPersister.update((CustomerBean) customer);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void markCustomerAsDeleted(String customerNumber) throws CustomerException {
        logger.info("markCustomerAsDeleted : customerNumber : ", customerNumber);
        if (customerNumber == null || "".equalsIgnoreCase(customerNumber)) {
            throw new CustomerException("Customer Number is Empty");
        }
        Customer customer =getCustomerByCustomerNumber(customerNumber);
        customerPersister.deleteFromDB((CustomerBean)customer);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Customer> getAllCustomers() throws CustomerException {
        logger.info("Getting All the Customers");
        return customerPersister.loadAll();
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Customer getEmptyCustomer() {
        Customer customer =new CustomerBean();
        try {
            long cusId = customerPersister.getLastCustomerId();
            String customerNumber = "CUS-" + (10000 + cusId);
            customer.setCustomerId(cusId+1);
            customer.setCustomerNumber(customerNumber);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return customer;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public LoginProfile getEmptyLoginProfile() {
        return new LoginProfileBean();
    }



    /**
     * validate customer number for null or empty
     *
     * @param customer
     * @throws CustomerException
     */
    @Override
    public void validateCustomer(Customer customer) throws CustomerException {
        if (customer.getCustomerNumber() == null || "".equals(customer.getCustomerNumber())) {
            throw new CustomerException("Customer Number Can't be Null or Empty" );
        }
    }

    @Override
    public long getLastCustomerId() {
        try {
            return customerPersister.getLastCustomerId();
        }catch (Exception e){
            return 1;
        }
    }
}
