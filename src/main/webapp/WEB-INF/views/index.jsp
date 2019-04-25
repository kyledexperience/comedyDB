<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/litera/bootstrap.min.css" />
<link rel="stylesheet" href="style.css" />
</head>
<body>
	<div class="container">

		<h1 class="display-1">Comedy Greats</h1>

		<table class="table">
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>State</th>
			</tr>


			<c:forEach var="p" items="${list}">
				<tr>
					<td>${p.firstName}</td>
					<td>${p.lastName}</td>
					<td>
						<!-- State -->
					</td>
				</tr>
			</c:forEach>




		</table>

	</div>
</body>
</html>