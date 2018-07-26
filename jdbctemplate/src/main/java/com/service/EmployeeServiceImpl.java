package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.EmployeeModel.Employee;
import com.dao_classes.EmployeeDAO;

public class EmployeeServiceImpl implements EmployeeService  {

	@Autowired
	EmployeeDAO Empdao;

	public void insertData(Employee emp) {
		Empdao.insertData(emp);

	}

	public List<Employee> getAllEmployees() {

		return Empdao.getAllEmployees();
	}

	public void deleteData(String id) {
		Empdao.deleteData(id);

	}

}
