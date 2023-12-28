package com.dhanush.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhanush.entity.Student;
import com.dhanush.repo.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentRepo studentRepo;

	@Override
	public Student addStudent(Student s) throws Exception {
		if(s==null) {
			throw new Exception();
		}
		else {
//			System.out.println(s.getName());
			studentRepo.save(s);
		}
		return s;
	}

}
