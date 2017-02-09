package com.miniproject.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpUpgradeHandler;
import javax.servlet.http.Part;

import com.miniproject.pojos.Actor;
import com.miniproject.pojos.Login;

public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String uname = req.getParameter("uname");
		String pwd= req.getParameter("pwd");
		
		Login a = new Login();
		a.setUname(uname);
		a.setPwd(pwd);
		System.out.println(a.isLoginSusscess());
		if (a.isLoginSusscess() == true) 
		{
			req.setAttribute("s", "successfully logged into to Actor");
		req.getRequestDispatcher("actor.jsp").forward(req, resp);
		}
		else
		{
			req.setAttribute("s", "Failed log in into to Actor");
			req.getRequestDispatcher("actor.jsp").forward(req, resp);
		}
			
	}
}
