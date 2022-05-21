package com.capg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capg.entity.User;
import com.capg.exceptions.UserNotFoundException;
import com.capg.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User addUser(User User){
	       return userRepository.save(User);
	}

	@Override
	public User updateUser(User User) {
		return userRepository.save(User);
	}

	@Override
	public String removeUserByUserId(int UserID) {
		userRepository.deleteById(UserID);
		return "User Deleted";
	}

	@Override
	public List<User> showAllUser() {
		return userRepository.findAll();
	}

	@Override
	public User showUserByUserId(int UserID) {
		return userRepository.findById(UserID).get();
	}

	@Override
	public String createUser(User user) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User addsave(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(int userid) {
		// TODO Auto-generated method stub
		
	}
	
}