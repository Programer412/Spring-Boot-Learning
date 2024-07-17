package com.gaurav.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gaurav.entity.Emp;

public interface EmpRepo extends JpaRepository<Emp,Integer>{

}
