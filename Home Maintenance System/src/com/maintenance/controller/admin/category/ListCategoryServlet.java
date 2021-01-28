package com.maintenance.controller.admin.category;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.maintenance.admin.BaseServlet;
import com.maintenance.admin.services.CategoryServices;

@WebServlet("/admin/list_category")
public class ListCategoryServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    public ListCategoryServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryServices services=new CategoryServices(dataSource,request,response);
		try {
			services.listCategory();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
