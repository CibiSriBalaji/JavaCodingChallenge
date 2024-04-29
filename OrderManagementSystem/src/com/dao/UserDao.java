package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.User;

public interface UserDao {

	int createUser(User user) throws SQLException;

	User login(String username, String password) throws SQLException;

	List<User> finadAll() throws SQLException;

}
