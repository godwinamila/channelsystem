package lk.ac.ucsc.webArc.assgnment.user.api;


import lk.ac.ucsc.webArc.assgnment.user.api.exceptions.UserException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * User: Hetti
 */

/**
 * Factory that is used to get the service interfaces of the user module to access main services provided by user module
 */
public class UserFactory {
    private static Logger logger = LoggerFactory.getLogger(UserFactory.class);

    private static UserFactory factory;
    private static ApplicationContext context;

    /**
     * Private constructor to avoid instantiation to have only one factory instance.
     */
    private UserFactory() throws UserException {
        synchronized (this) {
            if (context == null) {
                context = new ClassPathXmlApplicationContext("/impl/spring-config-user.xml");
            }
        }

    }

    /**
     * Get the instance of the UserFactory
     *
     * @return UserFactory instance
     * @throws UserException Error
     */
    public static UserFactory getInstance() throws UserException {
        if (factory == null) {
            return createInstance();
        }
        return factory;
    }

    /**
     * method to create the instance of the factory
     *
     * @return userFactory
     * @throws UserException
     */
    private static synchronized UserFactory createInstance() throws UserException {
        if (factory != null) {
            return factory;
        }
        factory = new UserFactory();

        return factory;
    }

    /**
     * Get the service API of the user module which is used to manage all user information
     *
     * @return UserManager
     */
    public UserManager getUserManager() {
        return context.getBean("userManager", UserManager.class);
    }





    /**
     * Get the service API of the user module which is used to manage all user login related operations
     *
     * @return UserLoginManager
     */
    public UserLoginManager getUserLoginManager() {
        return context.getBean("userLoginManager", UserLoginManager.class);
    }




    /**
     * method to set context to UserFactory
     * usage in unit testing only
     *
     * @param context
     */
    public static void setContext(ApplicationContext context) {
        UserFactory.context = context;
    }


}
