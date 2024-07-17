package com.gaurav.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();

	}

	@Bean
	public UserDetailsService getDetailsService() {
		return new CustomUserDetailsService();
	}

	@Bean
	public DaoAuthenticationProvider authencationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();

		// daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());

		daoAuthenticationProvider.setUserDetailsService(getDetailsService());

		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());

		return daoAuthenticationProvider;
	}

	/*
	 * Yes, you’re absolutely right! Let’s break down the process:
	 * 
	 * Storing Passwords (Registration or Password Change): When a user registers or
	 * changes their password, the plain-text password they provide is converted
	 * into a hashed (encoded) password. The
	 * daoAuthenticationProvider.setPasswordEncoder(passwordEncoder()) configuration
	 * ensures that the password is securely hashed using the configured
	 * PasswordEncoder. The hashed password is then stored in the database.
	 * Authentication (Login) Process: When a user tries to log in: They enter their
	 * plain-text password in the login form. Spring Security internally hashes this
	 * plain-text password using the same PasswordEncoder. The hashed password from
	 * the form is compared with the stored hashed password (retrieved from the
	 * UserDetailsService). If the hashes match, authentication succeeds, and the
	 * user is considered authenticated. Summary: The PasswordEncoder ensures
	 * consistent and secure password handling during both storage and
	 * authentication. The UserDetailsService retrieves user details (including the
	 * hashed password) during authentication. By combining these components, Spring
	 * Security provides a robust authentication process. Feel free to ask if you
	 * have any more questions or need further clarification! 😊
	 */

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		/*
		 * http.csrf().disable().authorizeHttpRequests()
		 * .requestMatchers("/").permitAll().anyRequest().authenticated().and().
		 * formLogin();
		 */
		http.csrf().disable().authorizeHttpRequests().requestMatchers("/").permitAll().anyRequest().authenticated()
				.and().formLogin().loginPage("/signin").loginProcessingUrl("/userlogin").defaultSuccessUrl("/about")
				.permitAll()
				// .failureUrl("/invalid")
				.and().logout().logoutSuccessUrl("/userlogout").permitAll();

		return http.build();
	}

}
