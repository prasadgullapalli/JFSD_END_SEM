<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Admin Login</title>
<meta name="description" content="A demo of a card payment on Stripe" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="../static/js/customer.js"></script>
<link rel="stylesheet" href="../static/css/global.css" />
<link rel="stylesheet" href="../static/css/customer.css" />
<script
	src="https://polyfill.io/v3/polyfill.min.js?version=3.52.1&features=fetch"></script>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-login">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-6">
								<a href="#" class="active" id="login-form-link">Employee
									Login</a>
							</div>
						</div>
						<hr>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<form:form method="post" action="/employee-login/submit"
									commandName="employeeLogin" modelAttribute="employeeLogin"
									style="display: block;">
									<div class="form-group">
										<b>Branch:</b>
										<form:select path="branchId" items="${branches}" />
									</div>
									<div class="form-group">
										<form:input type="text" path="emailId" tabindex="1"
											class="form-control" placeholder="Employee Id" value="" />
									</div>
									<div class="form-group">
										<form:input type="password" path="password" tabindex="2"
											class="form-control" placeholder="Password" />
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" value="Log In" tabindex="4"
													class="form-control btn btn-login" />
											</div>
											<div class="col-sm-6 col-sm-offset-3">
												<br /> <a class="form-control btn btn-login" href="/"
													role="button">Home</a>
											</div>
										</div>
									</div>
									<div class="alert-danger">
										<b>${invalidAdminLogin}</b>
									</div>
								</form:form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>