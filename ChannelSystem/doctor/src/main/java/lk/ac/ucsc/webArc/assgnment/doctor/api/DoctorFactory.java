package lk.ac.ucsc.webArc.assgnment.doctor.api;


import lk.ac.ucsc.webArc.assgnment.doctor.api.exceptions.DoctorException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * User: Hetti
 */

/**
 * Factory that is used to get the service interfaces of the doctors module to access main services provided by doctors module
 */
public class DoctorFactory {
    private static Logger logger = LoggerFactory.getLogger(DoctorFactory.class);

    private static DoctorFactory factory;
    private static ApplicationContext context;

    /**
     * Private constructor to avoid instantiation to have only one factory instance.
     */
    private DoctorFactory() throws DoctorException {
        synchronized (this) {
            if (context == null) {
                context = new ClassPathXmlApplicationContext("/impl/spring-config-doctor.xml");
            }
        }

    }

    /**
     * Get the instance of the DoctorFactory
     *
     * @return DoctorFactory instance
     * @throws DoctorException Error
     */
    public static DoctorFactory getInstance() throws DoctorException {
        if (factory == null) {
            return createInstance();
        }
        return factory;
    }

    /**
     * method to create the instance of the factory
     *
     * @return doctorFactory
     * @throws DoctorException
     */
    private static synchronized DoctorFactory createInstance() throws DoctorException {
        if (factory != null) {
            return factory;
        }
        factory = new DoctorFactory();

        return factory;
    }

    /**
     * Get the service API of the doctors module which is used to manage all doctors information
     *
     * @return DoctorManager
     */
    public DoctorManager getDoctorManager() {
        return context.getBean("doctorManager", DoctorManager.class);
    }


    /**
     * Get the service API of the doctors module which is used to manage all doctors login related operations
     *
     * @return DoctorLoginManager
     */
    public DoctorLoginManager getDoctorLoginManager() {
        return context.getBean("docLoginManager", DoctorLoginManager.class);
    }




    /**
     * method to set context to DoctorFactory
     * usage in unit testing only
     *
     * @param context
     */
    public static void setContext(ApplicationContext context) {
        DoctorFactory.context = context;
    }


}
