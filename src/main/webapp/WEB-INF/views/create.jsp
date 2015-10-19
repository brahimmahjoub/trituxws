<!doctype html>
<html>
<head>
<title>Create</title>
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
			<li class="active"><a href="#">Create</a></li>
			<li><a href="/list">List</a></li>
		</ul>
	</div>
	<div id="form">
		<form class="form-horizontal" action="/add" method="POST">
			<fieldset>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="name">Name</label>
					<div class="col-md-4">
						<input id="name" name="name" type="text" placeholder="name"
							class="form-control input-md" required="">

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="surname">Surname</label>
					<div class="col-md-4">
						<input id="surname" name="surname" type="text"
							placeholder="surname" class="form-control input-md" required="">

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="email">Email</label>
					<div class="col-md-4">
						<input id="email" name="email" type="email" placeholder="email"
							class="form-control input-md" required=""> <span
							class="help-block">unique mail</span>
					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="age">Age</label>
					<div class="col-md-4">
						<input id="age" name="age" type="number" placeholder="age"
							class="form-control input-md" required="">

					</div>
				</div>

				<!-- Button -->
				<div class="form-group">
					<div class="col-md-4 col-md-offset-4">
						<button type="submit" id="save" name="save"
							class="btn btn-primary">Add candidate</button>
					</div>
				</div>

			</fieldset>
		</form>
	</div>
</body>
</html>