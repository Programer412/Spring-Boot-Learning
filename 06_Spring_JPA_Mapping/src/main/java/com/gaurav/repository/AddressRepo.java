package com.gaurav.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gaurav.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Integer>{

}
