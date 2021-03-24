package com.springboot.microservices.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.microservices.entity.Friend;
import com.springboot.microservices.repo.FriendRepository;
import com.springboot.microservices.service.IFriendService;

@Service
public class FriendServiceImpl  implements IFriendService{

	@Autowired
	private FriendRepository repo;
	
	

	@Override
	public List<Long> getFriendsRegisterPhoneNors(Long phoneNor) {
		// TODO Auto-generated method stub
		List<Friend> list=repo.findByPhoneNor(phoneNor);
		List<Long> list2=new ArrayList<>();
		for (Friend f : list) {
			
			list2.add(f.getFriendNor());	
		}
			
		return list2;
	}



	@Override
	public boolean getRegisterNewFriend(Friend friend) {
		// TODO Auto-generated method stub
	boolean flag=repo.existsById(friend.getId());
	if(flag==true) {
		return false;
		
	}else {
		repo.saveAndFlush(friend);
		return true;
	}
	}

}
