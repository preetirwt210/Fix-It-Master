package com.maintenance.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.maintenance.dao.UserDAO;
import com.maintenance.entity.User;

public class UserServices{

	 private UserDAO userDao;
      private EntityManagerFactory entityManagerFactory;
      private EntityManager entityManager;
      
      public UserServices() {
    	  entityManagerFactory=Persistence.createEntityManagerFactory("Home Maintenance System");
    	  entityManager=entityManagerFactory.createEntityManager();
    	  userDao=new UserDAO(entityManager);
      }
      
      public List<User> listUsers(){
		List<User> listUsers=userDao.listAll();
    	  return listUsers;
    	  
      }

	public void createUsers() {
		User createUsers=new User();
		User user=userDao.create(createUsers);
		
		
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
