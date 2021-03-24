package com.springboot.microservices.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.microservices.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
