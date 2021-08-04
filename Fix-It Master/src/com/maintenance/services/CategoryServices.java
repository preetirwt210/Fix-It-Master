package com.maintenance.services;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.maintenance.dao.CategoryDAO;
import com.maintenance.entity.Category;

public class CategoryServices {
	 private CategoryDAO categoryDao;
	 private HttpServletRequest request;
	 private HttpServletResponse response;
	  private DataSource dataSource;
	    
	  public CategoryServices(DataSource dataSource,HttpServletRequest request,HttpServletResponse response) {
			
			this.request=request;
			this.response=response;
			this.dataSource=dataSource;
			categoryDao= new CategoryDAO(dataSource);
			
		}
	  
	  public void listCategory() throws Exception {
		  listCategory(null);
	  }
	  
	public void listCategory(String message) throws Exception {
		List<Category> listCategory=categoryDao.listCategories();
		
		request.setAttribute("list_Category",listCategory );
		if(message !=null) {
			request.setAttribute("message", message);
		}
		RequestDispatcher dispatcher=request.getRequestDispatcher("category_list.jsp");
		dispatcher.forward(request, response);
		
	}

	public void createCategory() throws Exception {
		String categoryName=request.getParameter("name");
		String image=request.getParameter("image");
		
		Category category=new Category();
		category.setName(categoryName);
		category.setBase64Image(image);
		categoryDao.createCategory(category);
		
		request.setAttribute("category",category );
		
		String message="Category Successfully Added";
		listCategory(message);
		
	}

	public void editCategory() throws Exception {
		Integer categoryId=Integer.parseInt(request.getParameter("categoryId"));
		
		Category category=categoryDao.editCategory(categoryId);
		System.out.println(categoryId);
		request.setAttribute("category", category);
		String editPage="updateCategoryForm.jsp";
		RequestDispatcher dispatcher=request.getRequestDispatcher(editPage);
		dispatcher.forward(request, response);
		
		
	}

	public void updateCategory() throws Exception {
		Integer categoryId=Integer.parseInt(request.getParameter("categoryId"));
		String name=request.getParameter("name");
		String image=request.getParameter("image");
		
		
		Category category=new Category(categoryId,name,image);
		categoryDao.updateCategory(category);
		String message="Category has been successfully updated";
		listCategory(message);
		
	}

	public void deleteCategory() throws Exception {
		Integer categoryId=Integer.parseInt(request.getParameter("categoryId"));
		
		categoryDao.deleteCategory(categoryId);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/admin/list_category");
		dispatcher.forward(request, response);
		
	}

	public void searchCategory() throws Exception {
		String searchCategory=request.getParameter("searchCategory");
		 List<Category> category = categoryDao.searchCategory(searchCategory);
	       
	        request.setAttribute("list_Category",category);
	                
	        RequestDispatcher dispatcher=request.getRequestDispatcher("category_list.jsp");
			dispatcher.forward(request, response);
		
	}

}
