package com.example.SpringBootRestApiEmployee.dao;

import java.util.List;

import com.example.SpringBootRestApiEmployee.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> findAll();
	
	public Employee getEmployee(int id);
	
	public Employee saveEmployee(Employee employee);
	
	public int deleteEmployee(int id);
}
