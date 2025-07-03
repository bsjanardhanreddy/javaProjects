<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Get All DataSources</title>
</head>
<body>
	
	<table border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>DataBase Name</th>
				<th>User Name</th>
				<th>Host Name</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var="ds" items="${dsList}">  <!-- CORRECT -->

				<tr>
					<td>${ds.altKey}</td>
					<td>${ds.dbName}</td>
					<td>${ds.userName}</td>
					<td>${ds.hostName}</td>
				</tr> 
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>
