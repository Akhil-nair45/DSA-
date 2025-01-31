package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.EmployeeDTO;
import com.example.demo.Model.Employee;
import com.example.demo.Repository.EmployeeRepo;

@RestController
@RequestMapping("/Employee")
public class LoginController {

	@Autowired
	private EmployeeRepo er;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody EmployeeDTO login)
	{
		Employee emp= er.findByEmployeName(login.getEmployeName());
		if(emp==null)
		{
			return new ResponseEntity<>("No Such User Present",HttpStatus.UNAUTHORIZED);
		}
		if(!emp.getPassword().equals(login.getPassword())) {
			return new ResponseEntity<>("Invalid Password!", HttpStatus.UNAUTHORIZED);
		}
		if(!emp.getEmployeName().equals(login.getEmployeName())) {
			return new ResponseEntity<>("Invalid Username",HttpStatus.UNAUTHORIZED);
		}
		return ResponseEntity.ok().body("Login Successfully!");
	}
}
