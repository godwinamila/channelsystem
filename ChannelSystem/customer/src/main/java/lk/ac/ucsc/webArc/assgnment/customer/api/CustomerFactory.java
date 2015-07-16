package lk.ac.ucsc.webArc.assgnment.customer.api;


import lk.ac.ucsc.webArc.assgnment.customer.api.exceptions.CustomerException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * User: Hetti
 */

/**
 * Factory that is used to get the service interfaces of the channelInfo module to access main services provided by channelInfo module
 */
public class CustomerFactory {
    private static Logger logger = LoggerFactory.getLogger(CustomerFactory.class);

    private static CustomerFactory factory;
    private static ApplicationContext context;

    /**
     * Private constructor to avoid instantiation to have only one factory instance.
     */
    private CustomerFactory() throws CustomerException {
        synchronized (this) {
            if (context == null) {
                context = new ClassPathXmlApplicationContext("/implGeneral/spring-config-customer.xml");
            }
        }

    }

    /**
     * Get the instance of the CustomerFactory
     *
     * @return CustomerFactory instance
     * @throws CustomerException Error
     */
    public static CustomerFactory getInstance() throws CustomerException {
        if (factory == null) {
            return createInstance();
        }
        return factory;
    }

    /**
     * method to create the instance of the factory
     *
     * @return customerFactory
     * @throws CustomerException
     */
    private static synchronized CustomerFactory createInstance() throws CustomerException {
        if (factory != null) {
            return factory;
        }
        factory = new CustomerFactory();

        return factory;
    }

    /**
     * Get the service API of the channelInfo module which is used to manage all channelInfo information
     *
     * @return CustomerManager
     */
    public CustomerManager getCustomerManager() {
        return context.getBean("customerManager", CustomerManager.class);
    }





    /**
     * Get the service API of the channelInfo module which is used to manage all channelInfo login related operations
     *
     * @return CustomerLoginManager
     */
    public CustomerLoginManager getCustomerLoginManager() {
        return context.getBean("cusLoginManager", CustomerLoginManager.class);
    }




    /**
     * method to set context to CustomerFactory
     * usage in unit testing only
     *
     * @param context
     */
    public static void setContext(ApplicationContext context) {
        CustomerFactory.context = context;
    }


}
