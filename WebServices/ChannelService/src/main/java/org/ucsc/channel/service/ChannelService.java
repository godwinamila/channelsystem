package org.ucsc.channel.service;

import java.util.List;

import org.ucsc.channel.model.ChannelDO;
import org.ucsc.channel.util.SampleDataUtil;

public class ChannelService{

	private final static String SUCCESS_MSG = "Channel added successfully.";
	
	public List<ChannelDO> getAllChannels(){
		return SampleDataUtil.getSamplChannels();
	}
	
	public String addChannel(ChannelDO channel){
		return SUCCESS_MSG;
	}
}