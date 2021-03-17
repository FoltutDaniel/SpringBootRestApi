package com.example.SpringBootRestApiEmployee.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		return this.employeeDAO.getEmployee(employeeId);
	}
	
	@PostMapping("/employees")
	public Employee saveEmployee(@RequestBody Employee employee) {
		
		employee.setId(0);
		
		return this.employeeDAO.saveEmployee(employee);
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		
		return this.employeeDAO.saveEmployee(employee);
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String deletedEmployee(@PathVariable int employeeId) {
		this.employeeDAO.deleteEmployee(employeeId);
		return "Employee with id "+employeeId+" was delete";
	}
}
