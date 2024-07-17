package com.gaurav.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gaurav.entity.Employee;

public interface EmpRepo extends JpaRepository<Employee, Integer>{
	
	public Employee findByEmail(String email);

}
