package com.cognizant.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.cognizant.dao.StudentDao;
import com.cognizant.dao.StudentDaoImpl;

@Configuration
@ComponentScan("com.cognizant")
@PropertySource("classpath:db.properties")
public class ApplicationConfig {
	
	@Autowired
	private Environment env;
	
	@Bean
	public DriverManagerDataSource getDataSource() throws IOException {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		
		ds.setDriverClassName(env.getProperty("DRIVER_CLASS"));
		ds.setUrl(env.getProperty("DB_URL"));
		ds.setUsername(env.getProperty("DB_USER"));
		ds.setPassword(env.getProperty("DB_PASS"));
		return ds;
	}
	
	
	@Bean
	public JdbcTemplate jdbcTemplate() throws IOException {
		JdbcTemplate jdbc = new JdbcTemplate();
		jdbc.setDataSource(getDataSource());
		return jdbc;
	}
	
	@Bean("dao")
	public StudentDaoImpl getDao() throws IOException {
		StudentDaoImpl dao = new StudentDaoImpl();
		return dao;
	}
}
