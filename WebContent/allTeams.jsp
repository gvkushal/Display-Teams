<%@page import="java.util.Map.Entry"%>
<%@page import="com.sun.javafx.collections.MappingChange.Map"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList,java.util.HashMap,java.util.ArrayList,java.util.Set" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<h1>List of All Teams</h1>
</head>
<style type="text/css">
.teams	{float: left;
    width: 100px;
    height: 20px;
    margin-right: 8px;
    background-color: linen;}
</style>
<body>
<%
//HashMap<String, ArrayList> teamsInfo= new HashMap<String,ArrayList>();
HashMap<String, ArrayList> teamsInfo = (HashMap<String, ArrayList>) request.getSession().getAttribute("teamsData");
Set s = teamsInfo.entrySet();
Iterator itr = s.iterator();
String player;
while(itr.hasNext())
{
	Entry<String,ArrayList> entry = (Entry<String,ArrayList>) itr.next();%>
	<div class=teams>
	<li>
	<label><b><%=entry.getKey()%></b></label>
	<%ArrayList<String> players= entry.getValue();
	Iterator playerIterator = players.iterator();
	while(playerIterator.hasNext())
	{
	player=(String) playerIterator.next();
	%>
	<ul><a href="<%=request.getContextPath() %>/MemberServlet?player=<%=player%>"> <%=player%> </a></ul>
	<%}%>
	</li>
	</div>	
<%}%>
</body>
</html>