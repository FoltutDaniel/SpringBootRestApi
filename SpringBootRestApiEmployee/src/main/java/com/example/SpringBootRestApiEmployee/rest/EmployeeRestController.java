package com.example.SpringBootRestApiEmployee.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootRestApiEmployee.dao.EmployeeDAO;
import com.example.SpringBootRestApiEmployee.entity.*;


@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeDAO employeeDAO;
	
	// quick and dirty: inject employee dao
	
	@Autowired
	public EmployeeRestController(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
	
	//expose "/employee" endpoint
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return this.employeeDAO.findAll();
	}
}
