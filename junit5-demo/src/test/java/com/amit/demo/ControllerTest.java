package com.amit.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ControllerTest {

	Controller controller;
	@BeforeEach
	void setUp() throws Exception {
		controller = new Controller();
	}
	@BeforeAll
	public static void init()
	{
		System.out.println("inside Init Method");
	}
	@Test
	void showHomePageTest() {
		assertEquals("home-page", controller.showHomePage(),"The actual and Expected page name does not match");
	}
	
	@Test
	void showContactUsPageTest() {
		assertEquals("Show-contact-us-page", controller.showContactUsPage());
	}


}
