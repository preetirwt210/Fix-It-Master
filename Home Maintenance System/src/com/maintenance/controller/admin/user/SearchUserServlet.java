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


@WebServlet("/admin/search_user")
public class SearchUserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SearchUserServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			searchUser(request,response);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}


	private void searchUser(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String searchUser=request.getParameter("searchUser");
		 List<User> users = userDao.searchUsers(searchUser);
	       
	        request.setAttribute("List_User",users);
	                
	        RequestDispatcher dispatcher=request.getRequestDispatcher("users_list.jsp");
			dispatcher.forward(request, response);
		
	}

}
