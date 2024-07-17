package com.gaurav;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.FileSystemUtils;

import com.gaurav.entity.Address;
import com.gaurav.entity.Category;
import com.gaurav.entity.Emp;
import com.gaurav.entity.Mobile;
import com.gaurav.entity.Product;
import com.gaurav.repository.AddressRepo;
import com.gaurav.repository.CategoryRepo;
import com.gaurav.repository.EmpRepo;
import com.gaurav.repository.MobileRepo;
import com.gaurav.repository.ProductRepo;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	private EmpRepo empRepo;

	@Autowired
	private MobileRepo mobileRepo;

	@Autowired
	private AddressRepo addressRepo;
	
	@Autowired
	private CategoryRepo cateRepo;
	
	@Autowired
	private ProductRepo pRepo;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		/*
		 * Emp emp = new Emp(); emp.setEmpName("pankaj");
		 * 
		 * Mobile mb = new Mobile(); mb.setMobilename("Nokia1"); //emp.setMobile(mb);
		 * mb.setEmp(emp); empRepo.save(emp); mobileRepo.save(mb);
		 * 
		 * 
		 * 
		 * System.out.println("save success");
		 */

		/*
		 * Emp emp = empRepo.findById(1).get();
		 * 
		 * System.out.println("Name= " + emp.getEmpName());
		 * System.out.println("Mobile= " + emp.getMobile().getMobilename()); Mobile
		 * m=mobileRepo.findById(2).get();
		 * 
		 * System.out.println("Emp Name= " + m.getEmp().getEmpName());
		 * System.out.println("Mobile= " + m.getMobilename());
		 */

		// OneToMany ManyToOne
		/*
		 * Emp emp=new Emp();
		 * 
		 * emp.setEmpName("hola");
		 * 
		 * Address ad=new Address(); ad.setAddress("india");
		 * ad.setType("current address");
		 * 
		 * ad.setEmp(emp);
		 * 
		 * Address ad2=new Address(); ad2.setAddress("pak");
		 * 
		 * ad2.setType("pemanent address");
		 * 
		 * ad2.setEmp(emp);
		 * 
		 * List<Address> list=new ArrayList<>(); list.add(ad); list.add(ad2);
		 * 
		 * 
		 * List<Address> list=Arrays.asList(ad,ad2); emp.setAddress(list);
		 * empRepo.save(emp); System.out.println("Save Success");
		 */

		
		/*
		 * Emp em=empRepo.findById(3).get(); System.out.println("Name="
		 * +em.getEmpName());
		 * 
		 * 
		 * 
		 * em.getAddress().forEach(e->System.out.println(e.getAddress()));
		 */
	
		/*
		 * Address ad=addressRepo.findById(3).get();
		 * System.out.println("Address= "+ad.getAddress());
		 * System.out.println("Emp Name= "+ad.getEmp().getEmpName());
		 */
	
		//Many to Many
		/*
		 * Category ca1=new Category(); ca1.setCategoryname("Electronics");
		 * 
		 * Category ca2=new Category(); ca2.setCategoryname("Mobile");
		 * 
		 * Product p1=new Product(); p1.setProductname("TV");
		 * 
		 * Product p2=new Product(); p2.setProductname("OnePlus");
		 * 
		 * Product p3=new Product(); p3.setProductname("Apple");
		 * 
		 * ca1.getProducts().add(p1); ca1.getProducts().add(p2);
		 * ca1.getProducts().add(p3);
		 * 
		 * ca2.getProducts().add(p2); ca2.getProducts().add(p3);
		 * 
		 * 
		 * p1.getCategories().add(ca1); p2.getCategories().add(ca1);
		 * p3.getCategories().add(ca1);
		 * 
		 * p2.getCategories().add(ca2); p3.getCategories().add(ca2);
		 * 
		 * cateRepo.save(ca1); cateRepo.save(ca2); System.out.println("Save Success");
		 */
		
		/*
		 * Category ca=cateRepo.findById(7).get();
		 * System.out.println(ca.getCategoryname());
		 * 
		 * ca.getProducts().forEach(e->System.out.println(e.getProductname()));
		 */
		
	Product p=pRepo.findById(6).get();
	System.out.println("Product name= "+ p.getProductname());
	
	p.getCategories().forEach(e->System.out.println(e.getCategoryname()));
	
	
	}
	

}
