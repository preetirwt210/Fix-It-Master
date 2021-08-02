package com.maintenance.controller.admin.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maintenance.entity.User;
import com.maintenance.services.UserServices;

@WebServlet("/admin/list_users")
public class ListUserServlet extends HttpServlet  {
	private static final long serialVersionUID = 1L; 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserServices userServices=new UserServices(request, response);
		userServices.listUsers();
		
	}

}
