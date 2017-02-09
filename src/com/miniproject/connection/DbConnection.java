package com.miniproject.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DbConnection {

	private String uname ="mallik";
	private String pwd = "Test123";
	private String url = "jdbc:mysql://localhost:3306/sakila?" ;
	
		
	public Connection connectDb() throws SQLException, InstantiationException, IllegalAccessException 
	{
		Connection con = null;
	
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try
		{
		con = DriverManager.getConnection(url,uname,pwd);
		//System.out.println("Connection Established");
		return con;
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return con;
	}
		
}
