package com.amit.studentapp.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.amit.studentapp.dao.StudentDAO;
import com.amit.studentapp.dto.Student;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {

	@InjectMocks
	StudentServiceImpl studentserviceimple;

	@Mock
	StudentDAO studentdao;

	@Test
	void testEnrollstudent() {
		Student amit = new Student(1, "Amit", "India");

		Mockito.when(studentdao.saveStudent(amit)).thenReturn(1);
		boolean isEnrolled = studentserviceimple.enrollstudent(amit);
		assertTrue(isEnrolled);

	}

	@Test
	void testEnrollstudent_withZerovalue() {
		Student amit = new Student(1, "Amit", "India");

		Mockito.when(studentdao.saveStudent(amit)).thenReturn(0);
		boolean isEnrolled = studentserviceimple.enrollstudent(amit);
		assertFalse(isEnrolled);

	}

}
