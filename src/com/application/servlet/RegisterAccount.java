package com.application.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.application.DAO.CRUD_Operation;
import com.application.bean.UserObject;

public class RegisterAccount extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(" post method it executed ");
		String fullName=req.getParameter("fullName");
		String userName=req.getParameter("userName");
		String password=req.getParameter("password");
		
		UserObject userObject=new UserObject();
		userObject.setFullName(fullName);
		userObject.setUserName(userName);
		userObject.setPassword(password);
		
		CRUD_Operation insert=new CRUD_Operation();
		boolean flag=insert.isRegister(userObject);
		if(flag)
		{
			RequestDispatcher rd=req.getRequestDispatcher("success.html");
			rd.forward(req,  resp);
		}
		else
		{
			resp.setContentType("text/html");
			PrintWriter out=resp.getWriter();
			out.print("Not registered");
			out.flush();
		}
		
		
	}
}
