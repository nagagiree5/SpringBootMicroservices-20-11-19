package com.springboot.microservices.service;

import java.util.List;

import com.springboot.microservices.dto.PhoneNorDetailsDto;
import com.springboot.microservices.entity.PhoneNorDetails;

public interface IPhoneNorDetailsService {

	List<PhoneNorDetailsDto>   getFindByPhnCallBy(Long phoneNor);
	String     getCreateNewUser(PhoneNorDetails norDetails)  throws  Exception;
}