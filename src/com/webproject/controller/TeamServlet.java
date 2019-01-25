package com.webproject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webproject.DAO.TeamMembersDAO;
import com.webproject.model.TeamMember;



@WebServlet("/TeamServlet")
public class TeamServlet extends HttpServlet {
 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	
		TeamMembersDAO tDAO = new TeamMembersDAO();
		PrintWriter out = response.getWriter();
		int number=0;
		System.out.println("I am in TeamServlet");
		
		if("AddTeam".equals((String)request.getParameter("action")))
		{
			
		System.out.println("I am in AddTeam");
		// code for adding team members
		String team = request.getParameter("team");
		ArrayList<TeamMember> players = new ArrayList<>(); 
		players.add(new TeamMember(request.getParameter("member1Firstname"),request.getParameter("member1Lastname"), request.getParameter("member1MonthOfBirth")));
		players.add(new TeamMember(request.getParameter("member2Firstname"),request.getParameter("member2Lastname"), request.getParameter("member2MonthOfBirth")));
		players.add(new TeamMember(request.getParameter("member3Firstname"),request.getParameter("member3Lastname"), request.getParameter("member3MonthOfBirth")));
		players.add(new TeamMember(request.getParameter("member4Firstname"),request.getParameter("member4Lastname"), request.getParameter("member4MonthOfBirth")));
		players.add(new TeamMember(request.getParameter("member5Firstname"),request.getParameter("member5Lastname"), request.getParameter("member5MonthOfBirth")));
		//System.out.println(players);
		tDAO.mySqlConnection();
		number=tDAO.addWholeTeam(team, players);
		if(number>0)
		{
			response.sendRedirect("addTeam.jsp?msg=Team Added Successfully");
		}
		else
		{
			out.println("Signup failure");
		}
		
		}
		else if("ShowTeams".equals((String)request.getParameter("action")))
		{
			System.out.println("I am in AllshowTeam");
		//code for display whole team
		tDAO.mySqlConnection();
		request.getSession().setAttribute("teamsData", tDAO.showAllTeams());
		RequestDispatcher rd = request.getRequestDispatcher("allTeams.jsp");
		rd.forward(request, response);
		}
		
		
	}

}
