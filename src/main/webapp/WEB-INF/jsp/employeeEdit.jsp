<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Employee Edit</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">
<link rel="stylesheet" href="/css/common.css">

</head>
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

		<div class="container-fluid mt-3">
		<fieldset class="fieldset-custom">
  		<legend class="legend-custom">Edit Employee</legend>

			<form:form id="form" action="/employee" method="post" modelAttribute="employee">
				<div class="row form-group">
					<div class="offset-2 col-2 ">
						<label>Code <span class="red-star">*</span> :
						</label>
					</div>
					<div class="col-5">
						<input class="form-control" type="text" name="code"
							value="${employee.code}" readonly>
					</div>
				</div>
				<div class="row form-group">
					<div class="offset-2 col-2 ">
						<label>Name <span class="red-star">*</span> :
						</label>
					</div>
					<div class="col-5">
						<input class="form-control" type="text" id="name" name="name" value="${employee.name}">
						<div id="nameError" class="invalid-feedback"></div>
					</div>
				</div>
				<div class="row form-group">
					<div class="offset-2 col-2 ">
						<label>Location <span class="red-star">*</span> :
						</label>
					</div>
					<div class="col-5">
						<textarea  class="form-control" id="location" name="location" rows="4" cols="10">${employee.location}</textarea>
						<div id="locationError" class="invalid-feedback"></div>
					</div>
				</div>
				<div class="row form-group">
					<div class="offset-2 col-2 ">
						<label>Email <span class="red-star">*</span> :
						</label>
					</div>
					<div class="col-5">
						<input class="form-control" type="email" id="email" name="email" value="${employee.email}">
						<div id="emailError" class="invalid-feedback"></div>
					</div>
				</div>
				<div class="row form-group">
					<div class="offset-2 col-2 ">
						<label>Date Of Birth <span class="red-star">*</span> :
						</label>
					</div>
					<div class="col-5">
						<input class="form-control" type="date" id="date" name="dateOfBirth" value="${employee.dateOfBirth}">
						<div id="dateError" class="invalid-feedback"></div>
					</div>
				</div>
				<div class="row form-group pt-3">
					<div class="offset-2 col-2 ">
						<button class="btn btn-primary px-5" type="submit">Submit</button>
					</div>
				</div>

				<br>
				
			</form:form>

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

	<script src="/js/employeeEdit.js"></script>

</body>
</html>