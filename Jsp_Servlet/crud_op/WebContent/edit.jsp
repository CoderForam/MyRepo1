<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Company Details</title>
</head>
<body>
	<h3>Update Company Details</h3>
	<form action="EditServlet2" method="post">
		<table>
			<tr>
				<td hidden="">Id:</td>
				<td><input type="text" name="id" value="${e.getId()}" /></td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="Name" value="${e.getName()}"/></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="email" name="Email" value="${e.getEmail()}"/></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><input type="text" name="Address" value="${e.getAddress()}"/>
				<td>
			</tr>
			<tr>
				<td>City:</td>
				<td><input type="text" name="City" value="${e.getCity()}"/></td>
			</tr>
			<tr>
				<td>Date of Birth:-</td>
				<td><input type="date" name="Date_of_Birth"
					placeholder="Enter Date of Birth" value="${e.getDate_of_Birth()}"/>
				</td>
			</tr>
			<tr>
				<td>Language:-</td>
				<td>
					<input type="checkbox" name="Language" value="English" ${not empty langMap.get('English') ? "checked" : ""}/>English
				</td>
				<td>
					<input type="checkbox" name="Language" value="Gujarati" ${not empty langMap.get('Gujarati') ? "checked" : ""}/>Gujarati
				</td>
				<td>
					<input type="checkbox" name="Language" value="Hindi" ${not empty langMap.get('Hindi') ? "checked" : ""}/>Hindi
				</td>
			</tr>
			<tr>
				<td>Gender:-</td>
				
				<td><input type="radio" name="Gender" value="Female" ${e.getGender() == "Female" ? "checked" : ""}/>Female</td>
				<td><input type="radio" name="Gender" value="Male" ${e.getGender() == "Male" ? "checked" : ""}/>Male</td>
			</tr>
			<tr>
				<td>Blood Group:-</td>
				<td><select name="Blood_Group">
						<option value=""></option>
						<option value="AB+" ${e.getBlood_Group() == "AB+" ? "selected" : ""}>AB+</option>
						<option value="A+" ${e.getBlood_Group() == "A+" ? "selected" : ""}>A+</option>
						<option value="B+" ${e.getBlood_Group() == "B+" ? "selected" : ""}>B+</option>
						<option value="B-" ${e.getBlood_Group() == "B-" ? "selected" : ""}>B-</option>
						<option value="AB-" ${e.getBlood_Group() == "AB-" ? "selected" : ""}>AB-</option>
						<option value="O+" ${e.getBlood_Group() == "O+" ? "selected" : ""}>O+</option>
				</select></td>
			</tr>
			
			<tr>
				<td colspan='2'><input type="submit" value="Update" /></td>
			</tr>
		</table>

	</form>
	
	<a href="ViewServlet">View Company Details</a>  
	
</body>
</html>