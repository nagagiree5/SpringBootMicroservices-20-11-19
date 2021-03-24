package com.springboot.microservices.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


public class PhoneNorDetailsDto {
	
	private Integer phnCallId;
    private Long phnCallBy;
	private Long phnCallTo;
	private Date phnCallOn;       
	private Long timeDurationSec;
	
	
	
	// Setters and Getters
	
	
	
	public Integer getPhnCallId() {
		return phnCallId;
	}
	public void setPhnCallId(Integer phnCallId) {
		this.phnCallId = phnCallId;
	}
	public Long getPhnCallBy() {
		return phnCallBy;
	}
	public void setPhnCallBy(Long phnCallBy) {
		this.phnCallBy = phnCallBy;
	}
	public Long getPhnCallTo() {
		return phnCallTo;
	}
	public void setPhnCallTo(Long phnCallTo) {
		this.phnCallTo = phnCallTo;
	}
	public Date getPhnCallOn() {
		return phnCallOn;
	}
	public void setPhnCallOn(Date phnCallOn) {
		this.phnCallOn = phnCallOn;
	}
	public Long getTimeDurationSec() {
		return timeDurationSec;
	}
	public void setTimeDurationSec(Long timeDurationSec) {
		this.timeDurationSec = timeDurationSec;
	}
	
	
	
}
