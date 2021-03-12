package com.maintenance.controller.admin.maintainServ;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maintenance.controller.BaseServlet;
import com.maintenance.services.ServicesServ;


@WebServlet("/admin/create_service")
public class CreateMaintainServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CreateMaintainServlet() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServicesServ services=new ServicesServ(dataSource,request,response);	
		try {
		services.createServices();
		}catch(Exception e) {
			e.printStackTrace();
		}
		}

}
