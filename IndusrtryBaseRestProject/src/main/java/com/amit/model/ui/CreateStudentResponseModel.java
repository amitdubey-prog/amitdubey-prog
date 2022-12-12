package com.amit.model.ui;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateStudentResponseModel {
	
	private String first_name;
	private String last_name;
	private String email;
	private String user_id;

}
