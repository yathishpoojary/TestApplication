package com.application.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class UserDataServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String qry="select * from usedetails.user ";
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class is loaded and regisrerd");
		
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=dinga");
			System.out.println("Connection established");
			
			pstmt=con.prepareStatement(qry);
			rs=pstmt.executeQuery();
			System.out.println("its executed " );
			 JSONArray arr = new JSONArray();
			while(rs.next())
			{
				JSONObject obj=new JSONObject();  
				 obj.put("fullName",rs.getString(1));    
				  obj.put("userName",rs.getString(2));    
				  obj.put("password",rs.getString(3));    
				   System.out.print(obj);    
//				System.out.println(rs.getString(1));
//				System.out.println(rs.getString(2));
//				System.out.println(rs.getString(3));
				   arr.add(obj);
				   
			}
			System.out.println("output "+arr);
			
			resp.setContentType("application/json");
			PrintWriter out=resp.getWriter();
			out.print(arr);
			out.flush();

		} catch (SQLException |ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
	}
}
