package com.application.DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.application.servlet.*;
import com.application.bean.LoginBean;
import com.application.bean.UserObject;

public class CRUD_Operation {
	public boolean isRegister(UserObject userObject){
		String qry="insert into usedetails.user values(?,?,?)";
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class is loaded and regisrerd");
		
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=dinga");
			System.out.println("Connection established");
			
			pstmt=con.prepareStatement(qry);
			pstmt.setString(1,userObject.getFullName() );
			pstmt.setString(2, userObject.getUserName());
			pstmt.setString(3, userObject.getPassword());
			pstmt.executeUpdate();
			System.out.println("its executed");
			
			return true;

		} catch (SQLException |ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		return false;
		
	}

	public boolean isValidUser(LoginBean loginObject)
	{
		// TODO Auto-generated method stub
		System.out.println("is valid "+ loginObject.getUserName()+loginObject.getPassword());
		String qry="select * from usedetails.user where userName=? & password=?";
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class is loaded and regisrerd");
		
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=dinga");
			System.out.println("Connection established");
			
			pstmt=con.prepareStatement(qry);
			pstmt.setString(1, loginObject.getUserName());
			pstmt.setString(2, loginObject.getPassword());
			rs=pstmt.executeQuery();
			System.out.println("its executed");
			System.out.println("rs.next()"+ rs.next());
			if(rs!=null)
				return true;
			else
				return false;

		} catch (SQLException |ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		return false;
	}
}
