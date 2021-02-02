package com.maintenance.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.maintenance.entity.Category;
import com.maintenance.entity.Services;

public class ServicesDAO {

private DataSource dataSource;
	
	public ServicesDAO(DataSource theDataSource) {
		dataSource=theDataSource;
	}

	public List<Services> listServices() throws SQLException {
		List<Services> services=new ArrayList<>();
	
		
		Connection myConn=null;
		Statement stmt=null;
		ResultSet rs=null;
		Services service=null;
		
	
		try {
			
			myConn=dataSource.getConnection();
			String sql="select * "
					+ "from service "
					+ "INNER JOIN category ON service.category_id=category.category_id ";
			stmt=myConn.createStatement();
		
			rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				service=new Services();
				int serviceId=rs.getInt("service_id");
				String title=rs.getString("title");
				String description=rs.getString("description");
				float price=rs.getFloat("price");
				
				
				service.setServiceId(serviceId);
				service.setTitle(title);
				service.setDescription(description);
				service.setPrice(price);
	            
				
				services.add(service);
			}
			
			return services;
		}
		finally {
			close(myConn,stmt,rs);
		}
		
	}

	private void close(Connection myConn, Statement stmt, ResultSet rs) throws SQLException {
		try {
		if(rs!=null) {
			rs.close();
		}
		if(stmt!=null) {
			stmt.close();
		}
		if(myConn!=null) {
			myConn.close();
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
			
		
		
	}
}
