package com.springboot.microservices.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("FRIENDINSTANCE-MS")
public interface IFriendFeign {
	

	@RequestMapping(value="/Microservices/geRegisterPhoneNors/{phoneNor}")
	public ResponseEntity<List<Long>> getFriendsRegisterPhoneNors(@PathVariable("phoneNor") Long phoneNor);
	
}
