package com.maintenance.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.maintenance.dao.CategoryDAO;
import com.maintenance.dao.ServicesDAO;
import com.maintenance.entity.Category;
import com.maintenance.entity.Services;

public class ServicesServ {

	 private ServicesDAO servicesDao;
	 private CategoryDAO categoryDao;
	 private EntityManagerFactory entityManagerFactory;
     private EntityManager entityManager;
	 private HttpServletRequest request;
	 private HttpServletResponse response;
	 
	    
	  public ServicesServ(HttpServletRequest request,HttpServletResponse response) {
			
			this.request=request;
			this.response=response;
			entityManagerFactory=Persistence.createEntityManagerFactory("Home Maintenance System");
	    	  entityManager=entityManagerFactory.createEntityManager();
			servicesDao= new ServicesDAO(entityManager);
			
		}
	  
	  public void listServices() throws Exception {
		  listServices(null);
	  }
	  
	public void listServices(String message) throws Exception {
		List<Services> listServices=servicesDao.listServices();
		
		request.setAttribute("list_serv",listServices );
		if(message !=null) {
			request.setAttribute("message", message);
		}
		RequestDispatcher dispatcher=request.getRequestDispatcher("services_list.jsp");
		dispatcher.forward(request, response);
		
	}

	public void createServices() {
		
		
	}

	public void showNewServicesForm() throws ServletException, IOException, SQLException {
		List<Category> listCategory=categoryDao.listCategories();
		request.setAttribute("listCategory", listCategory);
		
		String newPage="service_form.jsp";
		RequestDispatcher dispatcher=request.getRequestDispatcher(newPage);
		dispatcher.forward(request, response);
		
	}
}
