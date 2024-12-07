<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Customer Login</title>
<meta name="description" content="A demo of a card payment on Stripe" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="../static/js/customer.js"></script>
<link rel="stylesheet" href="../static/css/customer.css" />
<script
	src="https://polyfill.io/v3/polyfill.min.js?version=3.52.1&features=fetch"></script>
</head>
<body>
	<h2 style="text-align: center;">
		<b>Online Loan Management System</b>
	</h2>
	<br />
	<br />
	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-login">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-6">
								<a href="#" class="active" id="login-form-link">Login</a>
							</div>
							<div class="col-xs-6">
								<a href="#" id="register-form-link">Register</a>
							</div>
						</div>
						<hr>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<form:form id="login-form" action="/customer/login"
									method="post" commandName="customerLogin"
									modelAttribute="customerLogin" role="form"
									style="display: block;">
									<div class="form-group">
										<form:input type="text" path="emailId" tabindex="1"
											class="form-control" placeholder="Username" value="" />
									</div>
									<div class="form-group">
										<form:input type="password" path="password" tabindex="2"
											class="form-control" placeholder="Password" />
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="login-submit" id="login-submit"
													tabindex="4" class="form-control btn btn-login"
													value="Log In">

											</div>
											<div class="col-sm-6 col-sm-offset-3">
												<br /> <a class="form-control btn btn-login" href="/"
													role="button">Home</a>
											</div>
										</div>
									</div>
									<div class="alert-danger">${invalidCustomerLogin}</div>
								</form:form>
								<form:form id="register-form" action="/customer/register"
									method="post" commandName="customerLogin"
									modelAttribute="customerLogin" role="form"
									style="display: none;">
									<div class="form-group">
										<form:input type="text" tabindex="1" class="form-control"
											path="firstName" placeholder="First Name" required="required" />
									</div>
									<div class="form-group">
										<form:input type="text" tabindex="1" class="form-control"
											path="lastName" placeholder="Last Name" required="required" />
									</div>
									<div class="form-group">
										<form:input type="email" tabindex="1" class="form-control"
											path="emailId" placeholder="Email" required="required" />
									</div>
									<div class="form-group">
										<form:input type="text" tabindex="1" class="form-control"
											path="mobileNumber" placeholder="Mobile Number"
											required="required" />
									</div>
									<div class="form-group">
										<form:input type="text" tabindex="1" class="form-control"
											path="address" placeholder="Address" required="required" />
									</div>
									<div class="form-group">
										<form:input type="Date" tabindex="1" class="form-control"
											path="dob" placeholder="Date of birth" />
									</div>
									<div class="form-group" tabindex="1">
										<form:radiobutton path="gender" value="M" label="Male"
											class="form-control-radio" />
										<form:radiobutton path="gender" value="F" label="Female"
											class="" />

									</div>
									<div class="form-group">
										<form:input type="password" path="password"
											class="form-control" tabindex="1" placeholder="Password"
											required="required" />
									</div>

									<div class="form-group">
										<form:input type="text" path="ssnNumber" class="form-control"
											tabindex="1" placeholder="Social Number" required="required" />
									</div>

									<div class="form-group">
										<form:input type="text" path="occupation" class="form-control"
											tabindex="1" placeholder="Occupation" required="required" />
									</div>
									<div class="form-group">
										<button type="submit" class="btn btn-success btn-lg btn-block">Register
											Now</button>
									</div>
								</form:form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="alert-success">${successMessage}</div>
</body>
</html>