package com.home.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/home_maintenance")
	private DataSource dataSource;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/plain");
		
		Connection myConn=null;
		Statement stmt=null;
		ResultSet rs= null;
		
		try {
			myConn=dataSource.getConnection();
			
		String sql= "select * from users";
		stmt=myConn.createStatement();
		
		rs=stmt.executeQuery(sql);
		
		while(rs.next()) {
			
			
			String fullName= rs.getString("full_name");
			out.println(fullName);
		}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	
	}

}
