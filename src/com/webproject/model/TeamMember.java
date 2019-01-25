package com.webproject.model;

public class TeamMember 
{
	private String playerFirstName;
	private String playerLastName;
	private String playerMonthOfBirth;
	public TeamMember()
	{
		
	}

	public TeamMember(String playerFirstName, String playerLastName, String playerMonthOfBirth)
	{
		this.playerFirstName = playerFirstName;
		this.playerLastName = playerLastName;
		this.playerMonthOfBirth = playerMonthOfBirth;
	}

	public String getPlayerFirstName() {
		return playerFirstName;
	}

	public void setPlayerFirstName(String playerFirstName) {
		this.playerFirstName = playerFirstName;
	}

	public String getPlayerLastName() {
		return playerLastName;
	}

	public void setPlayerLastName(String playerLastName) {
		this.playerLastName = playerLastName;
	}

	public String getPlayerMonthOfBirth() {
		return playerMonthOfBirth;
	}

	public void setPlayerMonthOfBirth(String playerMonthOfBirth) {
		this.playerMonthOfBirth = playerMonthOfBirth;
	}
	

}
