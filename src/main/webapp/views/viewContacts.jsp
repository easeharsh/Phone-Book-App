<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Contacts</title>
</head>

<script>
function deleteConfirm()
{
	return confirm("Are you Sure want to delete :")
}
</script>
<body>
	<h2 align="center">View Contact Form</h2>
	<div align="center">
		<a href="/">Add New Contact</a>
	</div>
	<br>
	<br>
	
	
	<table border="1" align="center">
	
		<tr>
			<th>Contact Name</th>
			<th>Contact Email</th>
			<th>Contact Number</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${contact}" var="mycontact">
		
			<tr>
				<td>${mycontact.cname}</td>
				<td>${mycontact.email}</td>
				<td>${mycontact.cnum}</td>
				<td>
					<a href="editContact?cid=${mycontact.cid}">Edit</a>
					<a href="deleteContact?cid=${mycontact.cid}" onclick="return deleteConfirm()">Delete</a>
				</td>
			</tr>
			</c:forEach>
	</table>
	
	<div align="center">
	<br/>
		<font color='green'>${delsuccess}</font> 
	</div>

</body>
</html>