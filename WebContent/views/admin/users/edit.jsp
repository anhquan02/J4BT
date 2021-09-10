<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
</head>
<body>
	 <jsp:include page="../navbar.jsp"/>
	<form class="col-6 offset-3"
		action="/Assignment_BanThe/admin/users/update?id=${ user.id }"
		method="POST">
		<div class="mt-3">
			<label for="name" class="form-label">Name</label> <input type="text"
				value="${ user.username }" class="form-control" id="username"
				name="username" />
		</div>
		<div class="mt-3">
			<label for="email" class="form-label">Email</label> <input
				type="email" value="${ user.email }" class="form-control" id="email"
				name="email" />
		</div>
		<div class="mt-3">
			<label for="password" class="form-label">Password</label> <input
				type="password" value="${ user.password }" class="form-control"
				id="password" name="password" />
		</div>
		<div class="mt-3">
			<label for="email" class="form-label">Fullname</label> <input
				type="text" value="${ user.fullname }" class="form-control"
				id="fullname" name="fullname" />
		</div>
		<div class="mt-3">
			<label for="role" class="form-label">Role</label> <select
				class="form-select" name="admin">
				<option ${ !user.admin ? "selected" : "" } value="false">User</option>
				<option ${ user.admin ? "selected" : "" } value="true">Admin</option>
			</select>
		</div>
		<div class="mt-3">
			<button type="submit" class="btn btn-primary mb-3">Submit</button>
		</div>
	</form>
</body>
</html>