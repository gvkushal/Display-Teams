# Team-Viewer

Technologies used
1) JSP.
2) Servlets. 
3) JDBC.

Please, make sure you know java collections concept before looking into the actual code.

This project takes user information and stores in database and with few clicks it displays all team members and player information on the screen.

#Display Teams.
 Here we will display all the team details in one page.
 
#Display userdata in a team.
 All the users displayed in all teams page are hyperlinks and that link navigates to that particular information you clicked.
 
#Inputs user and team information.
 We can add one entire team detials in one shot.


### A very good project for a beginner to JSP, Servlets and Collections(JAVA) ###

To Understand the code easily first understand the below logic to display all the teams at once.

We have two items to store
1. Team name (String)
2. Players of a team (List)

To group the above items together we have one collection in java i.e "Map".
As we know Map is a {key:value} pair we can use the same concept to our items and place "TeamName as Key" and "Players<List> as Value"
 
 # i.e {TeamName1:[PlayersList], TeamName2:[PlayersList]}
