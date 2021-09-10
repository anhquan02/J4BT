<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
</head>
<body>

	<jsp:include page="../navbar.jsp" />
	<div class="col-8 offset-2">
		<div class="mt-5 row">
			<div class="col-6">
				<form action="/Assignment_BanThe/admin/danhmuc/store" method="post">
					<input class="" name = "tenDanhMuc">
					<button class="btn btn-success">Thêm mới</button>
				</form>
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
						<td>Tên danh mục</td>
						<td colspan="2">Action</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ list }" var="item">
						<tr>
							<td>${ item.id }</td>
							<td>${ item.tenDanhMuc }</td>
							<td>
							<td><a
								href="/Assignment_BanThe/admin/danhmuc/edit?id=${ item.id }"
								class="btn btn-primary">Update</a></td>
							<td><a
								href="/Assignment_BanThe/admin/danhmuc/delete?id=${ item.id }"
								class="btn btn-danger">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>