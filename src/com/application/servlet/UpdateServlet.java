package com.application.servlet;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;



public class UpdateServlet extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String username=req.getParameter("username");
	String fullName=req.getParameter("fullName");
	String password=req.getParameter("password");
	System.out.println(username+" the user name is ");
	System.out.println(fullName+" the full  name is ");
	
	//String qry="update usedetails.user set username="+"rahes"+",password"+"HIIII"+" where fullname="+"xx"+"";
	String qry="update usedetails.user set fullName='"+fullName+"', password='"+password+"' where username='"+username+"'";
	System.out.println("String qry is "+qry);
	Connection con=null;
	java.sql.Statement stmt=null;
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver class is loaded and regisrerd");
	
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=dinga");
		System.out.println("Connection established");
		
		stmt=con.createStatement();
		int n=stmt.executeUpdate(qry);
		
		if(n==0)
		{
			PrintWriter out=resp.getWriter();
			out.println("<html><body><a href=\"login.html\">back</a></body></html>");
		}
	///	req.setAttribute("bean", loginObject);
		RequestDispatcher rd=req.getRequestDispatcher("/success.html");
		rd.forward(req,  resp);
	} catch (SQLException |ClassNotFoundException e1) {
		e1.printStackTrace();
		
	}
}
}
