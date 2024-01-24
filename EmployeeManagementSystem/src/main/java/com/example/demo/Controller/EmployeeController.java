package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Employee;
import com.example.demo.Services.EmployeeService;

@RestController
@RequestMapping("/Employee")
@CrossOrigin
public class EmployeeController {

	
	@Autowired
	private EmployeeService er;
	
	
	@PostMapping("/addEmployee")
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee){
		return new ResponseEntity<>(er.addEmployee(employee),HttpStatus.CREATED);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<?> findAllEmployee(){
		return new ResponseEntity<>(er.findAllEmployee(),HttpStatus.OK);
	}
	
	@PutMapping("/edit")
	public ResponseEntity<?> editEmployee(@RequestBody Employee employee){
		return new ResponseEntity<>(er.editEmployee(employee),HttpStatus.CREATED);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id){
		return new ResponseEntity<>(er.findById(id),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable Integer id){
		return new ResponseEntity<>(er.deleteEmployee(id),HttpStatus.OK);
	}
	
}
