package com.maintenance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.maintenance.entity.Category;

public class CategoryDAO {

private DataSource dataSource;
	
	public CategoryDAO(DataSource theDataSource) {
		dataSource=theDataSource;
	}

	public List<Category> listCategories() throws SQLException {
		List<Category> categories=new ArrayList<>();
		
		Connection myConn=null;
		Statement myStmt=null;
		ResultSet myRs=null;
		
		try {
			myConn=dataSource.getConnection();
			String sql="select * from category";
			myStmt=myConn.createStatement();
			myRs=myStmt.executeQuery(sql);
			
			while(myRs.next()) {
				int categoryid=myRs.getInt("category_id");
				String  categoryName=myRs.getString("name");
				
				Category cat=new Category(categoryid,categoryName);
				categories.add(cat);
			}
			return categories;
		}
		finally{
			close(myConn,myStmt,myRs);
		}
		
		
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		try {
		if(myRs != null) {
			myRs.close();
		}
		if(myStmt != null) {
			myStmt.close();
		}
		if(myConn != null) {
			myConn.close();
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void createCategory(Category category) throws SQLException {
		Connection myConn=null;
		PreparedStatement ps=null;	
		
		try {
			myConn=dataSource.getConnection();
			String sql="insert into category "
					+ "(name)"
					+ " values(?)";
			ps=myConn.prepareStatement(sql);
			
			ps.setString(1, category.getName());
			
			ps.execute();
			
			
		}
		finally {
			close(myConn,ps,null);
		}
		
	}

	public Category editCategory(Integer categoryId) throws Exception {
		Category category=null;
		
		Connection myConn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			myConn=dataSource.getConnection();
			String sql="select * from category where category_id=?";
			stmt=myConn.prepareStatement(sql);
			stmt.setInt(1,categoryId);
			rs=stmt.executeQuery();
			
			if(rs.next()) {
				String name=rs.getString("name");
				
				category=new Category(categoryId,name);
				
			}else {
				throw new Exception("CategoryId is invalid" + categoryId);
			}
			return category;
		}
		
		finally {
			close(myConn,stmt,rs);
		}
	}

	public void updateCategory(Category category) throws SQLException {
		Connection myConn=null;
		PreparedStatement stmt=null;
		try {
			myConn=dataSource.getConnection();
			String sql="update category "
					+ "SET name=?"
					+ " where category_id =?";
			stmt=myConn.prepareStatement(sql);
			stmt.setString(1,category.getName());
			stmt.setInt(2, category.getCategoryId());
			stmt.execute();
			
			
		}
		
		finally {
			close(myConn,stmt,null);
		}
		
	}

	public void deleteCategory(Integer categoryId) {
		
		
	}
}
