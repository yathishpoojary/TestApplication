package com.application.servlet;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;
import org.json.simple.JSONObject;



public class DeleteUserServlet extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 
	String username=req.getParameter("username");
	String qry="delete from usedetails.user where userName='"+username+"'";
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
		System.out.println("Delete query successfully executed");
		/*if(n==0)
		{
			PrintWriter out=resp.getWriter();
			out.println("<html><body><a href=\"login.html\">back</a></body></html>");
		}
	///	req.setAttribute("bean", loginObject);
		RequestDispatcher rd=req.getRequestDispatcher("/success.html");
		rd.forward(req,  resp);*/
		

	/*	resp.setContentType("application/json");
		PrintWriter out=resp.getWriter();
		out.print("Successfully deleted");
		out.flush();*/
		
		RequestDispatcher rd=req.getRequestDispatcher("/success.html");
		rd.forward(req,  resp);
		
	} catch (SQLException |ClassNotFoundException e1) {
		e1.printStackTrace();
		
	}
}
}
