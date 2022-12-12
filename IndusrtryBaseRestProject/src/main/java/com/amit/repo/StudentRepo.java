package com.amit.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amit.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{
	
	Student findByEmail(String email);

}
