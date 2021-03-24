package com.springboot.microservices.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FRIENDS")
public class Friend {

	@Id
    private Integer id;

	private Long phoneNor;

	private Long friendNor;

	
	// Setters and Getters
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getPhoneNor() {
		return phoneNor;
	}

	public void setPhoneNor(Long phoneNor) {
		this.phoneNor = phoneNor;
	}

	public Long getFriendNor() {
		return friendNor;
	}

	public void setFriendNor(Long friendNor) {
		this.friendNor = friendNor;
	}  
	

	


	
}
