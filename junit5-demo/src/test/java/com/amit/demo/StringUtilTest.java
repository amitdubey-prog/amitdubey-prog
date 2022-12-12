package com.amit.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringUtilTest {

	StringUtil stringutil;
	@BeforeEach
	void setUp() throws Exception {
		stringutil =new StringUtil();
		System.out.println("inside setup");
	}

	@Test
	public void ifStringNulltest() {
		
		assertThrows(IllegalArgumentException.class, ()->stringutil.reverse(null));
		System.out.println("inside ifStringNulltest");
	}
	
	@Test
	public void ifStringemptytest() {
		
		assertThrows(IllegalArgumentException.class, ()->stringutil.reverse(""));
		System.out.println("inside ifStringemptytest");
	}
	
	@Test
	public void ifStringReversetest() {
		System.out.println("inside ifStringReversetest");
		
		String result = stringutil.reverse("Amit");
		assertNotNull(result);
		assertEquals("timA", result);
		
		
	}

}
