<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/litera/bootstrap.min.css" />
<link rel="stylesheet" href="/style.css" />
</head>
<body>

	<div class="container" id="state">

		<table class="table table-dark">

			<tr>
				<th>No.</th>
				<th>State</th>
			</tr>

			<c:forEach var="s" items="${state}">
				<tr>
					<td>${s.stateId}</td>
					<td>${s.state}</td>
				</tr>
			</c:forEach>

		</table>

	</div>

	<div id="form" class="container">
		<h3 class="display-5">Change Home State</h3>
		<form method="post">
			<span> <input type="hidden" name="id" value="${user.id}" />
				${user.firstName}&nbsp;${user.lastName}&nbsp; 
				<input type="number"
				name="stateId" value="${user.stateId}" />
			</span>

			<button class="btn btn-warning" type="submit">Update</button>
		</form>
		
		<a href="/" id="form">Back</a>

	</div>

</body>
</html>