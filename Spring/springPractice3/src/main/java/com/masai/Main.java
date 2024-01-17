package com.masai;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.masai.model.Department;
import com.masai.model.Employee;
import com.masai.service.Demo;

public class Main {
	
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		Demo d=ctx.getBean("demo",Demo.class);
		d.showDetails();
		Employee e=ctx.getBean("emp",Employee.class);
		System.out.println(e);
		((ClassPathXmlApplicationContext)ctx).close();
	}

}
