package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Product;
import com.model.User;
import com.utility.DBConnection;

public class UserDaoImpl implements UserDao{

	@Override
	public int createUser(User user) throws SQLException {
		// insert artist record in DB
				Connection con = DBConnection.dbConnect();
				String sql="INSERT INTO user (username, password, role) VALUES (?,?,?)";
				//prepare the statement 
				PreparedStatement pstmt = con.prepareStatement(sql);
				//attach the data
				pstmt.setString(1, user.getUsername());
				pstmt.setString(2, user.getPassword());
				pstmt.setString(3, user.getRole());
				//execute the query 
				int status = pstmt.executeUpdate(); 
				DBConnection.dbClose();
				return status;
		
	}

	@Override
	public User login(String username, String password) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql="select * from user where username=? AND password=?";
		//prepare the statement 
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		ResultSet rst  = pstmt.executeQuery();
		 
		if(rst.next()) {
			User user = new User();
			user.setUserId(rst.getInt("id"));
			user.setUsername(username);
			user.setPassword(password);
			user.setRole(rst.getString("role"));
			DBConnection.dbClose();
			return user;
		}
		else {
			DBConnection.dbClose();
			return null; 
	}

}

	@Override
	public List<User> finadAll() throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql="select * from user";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		List<User> userList = new ArrayList<>();
		while(rst.next() == true) {
			int userId = rst.getInt("id");
	        String username = rst.getString("username");
	        String password = rst.getString("password");
	        String role = rst.getString("role");
	        User user = new User(userId, username, password, role);
	        userList.add(user);
		}
		DBConnection.dbClose();		
		return userList;
	}
}
