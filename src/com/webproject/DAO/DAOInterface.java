package com.webproject.DAO;

import com.webproject.model.User;

/*
* @author G V kushal 
**/


public interface DAOInterface 
{
     public boolean loginCheck(User user);
     public void mySqlConnection();
	public int writeUserData(User user);
}
