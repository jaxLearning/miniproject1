package com.miniproject.service;

public class LoginValidation {
	
		String uname = "mallik";
		String pwd = "mallik";
		
	public boolean isLoginSuccessful(String uname, String pwd)
	{
		if((this.uname.equals(uname)) && (this.pwd.equals(pwd)))
			return true;
		else
			return false;
	}


}
