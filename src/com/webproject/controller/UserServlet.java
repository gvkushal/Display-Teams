package com.webproject.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webproject.DAO.DAOInterface;
import com.webproject.DAO.UserDAO;
import com.webproject.model.User;



@WebServlet({ "/login", "/register" })
public class UserServlet extends HttpServlet
{
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	
		PrintWriter out = response.getWriter();
		User user = new User();
		DAOInterface DAO = new UserDAO();
		System.out.println((String)request.getParameter("request_type"));		
		if ("login".equals((String)request.getParameter("request_type")))
		{	
			System.out.println("I am in ");
			String username = (String)request.getParameter("username");
			user.setUsername(username);
			String password = (String)request.getParameter("password");
			user.setPassword(password);
			
			if(username.trim().length()==0||password.trim().length()==0)
			{
				System.out.println("index check");
			response.sendRedirect("index.jsp");
			}
			else{
				
				DAO.mySqlConnection();
				if(DAO.loginCheck(user))
				{
					RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
					rd.forward(request, response);
				}
				else
				{
					response.sendRedirect("index.jsp");
					out.println("Invalid Credentials..Please login once again");
				}
			}	
		}
		else if ("register".equals((String)request.getParameter("request_type"))) //code for register SignUp.
		{	
			System.out.println("In register");
		int number=0;
		String username = (String)request.getParameter("username");
		user.setUsername(username);
		String password = (String)request.getParameter("password");
		user.setPassword(password);
		String firstname = (String)request.getParameter("firstname");
		user.setFirstname(firstname);
		String lastname = (String)request.getParameter("lastname");
		user.setLastname(lastname);
		if(username.trim().length()==0||password.trim().length()==0||firstname.trim().length()==0||lastname.trim().length()==0)
		{
			response.sendRedirect("signUp.jsp");
		}
		else
		{
		DAO.mySqlConnection();
		number = DAO.writeUserData(user);
		
		if(number>0)
		{
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		else
		{
			out.println("Signup failure");
		}
		}
		}	
	}
}

