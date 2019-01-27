package com.webproject.DAO;

/*
* @author G V kushal 
**/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;
import com.webproject.model.TeamMember;

public class MemberDAO {
	Connection con = null;

	public void mySqlConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "admin");
		} catch (SQLException e) {
			System.out.println("Connection to sql is failure");
		} catch (ClassNotFoundException e) {
			System.out.println("Class Not found Exeption");
		}
	}

	public TeamMember memberInfo(String playerName) {
		
		//Code to display player Information.
		
		TeamMember playerInfo = new TeamMember();
		String query = "select player,lastname,monthofbirth from players where player='" + playerName + "'";
		try {

			Statement st = (Statement) con.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			playerInfo.setPlayerFirstName(rs.getString(1));
			playerInfo.setPlayerLastName(rs.getString(2));
			playerInfo.setPlayerMonthOfBirth(rs.getString(3));
		} catch (SQLException e) {
			System.out.println("Exception raised in memberInfo function");
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return playerInfo;

	}
}
