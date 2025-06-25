<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>Save User</h2>

	<%
		String msg = (String)request.getAttribute("msg");
		if(msg != null){
			out.print(msg);
		}
	%>
	
		<form action="user" method="POST">
			<table>
		
				<tr>
					<td>name:</td>
					<td><input type="text" name="name"></td>
				</tr>
				
				<tr>
					<td>Email:</td>
					<td><input type="email" name="email"></td>
				</tr>
				
				<tr>
					<td>Phno:</td>
					<td><input type="number" name="phno"></td>
				</tr>
				
				<tr>
					<td></td>
					<td><input type="submit" name="save"></td>
				</tr>
		
			</table>
		</form>
	
	<a href="user">view Users</a>

</body>
</html>