package lk.ac.ucsc.webArc.assgnment.channelInfo.api;

import lk.ac.ucsc.webArc.assgnment.channelInfo.api.beans.ChannelSchedule;
import lk.ac.ucsc.webArc.assgnment.channelInfo.api.exceptions.ChannelScheduleException;

import java.util.List;

/**
 * Created by chamindah on 8/6/2015.
 */
public interface ChannelScheduleManager {
    String addChannelSchedule(ChannelSchedule channelInfo) throws ChannelScheduleException;

    void updateChannelSchedule(ChannelSchedule channelInfo) throws ChannelScheduleException;

    void markChannelScheduleAsDeleted(String channelInfoId) throws ChannelScheduleException;

    ChannelSchedule getChannelSchedule(String channelInfoId) throws ChannelScheduleException;

    List<ChannelSchedule> getAllChannelSchedule() throws ChannelScheduleException;

    List<ChannelSchedule> getChannelScheduleForDoctor(String doctorNumber) throws ChannelScheduleException;

    ChannelSchedule getEmptyChannelSchedule();
}
