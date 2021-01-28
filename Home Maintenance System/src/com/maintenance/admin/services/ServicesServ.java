package com.maintenance.admin.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.maintenance.dao.CategoryDAO;
import com.maintenance.dao.ServicesDAO;

public class ServicesServ {
	 private ServicesDAO servicesDao;
	 private HttpServletRequest request;
	 private HttpServletResponse response;
	  private DataSource dataSource;

	    
	  public ServicesServ(DataSource dataSource,HttpServletRequest request,HttpServletResponse response) {
			
			this.request=request;
			this.response=response;
			this.dataSource=dataSource;
			servicesDao= new ServicesDAO(dataSource);
			
		}
	  
	public void listServices() {
		

		
	}

}
