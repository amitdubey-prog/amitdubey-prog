package com.amit.dto;

import lombok.Data;

@Data
public class StudentDTO {
	private String first_name;
	private String last_name;
	private String email;
	private String password;
	private String encrypted_password;
	private String user_id;

}
