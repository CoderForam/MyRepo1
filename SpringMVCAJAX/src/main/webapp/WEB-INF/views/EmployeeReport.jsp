<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Report</title>
</head>
<body>
<div align="left">
	
	<a href="addEmployee"> Add Employee </a>
</div>

<div align="center">
	<table border="10">
		<thead>
			<tr>
				<th scope="col">ID</th>
		 		<th scope="col">Name</th>
				<th scope="col">Department</th>
				<th scope="col">Designation</th>
				<th scope="col">Total Experience</th>
				<th scope="col">Salary</th>
				<th scope="col">Edit</th>
				<th scope="col">Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="emp" items="${employee}">
				<tr>
					<td>${emp.id}</td>
					<td>${emp.name}</td>
					<td>${emp.department}</td>
					<td>${emp.designation}</td>
					<td>${emp.totalExperience}</td>
					<td>${emp.salary}</td>
					<td><a href="editEmployee/${emp.id}">Edit</a></td>
					<td><a href="deleteEmployee/${emp.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>