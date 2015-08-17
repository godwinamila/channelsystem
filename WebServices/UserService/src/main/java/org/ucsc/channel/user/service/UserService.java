package org.ucsc.channel.user.service;

import java.util.List;

import org.ucsc.channel.user.model.UserDO;
import org.ucsc.channel.user.util.SampleDataUtil;

public class UserService{
	
	public List<UserDO> getAllUsers(){
		return SampleDataUtil.getSamplUserss();
	}

}