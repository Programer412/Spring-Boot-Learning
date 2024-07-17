package com.gaurav.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.gaurav.repository.UserDao;
//@Component
@Service
public class UserService {
	//@Autowired
	private UserDao userDao;  // this is called a setter injection
	
	public UserService(UserDao userDao)
	{
		System.out.println("this is call const");
		this.userDao=userDao;
	}

	public String saveUser()
	{
		boolean f=userDao.save();
		if(f)
		{
			return "Register success";
		}
		else {
			return "server error";
		}
	}
}
