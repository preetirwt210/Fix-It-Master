package com.maintenance.controller.admin.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maintenance.admin.BaseServlet;
import com.maintenance.adminDBUtil.UserDbUtil;


@WebServlet("/admin/delete_user")
public class DeleteUserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    
    public DeleteUserServlet() {
        super();
       
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDbUtil userDbUtil=new UserDbUtil(dataSource,request,response);       
		try {
			userDbUtil.deleteUser();
	           }catch(Exception e) {
	        	   e.printStackTrace();
	           }
	}
	
	
	
}
