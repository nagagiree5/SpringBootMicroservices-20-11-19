package com.springboot.microservices.dto;

public class PlanDetailsDto {

	private Integer planId;
	private String planName;
	private String  tenure;
	
	// Setters and Getters
	
	
	public Integer getPlanId() {
		return planId;
	}

	public void setPlanId(Integer planId) {
		this.planId = planId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getTenure() {
		return tenure;
	}

	public void setTenure(String tenure) {
		this.tenure = tenure;
	}
	


	
}
