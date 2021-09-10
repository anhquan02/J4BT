<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
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
<jsp:include page="../navbar.jsp" />
	<div class="col-8 offset-2">
		<div class="mt-5 row">
			<div class="col-6">
			</div>
			<div class="col-4"></div>
			<div class="col-2 d-flex justify-content-end">
				<select class="form-select">
					<option value="10" selected>10</option>
					<option value="10">20</option>
					<option value="10">50</option>
					<option value="10">100</option>
				</select>
			</div>
		</div>
		<div class="mt-5 table-responsive">
			<table class="table table-striped">
				<thead>
					<tr>
						<td>Id</td>
						<td>Username</td>
						<td>Email</td>
						<td>Fullname</td>					
						<td>Role</td>
						<td colspan="2">Action</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ listUser }" var="user">
						<tr>
							<td>${ user.id }</td>
							<td>${ user.username }</td>
							<td>${ user.email }</td>
							<td>${ user.fullname }</td>
							<td>${ !user.admin ? "User" : "Admin" }</td>
							<td><a href="/Assignment_BanThe/admin/users/edit?id=${ user.id }"
								class="btn btn-primary">Update</a></td>
							<td><a href="/Assignment_BanThe/admin/users/delete?id=${ user.id }"
								class="btn btn-danger">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>