package com.webproject.DAO;

import com.webproject.model.User;

/*import com.user.User;*/

public interface DAOInterface 
{
     public boolean loginCheck(User user);
     public void mySqlConnection();
	//public User readUserData();
	public int writeUserData(User user);
	//public int updateUserData();
	//public int deleteUserData();
}
