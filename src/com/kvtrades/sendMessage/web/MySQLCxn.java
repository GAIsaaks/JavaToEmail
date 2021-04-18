package com.kvtrades.sendMessage.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLCxn {

	private static String jdbcURL = "jdbc:mysql://localhost:3306/mygallery?useSSL=false";//?useSSL=false";
	private static String jdbcUsername = "root";
	private static String jdbcPassword = "root123";
	
	public static Connection getConnection() {
		Connection connection = null;		
		try {
			Class.forName("com.mysql.jdbc.Driver"); // ONLY NEEDED FOR TOMCAT
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		return connection;
	}

}
