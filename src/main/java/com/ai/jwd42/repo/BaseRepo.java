package com.ai.jwd42.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepo {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/pos_project";
	private static final String DB_USERNAME = "root";
	private static final String DB_PASSWORD = "123lwh";

	private static Connection con;

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			if (con == null) {
				con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			} else {
				return con;
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Driver class not found");
		} catch (SQLException e) {
			System.out.println("Database connection not found");
		}
		return con;
	}
}
