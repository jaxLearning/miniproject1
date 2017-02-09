package com.miniproject.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.miniproject.pojos.Actor;

public class DbQuery  {

	 
	private String sql;
	ArrayList li;
	Connection con = null;
	DbConnection dbcon;
	Statement st = null;
	ResultSet rs = null;
	
	
	//function for Select Query
	public  void selectQuery(String sql) throws SQLException, InstantiationException, IllegalAccessException
	{
		
		
			ResultSet rs = st.executeQuery(sql);
			
		ArrayList<Actor> li = new ArrayList<Actor>();

		while(rs.next())
		{
			Actor a = new Actor();
			a.setActor_id(rs.getInt(1));
			a.setFirst_name(rs.getString(2));
			a.setLast_name(rs.getString(3));
			a.setLast_update(rs.getDate(4));
			li.add(a);
		}
		System.out.println("Actor Id" + "--" + "First Name" + "---"+ "Last_name" +"---"+ "Last_update");
		
		for(int i = 0; i<li.size();i++)
			{
				Actor a1 = new Actor();
				a1= li.get(i);
				System.out.println(a1.getActor_id()+ "--" + a1.getFirst_name() + "---"+a1.getLast_name()+"---"+a1.getLast_update());
			}
	}
	
	
	public DbQuery() throws InstantiationException, IllegalAccessException, SQLException {
		dbcon = new DbConnection();
		con = dbcon.connectDb();
		st = con.createStatement();
	}


	public  void updateQuery(String sql) throws SQLException
	{
		
	
		int rs = st.executeUpdate(sql);
		 
		 if (rs != 0) 
			 System.out.println("Record "+sql.subSequence(0, 6)+" Successful");
			 
		 else
			 System.out.println("Failed Record Update");
		 
	}
	

}
