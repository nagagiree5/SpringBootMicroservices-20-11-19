package com.springboot.microservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.microservices.entity.Friend;
import com.springboot.microservices.service.IFriendService;


@RestController
public class FriendController {

	@Autowired
	IFriendService  service;
	
	@PostMapping(value="/friend/registerFriend",   consumes="application/json", produces="text/plain") 
	 
	public String    letRegisterNewFriend(@RequestBody Friend friend) {
	boolean flag=service.getRegisterNewFriend(friend);
	if(flag==true) {
		return "Registration is successful...";
		
	}else {
		return "Registration is fail...";
	}  
	
	}
	
	@GetMapping(value="/geRegisterPhoneNors/{phoneNor}",  produces="application/json")
	List<Long> getFriendsRegisterPhoneNors(@PathVariable Long phoneNor){
	System.out.println("Instance 9493...");
		return service.getFriendsRegisterPhoneNors(phoneNor);
		
	}
}
