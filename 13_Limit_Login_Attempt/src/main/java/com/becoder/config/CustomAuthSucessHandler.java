package com.becoder.config;

import java.io.IOException;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.becoder.entity.User;
import com.becoder.repository.UserRepo;
import com.becoder.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomAuthSucessHandler implements AuthenticationSuccessHandler {
	

	/*
	 * @Autowired private UserRepo userRepo;
	 */
	@Autowired
	private UserService userService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
	
		Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
		
		  CustomUser customUser=(CustomUser)authentication.getPrincipal(); 
		User user=customUser.getUser();
		 
		/*
		 * String email=request.getParameter("username");
		 * 
		 * User user=userRepo.findByEmail(email);
		 */
if(user!=null)
{
	System.out.println("hello world");
	userService.resetAttempt(user.getEmail());
}


if (roles.contains("ROLE_ADMIN")) {
		//so here i can use user as well as admin because i use hasAnyRole and i give access admin to both user and admin page
			response.sendRedirect("/user/profile");
			
		} else {
			response.sendRedirect("/user/profile");
		}

	}

}
