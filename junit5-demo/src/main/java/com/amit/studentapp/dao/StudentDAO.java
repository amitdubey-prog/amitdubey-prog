package com.amit.studentapp.dao;

import com.amit.studentapp.dto.Student;

public interface StudentDAO {

	
	int saveStudent(Student student); // 0: not saved 1 : saved to DB
}
