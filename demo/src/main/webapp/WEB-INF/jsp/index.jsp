<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<title></title>
</head>
<body class="container">
	<div style="float: right; margin-bottom: 50px; margin-top: 24px;">
		<button type="button" class="btn btn-primary" data-toggle="modal"
			data-target="#exampleModalCenter">Add Employee</button>
	</div>


	<div class="table-responsive">
		<table id="addEmpTable" class="table table-striped table-bordered"
			style="width: 100%">
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Address</th>
					<th>Mobie No.</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${employees.size() gt 0 }">
						<c:forEach var="emp" items="${employees}">
							<tr>
								<td>${emp.firstName }</td>
								<td>${emp.lastName }</td>
								<td>${emp.address }</td>
								<td>${emp.mobileNo }</td>
								<td>
									<button type="button" class="btn btn-primary editBtn"
										empID="${emp.id}">
										<i class="fa fa-pencil"></i>
									</button>
									<button type="button" class="btn btn-danger delBtn"
										empID="${emp.id}">
										<i class="fa fa-trash"></i>
									</button>
								</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>

					</c:otherwise>
				</c:choose>

			</tbody>
		</table>
	</div>


	<div class="modal fade" id="exampleModalCenter" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form method="post" id="empForm">
						<div class="form-group">
							<label for="firstName">First Name</label> <input type="text"
								class="form-control" id="firstName" name="firstName"
								required="required" placeholder="First Name">
						</div>
						<div class="form-group">
							<label for="lastName">Last Name</label> <input type="text"
								class="form-control" id="lastName" name="lastName"
								required="required" placeholder="Enter email">
						</div>
						<div class="form-group">
							<label for="address">Address</label>
							<textarea type="email" class="form-control" id="address"
								name="address" required="required" placeholder="Enter Address">
								
							</textarea>
						</div>
						<div class="form-group">
							<label for="mobileNo">Mobile</label> <input type="text"
								class="form-control" required="required" name="mobileNo"
								id="mobileNo" placeholder="Enter Mobile">
						</div>

						<button type="submit" class="btn btn-primary">Submit</button>
					</form>
				</div>
			</div>
		</div>
	</div>


	<div class="modal fade" id="updateModel" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form method="post" id="empUpdateForm">
						<div class="form-group">
							<label for="updatefirstName">First Name</label> <input
								type="text" class="form-control" id="updatefirstName"
								name="updatefirstName" required="required"
								placeholder="First Name">
						</div>
						<div class="form-group">
							<label for="updatelastName">Last Name</label> <input type="text"
								class="form-control" id="updatelastName" name="updatelastName"
								required="required" placeholder="Enter email">
						</div>
						<div class="form-group">
							<label for="updateaddress">Address</label>
							<textarea type="email" class="form-control" id="updateaddress"
								name="updateaddress" required="required"
								placeholder="Enter Address">
								
							</textarea>
						</div>
						<div class="form-group">
							<label for="updatemobileNo">Mobile</label> <input type="text"
								class="form-control" required="required" name="updatemobileNo"
								id="updatemobileNo" placeholder="Enter Mobile">
						</div>
						<input type="text" disabled="disabled" hidden="" name="empId" id="empId" required="required">

						<button type="submit" class="btn btn-primary">Submit</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
	<script type="text/javascript" charset="utf8"
		src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.js"></script>
	<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

	<script src="../../api.js"></script>
</body>
</html>