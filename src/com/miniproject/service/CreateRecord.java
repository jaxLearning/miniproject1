package com.miniproject.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.miniproject.connection.DbQuery;
import com.miniproject.pojos.Actor;

public class CreateRecord {

	public void insertRecord(Actor a) throws InstantiationException, IllegalAccessException, SQLException
	{
		String sql = "Insert into sakila.actor (actor_id,first_name,last_name,last_update) Values "
				+ "("+a.getActor_id()+",'"+a.getFirst_name()+"','"+a.getLast_name()+"',"+a.getLast_update()+")";
	  System.out.println(sql);
			
		DbQuery db = new DbQuery();
		db.updateQuery(sql);
	}
	
	public ArrayList<Actor> searchRecord(Actor a) throws SQLException, InstantiationException, IllegalAccessException
	{
		String sql = "select * from sakila.Actor where actor_id ="+a.getActor_id();
	  System.out.println(sql);
		DbQuery db = new DbQuery();
		ArrayList <Actor> li = new ArrayList<Actor>();
		li = db.selectQuery(sql);
		return li;
	}
	
}
