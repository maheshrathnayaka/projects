<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

<c:url var="addUrl" value="/krams/add" />
<table style="border: 1px solid; width: 500px; text-align:center">
	<thead style="background:#fcf">
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Age</th>
			<th colspan="4"></th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${employees}" var="employee">
		<tr>
			<td><c:out value="${employee.firstName}" /></td>
			<td><c:out value="${employee.lastName}" /></td>
			<td><c:out value="${employee.age}" /></td>
		</tr>
	</c:forEach>
	</tbody>
</table>

<c:if test="${empty employees}">
	There are currently no persons in the list.
</c:if>

</body>
</html>