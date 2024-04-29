package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBConnection {

	static String userDB = "root";
	static String passDB = "Maha&cibi23";
	static String url = "jdbc:mysql://localhost:3306/OrderManagement";
	static String driver = "com.mysql.cj.jdbc.Driver";
	static Connection con;

	public static Connection dbConnect() {
		/* load the driver */
		try {
			Class.forName(driver);
			//System.out.println("Driver loaded");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not loaded...");
			e.printStackTrace();
		}

		/* Step 3: Establish the connection */
		try {
			con = DriverManager.getConnection(url, userDB, passDB);
			//System.out.println("connection established");
		} catch (SQLException e) {
			System.out.println("connection failed");
			e.printStackTrace();
		}
		return con;
	}

	public static void dbClose() {
		try {
			con.close();
			//System.out.println("Connection closed ");
		} catch (SQLException e) {
			System.out.println("Connection could not be closed");
		}
	}

	public static void main(String[] args) {
		//DBConfig dbCon = new DBConfig();
		DBConnection.dbConnect();
		DBConnection.dbClose();
	}
}

