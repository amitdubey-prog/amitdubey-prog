package com.amit.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.amit.service.StudentService;

@EnableWebSecurity(debug = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	StudentService studentService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(studentService);
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers(HttpMethod.POST, "/students").permitAll()
			.anyRequest().authenticated()
			.and()
			.httpBasic()
			.and()
			.formLogin()
			.and()
			.addFilterBefore(Myauthenticationfillter(), UsernamePasswordAuthenticationFilter.class);
		
	}
	private CustomSecurityConfig Myauthenticationfillter() throws Exception {
		
		CustomSecurityConfig filter = new CustomSecurityConfig(authenticationManager());
		
		return filter;
	}
}
