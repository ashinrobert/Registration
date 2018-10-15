package com.nissan.training.advancedjava.assignment;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		/* Setting bean fields */
		RegistrationBean bean = new RegistrationBean();
		bean.setFname(fname);
		bean.setLname(lname);
		bean.setEmail(email);
		bean.setMobile(mobile);
		
		/*Storing bean in database */
		
		if(bean.save()) { //Successfully inserted to db
			request.setAttribute("user", bean);
			RequestDispatcher rd=request.getRequestDispatcher("registration-success.jsp");  
            rd.forward(request, response); 
		}
		else { // db error 
			 	response.getWriter().print("Sorry registration failed. Please try a different email.");  
		        RequestDispatcher rd=request.getRequestDispatcher("/index.html");  
		        rd.include(request, response);  
		}
		
		
	}

}
