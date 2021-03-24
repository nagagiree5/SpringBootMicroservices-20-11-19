package com.springboot.microservices.dto;

import java.util.List;

public class CustomerDto {

	private Long phoneNor;
	private String name;
	private Integer age;
	private Integer planId;
	   
	private PlanDetailsDto currentPlan;
	private List<Long> friends;
	public Long getPhoneNor() {
		return phoneNor;
	}
	public void setPhoneNor(Long phoneNor) {
		this.phoneNor = phoneNor;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getPlanId() {
		return planId;
	}
	public void setPlanId(Integer planId) {
		this.planId = planId;
	}
	public PlanDetailsDto getCurrentPlan() {
		return currentPlan;
	}
	public void setCurrentPlan(PlanDetailsDto currentPlan) {
		this.currentPlan = currentPlan;
	}
	public List<Long> getFriends() {
		return friends;
	}
	public void setFriends(List<Long> friends) {
		this.friends = friends;
	}
	
	// Setters and Getters 
	
	
	
	 



}
