package com.masai.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.masai.model.Department;
import com.masai.model.Employee;

public class Demo {
	
//	public static void main(String[] args) {
//		LocalDate d = LocalDate.parse("yyyy-MM-dd") ;
//	}

	private Map<Department	, Employee> map ;
	private List<Employee> empList;
	
	
	public void myInit() {
		
		if(map == null || empList== null) throw new RuntimeException("not resolved" );
		else System.out.println("done");
		
	}
	
	public void destroy() {
		System.out.println("work done");
	}
	
	public void showDetails() {
		System.out.println(map);
		System.out.println(empList);
	}
	
	public Map<Department, Employee> getMap() {
		return map;
	}
	public void setMap(Map<Department, Employee> map) {
		this.map = map;
	}
	public List<Employee> getEmpList() {
		return empList;
	}
	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}
	@Override
	public String toString() {
		return "Demo [map=" + map + ", empList=" + empList + "]";
	}
	public Demo(Map<Department, Employee> map, List<Employee> empList) {
		super();
		this.map = map;
		this.empList = empList;
	}
	public Demo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
