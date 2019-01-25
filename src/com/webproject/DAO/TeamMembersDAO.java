package com.webproject.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.webproject.model.TeamMember;

public class TeamMembersDAO 
{
	Connection con=null;
	public void mySqlConnection()
	{
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "admin");
		}
		catch(SQLException e)
		{
			System.out.println("Connection to sql is failure");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Class Not found Exeption");
		}
	}
	public int addWholeTeam(String team, ArrayList<TeamMember> players)
	{
		int numberOfRowsEffected = 0;
		String query1 = "Insert into Teams(team) values(?)";
		String query2 = "select id from Teams where team='"+team+"'";
		String query3 = "Insert into Players values(?,?,?,?)";
		try
		{
		PreparedStatement ps1 = (PreparedStatement) con.prepareStatement(query1);
		PreparedStatement ps2= (PreparedStatement) con.prepareStatement(query3);
		Statement st = (Statement) con.createStatement();
		ps1.setString(1, team);
		ps1.executeUpdate();
		System.out.println(query2);
		ResultSet rs = st.executeQuery(query2); 
		rs.next();
		System.out.println("The team_id is:"+rs.getInt(1));
		for(int i=0; i<players.size();i++)
		{
			ps2.setString(1,players.get(i).getPlayerFirstName());
			ps2.setInt(2, rs.getInt(1));
			ps2.setString(3,players.get(i).getPlayerLastName());
			ps2.setString(4,players.get(i).getPlayerMonthOfBirth());
			numberOfRowsEffected = ps2.executeUpdate();
			System.out.println("Insterted member:"+i);
		}
		}
		catch(SQLException e)
		{
			System.out.println("Unable to update Team Members data, because of SQLException");
		}
		finally
		{
			try
			{
				con.close();
			}
			catch(SQLException e)
			{
				System.out.println(e);
			}
		}
		return numberOfRowsEffected;
	}
	public HashMap<String,ArrayList> showAllTeams()
	{
		int i;
		String team;
		HashMap<String,ArrayList> teamValues = new HashMap<String,ArrayList>();
		String query1 = "select team from Teams";
		String query2 = "select player from Teams, Players where team_id = id and team_id=(select id from Teams where team=?);";		
		try {
			Statement st = (Statement)con.createStatement();
			ResultSet rs1 = st.executeQuery(query1);			
			PreparedStatement pt = (PreparedStatement)con.prepareStatement(query2);
			while(rs1.next())
			{	
				team = rs1.getString(1);
				ArrayList<String> players = new ArrayList<String>();
				teamValues.put(team, players);
				pt.setString(1, team);
				ResultSet rs2 = pt.executeQuery();
				while(rs2.next())
				{
				players.add(rs2.getString(1));
				}
			}
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			finally
			{
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
			}
			
		}
		System.out.println(teamValues);
		return teamValues;
	}
}


