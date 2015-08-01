package lk.ac.ucsc.webArc.assgnment.channelInfo.impl.persistantImpl;




import lk.ac.ucsc.webArc.assgnment.channelInfo.api.beans.ChannelInfo;
import lk.ac.ucsc.webArc.assgnment.channelInfo.api.exceptions.ChannelInfoException;
import lk.ac.ucsc.webArc.assgnment.channelInfo.impl.beans.ChannelInfoBean;

import java.util.List;

/**
 * User: Hetti

 * Time: 3:10 PM
 *
 * here are method definitions for channelInfo persister,
 * method to delete channnelInfo from database,
 * get last channelInfo id from database for the usage of sequence generator etc
 */
public interface ChannelInfoPersister  {

    void update(ChannelInfoBean co) throws ChannelInfoException;

    void insert(ChannelInfoBean co) throws ChannelInfoException;

    ChannelInfoBean load(String channelInfoId) throws ChannelInfoException;

    List<ChannelInfo> loadAll();

    void deleteFromDB(ChannelInfoBean channelInfo) throws ChannelInfoException;


    List<ChannelInfo> getChannelInfoForCustomer(String customerNumber);

    List<ChannelInfo> getChannelInfoForDoctor(String doctorNumber);
}
