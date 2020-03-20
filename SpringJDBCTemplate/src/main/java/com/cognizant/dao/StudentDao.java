package com.cognizant.dao;

import java.util.List;

import com.cognizant.model.Student;

public interface StudentDao {
	
	public boolean insert(Student student);
	public boolean update(Student student);
	public boolean deleteById(int id);
	public Student getById(int id);
	public List<Student> getAll();
	
	
}
