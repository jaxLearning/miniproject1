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
import com.miniproject.service.LoginValidation;

public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//String uname = req.getParameter("uname");
		//String pwd= req.getParameter("pwd");
		
		Login a = new Login();
		a.setUname(req.getParameter("uname"));
		a.setPwd( req.getParameter("pwd"));
		LoginValidation l = new LoginValidation();
		if ((l.isLoginSuccessful(a.getUname(), a.getPwd())) == true)
		{
			req.setAttribute("s", a.getUname()+" successfully logged into to actor portal");
		req.getRequestDispatcher("actor.jsp").forward(req, resp);
		}
		else
		{
			req.setAttribute("s", a.getUname() + " failed log in into to actor..either username or password incorrect");
			req.getRequestDispatcher("loginfailed.jsp").forward(req, resp);
		}
			
	}
}
