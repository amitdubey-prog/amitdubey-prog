package com.amit.studentapp.service;

import com.amit.studentapp.dao.StudentDAO;
import com.amit.studentapp.dto.Student;

public class StudentServiceImpl implements StudentService {

	StudentDAO studentdao;

	public StudentDAO getStudentdao() {
		return studentdao;
	}

	public void setStudentdao(StudentDAO studentdao) {
		this.studentdao = studentdao;
	}

	@Override
	public boolean enrollstudent(Student student) {
		boolean ret = false;

		int isSaved = studentdao.saveStudent(student);

		if (isSaved == 1) {
			ret = true;
			if (ret) {
				System.out.println("Sending an enrollment email");
			}
			return ret;
		}

		return ret;
	}

}
