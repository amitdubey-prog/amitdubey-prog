package com.amit.demo;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
class SampleTest {

	@Mock
	Map map;
	

	
	@Test
	void sample_test() {
		
		//map =mock(Map.class);
	
		when(map.get(101)).thenReturn("Amit");
		when(map.get(102)).thenReturn("Anu");
		when(map.size()).thenReturn(20).thenReturn(30);
		when(map.isEmpty()).thenReturn(true);
		
		System.out.println(map.get(101));
		System.out.println(map.get(102));
		System.out.println(map.size());
		System.out.println(map.size());
		System.out.println(map.isEmpty());
	}

}
