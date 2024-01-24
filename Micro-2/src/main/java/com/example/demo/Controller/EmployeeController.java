package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Employee;
import com.example.demo.Service.EmployeeService;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {

	@Autowired
	private EmployeeService es;
	
	@PostMapping("/add")
	public ResponseEntity<?> addemployee(@RequestBody Employee emp)
	{
		return new ResponseEntity<>(es.saveEmployee(emp),HttpStatus.CREATED);
	}
	
	@PutMapping("/edit")
	public ResponseEntity<?> editEmployee(@RequestBody Employee emp)
	{
		return new ResponseEntity<>(es.editEmployee(emp),HttpStatus.CREATED);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll()
	{
		return new ResponseEntity<>(es.getAll(),HttpStatus.FOUND);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id)
	{
		return new ResponseEntity<>(es.getById(id),HttpStatus.FOUND);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable Integer id)
	{
		return new ResponseEntity<>(es.deleteEmployee(id),HttpStatus.OK);
	}
}
