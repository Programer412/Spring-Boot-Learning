package com.gaurav.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gaurav.service.UserService;

@Controller
public class HomeController {

//	@Autowired
	private UserService userService;

	public HomeController(UserService userService)
	{
		System.out.println("constructor injection");
		this.userService =userService;
	}
	@RequestMapping("/")
	public String Home()
	{
		return "home";
	}
	
	@RequestMapping("/createUser")
	public String registerUser()
	{
		
		String msg=userService.saveUser();
		System.out.println(msg);
		return "success";
	}
	
}
