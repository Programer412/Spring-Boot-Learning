package com.gaurav;

import java.util.List;

import org.hibernate.internal.build.AllowSysOut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.gaurav.entities.Student;
import com.gaurav.repository.StudentRepo;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(Application.class, args);
	StudentRepo stRepo=context.getBean(StudentRepo.class);
	
	Student st=new Student();
	
//	st.setName("gaurav");
//st.setAddress("india");
//stRepo.save(st);

//Student std=new Student();
//std.setName("pamkaj");
//std.setAddress("pak");
//stRepo.save(std);

//List<Student>list=(List<Student>)stRepo.findAll();
//for(Student sts:list)
//{
//	System.out.println(sts);
//	
//}

//list.forEach(student->System.out.println(student));

//Student sti=stRepo.findById(2).get();
//System.out.println(sti);
//
//sti.setName("hello world");
//sti.setAddress("England");
//Student l=stRepo.save(sti);
//System.out.println("updated Succesfully");
//System.out.println(l);


//stRepo.delete(st);
//System.out.println("delete succefully");
	
	//get student by name
/*Student std=stRepo.findByName("pamkaj");
System.out.println(std);
*/
// get student by address
	
/*
 * Student std=stRepo.findByAddress("pak"); System.out.println(std);
 */
	
	//Student std=stRepo.findByNameAndAddress("pamkaj", "india");
	/*
	 * List<Student> std= (List<Student>)stRepo.findByNameOrAddress("pamkaj",
	 * "india"); std.forEach(s->System.out.println(std));
	 */


	/*
	 * List<Student> std= (List<Student>)stRepo.findByAddressIsNull();
	 * std.forEach(s->System.out.println(std));
	 */

	/*
	 * List<Student> std= (List<Student>)stRepo.findByAddressIsNotNull();
	 * std.forEach(s->System.out.println(std));
	 */
	
	/*
	 * List<Student> std=stRepo.findByNameLike("gaurav");
	 * 
	 * std.forEach(s->System.out.println(s));
	 */
	
	
	/*
	 * List<Student> std=stRepo.findByNameStartsWith("g");
	 * 
	 * std.forEach(s->System.out.println(s));
	 */
	
	/*
	 * List<Student> std=stRepo.findByNameContaining("a");
	 * 
	 * std.forEach(s->System.out.println(s));
	 */
	
	
	/*
	 * List<Student> std=stRepo.findByOrderByNameDesc();
	 * 
	 * std.forEach(s->System.out.println(s));
	 */
	
	/*
	 * Boolean f=stRepo.existsByName("gaurav"); System.out.println(f);
	 */
	
	//custom query using
	
	/*
	 * Student std=stRepo.getStudentfindByNameAndAddress("pamkaj", "pak");
	 * System.out.println(std);
	 */

	
	/*
	 * List<Student> std=stRepo.searchname("gaurav"); System.out.println(std);
	 */

 //pagination

	Sort sort=Sort.by("id").ascending();//we can use decending here
	List<Student> listsort=stRepo.findAll(sort);
	
	System.out.println("----sorting Student details---");
	listsort.forEach(s->System.out.println(s));
	System.out.println("-------");
	
//	Pageable pageable=PageRequest.of(2,5,sort);
//	
//
//	Page<Student> p=stRepo.findAll(pageable);
//	p.get().forEach(e->System.out.println(e));
//	System.out.println("size "+p.getSize());
//	
//	System.out.println("elements "+p.getTotalElements());
//	
//	System.out.println("Pages"+p.getTotalPages());
//	
	}

}
