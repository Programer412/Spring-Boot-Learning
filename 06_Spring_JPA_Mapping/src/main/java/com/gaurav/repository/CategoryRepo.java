package com.gaurav.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gaurav.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
