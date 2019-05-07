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

	<img src="cellar.jpg" class="background">

	<div class="container">

		<div class="inner">

			<div class="wordart">
				<span class="text">Comedy Greats</span>
			</div>

			<table style="width: 75%; float: left;" class="table  table-hover">
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th></th>

				</tr>

				<c:forEach var="p" items="${list}">
					<tr>
						<td><a href="edit/${p.id}">${p.firstName}</a></td>
						<td>${p.lastName}</td>
						<td><a href="delete/${p.id}">Delete</a></td>
					</tr>
				</c:forEach>

			</table>

			<!-- Table alongside names showing States (RightTable join) -->
			<table style="width: 25%;" class="table">
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


		<h2 class="display-4">Add to the list</h2>
		<form method="post">
			<p>
				<input name="first" type="text" placeholder="First Name" /> <input
					name="last" type="text" placeholder="Last Name" /> <input
					name="state" type="number" value="1" />
			</p>
			<button class="btn btn-light" type="submit">Add</button>

		</form>

		<p class="display-5" id="bottom">
			<br>experienceD
		</p>

	</div>
</body>
</html>