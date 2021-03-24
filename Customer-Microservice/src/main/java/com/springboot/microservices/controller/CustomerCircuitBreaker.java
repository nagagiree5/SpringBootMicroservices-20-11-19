package com.springboot.microservices.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import com.springboot.microservices.dto.PlanDetailsDto;
import com.springboot.microservices.feignclient.IFriendFeign;
import com.springboot.microservices.feignclient.IPlanFeign;


@Service
public class CustomerCircuitBreaker {
 final static String FRIEND_URL="http://FRIENDINSTANCE-MS/Microservices/geRegisterPhoneNors/{phoneNor}";
//final static String PLAN_URL="http://PLANDETAILSMICROSERVICE-2/Microservices/getSpecificPlan/{planId}";
 
	/*
	 * @Autowired RestTemplate restTemplate;
	 */
 
	@Autowired
	IFriendFeign   friendFeign;
	@Autowired
	IPlanFeign   planFeign;
	
	@HystrixCommand(fallbackMethod="getFriendsCallback")
	public   List<Long>   getFriends(Long  phoneNor) {
		System.out.println("getFriends()");

		 //ResponseEntity<List<Long>> friends=restTemplate.exchange(FRIEND_URL,HttpMethod.GET,null,new ParameterizedTypeReference<List<Long>>() {},phoneNor);
		ResponseEntity<List<Long>> friends=friendFeign.getFriendsRegisterPhoneNors(phoneNor);
		List<Long>  friendsList=friends.getBody();
		return  friendsList;
		
	}
	
	//For Asynchronous...
	/*
	 * public Future<PlanDetailsDto> getSpecificPlanAsync(Integer planId) { return
	 * new AsyncResult<PlanDetailsDto>() { public PlanDetailsDto invoke() { //return
	 * restTemplate.getForObject(PLAN_URL, PlanDetailsDto.class, planId); return
	 * planFeign.getSpecificPlanDetails(planId); }
	 * 
	 * };
	 * 
	 * }
	 */
	
	public   List<Long>    getFriendsCallback(Long  phoneNo) {
		System.out.println("getFriendsCallback()...");
		return   new   ArrayList<Long>();
	}
	
}
