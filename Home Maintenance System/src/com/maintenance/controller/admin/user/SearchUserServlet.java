package com.maintenance.controller.admin.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maintenance.admin.BaseServlet;
import com.maintenance.adminDBUtil.UserDbUtil;
import com.maintenance.entity.User;


@WebServlet("/admin/search_user")
public class SearchUserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SearchUserServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDbUtil userDbUtil=new UserDbUtil(dataSource,request,response);
		try {
			userDbUtil.searchUser();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}


	
}
