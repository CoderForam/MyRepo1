<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/css/validation.css" />" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>
<script src="<c:url value="/resources/js/addEmpValidation.js" />"></script>
<meta charset="ISO-8859-1">
<title>Employee Registration</title>
</head>
<body>
	${successMsg}
	<div align="center">
		<h1>Employee Registration Form</h1>
		<form action="insertEmployee" method="post" id="addform">
			<table style="width: 50%">
				<tr>
					<td><label for="ename">Name</label></td>
					<td><input type="text" id="name" name="name" placeholder="Enter Employee Name" /></td>
				</tr>
				<tr>
					<td><label for="designation">Designation</label></td>
					<td><input type="text" id="designation" name="designation" placeholder="Enter designation" /></td>
				</tr>
				<tr>
					<td><label for="department">Department</label></td>
					<td><select name="department" id="department">
							<option value="IT" selected>IT</option>
							<option value="finance">Finance</option>
							<option value="hr">HR</option>
							<option value="sales">Sales</option>
							<option value="operations">Operations</option>
						</select></td>
				</tr>
				<tr>
					<td><label for="totalexp">Total Experience</label></td>
					<td><input type="number" id="totalExperience" name="totalExperience" placeholder="Total Experience (Numeric)" /></td>
				</tr>
				<tr>
					<td><label for="salary">Salary</label></td>
					<td><input type="number" id="salary" name="salary" placeholder="Salary"/></td>
				</tr>
			</table>
			<button type="submit" value="submit">Submit</button>
		</form>
		<div>
			<a href="employeeReport"> View Employee Report</a>
		</div>
	</div>
</body>
</html>