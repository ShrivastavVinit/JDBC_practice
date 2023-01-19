package com.tester;
import  static com.utils.DBConnection.OpenConnection;


public class TestConnection {

	public static void main(String[] args) {
	
		try
		{
			OpenConnection();
			//CRUD:
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

	}

}
