package com.springboot.microservices.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.microservices.entity.Friend;


public interface FriendRepository extends JpaRepository<Friend,Integer> {

	List<Friend>   findByPhoneNor(Long phoneNor);
	
	
}
