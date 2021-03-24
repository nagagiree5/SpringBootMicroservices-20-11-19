package com.springboot.microservices.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.springboot.microservices.dto.PhoneNorDetailsDto;
import com.springboot.microservices.entity.PhoneNorDetails;
import com.springboot.microservices.repo.PhoneNorDetailsRepository;
import com.springboot.microservices.service.IPhoneNorDetailsService;

@Service
public class PhoneNorDetailsServiceImpl implements IPhoneNorDetailsService {

	@Autowired
	private PhoneNorDetailsRepository repo;

	@Override
	public List<PhoneNorDetailsDto> getFindByPhnCallBy(Long phoneNor) {
		// TODO Auto-generated method stub

		List<PhoneNorDetails> phnNorList = repo.findByPhnCallBy(phoneNor);
		List<PhoneNorDetailsDto> phnNorList2 = new ArrayList<>();
		for (PhoneNorDetails norDetails : phnNorList) {
			PhoneNorDetailsDto dto = new PhoneNorDetailsDto();
			dto.setPhnCallId(norDetails.getPhnCallId());
			
			dto.setPhnCallTo(norDetails.getPhnCallTo());
			dto.setTimeDurationSec(norDetails.getTimeDurationSec());
			dto.setPhnCallOn(norDetails.getPhnCallOn());
			dto.setPhnCallBy(norDetails.getPhnCallBy());
			phnNorList2.add(dto);  
		}
		return phnNorList2;
	}

	@Override
	public String getCreateNewUser(@RequestBody PhoneNorDetails norDetails) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = repo.existsById(norDetails.getPhnCallId());
		if (flag == true) {
			throw new Exception();
		}
		repo.saveAndFlush(norDetails);
		return "User  is   Added   to   Database";

	}

}
