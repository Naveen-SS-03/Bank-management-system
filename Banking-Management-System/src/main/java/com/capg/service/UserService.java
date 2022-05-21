package com.capg.service;

import java.util.List;

import com.capg.entity.User;
import com.capg.exceptions.UserNotFoundException;

public interface UserService {
	public String createUser(User user) throws UserNotFoundException;

	User addUser(User User);

	User updateUser(User User);

	String removeUserByUserId(int UserID);

	User showUserByUserId(int UserID);

	List<User> showAllUser();

	public User addsave(User user);

	public void deleteUser(int userid);

}