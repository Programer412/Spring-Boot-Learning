package com.gaurav.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.gaurav.entity.Employee;

public class CustomUser implements UserDetails{

	private Employee emp;
	
	public CustomUser(Employee emp)
	{
		super();
		this.emp=emp;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	
		SimpleGrantedAuthority authority=new SimpleGrantedAuthority(emp.getRole());
		
		List<SimpleGrantedAuthority> list= new ArrayList();
		list.add(authority);
		return list;
		//return Arrays.asList(authority);
	}

	@Override
	public String getPassword() {
	
		return emp.getPassword();
	}

	@Override
	public String getUsername() {
		
		return emp.getEmail();
	}

}
