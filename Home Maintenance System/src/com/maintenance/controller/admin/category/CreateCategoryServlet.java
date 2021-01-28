package com.maintenance.controller.admin.category;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maintenance.admin.BaseServlet;
import com.maintenance.admin.services.CategoryServices;


@WebServlet("/admin/create_category")
public class CreateCategoryServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CreateCategoryServlet() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		CategoryServices services=new CategoryServices(dataSource,request,response);
		try {
			services.createCategory();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
