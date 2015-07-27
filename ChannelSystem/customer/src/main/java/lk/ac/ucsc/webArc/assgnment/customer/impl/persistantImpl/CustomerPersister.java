package lk.ac.ucsc.webArc.assgnment.customer.impl.persistantImpl;


import lk.ac.ucsc.webArc.assgnment.customer.api.beans.customer.Customer;
import lk.ac.ucsc.webArc.assgnment.customer.api.exceptions.CustomerException;
import lk.ac.ucsc.webArc.assgnment.customer.impl.beans.customer.CustomerBean;

import java.util.List;

/**
 * User: Hetti

 * Time: 3:10 PM
 *
 * here are method definitions for customer persister,
 * method to delete customers from database,
 * get last customer id from database for the usage of sequence generator etc
 */
public interface CustomerPersister  {

    void update(CustomerBean co) throws CustomerException;

    void insert(CustomerBean co) throws CustomerException;

    CustomerBean load(String customerNumber) throws CustomerException;

    List<Customer> loadAll();

    void deleteFromDB(CustomerBean customer) throws CustomerException;

    String getLastCustomerId() throws CustomerException;

    CustomerBean loadByCustomerNumber(String customerNumber) throws CustomerException;
}
