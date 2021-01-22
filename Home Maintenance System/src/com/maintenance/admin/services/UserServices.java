package com.maintenance.admin.services;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.maintenance.dao.UserDAO;
import com.maintenance.entity.User;

public class UserServices{

	 private UserDAO userDao;
	 private HttpServletRequest request;
	 private HttpServletResponse response;
	  private DataSource dataSource;
	    
	  public UserServices(DataSource dataSource,HttpServletRequest request,HttpServletResponse response) {
			
			this.request=request;
			this.response=response;
			this.dataSource=dataSource;
					userDao= new UserDAO(dataSource);
			
		}
	  
	  public void listUsers() throws Exception {
			listUsers(null);
		}
		
	public void listUsers(String message) throws Exception {
			
			List<User> listUsers=userDao.listUsers();
			
			request.setAttribute("List_User", listUsers);
			if(message!= null) {
				request.setAttribute("message", message);
				}
			RequestDispatcher dispatcher=request.getRequestDispatcher("users_list.jsp");
			dispatcher.forward(request, response);
			
			
		}


	public void createUsers() 
			throws Exception {
		
		String fullName=request.getParameter("fullName");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		User newUsers=new User(fullName,email,password);
		userDao.createUser(newUsers);
		String message="Users have created successfully";
		listUsers(message);
		
	}

    public void editUser() throws Exception{
		
		String userId=request.getParameter("userId");
		User user=userDao.editUser(userId);
		
		request.setAttribute("theUser",user);
		
		String editPage="updateUserForm.jsp";
		RequestDispatcher dispatcher=request.getRequestDispatcher(editPage);
		dispatcher.forward(request, response);
	}
    
    public void updateUser() 
			throws Exception {
		
	    int userId=Integer.parseInt(request.getParameter("userId"));
		String fullName=request.getParameter("fullName");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
        User users=new User(userId,fullName,email,password);
		userDao.updateUser(users);
		response.sendRedirect(request.getContextPath() + "/admin/list_users");
		
	}
    public void deleteUser() throws Exception {
		int userId=Integer.parseInt(request.getParameter("userId"));
		
		userDao.deleteUser(userId);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("list_users");
		dispatcher.forward(request, response);
		
	}

    public void searchUser()
			throws Exception {
		
		String searchUser=request.getParameter("searchUser");
		 List<User> users = userDao.searchUsers(searchUser);
	       
	        request.setAttribute("List_User",users);
	                
	        RequestDispatcher dispatcher=request.getRequestDispatcher("users_list.jsp");
			dispatcher.forward(request, response);
		
	}

	public void login() throws SQLException {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		boolean loginResult=userDao.checkLogin(email,password);
		if(loginResult) {
			System.out.println("User is authenticated");
		}else {
			System.out.println("Login failed");
		}
		
	}


}
