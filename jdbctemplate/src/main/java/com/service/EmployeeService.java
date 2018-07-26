package com.service;

import java.util.List;

import com.EmployeeModel.Employee;

public interface EmployeeService {
 
	
	 public void insertData(Employee emp);  
	 public List<Employee> getAllEmployees();  
	 public void deleteData(String id);  
}
