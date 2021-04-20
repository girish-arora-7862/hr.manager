<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<link rel="stylesheet" href="/css/common.css">
</head>
<body class="p-0 m-0">
	<c:import url="./header.jsp"></c:import>
	<br>
	<c:import url="./notification.jsp"></c:import>
	<div class="container p-0">
		<h3 class="font-weight-bold mt-4 font-size-25px">Login</h3>
		<br>
		<form id="form" method="POST" action="/login">
			<div class="row mb-3">		
				<div class="col-3">
					<p class="text-muted">Username <span class="red-star">*</span> :</p>
				</div>
				<div class="col-4">
					 <input class="form-control" type="text" id="username" name="username">
					 <div id="usernameError" class="invalid-feedback"></div>
				</div>
			</div>
			<div class="row mb-3">		
				<div class="col-3">
					<p class="text-muted">Password <span class="red-star">*</span> : </p>
				</div>
				<div class="col-4">
					<input class="form-control" type="password" id="password" name="password">
					<div id="passwordError" class="invalid-feedback"></div>
				</div>
			</div>
			<div >		
				<button class="btn btn-primary mr-5 px-5 float-right" type="submit">Login</button>
			</div>
		</form>
	</div>
	
	<c:import url="./footer.jsp"></c:import>


	
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>

	<script src="/js/login.js"></script>

</body>
</html>