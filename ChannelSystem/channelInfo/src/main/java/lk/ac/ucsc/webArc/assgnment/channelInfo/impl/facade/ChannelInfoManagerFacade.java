package lk.ac.ucsc.webArc.assgnment.channelInfo.impl.facade;


import lk.ac.ucsc.webArc.assgnment.channelInfo.api.ChannelInfoManager;


import lk.ac.ucsc.webArc.assgnment.channelInfo.api.beans.ChannelInfo;
import lk.ac.ucsc.webArc.assgnment.channelInfo.api.exceptions.ChannelInfoException;
import lk.ac.ucsc.webArc.assgnment.channelInfo.impl.beans.ChannelInfoBean;
import lk.ac.ucsc.webArc.assgnment.channelInfo.impl.persistantImpl.ChannelInfoPersister;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * ChannelInfoManagerFacade class implements all the services defined in the ChannelInfoManager interface.
 * This class has a reference to the ChannelInfoCacheFacade class that provides all the cache and physical storage related operations.
 * All the operations are done through ChannelInfoCacheFacade.
 * <p/>
 * User: Hetti

 * Time: 2:34 PM
 */
public class ChannelInfoManagerFacade implements ChannelInfoManager {
    private static Logger logger = LoggerFactory.getLogger(ChannelInfoManagerFacade.class);


    private ChannelInfoPersister channelInfoPersister;


    public ChannelInfoPersister getChannelInfoPersister() {
        return channelInfoPersister;
    }

    public void setChannelInfoPersister(ChannelInfoPersister channelInfoPersister) {
        this.channelInfoPersister = channelInfoPersister;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int addChannelInfo(ChannelInfo channelInfo) throws ChannelInfoException {
        logger.info("Adding the channelInfo -{} to cache", channelInfo);
        if (channelInfo == null) {
            throw new ChannelInfoException("channelInfo can't be null");
        }


        channelInfoPersister.insert((ChannelInfoBean) channelInfo);
        logger.debug("Adding channelInfo process finished");
        return channelInfo.getChannelInfoId();

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateChannelInfo(ChannelInfo ChannelInfo) throws ChannelInfoException {
        logger.info("Update the ChannelInfo {}", ChannelInfo);
        if (ChannelInfo == null) {
            throw new ChannelInfoException("ChannelInfo can't be null");
        }

        channelInfoPersister.update((ChannelInfoBean) ChannelInfo);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void markChannelInfoAsDeleted(String channelInfoId) throws ChannelInfoException {
        logger.info("markChannelInfoAsDeleted : ChannelInfoNumber : ", channelInfoId);
        if (channelInfoId == null || "".equalsIgnoreCase(channelInfoId)) {
            throw new ChannelInfoException("ChannelInfo Number is Empty");
        }
        ChannelInfo channelInfo =getChannelInfo(channelInfoId);
        channelInfoPersister.deleteFromDB((ChannelInfoBean)channelInfo);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ChannelInfo getChannelInfo(String channelInfoId) throws ChannelInfoException {
        logger.info("Getting the channelInfo with channelInfo number - {}", channelInfoId);
        if (channelInfoId == null || "".equalsIgnoreCase(channelInfoId)) {
            throw new ChannelInfoException("ChannelInfo Number Can't be Null or Empty");
        }
        return channelInfoPersister.load(channelInfoId);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public List<ChannelInfo> getAllChannelInfo() throws ChannelInfoException {
        logger.info("Getting All the channnelInfo");
        return channelInfoPersister.loadAll();
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public ChannelInfo getEmptyChannelInfo() {
        return new ChannelInfoBean();
    }

    @Override
    public List<ChannelInfo> getChannelInfoForCustomer(String customerNumber) throws ChannelInfoException {
        return channelInfoPersister.getChannelInfoForCustomer(customerNumber);
    }

    @Override
    public List<ChannelInfo> getChannelInfoForDoctor(String doctorNumber) throws ChannelInfoException {
        return channelInfoPersister.getChannelInfoForDoctor(doctorNumber);
    }
}
