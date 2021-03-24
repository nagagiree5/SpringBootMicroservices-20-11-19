package com.springboot.microservices.service.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.microservices.dto.CustomerDto;
import com.springboot.microservices.dto.ForLogin;
import com.springboot.microservices.entity.Customer;
import com.springboot.microservices.repo.CustomerRepository;
import com.springboot.microservices.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	CustomerRepository repo;
	
	@Override
	public String getSave(Customer customer) {
		// TODO Auto-generated method stub
	
		boolean flag=repo.existsById(customer.getPhoneNor());
		if(flag==true) {
			return "Registration is fail..";
			
		}else {
			repo.saveAndFlush(customer);
			return "Registration is successful....";
		}
	}

	@Override
	public CustomerDto getFindByPhoneNor(Long phoneNor) {
		// TODO Auto-generated method stub
		Optional<Customer> opt=repo.findById(phoneNor);
		Customer customer=opt.get();
		CustomerDto dto=new CustomerDto();
		BeanUtils.copyProperties(customer, dto);
		return dto;
	}

	@Override
	public boolean getVerification(ForLogin login) {
		// TODO Auto-generated method stub
		if(repo.existsById(login.getPhoneNor())) {
			Optional<Customer> opt=repo.findById(login.getPhoneNor());
			Customer customer=opt.get();
			if(customer.getPassword().equals(login.getPassword())) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}

	
	
	
}
