package com.maintenance.controller.admin.maintainServ;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maintenance.controller.BaseServlet;
import com.maintenance.services.ServicesServ;


@WebServlet("/admin/new_services")
public class NewMaintainServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
   
    public NewMaintainServlet() {
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
