package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Model.Employee;

@Service
public interface EmployeeService {

	
	public Employee saveEmployee(Employee emp);
	
	public Employee editEmployee(Employee emp);
	
	public Employee getById(Integer id);
	
	public List<Employee> getAll();
	
	public String deleteEmployee(Integer id);
}
