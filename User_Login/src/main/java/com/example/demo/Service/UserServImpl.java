package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepo;

@Service
public class UserServImpl implements UserServ{

	@Autowired
	private UserRepo ur;
	
	@Override
	public User addUser(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		return ur.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return ur.findAll();
	}

	@Override
	public User getUserById(Integer id) {
		Optional<User> userfromdatabase = ur.findById(id);
		if(userfromdatabase.get().getIsDeleted() == 1) {
		return null;
		}
		return userfromdatabase.get();
	}

	@Override
	public ResponseEntity<String> deleteUser(Integer id) {
		Optional<User> user = ur.findById(id);
		if(user.isPresent()) {
			User u = user.get();
			u.setIsDeleted(1);
			ur.save(u);
			return new ResponseEntity<>("User Deleted Successfully!", HttpStatus.OK);
		}
		else {
		return new ResponseEntity<>("User Not Found!", HttpStatus.NOT_FOUND);
	}
	}
	
//	@Override
//	public ResponseEntity<String> deleteuser(Integer id) {
//		Optional<User> user=ur.findById(id);
//		if(user.isPresent())
//		{
//			User u= user.get();
//			u.setIsDeleted(1);
//			ur.save(u);
//			return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
//		}
//		else {
//		return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
//	}
//	}

	@Override
	public boolean validate(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		User userfromdatabase = ur.findByEmail(user.getEmail());
		if(userfromdatabase.getIsDeleted() == 1) return false;
		else {
			if(userfromdatabase == null) return false;
			if(passwordEncoder.matches(user.getPassword(),userfromdatabase.getPassword())) return true;
			return false;
		}
		
	}

	@Override
	public List<User> findNotMarkedDeletedUser() { 
		return ur.findNotMarkedDeletedUser();
	}

}
