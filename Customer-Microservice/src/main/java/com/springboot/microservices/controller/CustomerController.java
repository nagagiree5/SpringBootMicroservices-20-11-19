package com.springboot.microservices.controller;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.microservices.dto.CustomerDto;
import com.springboot.microservices.dto.ForLogin;
import com.springboot.microservices.dto.PlanDetailsDto;
import com.springboot.microservices.entity.Customer;
import com.springboot.microservices.feignclient.IFriendFeign;
import com.springboot.microservices.feignclient.IPlanFeign;
import com.springboot.microservices.service.ICustomerService;

@RestController
@RibbonClient(name = "custmicro")
public class CustomerController {

	//final static String FRIEND_URL="http://FRIENDINSTANCE-MS/Microservices/geRegisterPhoneNors/{phoneNor}";
	final static String PLAN_URL="http://PLANDETAILSMICROSERVICE-2/Microservices/getSpecificPlan/{planId}";
	
	@Autowired
	ICustomerService service;
	
	/*
	 * @Autowired RestTemplate restTemplate;
	 */
	
	@Autowired
	CustomerCircuitBreaker   breaker;
	
	@Autowired
	IFriendFeign   friendFeign;
	
	@Autowired
	IPlanFeign   planFeign;
	
	
	@PostMapping(value="/customer/register",   consumes="application/json", produces="text/plain") 
	public String    letRegisterNewFriend(@RequestBody Customer customer) {
		return service.getSave(customer);
	
	}
	@PostMapping(value="/customer/login",   consumes="application/json") 
	public boolean    letVerify(@RequestBody ForLogin login) {
		return service.getVerification(login);
		
	}
	@GetMapping(value="/viewProfle/{phoneNor}",  produces="application/json")
	public CustomerDto getViewProfile(@PathVariable Long phoneNor){
		
		CustomerDto dto=service.getFindByPhoneNor(phoneNor);
		
		// To call Friend_MS...
		// List<Long> friends=restTemplate.getForObject(FRIEND_URL,List.class,phoneNor);
		/*
		 * ResponseEntity<List<Long>> friends=restTemplate.exchange(FRIEND_URL,
		 * HttpMethod.GET,null,new ParameterizedTypeReference<List<Long>>() { },
		 * phoneNor); List<Long> friendsList=friends.getBody();
		 * dto.setFriends(friendsList);
		 */
		
		
		/*
		 * Call   circuit breaker instead of calling friend microservice
		 * circuit breaker is added with hystrix support, 
		 * so it calls fallbackMethod when circuit is open...
		 */
		long  x=System.currentTimeMillis();
		
		Long  phoneNum=dto.getPhoneNor();
		List<Long>  friendsList = breaker.getFriends(phoneNor);
		dto.setFriends( friendsList);
		
		// To call PlanDetails_MS...
		Integer planId=dto.getPlanId();
		//PlanDetailsDto planDetailsDto=restTemplate.getForObject(PLAN_URL, PlanDetailsDto.class,planId);
		
		//RestTemplate restTemplate2=new RestTemplate();
		
		//PlanDetailsDto planDetailsDto=restTemplate.getForObject(PLAN_URL, PlanDetailsDto.class,planId);
		PlanDetailsDto planDetailsDto=planFeign.getSpecificPlanDetails(planId);
		dto.setCurrentPlan(planDetailsDto);
	//For Asynchronous...
		/*
		 * try { Future<PlanDetailsDto> future=breaker.getSpecificPlanAsync(planId);
		 * PlanDetailsDto planDetailsDto=future.get();
		 * dto.setCurrentPlan(planDetailsDto);
		 * 
		 * 
		 * } catch (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (ExecutionException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 */ 
		
		long  y= System.currentTimeMillis();
		System.out.println("Time taken in ms... : "+(y-x));
		
		return dto;
		
	}
	   
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
