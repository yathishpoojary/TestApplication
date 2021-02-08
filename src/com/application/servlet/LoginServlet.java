package com.application.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.application.DAO.CRUD_Operation;
import com.application.bean.LoginBean;
import com.application.bean.UserObject;

public class LoginServlet extends HttpServlet{
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(" get method it executed ");
		String userName=req.getParameter("userName");
		String password=req.getParameter("password");
		
		System.out.println(" userName "+userName);
		System.out.println(" password "+password);
		
		LoginBean loginObject=new LoginBean();
		loginObject.setUserName(userName);
		loginObject.setPassword(password);
		
		CRUD_Operation read=new CRUD_Operation();
		boolean b=read.isValidUser(loginObject);
		System.out.println(" BBBB "+b);
		if(b)
		{

			req.setAttribute("bean", loginObject);
			RequestDispatcher rd=req.getRequestDispatcher("/success.html");
			rd.forward(req,  resp);
		}
		
}
}
	
