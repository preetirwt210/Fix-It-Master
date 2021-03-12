package com.maintenance.controller.admin.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maintenance.controller.BaseServlet;
import com.maintenance.services.UserServices;

@WebServlet("/admin/create_user")
public class CreateUserServlet extends BaseServlet{
	private static final long serialVersionUID = 1L;
		
    public CreateUserServlet() {
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
			UserServices userDbUtil=new UserServices(dataSource,request,response);
			try {
				userDbUtil.createUsers();
			} catch (Exception e) {
				e.printStackTrace();
			}

	}

	

}
