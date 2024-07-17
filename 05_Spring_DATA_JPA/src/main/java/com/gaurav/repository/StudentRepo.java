package com.gaurav.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.gaurav.entities.Student;

//public interface StudentRepo extends CrudRepository<Student,Integer>{
public interface StudentRepo extends JpaRepository<Student, Integer> {

	Student findByName(String name);

	Student findByAddress(String name);

	Student findByNameAndAddress(String name, String address);

	@Query("select u from Student u where u.name=?1 and u.address=?2")
	Student getStudentfindByNameAndAddress(String name, String address);

	@Query("select u from Student u where u.name like:nm")
	List<Student> searchname(@Param(value = "nm") String nm);

	
	  @Query("select q from Student q where q.name=:nm or q.address=:ad") 
	  
	  Student getStudentfindByNameOrAddress(@Param("nm")String nm,@Param("ad")String ad);
	 
	List<Student> findByNameOrAddress(String name, String address);

	List<Student> findByAddressIsNull();

	List<Student> findByAddressIsNotNull();

	List<Student> findByNameLike(String name);

	List<Student> findByNameStartsWith(String ch);

	List<Student> findByNameContaining(String ch);

	List<Student> findByOrderByNameDesc();

	boolean existsByName(String name);

}
