package com.maintenance.admin.user;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.sql.DataSource;

public class UserDAO {

	private DataSource dataSource;
	
	public UserDAO(DataSource theDataSource) {
		dataSource=theDataSource;
	}
	
	public List<User> listUsers() throws Exception{
		List<User> listUsers=new ArrayList<>();
		
		Connection myConn=null;
		Statement myStmt=null;
		ResultSet myRs=null;
		
		try {
			myConn=dataSource.getConnection();
		     
			String sql="Select * from users order by full_name";
			
			myStmt=myConn.createStatement();
			
			myRs=myStmt.executeQuery(sql);
			
			while(myRs.next()) {
				int id=myRs.getInt("user_id");
				String fullName=myRs.getString("full_name");
				String email=myRs.getString("email");
				String password=myRs.getString("password");
				
				User tempUser=new User(id,fullName,email,password);
				
				listUsers.add(tempUser);
			}
	        
			return listUsers;
		}
		finally {
			close(myConn,myStmt,myRs);
		}
		
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		try {
			if(myRs!=null) {
				myRs.close();
			}
			if(myStmt !=null) {
				myStmt.close();
			}
			if(myConn !=null) {
				myConn.close();
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
	     }
	
	}
}
