<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html>
<head>
<title>Show</title>
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
			<li><a href="/list">List</a></li>
		</ul>
	</div>
	<div class="col-md-10 col-md-offset-1">
		<c:if test="${updated != null}">
			<div class="alert alert-success" role="alert">
				<strong>Success!</strong> ${updated }
			</div>
		</c:if>
	</div>
	<div id="form" class="col-md-10">
		<form class="form-horizontal" method="GET">
			<fieldset>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="name">Name</label>
					<div class="col-md-4">${candidateInstance.getName() }</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="surname">Surname</label>
					<div class="col-md-4">${candidateInstance.getSurname() }</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="email">Email</label>
					<div class="col-md-4">${candidateInstance.getEmail() }</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="age">Age</label>
					<div class="col-md-4">${candidateInstance.getAge() }</div>
				</div>

				<!-- Button (Double) -->
				<div class="form-group">
					<div class="col-md-8 col-md-offset-4">
						<a class="btn btn-success"
							href="/edit/${candidateInstance.getId() }">Edit</a> <a
							class="btn btn-danger"
							href="/remove/${candidateInstance.getId() }">Delete</a>
					</div>
				</div>

			</fieldset>
		</form>
	</div>
</body>
</html>