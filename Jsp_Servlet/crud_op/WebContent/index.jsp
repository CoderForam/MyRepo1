<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Company Details</title>
</head>
<body>
	<h3>Company Details</h3>
	<form action="CompanyDetailsSave" method="post">
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="Name" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="email" name="Email" /></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><input type="text" name="Address" />
				<td>
			</tr>
			<tr>
				<td>City:</td>
				<td><input type="text" name="City" /></td>
			</tr>
			<tr>
				<td>Date of Birth:-</td>
				<td><input type="date" name="Date_of_Birth"
					placeholder="Enter Date of Birth" />
					<%-- <c:if test="${not empty dob}">
						<spring:message code="${dob}"></spring:message>
					</c:if> --%>
				</td>
			</tr>
			<tr>
				<td>Language:-</td>
				<td><input type="checkbox" name="Language" value="English"/>English</td>
				<td><input type="checkbox" name="Language" value="Gujarati"/>Gujarati</td>
				<td><input type="checkbox" name="Language" value="Hindi"/>Hindi</td>
			</tr>
			<tr>
				<td>Gender:-</td>
				<td><input type="radio" name="Gender" value="Female"/>Female</td>
				<td><input type="radio" name="Gender" value="Male"/>Male</td>
			</tr>
			<tr>
				<td>Blood Group:-</td>
				<td><select name="Blood_Group">
						<option value=""></option>
						<option value="AB+">AB+</option>
						<option value="A+">A+</option>
						<option value="B+" >B+</option>
						<option value="B-">B-</option>
						<option value="AB-">AB-</option>
						<option value="O+">O+</option>
				</select></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="submit" /></td>
			</tr>
		</table>

	</form>
	
	<a href="ViewServlet">View Company Details</a>  
	
</body>
</html>