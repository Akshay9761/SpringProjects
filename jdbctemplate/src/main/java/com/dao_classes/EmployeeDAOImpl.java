package com.dao_classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.EmployeeModel.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	private static final	String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS  Employee "
			+ "( ID   INT(5)     NOT NULL,"
			+ "E_NAME  VARCHAR(20) NOT NULL, "
			+ "E_SALARY VARCHAR(10), E_DESIGNATION VARCHAR(16), "
			+ "PRIMARY KEY(ID))IN TSTAKS;";



	private JdbcTemplate jdbcTemplate; 

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}

	// to create table
	public  void create(){
		jdbcTemplate.execute(CREATE_TABLE); 
		System.out.println("Table Created Successfully:)");
	}

	//inserting in table
	public void insertData(Employee emp) {

		try{
			create();
		}
		catch(Exception e){
			System.out.println(e);
		}

		String sql_insert = "INSERT INTO Employee "  
				+ "(E_NAME, E_SALARY, E_DESIGNATION) VALUES (?, ?,?)";  

		jdbcTemplate.update( sql_insert,  
				new Object[] { emp.getName(), emp.getSalary(), emp.getDesignation()});  
	}

	// list all employees
	public List<Employee> getAllEmployees() {

		return jdbcTemplate.query("select * from Employee",new RowMapper<Employee>(){  

			public Employee mapRow(ResultSet rs, int rownumber) throws SQLException {  
				Employee emp=new Employee();  
				emp.setId(rs.getInt(1));  
				emp.setName(rs.getString(2));  
				emp.setSalary(rs.getFloat(3)); 
				emp.setDesignation(rs.getString(4));
				return emp;  
			}  
		});  
	} 

	// delete employee
	public void deleteData(String id) {
		String sql_delete = "delete from Employee where ID=" + id;  
		jdbcTemplate.update(sql_delete);  

	}

}
