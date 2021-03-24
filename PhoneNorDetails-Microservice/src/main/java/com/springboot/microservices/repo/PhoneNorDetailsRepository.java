package com.springboot.microservices.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.microservices.entity.PhoneNorDetails;

@Repository
public interface PhoneNorDetailsRepository extends JpaRepository<PhoneNorDetails, Integer> {

	List<PhoneNorDetails>   findByPhnCallBy(Long phoneNor);
	
}
