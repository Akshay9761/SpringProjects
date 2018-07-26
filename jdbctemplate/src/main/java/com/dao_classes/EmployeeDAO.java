package com.dao_classes;

import java.util.List;

import com.EmployeeModel.Employee;

public interface EmployeeDAO {

	public void insertData(Employee emp);  
	public List<Employee> getAllEmployees();  
	public void deleteData(String id);  

}
