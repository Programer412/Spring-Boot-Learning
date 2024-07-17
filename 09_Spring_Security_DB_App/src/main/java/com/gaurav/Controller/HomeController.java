package com.gaurav.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	
	//@RequestMapping(method=RequestMethod.GET,value="/")
	@GetMapping("/")
	public String index()
{
	return"index";
}
	@GetMapping("/about")
	public String about()
	{
		return "about";
	}
	@GetMapping("/profile")
	public String profile()
	{
		return"profile";
	}
	@GetMapping("/signin")
	public String signin()
	{
		return"login";
	}
	@GetMapping("/invalid")
	public String invalid()
	{
		return "error";
	}
	@GetMapping("/userlogout")
	public String logout()
	{
		return "logout";
	}
	

	

}
