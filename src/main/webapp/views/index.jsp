<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact Information Table</title>
</head>
<body>
	<h2 align="center">Contact Information</h2>
	<form:form method="post" action="/saveContact" modelAttribute="contact">
		<table align="center">
			<tr>
				<td>Contact Name</td>
				<td><form:input path="cname"/></td>
				<form:hidden path="cid"/>
			</tr>
			<tr>
				<td>Contact Email</td>
				<td><form:input path="email"/></td>
			</tr>
			<tr>
				<td>Contact Number</td>
				<td><form:input path="cnum"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Register"></td>
			</tr>
			<tr>
				<td><a href="viewAllContact">View AllContacts</a></td>
			</tr>
		</table>
	</form:form>

	<div align="center">
		<font color='green'>${success}</font> 
		<font color='red'>${failure}</font>
	</div>
</body>
</html>