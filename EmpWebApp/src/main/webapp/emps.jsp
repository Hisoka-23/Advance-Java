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

	<a href="index.jsp">Add New Emp</a>

	<form action="select" method="POST">
		<table>
			
			<tr>
				<td>Emp Gender</td>
				<td>
					<select name="gender">
						<option value="">-Select-</option>
						<option value="Male">Male</option>
						<option value="Female">FeMale</option>
					</select>
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
				<td><input type="submit" value="Search" /></td>
			</tr>
					
		</table>
	</form>
	
	<hr/>

	<table border="1">
		<thead>
			<tr>
				<th>S.No</th>
				<th>Name</th>
				<th>Dept</th>
				<th>Gender</th>
				<th>Exp</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${emps}" var="emp" varStatus="index">
				<tr>
					<td>${index.count}</td>
					<td>${emp.empName}</td>
					<td>${emp.empDept}</td>
					<td>${emp.empGender}</td>
					<td>${emp.empExp}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


</body>
</html>