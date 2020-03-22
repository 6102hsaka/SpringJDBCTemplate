package com.cognizant.service;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cognizant.config.ApplicationConfig;
import com.cognizant.dao.StudentDao;
import com.cognizant.dao.StudentDaoImpl;
import com.cognizant.model.Student;

public class StudentService {
	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		StudentDao studentDao = context.getBean("dao", StudentDaoImpl.class);
		
		Student s1 = new Student(1, "Akash");
		Student s2 = new Student(2, "Samir");
		Student s3 = new Student(3, "Aditya");
		
		Student[] students = {s1,s2,s3};
		
		for(Student st : students) {
			studentDao.insert(st);
		}
		System.out.println("Students details");
		studentDao.getAll().forEach(System.out::println);
		
		System.out.println("----------------------------------------");
		
		Student newStudent = new Student(3, "Aaditya");
		if(studentDao.update(newStudent)) {
			System.out.println("record updated");
		}
		
		System.out.println("Students details");
		studentDao.getAll().forEach(System.out::println);
		
		System.out.println("----------------------------------------");
		
		System.out.println("Record of Student 3 deleted ? - "+studentDao.deleteById(3));
		System.out.println("Students details");
		studentDao.getAll().forEach(System.out::println);
	}
}
