package com.amit.demo;

import static org.junit.jupiter.api.Assertions.*;

import javax.naming.InitialContext;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

import com.amit.studentapp.dto.Student;

class StudentTest {

	
	
	
	@Test
	@DisplayName("AssertallwithStudentTest")
	void assertalltest() {

		Student student = new Student(1, "Amit", "India");
		assertAll("Testing Student Properties", 
				()->{assertEquals(1, student.getId(),"The actual and Expected student ID  does not match");},
				()->{assertEquals("Amit", student.getName(),"The actual and Expected student Name  does not match");},
				()->{assertEquals("India", student.getCountry(),"The actual and Expected student Country  does not match");}
				);
				
	}
	
	@Test
	@Disabled
	public void sampleTest()
	{
		assertEquals(1, 1234);
	}
	
	@Test
	@EnabledOnOs(value = OS.MAC)
	public void run_on_mac()
	{
		System.out.println("If you are seeing this ,you are on Mac OS");
		
	}
	@Test
	@EnabledOnOs(value = OS.WINDOWS)
	public void run_on_windows()
	{
		System.out.println("If you are seeing this ,you are on windows OS");
		
	}
	@Test
	@EnabledOnJre(value = JRE.JAVA_8)
	public void runonjre8()
	{
		System.out.println("If you are seeing this ,you are using java8");
		
	}
	@Test
	@EnabledOnJre(value = JRE.JAVA_16)
	public void runonjre16()
	{
		System.out.println("If you are seeing this ,you are using java16");
		
	}
	@Test
	@EnabledIfEnvironmentVariable(named  = "USER" ,matches = "Amit Dubey" )
	public void runItforAmit()
	{
		System.out.println("If you are seeing this ,you are Amit");
		
	}
	
	@Test
	@EnabledIfEnvironmentVariable(named  = "USER" ,matches = "Other" )
	public void runItforOther()
	{
		System.out.println("If you are seeing this ,you are Other");
		
	}
}
