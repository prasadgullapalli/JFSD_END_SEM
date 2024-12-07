<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>Customer Dashboard</title>

<!-- Bootstrap CSS CDN -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
	integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4"
	crossorigin="anonymous">
<!-- Our Custom CSS -->
<link rel="stylesheet" href="../static/css/sideBar.css" />

<!-- Font Awesome JS -->
<script defer
	src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js"
	integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ"
	crossorigin="anonymous"></script>
<script defer
	src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js"
	integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY"
	crossorigin="anonymous"></script>
</head>

<body>
	<div class="wrapper">
		<!-- Sidebar  -->
		<jsp:include page="customer-side-bar.jsp" />
		<!-- Page Content  -->
		<div id="content">

			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<div class="container-fluid">
					<div>
						<h2>Online Loan Management System</h2>
					</div>

					<button class="btn btn-dark d-inline-block d-lg-none ml-auto"
						type="button" data-toggle="collapse"
						data-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<i class="fas fa-align-justify"></i>
					</button>

					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="nav navbar-nav ml-auto">
							<li class="nav-item"><form:form method="get"
									action="/customer/logout">
									<input type="submit" value="Logout" />
								</form:form></li>
						</ul>
					</div>
				</div>
			</nav>

			<div class="container">
				<div
					class="row d-flex justify-content-center align-items-center h-100">
					<div class="col-lg-8 col-xl-6">
						<div class="card rounded-3">

							<div class="card-body p-4">
								<h3 class="mb-4 pb-2 pb-md-0 mb-md-5 px-md-2">Profile
									Update</h3>

								<form:form id="register-form"
									action="/customer-dashboard/update" method="post"
									commandName="customer" modelAttribute="customer" role="form">
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
										<button type="submit" class="btn btn-success btn-lg btn-block">Update</button>
									</div>
								</form:form>

								<div class="alert-success">${message}</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- jQuery CDN - Slim version (=without AJAX) -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<!-- Popper.JS -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"
		integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
		crossorigin="anonymous"></script>
	<!-- Bootstrap JS -->
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"
		integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm"
		crossorigin="anonymous"></script>

	<script type="text/javascript">
		$(document).ready(function() {
			$('#sidebarCollapse').on('click', function() {
				$('#sidebar').toggleClass('active');
			});
		});
	</script>
</body>

</html>
