package com.maintenance.admin;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.maintenance.dao.UserDAO;


public abstract class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 protected UserDAO userDao;
		
	    @Resource(name="jdbc/home_maintenance")
	    protected DataSource dataSource;
	    
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
		public void destroy() {
			super.destroy();
		}

	public BaseServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
