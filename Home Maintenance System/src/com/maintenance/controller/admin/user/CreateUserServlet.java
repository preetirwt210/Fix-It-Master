package com.maintenance.controller.admin.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maintenance.admin.BaseServlet;
import com.maintenance.entity.User;

@WebServlet("/admin/create_user")
public class CreateUserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
    public CreateUserServlet() {
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try {
			createUsers(request, response);
			}
			catch(Exception e) {
				throw new ServletException(e);
			}
	}

	public void createUsers(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		
		String fullName=request.getParameter("fullName");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		
		User newUsers=new User(fullName,email,password);
		userDao.createUser(newUsers);
		
		String message = "User has been updated successfully!!";
		request.setAttribute("message", message);
		response.sendRedirect(request.getContextPath() + "/admin/list_users" );
		
		
	}

	


}
