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
	<jsp:include page="../navbar.jsp" />
	<form class="col-6 offset-3"
		action="/Assignment_BanThe/admin/danhmuc/update?id=${ danhmuc.id }"
		method="POST">
		<div class="mt-3">
			<label for="id" class="form-label">Id</label> <input type="text"
				value="${ danhmuc.id }" class="form-control" id="id"
				name="id" disabled="disabled"/>
		</div>
		<div class="mt-3">
			<label for="tenDanhMuc" class="form-label">Tên danh mục</label> <input
				type="text" value="${ danhmuc.tenDanhMuc }" class="form-control" id="tenDanhMuc"
				name="tenDanhMuc" />
		</div>
		<div class="mt-3">
			<button type="submit" class="btn btn-primary mb-3">Submit</button>
		</div>
	</form>
</body>
</html>