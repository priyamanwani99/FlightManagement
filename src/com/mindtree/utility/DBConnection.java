package com.mindtree.utility;



	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	public class DBConnection {
		public static Connection getDBConnection() {
			Connection connection = null;
			String url = "jdbc:mysql://localhost:3306/airlinesbooking";
			String userName = "root";
			String password = "9333127699";
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("something went wrong while loading Driver class " + e.getMessage());
			}
			try {
				connection = DriverManager.getConnection(url, userName, password);
				System.out.println("database connected succesfully");
			} catch (SQLException e) {
				System.out.println("something went wrong while establishing the connection " + e.getMessage());
			}
			return connection;

		}
	}

 