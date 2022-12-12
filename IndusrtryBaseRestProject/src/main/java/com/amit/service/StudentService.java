package com.amit.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.amit.dto.StudentDTO;


public interface StudentService extends UserDetailsService{
	
	  StudentDTO createStudent(StudentDTO studentDto);

}
