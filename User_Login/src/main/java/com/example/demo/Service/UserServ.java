package com.example.demo.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.Entity.User;

public interface UserServ {

	
	public User addUser(User user);
	
	public List<User> getAllUser();
	
	public User getUserById(Integer id);
	
	public ResponseEntity<String> deleteUser(Integer id);
	
	public boolean validate(User user);
	
	List<User> findNotMarkedDeletedUser();
	
	
}
