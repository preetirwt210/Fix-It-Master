package com.maintenance.controller.admin.maintainServ;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maintenance.controller.BaseServlet;
import com.maintenance.services.ServicesServ;

@WebServlet("/admin/list_services")
public class ListMaintainServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ListMaintainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServicesServ services=new ServicesServ(dataSource,request,response);
			try {
				services.listServices();
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}

}
