package com.springboot.microservices.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.microservices.dto.PlanDetailsDto;

@FeignClient("PLANDETAILSMICROSERVICE-2")
public interface IPlanFeign {
	

	@RequestMapping(value="/Microservices/getSpecificPlan/{planId}")
	public    PlanDetailsDto getSpecificPlanDetails(@PathVariable("planId") Integer planId);
	
	
}
