package com.pack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

//import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pack.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	List<com.pack.entity.Employee>    findByDeptno(Integer  deptno);
   // List<com.pack.entity.Employee> findAllEmps();
}
	
