<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav id="sidebar">
	<div class="sidebar-header">
		<h3 style="font-size: 22px;">OLMS - Customer</h3>
	</div>

	<ul class="list-unstyled components">
		<p style="color: white; font-size: 15px; font-weight: bold;">
			<b><c:out
					value="${sessionScope.CUSTOMER_LOGIN.firstName} - ${sessionScope.CUSTOMER_LOGIN.lastName}" /></b>
		</p>
		<li><a href="/loan-request/save">Apply loan</a></li>
		<li><a href="/loan-request/by-customer-id">Loans</a></li>
		<li><a href="/customer-dashboard/profile">Settings</a></li>
		<li><a href="/user-activity/cust-activity">My Activity</a></li>
		<li><a href="/emi-calculator">Calculate EMI</a></li>
		<li><a href="/loans/status-graph">Graphical Representation</a></li>
		
		
		
		<!-- <li class="active"><a href="#homeSubmenu" data-toggle="collapse"
			aria-expanded="false" class="dropdown-toggle">Loan Offers</a>
			<ul class="collapse list-unstyled" id="homeSubmenu">
				<li><a href="/loan-request/save">Apply loan</a></li>
				<li><a href="/loan-offers/display">Check Loan Offers</a></li>
			</ul></li>
		<li><a href="/loan-request/save">Apply loan</a></li>
		<li><a href="/loan-information/loans">Loans</a></li>
		<li><a href="/customer-dashboard/profile">Settings</a></li>
		<li><a href="#pageSubmenu" data-toggle="collapse"
			aria-expanded="false" class="dropdown-toggle">Pages</a>
			<ul class="collapse list-unstyled" id="pageSubmenu">
				<li><a href="#">Page 1</a></li>
				<li><a href="#">Page 2</a></li>
				<li><a href="#">Page 3</a></li>
			</ul></li>
		<li><a href="#">Portfolio</a></li>
		<li><a href="#">Contact</a></li> -->
	</ul>
</nav>