package com.springboot.microservices.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "plandetails")
public class PlanDetails {

	
	@Id
	@Column(name="plan_id",length =5)
	private Integer planId;

	@Column(name="plan_name",length =25)
	private String planName;
	
	@Column(name="tenure",length =35)
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
