package com.maintenance.controller.admin.category;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maintenance.admin.BaseServlet;
import com.maintenance.services.CategoryServices;

@WebServlet("/admin/search_category")
public class SearchCategoryServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SearchCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryServices services=new CategoryServices(dataSource,request,response);
		try {
		services.searchCategory();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	

}
