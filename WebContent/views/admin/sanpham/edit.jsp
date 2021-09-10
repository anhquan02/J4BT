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
	<form class="col-6 offset-3"
		action="/Assignment_BanThe/admin/sanpham/update?id=${ item.id }"
		method="POST">
		<div class="mt-3">
			<label for="id" class="form-label">Id</label> <input type="text"
				value="${ item.id }" class="form-control" id="id" name="id"
				disabled="disabled" />
		</div>
		<div class="mt-3">
			<label for="tenSanPham" class="form-label">Tên sản phẩm</label> <input
				type="text" value="${ item.tenSanPham }" class="form-control"
				id="tenSanPham" name="tenSanPham" />
		</div>
		<div class="mt-3">
			<label for="danhMuc" class="form-label">Danh Mục</label> <select
				class="form-select" name="danhMucId">
				<c:forEach items="${listDM}" var="dm">
					<option value="${dm.id}" >${dm.tenDanhMuc }</option>
				</c:forEach>
			</select>
		</div>
		<div class="mt-3">
			<label for="seri" class="form-label">Key</label> <input type="text"
				value="${ item.seri }" class="form-control" id="seri" name="seri" />
		</div>
		<div class="mt-3">
			<label for="giaMua" class="form-label">Giá mua</label> <input
				type="text" value="${ item.giaMua }" class="form-control"
				id="giaMua" name="giaMua" />
		</div>
		<div class="mt-3">
			<label for="giaBan" class="form-label">Giá bán</label> <input
				type="text" value="${ item.giaBan }" class="form-control"
				id="giaBan" name="giaBan" />
		</div>
		<div class="mt-3">
			<button type="submit" class="btn btn-primary mb-3">Submit</button>
		</div>
	</form>
</body>
</html>