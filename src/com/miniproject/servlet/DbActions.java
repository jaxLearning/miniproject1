package com.miniproject.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.miniproject.connection.DbQuery;
import com.miniproject.pojos.Actor;
import com.miniproject.service.CreateRecord;

public class DbActions extends HttpServlet {

	CreateRecord cr;
	 String sql;
		ArrayList <Actor> Li;
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException
	{
	 String actionName = req.getParameter("search");
	// String actionName1 = req.getParameter("search");

	 System.out.println(actionName);
	 Actor a = new Actor();
	 a.setFirst_name(req.getParameter("fname"));
	 a.setLast_name(req.getParameter("lname"));
	 a.setActor_id(Integer.parseInt(req.getParameter("aid")));
	 cr = new CreateRecord();

		System.out.println(a.getActor_id());
	 if (actionName.contentEquals("Create Actor"))
	 {
		
		 try {
			cr.insertRecord(a);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	 	 
	 }
	 else if (actionName.contentEquals("Search Actor"))
	 {
		 try {
			Li = cr.searchRecord(a);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 req.setAttribute("res", Li.get(0));
	 }
	 }
}
