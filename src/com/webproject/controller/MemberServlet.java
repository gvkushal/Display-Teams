package com.webproject.controller;

/*
* @author G V kushal 
**/

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webproject.DAO.MemberDAO;
import com.webproject.DAO.TeamMembersDAO;
import com.webproject.model.TeamMember;

//Servlet for all player info display operations.

@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		MemberDAO mDAO = new MemberDAO();
		String playerName = request.getParameter("player");
		mDAO.mySqlConnection();
		request.getSession().setAttribute("playerInfo", mDAO.memberInfo(playerName));	
		RequestDispatcher rd = request.getRequestDispatcher("playerInfo.jsp");
		rd.forward(request, response);
	}
}
