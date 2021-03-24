package com.springboot.microservices.service;

import java.util.List;

import com.springboot.microservices.dto.PlanDetailsDto;

import com.springboot.microservices.entity.PlanDetails;


public interface IPlanDetailsService {

	
	List<PlanDetailsDto> getAllPlanDetails() ;
	PlanDetailsDto getSpecificPlanDetails(Integer planId) ;
	String     getCreateNewUser(PlanDetails planDetails)  throws  Exception;
	
}
