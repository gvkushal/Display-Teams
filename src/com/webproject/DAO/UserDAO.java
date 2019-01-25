package com.webproject.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.webproject.model.User;

//import com.user.User;

public class UserDAO implements DAOInterface
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
	public boolean loginCheck(User user)
	{
		
		boolean loginSuccess=false;
		String query = "select * from userdata where Name=? and Password=?";
		try
		{
		PreparedStatement pt = con.prepareStatement(query);
		pt.setString(1, user.getUsername());
		pt.setString(2, user.getPassword());
		ResultSet rs = pt.executeQuery();
		if(rs.next())
		{
			loginSuccess= true;
		}
		}
		catch(SQLException e)
		{
			System.out.println("Connection to sql is failure");
		}
			finally
		{
			try{
			con.close();
			}
			catch(Exception e)
			{
				System.out.println("Exception Raised when closing connection");
			}
		}
		System.out.println("Connection successfully :"+loginSuccess);
		return loginSuccess;
	}
public int writeUserData(User user)
{
	String query = "Insert into userdata values(?,?,?,?)";
	int numberOfRowsEffected = 0;
	try
	{
	PreparedStatement pt = con.prepareStatement(query);
	pt.setString(1, user.getUsername());
	pt.setString(2, user.getPassword());
	pt.setString(3,user.getFirstname());
	pt.setString(4, user.getLastname());
	numberOfRowsEffected = (int) pt.executeUpdate();
	}
	catch(SQLException e)
	{
		System.out.println("Connection to sql is failure");
	}
	finally
	{
		try{
		con.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception Raised when closing connection");
		}
	}

	return numberOfRowsEffected;
	
	
}
}
