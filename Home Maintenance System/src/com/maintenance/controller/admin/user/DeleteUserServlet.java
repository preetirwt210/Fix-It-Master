package com.maintenance.controller.admin.user;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.maintenance.dao.UserDAO;


@WebServlet("/admin/delete_user")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 private UserDAO userDao;
	    
	    @Resource(name="jdbc/home_maintenance")
	    private DataSource dataSource;
	    
		@Override
		public void init() throws ServletException {
			
			super.init();
			try {
				userDao=new UserDAO(dataSource);
			}
			catch(Exception e) {
				throw new ServletException(e);
			}
		}
    
    public DeleteUserServlet() {
        super();
       
    }
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	           try {
	        	   deleteUser(request,response);
	           }catch(Exception e) {
	        	   e.printStackTrace();
	           }
	}
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int userId=Integer.parseInt(request.getParameter("userId"));
		
		userDao.deleteUser(userId);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("list_users");
		dispatcher.forward(request, response);
		
	}

	
	
}
