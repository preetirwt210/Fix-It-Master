package com.maintenance.controller.admin.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maintenance.admin.BaseServlet;
import com.maintenance.services.UserServices;


@WebServlet("/admin/search_user")
public class SearchUserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SearchUserServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserServices services=new UserServices(dataSource,request,response);
		try {
			services.searchUser();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}


	
}
