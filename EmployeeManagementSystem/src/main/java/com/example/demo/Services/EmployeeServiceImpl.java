package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Employee;
import com.example.demo.Repository.EmployeeRepo;


@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepo er;

	@Override
	public Employee addEmployee(Employee employee) {
		return er.save(employee);
	}

	@Override
	public List<Employee> findAllEmployee() {
		return er.findAll();
	}

	@Override
	public Employee editEmployee(Employee employee) {
		return er.save(employee);
	}

	@Override
	public Employee findById(Integer id) {
		return er.findById(id).get();
	}

	@Override
	public String deleteEmployee(Integer id) {
		Employee emp=er.findById(id).get();
		if(emp!=null)
		{
			er.delete(emp);
			return "Employee Deleted Successfully";
		}
		return "some error occured!";
	}

}
