package com.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.EmployeeModel.Employee;
import com.service.EmployeeService;

@Controller
public class MainController {
	
	EmployeeService empSer;
	
	@RequestMapping(value="/")
	public String indexPage(){
		
		return "index";
	}
	@RequestMapping(value="/register",method=RequestMethod.GET)
	
	public String registerPage(){
		return "register";
	}
	
	@RequestMapping(value="/insert" , method=RequestMethod.POST)
	public String insertData(@ModelAttribute Employee emp){
		 if (emp != null)  
			   empSer.insertData(emp);  
			  return "redirect:/getList";  
	}
	 
	@RequestMapping(value="/getList", method = RequestMethod.GET)  
	 public ModelAndView getEmployeeLIst() {  
	  List<Employee> emplist = empSer.getAllEmployees();  
	  return new ModelAndView("emplist", "emplist", emplist);  
	 }  
	 
	
	
	 @RequestMapping(value="/delete", method=RequestMethod.GET)  
	 public String deleteUser(@RequestParam String id) {  
	  System.out.println("id = " + id);  
	  empSer.deleteData(id);  
	  return "redirect:/getList";  
	 }  
}
