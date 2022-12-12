package com.amit.model.ui;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateStudentRequestModel {
	
	@NotNull(message = "Firstname can't be null")
	private String first_name;
	@NotNull(message = "Lastname can't be null")
	private String last_name;
	@NotNull(message = "email can't be null")
	private String email;
	@NotNull(message = "password can't be null")
	@Size(min = 8,max = 12,message = "password should be 8 to 12 characters.")
	private String password;

}
