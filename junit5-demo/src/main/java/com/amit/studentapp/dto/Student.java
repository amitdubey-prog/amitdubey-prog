package com.amit.studentapp.dto;

public class Student {

	private int Id;
	private String name;
	private String Country;

	public int getId() {
		return Id;
	}

	public Student(int id, String name, String country) {

		Id = id;
		this.name = name;
		Country = country;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	

	
}
