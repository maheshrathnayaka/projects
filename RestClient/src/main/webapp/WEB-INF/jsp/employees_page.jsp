<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Employees</h1>
	<c:if test="${empty employees}">
	There are currently no employees in the list
</c:if>
	<c:if test="${employees}">
		<c:url var="addUrl" value="/add_employee" />
		<table border="1">
			<tr
				style="font-family: 'Vollkorn', serif; font-weight: bold; font-size: 1.5em; color: #305050">
				<td width="100">EID</td>
				<td width="150">First Name</td>
				<td width="150">Last Name</td>
				<td width="150">Age</td>
				<td width="150">City</td>
				<td width="150">Salary</td>
				<td width="50">Edit</td>
				<td width="50">Delete</td>
			</tr>
			<c:forEach items="${employees}" var="employee">
				<tr>
					<td><c:out value="${employee.eid}" /></td>
					<td id="${employee.eid}title"><c:out
							value="${employee.firstName}" /></td>
					<td id="${employee.eid}year"><c:out
							value="${employee.lastName}" /></td>
					<td id="${employee.eid}year"><c:out value="${employee.age}" /></td>
					<td id="${employee.eid}year"><c:out value="${employee.city}" /></td>
					<td id="${employee.eid}year"><c:out value="${employee.salary}" /></td>
					<td><button class="update" id="${employee.eid}edit">Update</button></td>
					<td><button class="delete" id="${employee.eid}delete">Delete</button></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>