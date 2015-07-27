package lk.ac.ucsc.webArc.assgnment.medicalInfo.api;

import lk.ac.ucsc.webArc.assgnment.medicalInfo.api.exceptions.MedicalInfoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * User: Hetti
 */

/**
 * Factory that is used to get the service interfaces of the medicalInfo module to access main services provided by medicalInfo module
 */
public class MedicalInfoFactory {
    private static Logger logger = LoggerFactory.getLogger(MedicalInfoFactory.class);

    private static MedicalInfoFactory factory;
    private static ApplicationContext context;

    /**
     * Private constructor to avoid instantiation to have only one factory instance.
     */
    private MedicalInfoFactory() throws MedicalInfoException {
        synchronized (this) {
            if (context == null) {
                context = new ClassPathXmlApplicationContext("/impl/spring-config-medicalInfo.xml");
            }
        }

    }

    /**
     * Get the instance of the MedicalInfoFactory
     *
     * @return MedicalInfoFactory instance
     * @throws MedicalInfoException Error
     */
    public static MedicalInfoFactory getInstance() throws MedicalInfoException {
        if (factory == null) {
            return createInstance();
        }
        return factory;
    }

    /**
     * method to create the instance of the factory
     *
     * @return MedicalInfoFactory
     * @throws MedicalInfoException
     */
    private static synchronized MedicalInfoFactory createInstance() throws MedicalInfoException {
        if (factory != null) {
            return factory;
        }
        factory = new MedicalInfoFactory();

        return factory;
    }

    /**
     * Get the service API of the medicalInfo module which is used to manage all medicalInfo information
     *
     * @return CustomerManager
     */
    public MedicalInfoManager getMedicalInfoManager() {
        return context.getBean("medicalInfoManager", MedicalInfoManager.class);
    }


    /**
     * method to set context to MedicalInfoFactory
     * usage in unit testing only
     *
     * @param context
     */
    public static void setContext(ApplicationContext context) {
        MedicalInfoFactory.context = context;
    }


}
