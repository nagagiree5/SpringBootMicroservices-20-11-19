package com.springboot.microservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.microservices.dto.PlanDetailsDto;
import com.springboot.microservices.entity.PlanDetails;
import com.springboot.microservices.service.IPlanDetailsService;


@RestController
public class PlanDetailsController {

	@Autowired
	IPlanDetailsService service;
	
	@GetMapping(value="/getAllPlanDetails/all",  produces="application/json")
	public  List<PlanDetailsDto> letAllPlanDetails(){
		return service.getAllPlanDetails();
		
	}
	
	@GetMapping(value="/getSpecificPlan/{planId}",  produces="application/json")
	public    PlanDetailsDto letSpecificPlanDetails(@PathVariable Integer planId) {
		return service.getSpecificPlanDetails(planId);
	
	}
	
	@PostMapping(value="/insertDataToDataBase",   consumes="application/json", produces="text/plain")      //This endpoint is optinal....
	public String letCreateNewUser(@RequestBody PlanDetails planDetails) throws Exception{
		return service.getCreateNewUser(planDetails);
	}
	
	
	
}
