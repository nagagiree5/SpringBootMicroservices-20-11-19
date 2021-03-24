package com.springboot.microservices.service;

import com.springboot.microservices.dto.CustomerDto;
import com.springboot.microservices.dto.ForLogin;
import com.springboot.microservices.entity.Customer;


public interface ICustomerService {
	
	String     getSave(Customer Customer);
	CustomerDto   getFindByPhoneNor(Long phoneNor);
	boolean    getVerification(ForLogin login);
}