package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.User;
import com.example.demo.Service.UserServImpl;

@RestController
@RequestMapping("/User")
public class UserController {
	
	@Autowired
	private UserServImpl ur;

	@PostMapping("/addUser")
	public ResponseEntity<?> addUser(@RequestBody User user){
		return new ResponseEntity<>(ur.addUser(user),HttpStatus.CREATED);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<?> getAllUser(){
		return new ResponseEntity<>(ur.getAllUser(),HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<?> getUserById (@PathVariable int id){
		return new ResponseEntity<>(ur.getUserById(id), HttpStatus.FOUND);
	}
	
	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<?> deleteUser(@PathVariable Integer id){
		return new ResponseEntity<>(ur.deleteUser(id), HttpStatus.OK);
	}
//	@DeleteMapping("/delete/{id}")
//	public ResponseEntity<?> deleteuser(@PathVariable Integer id){
//		return new ResponseEntity<>(serv1.deleteuser(id),HttpStatus.OK);
//	}
	
	@GetMapping("/validate")
	public ResponseEntity<?> validate(User user){
		boolean isValid = ur.validate(user);
		if(isValid) return new ResponseEntity<>("Successfull!", HttpStatus.OK);
		return new ResponseEntity<>("Authentication Failed", HttpStatus.UNAUTHORIZED);
	}
	
	@PutMapping("/edit")
	public ResponseEntity<?> editUser(User user){
		return new ResponseEntity<>(ur.addUser(user),HttpStatus.CREATED);
	}
	
}
