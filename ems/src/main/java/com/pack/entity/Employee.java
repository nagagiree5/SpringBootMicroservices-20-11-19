package com.pack.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//import org.springframework.data.mongodb.core.mapping.Document;

//import org.springframework.data.annotation.Id;

@Entity
@Table(name="emp")
//@Document(collection="employees")
public class Employee implements Serializable{
	@Id
	private Integer empno;
	private String ename;
	private Double salary;
	private Integer deptno;
	public Integer getEmpno() { 
		return empno;
	}
	public void setEmpno(Integer empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
}
