<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		String msg = (String)request.getAttribute("msg");
		if(msg != null){
			out.print(msg);
		}
	%>

	<form action="insert" method="POST">
		<table>
			<tr>
				<td>Emp Name</td>
				<td><input type="text" name="name"></td>
			</tr>
			
			<tr>
				<td>Emp Email</td>
				<td><input type="email" name="email"></td>
			</tr>
			
			<tr>
				<td>Emp Gender</td>
				<td>
					<input type="radio" name="gender" value="Male">Male
					<input type="radio" name="gender" value="FeMale">FeMale
				</td>
			</tr>
			
			<tr>
				<td>Emp Dept</td>
				<td>
					<select name="dept">
						<option value="">-Select-</option>
						<option value="development">Developement</option>
						<option value="testing">Testing</option>
						<option value="db">Database</option>
						<option value="ops">Operations</option>
					</select>
				</td>
			</tr>
			
			<tr>
				<td>Emp Exp</td>
				<td>
					<select name="exp">
						<option value="">-Select-</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
					</select>
				</td>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="submit" value="Save" /></td>
			</tr>
					
		</table>
	</form>

	<a href="emps.jsp">View Emplopees</a>

</body>
</html>