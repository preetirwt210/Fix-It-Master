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
import com.maintenance.adminDBUtil.UserDbUtil;
import com.maintenance.dao.UserDAO;
import com.maintenance.entity.User;


@WebServlet("/admin/update_user")
public class UpdateUserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
   public UpdateUserServlet() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDbUtil userDbUtil=new UserDbUtil(dataSource,request,response);
		try {
			userDbUtil.updateUser();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	

}
