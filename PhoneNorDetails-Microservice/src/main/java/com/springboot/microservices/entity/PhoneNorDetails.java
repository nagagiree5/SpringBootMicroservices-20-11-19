package com.springboot.microservices.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "phonenordetails")
public class PhoneNorDetails {
	@Id
	@Column(name="phn_call_id",length =5)
	private Integer phnCallId;

	@Column(name="phn_call_by",length =25)
	private Long phnCallBy;
	
	@Column(name="phn_call_to",length =25)
	private Long  phnCallTo;
	
	@Column(name="phn_call_on")
	@Temporal(TemporalType.DATE)
	private Date phnCallOn;
	   
	@Column(name="time_duration_sec",length =25)
	private Long  timeDurationSec;

	
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
