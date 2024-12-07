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

<title>Collapsible sidebar using Bootstrap 4</title>

<!-- Bootstrap CSS CDN -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
	integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4"
	crossorigin="anonymous">
<!-- Our Custom CSS -->
<link rel="stylesheet" href="../static/css/employeeSideBar.css" />

<!-- Font Awesome JS -->
<script defer
	src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js"
	integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ"
	crossorigin="anonymous"></script>
<script defer
	src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js"
	integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY"
	crossorigin="anonymous"></script>
<style type="text/css">
.form-inline {
	display: flex;
	flex-flow: row wrap;
	align-items: center;
}

.form-inline label {
	margin: 5px 10px 5px 0;
}

.form-inline input {
	vertical-align: middle;
	margin: 5px 10px 5px 0;
	padding: 10px;
	background-color: #fff;
	border: 1px solid #ddd;
}

.form-inline button {
	padding: 10px 20px;
	background-color: dodgerblue;
	border: 1px solid #ddd;
	color: white;
	cursor: pointer;
}

.form-inline button:hover {
	background-color: royalblue;
}

@media ( max-width : 800px) {
	.form-inline input {
		margin: 10px 0;
	}
	.form-inline {
		flex-direction: column;
		align-items: stretch;
	}
}
</style>
</head>

<body>
	<div class="wrapper">
		<!-- Sidebar  -->
		<jsp:include page="employee-side-bar.jsp" />
		<!-- Page Content  -->
		<div id="content">

			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<div class="container-fluid">
					<div>
						<h2>Online Loan Management System</h2>
					</div>

					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="nav navbar-nav ml-auto">
							<li class="nav-item"><form:form method="get"
									action="/employee-login/logout">
									<input type="submit" value="Logout (<c:out value="${sessionScope.EMPLOYEE_LOGIN.firstName}"/>)" />
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
								<h3 class="mb-4 pb-2 pb-md-0 mb-md-5 px-md-2">Create Loan
									Offer</h3>

								<form:form class="px-md-2" id="register-form"
									action="/loan-offers/submit" method="post"
									commandName="loanOffers" modelAttribute="loanOffers">

									<div class="form-outline mb-4">
										<form:input type="text" tabindex="1" class="form-control"
											path="loanName" placeholder="Loan Name" required="required" />
									</div>

									<div class="form-outline mb-4">
										<form:input type="number" tabindex="1" class="form-control"
											path="loanRange" placeholder="amount" required="required" />
									</div>

									<div class="form-outline mb-4">
										<form:input type="number" tabindex="1" class="form-control"
											path="interest" placeholder="Interest" required="required" />
									</div>

									<div class="form-outline mb-4">
										<form:select class="form-control" path="loanTypeId"
											items="${loanTypes}" />
									</div>

									<div class="form-outline mb-4">
										<form:input type="Date" tabindex="1" class="form-control"
											path="startingDate" placeholder="Starting Date" />
									</div>
									<div class="form-outline mb-4">
										<form:input type="Date" tabindex="1" class="form-control"
											path="endingDate" placeholder="Ending Date" />
									</div>

									<div class="form-group">
										<button type="submit" class="btn btn-success btn-lg btn-block">Save</button>
									</div>
									<div class="alert-success">${saveMessage}</div>
								</form:form>
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
