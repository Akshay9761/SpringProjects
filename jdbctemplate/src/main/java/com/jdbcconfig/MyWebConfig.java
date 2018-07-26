package com.jdbcconfig;


import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.dao_classes.EmployeeDAO;
import com.dao_classes.EmployeeDAOImpl;


@EnableWebMvc
@Configuration  
@ComponentScan(basePackages="com.controller")
public class MyWebConfig {

	@Bean
	public ViewResolver viewResolver(){
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
       
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}         
	
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		//DB2 database i m using
		dataSource.setDriverClassName("com.ibm.db2.jcc.DB2Driver");
		dataSource.setUrl("jdbc:db2://192.168.2.209:50000/TSTAKS");
		dataSource.setUsername("db2admin");
		dataSource.setPassword("db2admin");
		return dataSource;
	}
	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
		return jdbcTemplate;
	}

	@Bean
	public EmployeeDAO employeeDAO(){
		EmployeeDAOImpl empDao = new EmployeeDAOImpl();
		empDao.setJdbcTemplate(jdbcTemplate());
		return empDao;
	}                                              

}
