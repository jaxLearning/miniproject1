package com.miniproject.servlet;

import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.miniproject.connection.DbQuery;
import com.miniproject.pojos.Actor;

public class DbActions extends HttpServlet {

	DbQuery db;
	 String sql
		ArrayList <Actor> Li;
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
	{
	 String actionName = req.getParameter("dbaction");
	 Actor a = new Actor();
	 a.setFirst_name(req.getParameter("fname"));
	 a.setLast_name(req.getParameter("lname"));
	 
	 if (actionName == "Create")
		  sql = "Insert into sakila.actor (actor_id,first_name,last_name,last_update) Values "
					+ "("+"select actor_id from sakila.actor Order By actor_id DESC Limit 1"+",'"+a.getFirst_name()+"','"+a.getLast_name()+"',"+a.getLast_update()+")"; 
		 db = new DbQuery();
	 	 db.updateQuery(sql);
	 	 
	 }
}
