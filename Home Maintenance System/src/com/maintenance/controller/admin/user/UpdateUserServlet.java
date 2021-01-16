package com.maintenance.controller.admin.user;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.maintenance.admin.BaseServlet;
import com.maintenance.dao.UserDAO;
import com.maintenance.entity.User;


@WebServlet("/admin/update_user")
public class UpdateUserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
   public UpdateUserServlet() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		updateUser(request,response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		
	    int userId=Integer.parseInt(request.getParameter("userId"));
		String fullName=request.getParameter("fullName");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
        User users=new User(userId,fullName,email,password);
		userDao.updateUser(users);
		response.sendRedirect(request.getContextPath() + "/admin/list_users");
		
	}

}
