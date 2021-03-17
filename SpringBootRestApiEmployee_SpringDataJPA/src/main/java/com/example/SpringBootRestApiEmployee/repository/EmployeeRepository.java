package com.example.SpringBootRestApiEmployee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.SpringBootRestApiEmployee.entity.Employee;

@RepositoryRestResource(path="employees")
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
