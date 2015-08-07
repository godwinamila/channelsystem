package lk.ac.ucsc.webArc.assgnment.channelInfo.impl.facade;

import lk.ac.ucsc.webArc.assgnment.channelInfo.api.ChannelScheduleManager;

import lk.ac.ucsc.webArc.assgnment.channelInfo.api.beans.ChannelSchedule;

import lk.ac.ucsc.webArc.assgnment.channelInfo.api.exceptions.ChannelScheduleException;

import lk.ac.ucsc.webArc.assgnment.channelInfo.impl.beans.ChannelScheduleBean;
import lk.ac.ucsc.webArc.assgnment.channelInfo.impl.persistantImpl.ChannelSchedulePersister;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by chamindah on 8/6/2015.
 */
public class ChannelScheManagerFacade implements ChannelScheduleManager{
    private static Logger logger = LoggerFactory.getLogger(ChannelScheManagerFacade.class);

    private ChannelSchedulePersister channelSchedulePersister;

    @Override
    public String addChannelSchedule(ChannelSchedule channelSchedule) throws ChannelScheduleException {
        logger.info("Adding the channelSchedule -{} to cache", channelSchedule);
        if (channelSchedule == null) {
            throw new ChannelScheduleException("channelSchedule can't be null");
        }
        channelSchedulePersister.insert((ChannelScheduleBean) channelSchedule);
        logger.debug("Adding channelSchedule process finished");
        return ""+channelSchedule.getChanScheId();
    }

    @Override
    public void updateChannelSchedule(ChannelSchedule channelSchedule) throws ChannelScheduleException {
        logger.info("Update the ChannelInfo {}", channelSchedule);
        if (channelSchedule == null) {
            throw new ChannelScheduleException("ChannelInfo can't be null");
        }
        channelSchedulePersister.update((ChannelScheduleBean) channelSchedule);
    }

    @Override
    public void markChannelScheduleAsDeleted(String channelScheduleId) throws ChannelScheduleException {
        logger.info("markChannelInfoAsDeleted : channelScheduleId : ", channelScheduleId);
        if (channelScheduleId == null || "".equalsIgnoreCase(channelScheduleId)) {
            throw new ChannelScheduleException("ChannelInfo Number is Empty");
        }
        ChannelSchedule channelSchedule =getChannelSchedule(channelScheduleId);
        channelSchedulePersister.deleteFromDB((ChannelScheduleBean)channelSchedule);
    }

    @Override
    public ChannelSchedule getChannelSchedule(String channelScheduleId) throws ChannelScheduleException {
        logger.info("Getting the channelSchedule with channelScheduleId - {}", channelScheduleId);
        if (channelScheduleId == null || "".equalsIgnoreCase(channelScheduleId)) {
            throw new ChannelScheduleException("ChannelInfo Number Can't be Null or Empty");
        }
        return channelSchedulePersister.load(channelScheduleId);
    }

    @Override
    public List<ChannelSchedule> getAllChannelSchedule() throws ChannelScheduleException {
        logger.info("Getting All the ChannelSchedule");
        return channelSchedulePersister.loadAll();
    }

    @Override
    public List<ChannelSchedule> getChannelScheduleForDoctor(String doctorNumber) throws ChannelScheduleException {
         return channelSchedulePersister.getChannelScheduleForDoctor(doctorNumber);
    }

    @Override
    public ChannelSchedule getEmptyChannelSchedule() {
        return new ChannelScheduleBean();
    }

    public ChannelSchedulePersister getChannelSchedulePersister() {
        return channelSchedulePersister;
    }

    public void setChannelSchedulePersister(ChannelSchedulePersister channelSchedulePersister) {
        this.channelSchedulePersister = channelSchedulePersister;
    }
}
