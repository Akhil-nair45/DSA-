package com.example.demo.Services;

import java.util.List;

import com.example.demo.Model.Employee;

public interface EmployeeService {

	public Employee addEmployee(Employee employee);
	
	public List<Employee> findAllEmployee();
	
	public Employee editEmployee(Employee employee);
	
	public Employee findById(Integer id);
	
	public String deleteEmployee(Integer id);
}
