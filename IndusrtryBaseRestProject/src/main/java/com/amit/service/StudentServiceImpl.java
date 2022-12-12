package com.amit.service;

import java.util.ArrayList;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.amit.dto.StudentDTO;
import com.amit.entity.Student;
import com.amit.repo.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepo studentRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public StudentDTO createStudent(StudentDTO studentDto) {

		studentDto.setUser_id(UUID.randomUUID().toString());
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		// studentDto ->Student
		Student student = modelMapper.map(studentDto, Student.class);
		String encodedPassword = passwordEncoder.encode(studentDto.getPassword());
		student.setEncrypted_password(encodedPassword);

		Student student1 = studentRepo.save(student);

		StudentDTO studentDTO = modelMapper.map(student1, StudentDTO.class);
		return studentDTO;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Student customer = studentRepo.findByEmail(username);
		if (customer == null) {
			throw new UsernameNotFoundException("Username " + username + " not existed in  our DB");
		}
		return new User(customer.getEmail(), customer.getEncrypted_password(), new ArrayList<>());
	}

}
