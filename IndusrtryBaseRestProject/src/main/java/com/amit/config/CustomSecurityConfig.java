package com.amit.config;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class CustomSecurityConfig extends UsernamePasswordAuthenticationFilter {

	
	private AuthenticationManager authenticationManager;
	public CustomSecurityConfig(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		
		String userName = getUserName(request);
		String passwordName = getPasswordName(request);
		
		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
				userName, passwordName,new ArrayList<>());
		Authentication authenticate = authenticationManager.authenticate(authRequest);
		
		return authenticate;
	}

	private String getPasswordName(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return request.getParameter("password");
	}

	private String getUserName(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return request.getParameter("username");
	}
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		
		SecurityContextHolder.getContext().setAuthentication(authResult);
		
		
	}
}
