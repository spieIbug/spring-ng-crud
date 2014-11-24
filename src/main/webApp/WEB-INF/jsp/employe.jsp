<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employes Management</title>
</head>
<body>
	<center>
		<input type="button" value="switch to Angular"
			onclick="javascript:window.location='./';" />
	</center>
	<h1>Employess Data</h1>
	<form:form action="employe.execute" method="POST" commandName="employe">
		<table width="100%">
			<tr>
				<td>Employe ID</td>
				<td><form:input path="employeId" /></td>
			</tr>
			<tr>
				<td>First name</td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td>Last name</td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td>Experience</td>
				<td><form:input path="experience" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="action" value="Add" />
					<input type="submit" name="action" value="update" /> <input
					type="submit" name="action" value="Delete" /> <input type="submit"
					name="action" value="find" /></td>
			</tr>
		</table>
	</form:form>
	<br>
	<table width="100%">
		<th>ID</th>
		<th>First name</th>
		<th>Last name</th>
		<th>Experience</th>
		<c:forEach items="${employeList}" var="employe">
			<tr>
				<td>${employe.employeId}</td>
				<td>${employe.firstName}</td>
				<td>${employe.lastName}</td>
				<td>${employe.experience}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>