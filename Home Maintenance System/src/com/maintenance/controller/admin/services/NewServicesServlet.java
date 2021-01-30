package com.maintenance.controller.admin.services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maintenance.admin.BaseServlet;
import com.maintenance.admin.services.ServicesServ;


@WebServlet("/admin/new_services")
public class NewServicesServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
   
    public NewServicesServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServicesServ services=new ServicesServ(dataSource,request,response);
		try {
			services.showNewServicesForm();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
