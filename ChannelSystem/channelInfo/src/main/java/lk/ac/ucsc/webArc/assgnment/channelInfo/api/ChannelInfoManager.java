package lk.ac.ucsc.webArc.assgnment.channelInfo.api;

import lk.ac.ucsc.webArc.assgnment.channelInfo.api.beans.ChannelInfo;
import lk.ac.ucsc.webArc.assgnment.channelInfo.api.exceptions.ChannelInfoException;


import java.util.List;

/**
 * This is the service interface to manage all the channelInfo related information.
 * All the channelInfo related operations should be done through this interface.
 * <p/>
 * User: Hetti

 * Time: 12:27 PM
 */
    public interface ChannelInfoManager {

    String addChannelInfo(ChannelInfo channelInfo) throws ChannelInfoException;

    void updateChannelInfo(ChannelInfo channelInfo) throws ChannelInfoException;

    void markChannelInfoAsDeleted(String channelInfoId) throws ChannelInfoException;

    ChannelInfo getChannelInfo(String channelInfoId) throws ChannelInfoException;

    List<ChannelInfo> getAllChannelInfo() throws ChannelInfoException;

    ChannelInfo getEmptyChannelInfo();


}

