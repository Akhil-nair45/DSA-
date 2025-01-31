package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Employee;
import com.example.demo.Repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	@Autowired
	private EmployeeRepo er;
	
	
	@Override
	public Employee saveEmployee(Employee emp) {
		return er.save(emp);
	}

	@Override
	public Employee editEmployee(Employee emp) {
		return er.save(emp);
	}

	@Override
	public Employee getById(Integer id) {
		return er.findById(id).get();
	}

	@Override
	public List<Employee> getAll() {
		return er.findAll();
	}

	@Override
	public String deleteEmployee(Integer id) {
		Employee emp= er.findById(id).get();
		if(emp!=null)
		{
			er.delete(emp);
			return "Employee deleted Successfully!";
		}
		return "Some Error Occured!";
	}

}
