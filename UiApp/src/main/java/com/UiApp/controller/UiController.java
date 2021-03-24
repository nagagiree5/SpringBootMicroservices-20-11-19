package com.UiApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.UiApp.model.Customer;
import com.UiApp.model.CustomerDTO;
import com.UiApp.model.Login;

@Controller
public class UiController {
	RestTemplate    restTemplate=new  RestTemplate();
	
	@GetMapping(value="/register") 
	public    String   getRegistrationPage(Model  model) {
		model.addAttribute("customer", new Customer());
		return    "registration";
	}
	@PostMapping(value="/signup")
	public    String     registerCustomer(@ModelAttribute Customer  customer, Model  model) {
		
		String   msg = restTemplate.postForObject("http://localhost:4004/CustomerMicroservice/register",customer,String.class);
		model.addAttribute("message", msg);
		return   "success";
	}
	
	@GetMapping(value="/login")
	public     String     getLoginPage(Model   model)
	{
		model.addAttribute("login", new  Login());
		return   "login";
	}
	
	@PostMapping(value="/doLogin")
	public    String     checkLogin(@ModelAttribute   Login   login) {
		boolean  flag=restTemplate.postForObject("http://localhost:4004/CustomerMicroservice/login", login, Boolean.class);
		if(flag==true) {
			return    "home";
		}
		else {
			return  "login";
		}
	}

	@GetMapping(value="/profile")
	public    String    getCustomerProfile(@RequestParam  Long  phoneNo, Model   model) {
		CustomerDTO   dto=restTemplate.getForObject("http://localhost:4004/CustomerMicroservice/viewProfile/{phoneNo}", CustomerDTO.class, phoneNo);
		model.addAttribute("dto", dto);
		return   "profile";
	}
}
