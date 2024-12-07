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

<title>Manage Offered Loans</title>

<!-- jQuery CDN - Slim version (=without AJAX) -->

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<link rel="stylesheet" href="../static/css/employeeSideBar.css" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">

<script src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js"></script>
<script defer
	src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.js"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


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
									<input type="submit" value="Logout (<c:out value="${sessionScope.EMPLOYEE_LOGIN.firstName}"/>)" />
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
									<h2>Offered Loans</h2>
								</div>
							</div>
						</div>
						<table class="table table-striped table-hover">
							<thead>
								<tr>
									<th>Loan Name</th>
									<th>Amount</th>
									<th>Starting Date</th>
									<th>Ending Date</th>
									<th>Interest</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="offer" items="${offers}">

									<tr>
										<td>${offer.loanName}</td>
										<td>${offer.loanRange}</td>
										<td>${offer.displayStartingDate}</td>
										<td>${offer.displayEndingDate}</td>
										<td>${offer.interest}%</td>
										<td><a onclick="editLoanOffer(${offer.offerId})"
											class="edit" data-toggle="modal"><i
												class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
											<a onclick="deleteLoanOffer(${offer.offerId})" class="delete"
											data-toggle="modal"><i class="material-icons"
												data-toggle="tooltip" title="Delete">&#xE872;</i></a></td>
									</tr>


								</c:forEach>

							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>


	<div class="modal fade" id="modalLoginForm" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header text-center">
					<h4 class="modal-title w-100 font-weight-bold">Update Loan
						Offer</h4>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body mx-3">
					<div class="md-form mb-3">
						<label for="loanName">Loan Name</label> <input type="text"
							id="loanName" name="name" value="" class="form-control">
					</div>
					<div class="md-form mb-3">
						<label for="loanAmount">Loan Amount</label> <input type="number"
							id="loanAmount" name="loanAmount" value="" class="form-control">
					</div>
					<div class="md-form mb-3">
						<label for="interest">Interest</label> <input type="number"
							id="interest" name="interest" value="" class="form-control">
					</div>
					<div class="md-form mb-3">
						<label for="startingDate">Starting Date</label> <input type="Date"
							id="startingDate" name="startingDate" value="" class="form-control">
					</div>
					<div class="md-form mb-3">
						<label for="startingDate">Ending Date</label> <input type="Date"
							id="endingDate" name="endingDate" value="" class="form-control">
					</div>
					<input type="hidden" id="loanOfferId" name="loanOfferId" value="">
				</div>
				<div class="modal-footer d-flex justify-content-right">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button class="btn btn-success" onclick="updateLoanOffer()">Update</button>
				</div>
			</div>
		</div>
	</div>

</body>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<!-- Popper.JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<!-- Bootstrap JS -->
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>

<script type="text/javascript">

	$(document).ready(function() {
		$('#sidebarCollapse').on('click', function() {
			$('#sidebar').toggleClass('active');
		});
	});
	
	function editLoanOffer(loanId){
		
		$.ajax({
	        url: '/loan-offers/get-loan-offer',
	        type: 'POST',
	        contentType: 'application/json',
	        data: JSON.stringify(loanId),
	        error: function () {
	        },
	        success: function (response) {
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
	
	function updateLoanOffer(){
		
		$.ajax({
	        url: '/loan-offers/update-loan-offer',
	        type: 'POST',
	        contentType: 'application/json',
	        data: JSON.stringify({
	        	loanName: $("#loanName").val(),
	        	loanRange: $("#loanAmount").val(),
	        	interest: $("#interest").val(),
	        	offerId: $("#loanOfferId").val(),
	        	startingDate: $("#startingDate").val(),
	        	endingDate: $("#endingDate").val(),
	        }),
	        error: function () {
	        },
	        success: function (response) {
	        	
	        	location.href = "/loan-offers/display";
	        }
	    });
	}
	
	function deleteLoanOffer(loanId){
		console.log(loanId);
	    
		$.ajax({
	        url: '/loan-offers/delete-loan-offer',
	        type: 'POST',
	        contentType: 'application/json',
	        data: JSON.stringify(loanId),
	        error: function () {
	        },
	        success: function (response) {
	        	console.log(response.deleteMessage);
	        	location.href = "/loan-offers/display";
	        }
	    });
	}
</script>
</body>

</html>
