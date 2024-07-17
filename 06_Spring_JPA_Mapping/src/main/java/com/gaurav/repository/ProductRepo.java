package com.gaurav.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gaurav.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

}
