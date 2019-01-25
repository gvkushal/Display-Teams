<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%String msg=request.getParameter("msg");
  if(msg!=null)
  {%>
  <h1>Team Added Successfully..!!</h1>
  <%}%>
  
</head>
<body>
<form action="TeamServlet">
Name of the Team <input type="text" name="team"/>
<ul>
<li>
<label> Player1 </label>
<input type="text" name="member1Firstname" placeholder="Firstname"/>
<input type="text" name="member1Lastname" placeholder="Lastname"/>
<input type="text" name="member1MonthOfBirth" placeholder="MOB"/>
</li>
<li>
<label> Player2 </label>
<input type="text" name="member2Firstname" placeholder="Firstname"/>
<input type="text" name="member2astname" placeholder="Lastname"/>
<input type="text" name="member2MonthOfBirth" placeholder="MOB"/>
</li>
<li>
<label> Player3 </label>
<input type="text" name="member3Firstname" placeholder="Firstname"/>
<input type="text" name="member3Lastname" placeholder="Lastname"/>
<input type="text" name="member3MonthOfBirth" placeholder="MOB"/>
</li>
<li>
<label> Player4 </label>
<input type="text" name="member4Firstname" placeholder="Firstname"/>
<input type="text" name="member4Lastname" placeholder="Lastname"/>
<input type="text" name="member4MonthOfBirth" placeholder="MOB"/>
</li>
<li>
<label> Player5 </label>
<input type="text" name="member5Firstname" placeholder="Firstname"/>
<input type="text" name="member5Lastname" placeholder="Lastname"/>
<input type="text" name="member5MonthOfBirth" placeholder="MOB"/>
</li>
</ul>
<!-- <input type="hidden" name="request_type" value="AddTeam"/> -->
<input type="submit" name="action" value="AddTeam"/>
<!-- <input type="hidden" name="request_type" value="ShowTeams"/> -->
<input type="submit" name="action" value="ShowTeams" />
</form>
</body>
</html>