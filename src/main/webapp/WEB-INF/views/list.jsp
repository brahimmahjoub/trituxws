<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<title>List</title>
<script type="text/javascript"
	src="../../assets/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="../../assets/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div id="navbar">
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#"> Tritux </a>
				</div>
			</div>
		</nav>
	</div>
	<div id="navbar">
		<ul class="nav nav-pills">
			<li><a href="/create">Create</a></li>
			<li class="active"><a href="#">List</a></li>
		</ul>
	</div>
	<div class="col-md-10 col-md-offset-1">
		<c:if test="${created != null}">
		<div class="alert alert-success" role="alert">
			<strong>Success!</strong> ${created }
		</div>
		</c:if>
		<c:if test="${removed != null}">
		<div class="alert alert-info" role="alert">
			<strong>Info!</strong> ${removed }
		</div>
		</c:if>
		<c:if test="${error != null}">
		<div class="alert alert-danger" role="alert">
			<strong>Error!</strong> ${error }
		</div>
		</c:if>
		<table class="table table-striped">
			<thead>
				<th>Name</th>
				<th>Surname</th>
				<th>email</th>
				<th>age</th>
			</thead>
			<tbody>
				<c:forEach items="${candidatesList}" var="candidateInstance">
					<tr>
						<td><a href="/show/${candidateInstance.getId()}">${candidateInstance.getName()}</a></td>
						<td>${candidateInstance.getSurname()}</td>
						<td>${candidateInstance.getEmail()}</td>
						<td>${candidateInstance.getAge()}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>