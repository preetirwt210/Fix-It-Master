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


@WebServlet("/admin/edit_user")
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDao;
	
	@Resource(name="jdbc/home_maintenance")
	private DataSource dataSource;  
	
	public EditUserServlet() {
        super();
    }
    
    @Override
	public void init() throws ServletException {
	
		super.init();
		try {
		userDao=new UserDAO(dataSource);
		}catch(Exception e) {
			throw new ServletException(e);
		}
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		try {
		editUser(request,response);

		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

	private void editUser(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String userId=request.getParameter("userId");
		User user=userDao.editUser(userId);
		
		request.setAttribute("theUser",user);
		
		String editPage="updateUserForm.jsp";
		RequestDispatcher dispatcher=request.getRequestDispatcher(editPage);
		dispatcher.forward(request, response);
		
		
		
		
	}

	
}
