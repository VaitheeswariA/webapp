package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utils {
	private static Utils utils=null;
	
	private Utils()
	{
		
	}
	
	public static Utils getInstance()
	{
		if(utils==null)
			utils=new Utils();
		return utils;
	}
	
	public Connection dataBaseConnection()
	{
		Connection connect=null;
		try {
			connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/bus_db", "root", "@Jjack007");
			System.out.println("Connected Successfully");
		} catch (SQLException e) {
			System.out.println("Connection Not established successfully");
			e.printStackTrace();
		}
		return connect;
	}
}
