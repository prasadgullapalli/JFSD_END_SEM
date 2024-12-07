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

<title>User Activity</title>

<!-- jQuery CDN - Slim version (=without AJAX) -->

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<link rel="stylesheet" href="../static/css/employeeSideBar.css" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link
	href="https://cdn.jsdelivr.net/npm/select2@4.1.0-beta.1/dist/css/select2.min.css"
	rel="stylesheet" />


<script src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js"></script>
<script defer
	src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js"></script>
<!-- <script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.js"></script> -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script
	src="https://cdn.jsdelivr.net/npm/select2@4.1.0-beta.1/dist/js/select2.min.js"></script>


<style type="text/css">
.table-responsive {
	margin: 30px 0;
}

.table-wrapper {
	background: #fff;
	padding: 20px 25px;
	border-radius: 3px;
	min-width: 1000px;
	box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
}

.table-title {
	padding-bottom: 15px;
	background: #435d7d;
	color: #fff;
	padding: 16px 30px;
	min-width: 100%;
	margin: -20px -25px 10px;
	border-radius: 3px 3px 0 0;
}

.table-title h2 {
	margin: 5px 0 0;
	font-size: 24px;
}

.table-title .btn-group {
	float: right;
}

.table-title .btn {
	color: #fff;
	float: right;
	font-size: 13px;
	border: none;
	min-width: 50px;
	border-radius: 2px;
	border: none;
	outline: none !important;
	margin-left: 10px;
}

.table-title .btn i {
	float: left;
	font-size: 21px;
	margin-right: 5px;
}

.table-title .btn span {
	float: left;
	margin-top: 2px;
}

table.table tr th, table.table tr td {
	border-color: #e9e9e9;
	padding: 12px 15px;
	vertical-align: middle;
}

table.table tr th:first-child {
	width: 60px;
}

table.table tr th:last-child {
	width: 100px;
}

table.table-striped tbody tr:nth-of-type(odd) {
	background-color: #fcfcfc;
}

table.table-striped.table-hover tbody tr:hover {
	background: #f5f5f5;
}

table.table th i {
	font-size: 13px;
	margin: 0 5px;
	cursor: pointer;
}

table.table td:last-child i {
	opacity: 0.9;
	font-size: 22px;
	margin: 0 5px;
}

table.table td {
	width: 20%;
}

table.table td a {
	font-weight: bold;
	color: #566787;
	display: inline-block;
	text-decoration: none;
	outline: none !important;
}

table.table td a:hover {
	color: #2196F3;
}

table.table td a.edit {
	color: #FFC107;
}

table.table td a.delete {
	color: #F44336;
}

table.table td i {
	font-size: 19px;
}

table.table .avatar {
	border-radius: 50%;
	vertical-align: middle;
	margin-right: 10px;
}

.hint-text {
	float: left;
	margin-top: 10px;
	font-size: 13px;
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
									<input type="submit"
										value="Logout (<c:out value="${sessionScope.EMPLOYEE_LOGIN.firstName}" />)" />
								</form:form></li>
						</ul>
					</div>
				</div>
			</nav>
			<div class="container-xl">
				<div class="table-responsive">
					<div class="table-wrapper">
						<div class="table-title">
							<div class="row">
								<div class="col-sm-6">
									<h2>User Activity</h2>
								</div>
							</div>
						</div>
						<!-- started -->
						<!-- Dropdown -->
						<select id='selUser' style='width: 200px;'>
							<option value=''>Select User</option>
							<c:forEach items="${customers}" var="cust">
								<option value='${cust.customerId}'>${cust.firstName}
									${cust.lastName}</option>
							</c:forEach>
						</select> <input type='button' value='Submit' id='but_read'>
						<!-- ended -->
						<div id="userActivities"></div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>

<!-- <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
 -->
<!-- Popper.JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<!-- Bootstrap JS -->
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$('#sidebarCollapse').on('click', function() {
							$('#sidebar').toggleClass('active');
						});

						// Initialize select2
						$("#selUser").select2();

						// Read selected option
						$('#but_read')
								.click(
										function() {
											var username = $(
													'#selUser option:selected')
													.text();
											var userid = $('#selUser').val();

											$
													.ajax({
														url : '/user-activity/activities',
														type : 'POST',
														contentType : 'application/json',
														data : JSON
																.stringify(userid),
														error : function() {
														},
														success : function(
																response) {
															console
																	.log(response.activities);
															$("#userActivities")
																	.html("");

															var html = '<div class="container-xl"><div class="table-responsive"><div class="table-wrapper"><table class="table table-striped table-hover"><thead><tr><th>Activity Type</th><th>Time</th></tr></thead><tbody>';
															$
																	.each(
																			response.activities,
																			function(
																					i,
																					item) {
																				html = html
																						+ '<tr><td>'
																						+ item.activityType
																						+ '</td><td>'
																						+ item.displayActivityTime
																						+ '</td></tr>';
																			});

															html = html
																	+ '</tbody></table></div></div></div>';
															console.log(html);
															$("#userActivities")
																	.html(html);
														}
													});

											$('#result').html(
													"id : " + userid
															+ ", name : "
															+ username);

										});
					});

	function editLoanOffer(loanId) {

		$.ajax({
			url : '/loan-offers/get-loan-offer',
			type : 'POST',
			contentType : 'application/json',
			data : JSON.stringify(loanId),
			error : function() {
			},
			success : function(response) {
				$("#loanName").val(response.loanOffer.loanName);
				$("#loanAmount").val(response.loanOffer.loanRange);
				$("#startingDate").val(response.loanOffer.startingDate);
				$("#endingDate").val(response.loanOffer.endingDate);
				$("#interest").val(response.loanOffer.interest);
				$("#loanOfferId").val(response.loanOffer.offerId);
				$('#modalLoginForm').modal('show');
			}
		});
	}

	function updateLoanOffer() {

		$.ajax({
			url : '/loan-offers/update-loan-offer',
			type : 'POST',
			contentType : 'application/json',
			data : JSON.stringify({
				loanName : $("#loanName").val(),
				loanRange : $("#loanAmount").val(),
				interest : $("#interest").val(),
				offerId : $("#loanOfferId").val(),
				startingDate : $("#startingDate").val(),
				endingDate : $("#endingDate").val(),
			}),
			error : function() {
			},
			success : function(response) {

				location.href = "/loan-offers/display";
			}
		});
	}

	function deleteLoanOffer(loanId) {
		console.log(loanId);

		$.ajax({
			url : '/loan-offers/delete-loan-offer',
			type : 'POST',
			contentType : 'application/json',
			data : JSON.stringify(loanId),
			error : function() {
			},
			success : function(response) {
				console.log(response.deleteMessage);
				location.href = "/loan-offers/display";
			}
		});
	}
</script>
</body>

</html>
