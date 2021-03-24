package com.springboot.microservices.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.microservices.dto.PlanDetailsDto;
import com.springboot.microservices.entity.PlanDetails;
import com.springboot.microservices.repo.PlanDetailsRepository;
import com.springboot.microservices.service.IPlanDetailsService;

@Service
public class PlanDetailsServiceImpl implements IPlanDetailsService {

	@Autowired
	private PlanDetailsRepository repo;
	
	
	@Override
	public List<PlanDetailsDto> getAllPlanDetails() {
		// TODO Auto-generated method stub

		List<PlanDetails> list = repo.findAll();
		List<PlanDetailsDto> list2 = new ArrayList<>();
		for (PlanDetails planDetails : list) {
			PlanDetailsDto dto = new PlanDetailsDto();
			
			BeanUtils.copyProperties(planDetails,dto);
		    
			list2.add(dto);  
		}
		return list2;
	}


	@Override
	public PlanDetailsDto getSpecificPlanDetails(Integer planId) {
		// TODO Auto-generated method stub

		Optional<PlanDetails>      opt = repo.findById(planId);
		PlanDetails   planDetails=opt.get();
		PlanDetailsDto   dto=new  PlanDetailsDto ();
		BeanUtils.copyProperties(planDetails,dto);
			return   dto;
	}


	@Override
	public String getCreateNewUser(PlanDetails planDetails) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = repo.existsById(planDetails.getPlanId());
		if (flag == true) {
			throw new Exception();
		}
		repo.saveAndFlush(planDetails);
		return "User  is   Added   to   Database";

	}


}
