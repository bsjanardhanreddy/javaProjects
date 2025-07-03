<%@ taglib uri="jakarta.servlet.jsp.jstl.core" prefix="c" %>
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
			<c:forEach var="ds" items="${dsList}">
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
