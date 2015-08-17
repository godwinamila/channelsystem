package org.ucsc.channel.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.ucsc.channel.model.ChannelDO;

public class SampleDataUtil {

	public static List<ChannelDO> getSamplChannels(){
		
		List<ChannelDO> channelList = new ArrayList<ChannelDO>();
		
		ChannelDO channel1 = new ChannelDO();
		channel1.setChannelId("CH0000001");
		channel1.setCustomerNumber("CU0009012");
		channel1.setDateCreated((new Date()).toString());
		channel1.setDoctorNumber("DO002112");
		channel1.setLocaltion("Room 5");
		channel1.setTimeSlot("4:30 PM");
		
		ChannelDO channel2 = new ChannelDO();
		channel2.setChannelId("CH0000002");
		channel2.setCustomerNumber("CU0009016");
		channel2.setDateCreated((new Date()).toString());
		channel2.setDoctorNumber("DO002111");
		channel2.setLocaltion("Room 3");
		channel2.setTimeSlot("5:30 PM");
		
		ChannelDO channel3 = new ChannelDO();
		channel3.setChannelId("CH0000003");
		channel3.setCustomerNumber("CU0008042");
		channel3.setDateCreated((new Date()).toString());
		channel3.setDoctorNumber("DO001519");
		channel3.setLocaltion("Room 1");
		channel3.setTimeSlot("7:30 PM");
		
		channelList.add(channel1);
		channelList.add(channel2);
		channelList.add(channel3);
		return channelList;
	}
}
