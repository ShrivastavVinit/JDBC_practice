package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DBConnection {
	
	//this class used for making connection to DB
	//static Connection : singleton : connection established once.
	
	private static Connection con;
	
	public static void OpenConnection() throws SQLException, ClassNotFoundException
	{
		System.out.println("-----Driver Loaded....");
		
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java" , "root", "root123");
		System.out.println("Connected To DB.....");
	
	}
	
	public static Connection getCon()
	{
		return con;
	}
	
	public static void closeConnection() throws SQLException 
	{
		if(con!=null);
		con.close();
	}
	
}
