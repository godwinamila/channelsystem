package lk.ac.ucsc.webArc.assgnment.customer.api;

import lk.ac.ucsc.webArc.assgnment.customer.api.beans.customer.Customer;
import lk.ac.ucsc.webArc.assgnment.customer.api.beans.customer.LoginProfile;
import lk.ac.ucsc.webArc.assgnment.customer.api.exceptions.CustomerException;


import java.util.List;

/**
 * This is the service interface to manage all the customer related information.
 * All the customer related operations should be done through this interface.
 * <p/>
 * User: Hetti

 * Time: 12:27 PM
 */
public interface CustomerManager {


    Customer getCustomerByCustomerNumber(String customerNumber) throws CustomerException;

    Customer getCustomerByLoginNameOrAlias(String loginName) throws CustomerException;

    long addCustomer(Customer customer) throws CustomerException;

    void updateCustomer(Customer customer) throws CustomerException;

    void markCustomerAsDeleted(String customerNumber) throws CustomerException;

    List<Customer> getAllCustomers() throws CustomerException;

    Customer getEmptyCustomer();

    LoginProfile getEmptyLoginProfile();

    void validateCustomer(Customer customer) throws CustomerException;

    long getLastCustomerId();
}

