<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="<c:url value="/resources/css/validation.css" />" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>
<script src="<c:url value="/resources/js/updateEmpValidation.js" />"></script> 
<title></title>
</head>
<body>
	<div align="center">
		<h1>Edit Employee Form</h1>
		<form action="updateEmployee" method="post" id="updateform">
			<table style="width: 50%">
				<tr>
					<td><label for="id">Id</label></td>
					<td><input type="number" id="id" name="id" value="${employee.id}" readonly="readonly"/></td>
				</tr>
				<tr>
					<td><label for="ename">Name</label></td>
					<td><input type="text" id="name" name="name" value="${employee.name}" placeholder="Enter Employee Name"/></td>
				</tr>
				<tr>
					<td><label for="designation">Designation</label></td>
					<td><input type="text" id="designation" name="designation" placeholder="Enter designation" value="${employee.designation}"/></td>
				</tr>
				<tr>
					<td><label for="department">Department</label></td>
					<td><select name="department" id="department" >
							<option value="IT" ${employee.department == "IT" ? "selected" : ""}>IT</option>
							<option value="finance" ${employee.department == "finance" ? "selected" : ""}>Finance</option>
							<option value="hr" ${employee.department == "hr" ? "selected" : ""}>HR</option>
							<option value="sales" ${employee.department == "sales" ? "selected" : ""}>Sales</option>
							<option value="operations" ${employee.department == "operations" ? "selected" : ""}>Operations</option>
						</select></td>
				</tr>
				<tr>
					<td><label for="totalexp">Total Experience</label></td>
					<td><input type="number" id="totalExperience" name="totalExperience" placeholder="Total Experience (Numeric)" value="${employee.totalExperience}" /></td>
				</tr>
				<tr>
					<td><label for="salary">Salary</label></td>
					<td><input type="number" id="salary" name="salary" placeholder="Salary" value="${employee.salary}"/></td>
				</tr>
			</table>
			<button type="submit" value="submit">Submit</button>
		</form>
	</div>
</body>
</html>