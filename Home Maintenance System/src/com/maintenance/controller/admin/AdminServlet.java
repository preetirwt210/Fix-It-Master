package com.maintenance.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maintenance.controller.BaseServlet;

@WebServlet("/admin/")
public class AdminServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AdminServlet() {
        super();
    }

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String homepage="index.jsp";
		System.out.println("AdminServlet");
		RequestDispatcher dispatcher= request.getRequestDispatcher(homepage);
		dispatcher.forward(request, response);
	}

}
