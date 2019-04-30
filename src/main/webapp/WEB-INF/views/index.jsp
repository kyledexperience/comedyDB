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

		<div>
			<table style="width:75%; float: left;" class="table">
				<tr>
					<th>First Name</th>
					<th>Last Name</th>

				</tr>


				<c:forEach var="p" items="${list}">
					<tr>
						<td>${p.firstName}</td>
						<td>${p.lastName}</td>
					</tr>
				</c:forEach>

			</table>

			<!-- Table alongside names showing States (RightTable join) -->
			<table style="width:25%;" class="table">
				<tr>
					<th>State</th>
				</tr>
				<c:forEach var="s" items="${state}">
					<tr>
						<td>${s.state}</td>
					</tr>
				</c:forEach>
			</table>
		</div>

		<form method="post">
			<p>
				<input name="first" placeholder="First Name" /><input name="last"
					placeholder="Last Name" /><input type="number" name="state"
					value="1" />
			</p>
			<button type="submit">Add</button>

		</form>

	</div>
</body>
</html>