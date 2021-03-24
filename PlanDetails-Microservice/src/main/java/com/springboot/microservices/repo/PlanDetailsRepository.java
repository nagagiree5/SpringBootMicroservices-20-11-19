package com.springboot.microservices.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.microservices.entity.PlanDetails;

public interface PlanDetailsRepository extends JpaRepository<PlanDetails,Integer> {

}
