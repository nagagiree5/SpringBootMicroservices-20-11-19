package com.springboot.microservices.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

	
	@Id
	@Column(name="phone_nor",length =15)
	private Long phoneNor;

	@Column(name="name",length =25)
	private String name;
	
	@Column(name="age",length =5)
	private Integer  age;
	
	@Column(name="plan_id",length =15)
	private Integer  planId;
	
	@Column(name="password")
	private String password;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	// Setters and Getters  
	
	
	
	
	


	
}
