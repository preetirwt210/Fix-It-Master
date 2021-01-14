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
import com.maintenance.entity.User;

@WebServlet("/admin/create_user")
public class CreateUserServlet extends HttpServlet {
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
       
   
    public CreateUserServlet() {
        super();
        
    }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		try {
			createUsers(request,response);
			}
			catch(Exception e) {
				throw new ServletException(e);
			}
	}

	private void createUsers(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		
		String fullName=request.getParameter("fullName");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		
		User newUsers=new User(fullName,email,password);
		userDao.createUser(newUsers);
		RequestDispatcher dispatcher=request.getRequestDispatcher("list_users");
		dispatcher.forward(request, response);
		
	}



}
