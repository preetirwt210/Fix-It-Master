package com.maintenance.controller.admin.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maintenance.admin.BaseServlet;


@WebServlet("/admin/delete_user")
public class DeleteUserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    
    public DeleteUserServlet() {
        super();
       
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	           try {
	        	   deleteUser(request,response);
	           }catch(Exception e) {
	        	   e.printStackTrace();
	           }
	}
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int userId=Integer.parseInt(request.getParameter("userId"));
		
		userDao.deleteUser(userId);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("list_users");
		dispatcher.forward(request, response);
		
	}

	
	
}
