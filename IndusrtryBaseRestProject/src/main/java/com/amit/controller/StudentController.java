package com.amit.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amit.dto.StudentDTO;
import com.amit.model.ui.CreateStudentRequestModel;
import com.amit.model.ui.CreateStudentResponseModel;
import com.amit.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/test")
	public String test() {
		return "testing...";
		

		
	}

	@PostMapping("/students")
	public ResponseEntity<CreateStudentResponseModel> createStudent(
			@Valid @RequestBody CreateStudentRequestModel requestModel) {

		// accept the request : ->
		// to save the request do a service call: StudentDTo
		// CreateStudentRequestModel ->StudentDTO

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		StudentDTO studentDTO = modelMapper.map(requestModel, StudentDTO.class);
		StudentDTO dto = studentService.createStudent(studentDTO);

		CreateStudentResponseModel response = modelMapper.map(dto, CreateStudentResponseModel.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);

	}

}
