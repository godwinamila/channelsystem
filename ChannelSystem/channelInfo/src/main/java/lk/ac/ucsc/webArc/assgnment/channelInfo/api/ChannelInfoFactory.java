package lk.ac.ucsc.webArc.assgnment.channelInfo.api;

import lk.ac.ucsc.webArc.assgnment.channelInfo.api.exceptions.ChannelInfoException;
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
public class ChannelInfoFactory {
    private static Logger logger = LoggerFactory.getLogger(ChannelInfoFactory.class);

    private static ChannelInfoFactory factory;
    private static ApplicationContext context;

    /**
     * Private constructor to avoid instantiation to have only one factory instance.
     */
    private ChannelInfoFactory() throws ChannelInfoException {
        synchronized (this) {
            if (context == null) {
                context = new ClassPathXmlApplicationContext("/impl/spring-config-channelInfo.xml");
            }
        }

    }

    /**
     * Get the instance of the ChannelInfoFactory
     *
     * @return ChannelInfoFactory instance
     * @throws ChannelInfoException Error
     */
    public static ChannelInfoFactory getInstance() throws ChannelInfoException {
        if (factory == null) {
            return createInstance();
        }
        return factory;
    }

    /**
     * method to create the instance of the factory
     *
     * @return ChannelInfoFactory
     * @throws ChannelInfoException
     */
    private static synchronized ChannelInfoFactory createInstance() throws ChannelInfoException {
        if (factory != null) {
            return factory;
        }
        factory = new ChannelInfoFactory();

        return factory;
    }

    /**
     * Get the service API of the channelInfo module which is used to manage all channelInfo information
     *
     * @return ChannelInfoManager
     */
    public ChannelInfoManager getChannelInfoManager() {
        return context.getBean("channelInfoManager", ChannelInfoManager.class);
    }


    public ChannelScheduleManager getChannelScheduleManager() {
        return context.getBean("channelScheduleManager", ChannelScheduleManager.class);
    }
    /**
     * method to set context to ChannelInfoFactory
     * usage in unit testing only
     *
     * @param context
     */
    public static void setContext(ApplicationContext context) {
        ChannelInfoFactory.context = context;
    }


}
