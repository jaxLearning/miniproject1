package com.miniproject.connection;

import java.sql.SQLException;
import java.util.Date;

import com.miniproject.pojos.Actor;

public class TestDb {
	public static void main(String[]args) throws SQLException, InstantiationException, IllegalAccessException
	{
		DbQuery db = new DbQuery();
		db.selectQuery("select * from sakila.Actor");
		System.out.println("Retrieval of record is successful");
		
		Date last_update = new Date();
		
		Actor a= new Actor();
		a.setActor_id(205);
		a.setFirst_name("Mallik");
		a.setLast_name("Dhupagutnla");
		a.setLast_update(null);
		String sql = "Insert into sakila.actor (actor_id,first_name,last_name,last_update) Values "
				+ "("+a.getActor_id()+",'"+a.getFirst_name()+"','"+a.getLast_name()+"',"+a.getLast_update()+")";
		System.out.println(sql);
		db.updateQuery(sql);
		
		
		db.selectQuery("select * from sakila.Actor where actor_id ="+a.getActor_id());
		
		db.updateQuery("Delete from sakila.actor where actor_id =201");
		
		db.selectQuery("select * from sakila.Actor where actor_id =201");
		
		db.updateQuery("Update sakila.actor set first_name = 'mallikharjuna' where actor_id = "+a.getActor_id());
		db.selectQuery("select * from sakila.Actor where actor_id ="+a.getActor_id());

	}
}
