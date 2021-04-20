<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">
<link rel="stylesheet" href="/css/common.css">
</head>
<body>
<body class="p-0 m-0">
	<c:import url="./header.jsp"></c:import>
	<div class="container p-0">
		<div class="text-right mt-5 row">
			<div class="offset-6 col-4">
				<h2>Welcome ${username} !</h2>
			</div>
			<div class="col-2">
				<a class="btn btn-primary px-5" href="/logout">Logout</a>
			</div>

		</div>

		<div class="container mt-3">
			<fieldset class="fieldset-custom px-5">
				<legend class="legend-custom">Employee Listings</legend>



				<div class="row">
					<div class="col-8 p-0">
						<form action="/excel" method="post" enctype="multipart/form-data">
							<div class="custom-file mb-3 w-75">
								<input type="file" name="file" class="custom-file-input"
									required> <label class="custom-file-label">
									Excel Spread Sheet File </label>
							</div>
							<button class="btn btn-primary ml-3 px-5 d-inline" type="submit">Submit</button>
						</form>

					</div>
					<div class="col p-0">
						<a class="btn btn-primary px-5 float-right" href="/excel"
							target="_blank">Download</a>
					</div>



				</div>

				<h3 class="font-weight-bold mt-4 mb-4 font-size-25px">Employees
					Table</h3>
				<div class="row mx-2">
					<table class="table table-hover">
						<thead class="thead-light  table-primary">
							<tr class="row">
								<th class="col">S.No.</th>
								<th class="col">Code</th>
								<th class="col">Name</th>
								<th class="col">Location</th>
								<th class="col">Email</th>
								<th class="col">Date Of Birth</th>
								<th class="col">Action</th>
							</tr>
						</thead>
						<c:forEach items="${employees}" var="employee" varStatus="loop">
							<tr class="row">
								<td class="col">${loop.index + 1}</td>
								<td class="col">${employee.code}</td>
								<td class="col">${employee.name}</td>
								<td class="col">${employee.location}</td>
								<td class="col">${employee.email}</td>
								<td class="col">${employee.dateOfBirth}</td>
								<td class="col"><a href="/employee/${employee.code}">
										Edit </a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</fieldset>
		</div>
	</div>

	<br>
	<br>
	<br>

	<c:import url="./footer.jsp"></c:import>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
		crossorigin="anonymous"></script>

	<script src="/js/home.js"></script>

</body>
</html>