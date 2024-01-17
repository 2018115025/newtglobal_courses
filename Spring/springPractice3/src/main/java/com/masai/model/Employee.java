package com.masai.model;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service
public class Employee {
	
	private int id;
	private LocalDate date;
	public Employee(int id, LocalDate date) {
		super();
		this.id = id;
		this.date = date;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", date=" + date + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	

}
