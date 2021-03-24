package com.springboot.microservices.service;

import java.util.List;

import com.springboot.microservices.entity.Friend;


public interface IFriendService {
	
	boolean    getRegisterNewFriend(Friend friend);
	List<Long> getFriendsRegisterPhoneNors(Long phoneNor) ;
}
  