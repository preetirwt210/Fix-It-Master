package com.maintenance.controller.admin.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maintenance.services.UserServices;

@WebServlet("/admin/create_user")
public class CreateUserServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
		
    public CreateUserServlet() {
    }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
			UserServices userServices=new UserServices(request, response);
			userServices.createUsers();
			userServices.listUsers("New User Created Succesfully.");

	}

	

}
