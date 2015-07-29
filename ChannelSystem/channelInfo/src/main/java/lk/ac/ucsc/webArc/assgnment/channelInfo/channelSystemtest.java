package lk.ac.ucsc.webArc.assgnment.channelInfo;

import lk.ac.ucsc.webArc.assgnment.channelInfo.api.ChannelInfoFactory;
import lk.ac.ucsc.webArc.assgnment.channelInfo.api.ChannelInfoManager;
import lk.ac.ucsc.webArc.assgnment.channelInfo.api.beans.ChannelInfo;

import java.util.Date;

/**
 * Created by chamindah on 7/27/2015.
 */
public class channelSystemtest {
    public static void main(String[] args){
        try {
            ChannelInfoFactory channelInfoFactory = ChannelInfoFactory.getInstance();
            ChannelInfoManager channelInfoManager =channelInfoFactory.getChannelInfoManager();
            ChannelInfo channelInfo=channelInfoManager.getEmptyChannelInfo();
            channelInfo.setChannelInfoId("channel_1");
            channelInfo.setChannelStatus(0);
            channelInfo.setCreateDate(new Date());
            channelInfo.setDoctorNumber("doc_00001");
            channelInfo.setLocation("Colombo");
            channelInfo.setPatientNumber("pat_000001");
            channelInfo.setTimeSlot("10:25");
            channelInfoManager.addChannelInfo(channelInfo);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
