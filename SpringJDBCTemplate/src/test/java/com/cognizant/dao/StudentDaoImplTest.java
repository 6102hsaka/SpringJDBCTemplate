package com.cognizant.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.cognizant.model.Student;

public class StudentDaoImplTest {

	@Test
	public void testInsert() {
		Student s = new Student(1, "Akash");
		boolean expected = new StudentDaoImpl().insert(s);
		assertTrue(expected);
	}

	@Test
	public void testUpdate() {
		Student s = new Student(1, "Akash Sharma");
		boolean expected = new StudentDaoImpl().update(s);
		assertTrue(expected);
	}
	
	@Test
	public void testDeleteById() {
		boolean expected = new StudentDaoImpl().deleteById(1);
		assertTrue(expected);
	}
	
	@Test
	public void testGetById() {
		Student student = new StudentDaoImpl().getById(2);
		System.out.println(student);
		assertNotNull(student);
	}
	@Test
	public void testGetAll() {
		List<Student> list = new StudentDaoImpl().getAll();
		System.out.println(list);
		assertNotNull(list);
		
	}
}
