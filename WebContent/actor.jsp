<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div><% String value=(String)request.getAttribute("s"); %>
<%=value %>
</div>
<div>
<h1><p align="center"><big><i>Actor Information Page</i></big></p></h1>
</div>

<div>
<form action = "dbaction" method = "get">
		Actor First Name:	<input name="fname">
		<br><br>Actor Last Name: <input name = "lname"><br><br><br> 
		<input type="submit" value="Search Actor">
		<input type="submit" value="Create Actor">
		<input type="submit" value = "Update Actor">
		<input type="submit" value = "Delete Actor">

		</form></div>
		
<div>
<table style="width: 940px; " align="center" class="results">
<tr>
<td align="Center"><b><big>Actor Id
</big></b><td><p align="center"><b><big>First Name
</big></b></p><td><p align="center"><b><big> Last Name
</big></b></p></td>
</tr><br>
<tbody>
<tr>
<% String sresults= (String)request.getAttribute("search"); %>
<%=sresults %>
</tr>
</tbody>
</table>
</div>

</body>
</html>