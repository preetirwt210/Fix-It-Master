package com.maintenance.controller.admin.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maintenance.admin.BaseServlet;
import com.maintenance.entity.User;

@WebServlet("/admin/list_users")
public class ListUserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			listUsers(request,response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	
	private void listUsers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<User> listUsers=userDao.listUsers();
		
		request.setAttribute("List_User", listUsers);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("users_list.jsp");
		dispatcher.forward(request, response);
		
		
	}


}
