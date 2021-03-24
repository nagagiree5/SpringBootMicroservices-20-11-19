package com.springboot.microservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.microservices.dto.PhoneNorDetailsDto;
import com.springboot.microservices.entity.PhoneNorDetails;
import com.springboot.microservices.service.IPhoneNorDetailsService;

@RestController
public class PhoneNorDetailsController {

	@Autowired
	IPhoneNorDetailsService service;
	
	@GetMapping(value="/phoneCallDeatils/{phoneNor}",  produces="application/json")
	public List<PhoneNorDetailsDto> letFindByPhnCallBy(@PathVariable  Long phoneNor) {
		return service.getFindByPhnCallBy(phoneNor);	
	}
	
	@PostMapping(value="/insertDataToDataBase",   consumes="application/json", produces="text/plain")          //This endpoint is optinal....
	public     String     letCreateNewUser(@RequestBody   PhoneNorDetails norDetails)  throws  Exception {
		return service.getCreateNewUser(norDetails);
	
	}
}
