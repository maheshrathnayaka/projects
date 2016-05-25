<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
ewhgeg hwedhje
<table  border="1">
  <tr style=" font-family: 'Vollkorn', serif;
  font-weight: bold;
  font-size: 1.5em;color:#305050">
		<td width="100">Id</td>
		<td width="150">Movie</td>
		<td width="150">Year</td>
		<td width="100">Edit</td>
		<td width="100">Delete</td>
		
		
	</tr>
	<c:forEach items="${person}" var="m">
		<tr>
			<td><c:out value="${m.id}" /></td>
			<td id="${m.id}title"><c:out value="${m.name}" /></td>
			<td id="${m.id}year"><c:out value="${m.name}" /></td>
			<td><button class="update" id="${m.id}edit" >Update</button></td>
			<td><button class="delete" id="${m.id}delete" >Delete</button></td>
		</tr>
	</c:forEach>
</table>

</body>
</html>