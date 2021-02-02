package com.maintenance.dao;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.sql.DataSource;

import com.maintenance.entity.Category;


public class CategoryDAO {

private DataSource dataSource;
	
	public CategoryDAO(DataSource theDataSource) {
		dataSource=theDataSource;
	}

	public List<Category> listCategories() throws SQLException, IOException {
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
				Blob blob = myRs.getBlob("image");
                
                InputStream inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;
                 
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);                  
                }
                 
                byte[] imageBytes = outputStream.toByteArray();
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                 
                inputStream.close();
                outputStream.close();
                 
				
				
				Category cat=new Category();
				cat.setCategoryId(categoryid);
				cat.setName(categoryName);
				cat.setBase64Image(base64Image);
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
					+ "(name,image)"
					+ " values(?,?)";
			ps=myConn.prepareStatement(sql);
			
			ps.setString(1, category.getName());
			ps.setString(2, category.getBase64Image());
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
				Blob blob = rs.getBlob("image");
                
                InputStream inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;
                 
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);                  
                }
                 
                byte[] imageBytes = outputStream.toByteArray();
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                 
                 
                inputStream.close();
                outputStream.close();
                 
				category.setCategoryId(categoryId);
				category.setName(name);
				category.setBase64Image(base64Image);
				
				
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

	public void deleteCategory(Integer categoryId) throws SQLException {
		Connection myConn=null;
		PreparedStatement stmt=null;
		try {
			myConn=dataSource.getConnection();
			String sql="delete from category where category_id=?";
			stmt=myConn.prepareStatement(sql);
			stmt.setInt(1,categoryId);
			stmt.execute();
		}
		
		finally {
			close(myConn,stmt,null);
		}
		
		
	}

	public List<Category> searchCategory(String searchCategory) throws SQLException {
List<Category> category = new ArrayList<>();
        
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        int categoryId;
        
        try {
            
            myConn = dataSource.getConnection();
            
            if (searchCategory != null && searchCategory.trim().length() > 0) {
                
                String sql = "select * from category where lower(name) like ? ";
              
                myStmt = myConn.prepareStatement(sql);
               
                String theSearchNameLike = "%" + searchCategory.toLowerCase() + "%";
                myStmt.setString(1, theSearchNameLike);
                
            } else {
               
                String sql = "select * from category order by name";
                
                myStmt = myConn.prepareStatement(sql);
            }
            myRs = myStmt.executeQuery();
            
            while (myRs.next()) {
                
                int id = myRs.getInt("category_id");
                String name = myRs.getString("name");
                
                
                Category tempCategory = new Category(id, name);
                category.add(tempCategory);            
            }
            
            return category;
        }
        finally {
            close(myConn, myStmt, myRs);	
            }

	}
}
