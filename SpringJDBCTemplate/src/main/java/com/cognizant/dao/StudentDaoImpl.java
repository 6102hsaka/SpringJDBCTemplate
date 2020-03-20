package com.cognizant.dao;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cognizant.config.ApplicationConfig;
import com.cognizant.model.Student;

public class StudentDaoImpl implements StudentDao {
	
	JdbcTemplate jdbcTemplate = null;

	public StudentDaoImpl() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		jdbcTemplate = context.getBean("jdbcTemplate",JdbcTemplate.class);
	}
	

	public boolean insert(Student student) {
		String sql = "Insert into student values(?,?)";
		int n = jdbcTemplate.update(sql,student.getId(),student.getName());
		return (n==1);
	}

	public boolean update(Student student) {
		String sql = "update student set name=? where id=?";
		int n = jdbcTemplate.update(sql,student.getName(),student.getId());
		return (n==1);
	}

	public boolean deleteById(int id) {
		String sql = "delete from student where id=?";
		int n = jdbcTemplate.update(sql,id);
		return (n==1);
	}

	public Student getById(int id) {
		List<Student> st=null;
		try {
			String sql = "select * from student where id=?";
			st = jdbcTemplate.query(sql, new Object[] {id},(rs,row)->new Student(rs.getInt(1), rs.getString(2)));
			return st.get(0);
		}
		catch (Exception e) {
			return null;
		}
	}

	public List<Student> getAll() {
		List<Student> st = null;
		try {
			String sql = "select * from student";
			st = jdbcTemplate.query(sql, (rs,row)->new Student(rs.getInt(1), rs.getString(2)));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return st;
	}
}
