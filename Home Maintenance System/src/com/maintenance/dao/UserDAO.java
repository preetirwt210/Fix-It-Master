package com.maintenance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.maintenance.entity.User;

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
			
			
			while(myRs.next()) {
				int userId=myRs.getInt("user_id");
				String fullName=myRs.getString("full_name");
				String email=myRs.getString("email");
				String password=myRs.getString("password");
				
				User tempUser=new User(userId,fullName,email,password);
				
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

	public void createUser(User newUsers) throws Exception {
		Connection myConn=null;
		PreparedStatement stmt=null;
		
		try {
			myConn=dataSource.getConnection();
			String sql="insert into users"
			+ "(full_name,email,password)"
				+	"values(?,?,?)";
			
			stmt=myConn.prepareStatement(sql);
			
			stmt.setString(1,newUsers.getFullName());
			stmt.setString(2,newUsers.getEmail());
			stmt.setString(3,newUsers.getPassword());
			
			stmt.execute();
		
			
		}
		finally {
			close(myConn,stmt,null);
		}
		
	}

	public User editUser(String userId) throws Exception {
		
		User user=null;
		Connection myConn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		int theUserId;
		
		try {
			theUserId=Integer.parseInt(userId);
			myConn=dataSource.getConnection();
			String sql="Select * from users where user_id=?";
			
			stmt=myConn.prepareStatement(sql);
			stmt.setInt(1,theUserId);
			rs=stmt.executeQuery();
			if(rs.next()) {
				String fullName=rs.getString("full_name");
				String email=rs.getString("email");
				String password=rs.getString("password");
				
				user=new User(theUserId,fullName,email,password);
			}
			else {
				throw new Exception("Could not find UserId: " + theUserId);
			}
			return user;
		}
		
		finally {
			close(myConn,stmt,rs);
		}
		
	}

	public void updateUser(User users) throws Exception {
		Connection myConn=null;
		PreparedStatement stmt=null;
		
		try {
			myConn=dataSource.getConnection();
			String sql="update users " 
			         +"SET full_name=?, email=?, password=? "
					+ "where user_id =?";
			
			stmt=myConn.prepareStatement(sql);
			
			stmt.setString(1,users.getFullName());
			stmt.setString(2,users.getEmail());
			stmt.setString(3,users.getPassword());
			stmt.setInt(4,users.getUserId());
			
			stmt.execute();
			
		}
		finally {
			close(myConn,stmt,null);
		}
		
	}

	public void deleteUser(int userId) throws Exception{
		Connection myConn=null;
		PreparedStatement stmt=null;
		try {
			
			myConn=dataSource.getConnection();
			String sql="delete from users where user_id=?";
			stmt=myConn.prepareStatement(sql);
			
			stmt.setInt(1,userId);
			
			stmt.execute();
		}
		finally {
			close(myConn,stmt,null);
		}
		
	}



	public List<User> searchUsers(String searchUser) throws Exception {
      List<User> users = new ArrayList<>();
        
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        int userId;
        
        try {
            
            myConn = dataSource.getConnection();
            
            if (searchUser != null && searchUser.trim().length() > 0) {
                
                String sql = "select * from users where lower(full_name) like ? ";
              
                myStmt = myConn.prepareStatement(sql);
               
                String theSearchNameLike = "%" + searchUser.toLowerCase() + "%";
                myStmt.setString(1, theSearchNameLike);
                
            } else {
               
                String sql = "select * from users order by full_name";
                
                myStmt = myConn.prepareStatement(sql);
            }
            myRs = myStmt.executeQuery();
            
            while (myRs.next()) {
                
                int id = myRs.getInt("user_id");
                String fullName = myRs.getString("full_name");
                String email = myRs.getString("email");
                String password = myRs.getString("password");
                
                User tempUser = new User(id, fullName, email, password);
                users.add(tempUser);            
            }
            
            return users;
        }
        finally {
            close(myConn, myStmt, myRs);	
            }
	}

public User checkLogin(String email, String password) throws SQLException {
	User users=null;
	        Connection myConn = null;
	        PreparedStatement myStmt = null;
	        ResultSet myRs = null;
	        
	        try {
	            myConn = dataSource.getConnection();
	                String sql = "SELECT * FROM users WHERE email=? AND password=? ";
	                myStmt = myConn.prepareStatement(sql);
	                myStmt.setString(1,email);
	                myStmt.setString(2,password);
	                myRs=myStmt.executeQuery();
	                
	                if(myRs.next()) {
	                	users=new User();
	    			}
	    			
	                return users;
	        }
	        finally {
	            close(myConn, myStmt, myRs);	
	            }

	}



}
