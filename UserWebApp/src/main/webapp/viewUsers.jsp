<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<a href="index.jsp">Add New User</a>

	<table>
	
		<thead>
			<tr>
				<td>S.No</td>
				<td>Name</td>
				<td>Email</td>
				<td>Phno</td>
			</tr>
		</thead>
		
		<tbody>
		
			<c:forEach items="${users}" var="user" varStatus="index">
				<tr>
					<td>${index.count}</td>
					<td>${user.userName}</td>
					<td>${user.userEmail}</td>
					<td>${user.userPhno}</td>
				</tr>
			</c:forEach>
			
		</tbody>
	
	</table>

</body>
</html>