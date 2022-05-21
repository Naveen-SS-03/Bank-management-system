package com.capg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.entity.User;
import com.capg.exceptions.UserNotFoundException;
import com.capg.repository.UserRepository;
import com.capg.service.UserServiceImpl;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	private int validUser = 0;
	@Autowired
	UserServiceImpl UserService;

	@Autowired
	private UserRepository UserRepository;
	
	@PostMapping("/createUser")
	public ResponseEntity<User> createUser(@RequestBody User User) throws UserNotFoundException{
		User u = UserService.addUser(User);
		return new ResponseEntity<User>(u,HttpStatus.CREATED);
	}
	@PutMapping("/updateUser")
	public ResponseEntity<User> updateUser(@RequestBody User User) throws UserNotFoundException{
		Integer id = User.getUserId();
	    if(UserRepository.findById(id).isPresent()) {
	    	User u = UserService.updateUser(User);
	    return new ResponseEntity<User>(u,HttpStatus.OK);
	    }
	    else {
	    	throw new UserNotFoundException("User Details with Id: "+id+" not found!!");
	    }
	}
	@DeleteMapping("/deleteById/{User_id}")
	public ResponseEntity<String> deleteUser(@PathVariable int User_id) throws UserNotFoundException{
	    if(UserRepository.findById(User_id).isPresent()) {
	    	String u = UserService.removeUserByUserId(User_id);
	    return new ResponseEntity<String>(u,HttpStatus.OK);
	    }
	    else {
	    	throw new UserNotFoundException("User Details with Id: "+User_id+" not found!!");
	    }
	}
	@GetMapping("/getById/{User_id}")
	public ResponseEntity<User> getUser(@PathVariable int User_id) throws UserNotFoundException{
	    if(UserRepository.findById(User_id).isPresent()) {
	    	User u = UserService.showUserByUserId(User_id);
	    return new ResponseEntity<User>(u,HttpStatus.OK);
	    }
	    else {
	    	throw new UserNotFoundException("User Details with Id: "+User_id+" not found!!");
	    }
	}
	@GetMapping("/list")
	public List<User> getAllUser(){
		return UserService.showAllUser();
	}

}
