package org.ucsc.channel.user.util;

import java.util.ArrayList;
import java.util.List;

import org.ucsc.channel.user.model.UserDO;

public class SampleDataUtil {

	public static List<UserDO> getSamplUserss(){
		
		List<UserDO> userList = new ArrayList<UserDO>();
		
		UserDO user1 = new UserDO();
		user1.setFirstName("Kamal");
		user1.setLastName("Perera");
		user1.setUserName("kamal");
		
		UserDO user2 = new UserDO();
		user2.setFirstName("Sunil");
		user2.setLastName("Perera");
		user2.setUserName("sunil");
		
		UserDO user3 = new UserDO();
		user2.setFirstName("Bimal");
		user2.setLastName("Peiris");
		user2.setUserName("bimal");
		
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		return userList;
	}
}
