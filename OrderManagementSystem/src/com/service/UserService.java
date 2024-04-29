package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.exception.InvalidCredentialsException;
import com.model.User;

public class UserService {
	UserDao userDao = new UserDaoImpl();
	public int createUser(User user) throws SQLException {
		return userDao.createUser(user);
		
	}
	public User login(String username, String password) throws SQLException, InvalidCredentialsException {
		 
		User user = userDao.login(username,password);
		if(user == null) {
			throw new InvalidCredentialsException("Invalid Credentials");
		}
		return user;
	}
	public List<User> findAll() throws SQLException{
		// TODO Auto-generated method stub
		return userDao.finadAll();
	}

}
