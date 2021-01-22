package com.maintenance.controller.admin.user;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.maintenance.admin.BaseServlet;
import com.maintenance.admin.services.UserServices;

@WebServlet("/admin/list_users")
public class ListUserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	 @Resource(name="jdbc/home_maintenance")
	    protected DataSource dataSource;
	    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserServices userDbUtil=new UserServices(dataSource,request,response);
		try {
			userDbUtil.listUsers();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	
}
