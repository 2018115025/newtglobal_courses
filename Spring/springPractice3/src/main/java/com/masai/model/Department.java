package com.masai.model;

import org.springframework.stereotype.Service;

@Service
public class Department {
	
	private String name;

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void create() {
		System.out.println("dep created");
	}

	public Department(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Department [name=" + name + "]";
	}
	
	

}
