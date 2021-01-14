package com.maintenance.controller.admin.user;

import java.io.IOException;
import java.util.List;

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

@WebServlet("/admin/list_users")
public class ListUserServlet extends HttpServlet {
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
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			listUsers(request,response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	private void listUsers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<User> listUsers=userDao.listUsers();
		
		request.setAttribute("List_User", listUsers);
		
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("users_list.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
