package com.maintenance.controller.admin.category;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maintenance.admin.BaseServlet;
import com.maintenance.admin.services.CategoryServices;


@WebServlet("/admin/delete_category")
public class DeleteCategoryServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryServices services=new CategoryServices(dataSource,request,response);
		try {
		services.deleteCategory();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
