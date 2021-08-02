package com.maintenance.services;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maintenance.dao.UserDAO;
import com.maintenance.entity.User;

public class UserServices{

	 private UserDAO userDao;
      private EntityManagerFactory entityManagerFactory;
      private EntityManager entityManager;
      private HttpServletRequest request;
      private HttpServletResponse response;
      
      public UserServices(HttpServletRequest request, HttpServletResponse response ) {
    	  this.request=request;
    	  this.response= response;
    	  entityManagerFactory=Persistence.createEntityManagerFactory("Home Maintenance System");
    	  entityManager=entityManagerFactory.createEntityManager();
    	  userDao=new UserDAO(entityManager);
      }
     
      public void listUsers() 
    		  throws ServletException, IOException {
    	  listUsers(null);
      }
      
      
      public void listUsers(String message) throws ServletException, IOException{
		List<User> listUsers=userDao.listAll();
		
		request.setAttribute("List_User", listUsers);
		
		if(message !=null) {
			request.setAttribute("message", message);
		}
		RequestDispatcher dispatcher=request.getRequestDispatcher("users_list.jsp");
		dispatcher.forward(request, response);
    	  
      }

	public void createUsers() throws ServletException, IOException {
		
		String fullName=request.getParameter("fullName");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		User createUsers=new User(fullName,email,password);
		
		userDao.create(createUsers);
		
		
	}

	public void deleteUser() {
		// TODO Auto-generated method stub
		
	}

	public void editUser() {
		// TODO Auto-generated method stub
		
	}

	public void searchUser() {
		// TODO Auto-generated method stub
		
	}

	public void updateUser() {
		// TODO Auto-generated method stub
		
	}

   /* public void searchUser()
			throws Exception {
		
		String searchUser=request.getParameter("searchUser");
		 List<User> users = userDao.searchUsers(searchUser);
	       
	        request.setAttribute("List_User",users);
	                
	        RequestDispatcher dispatcher=request.getRequestDispatcher("users_list.jsp");
			dispatcher.forward(request, response);
		
	}
*/
}
