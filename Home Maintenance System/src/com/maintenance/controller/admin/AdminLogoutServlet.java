package com.maintenance.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maintenance.controller.BaseServlet;

@WebServlet("/admin/logout")
public class AdminLogoutServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AdminLogoutServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message="Successfully Logged out!!";
		request.getSession().removeAttribute("useremail");
		RequestDispatcher dispatcher=request.getRequestDispatcher("login.jsp");
		request.setAttribute("message", message);
		dispatcher.forward(request, response);
		
	}


}
