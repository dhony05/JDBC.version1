package com.collabera.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class ConectionManager {
	
	static final String URL = "jdbc:mysql://localhost:3306/sakila?serverTimezone=EST5EDT";
	static final String USERNAME = "root";
	static final String PASSWORD = "1a234567";
	
	
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			 System.out.println("----------Connection was made----------");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void closingConnection(Connection conn) {
		if(conn == null )return;
		try {
			conn.close();
			System.out.println("----------Connection was closed----------");
		}
		catch(SQLException sqle) {sqle.printStackTrace();}
		finally { conn = null ;	}
		}
	
	

	public static void main(String[] args) {
		
		
		Connection conn = ConectionManager.getConnection();
		// same thing from above
		try {
			Statement statement = conn.createStatement();
			String query1= "SELECT first_name,last_name, CONCAT(first_name, \" \",last_name) AS full_name FROM actor";
			ResultSet result = statement.executeQuery(query1);
			
			while(result.next()) {
				System.out.println(result.getString("full_name"));
			} 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		
		
		
		
		
		
//		try {
//			conn.close();
//			System.out.println("connection was closed");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		
		
		closingConnection(conn);
	}

}
