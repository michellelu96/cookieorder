<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<title>Insert title here</title>
</head>
<body>
	<div class="containerBack container mt-5">
		<nav class="navbar navbar-expand-xl navbar-dark bg-dark">
			<div class="container-fluid">
				<a class="navbar-brand" href="#">Cookie Monsters Bakery</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarBasic"
					aria-controls="navbarBasic" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse show" id="navbarBasic">
					<ul class="navbar-nav me-auto mb-2 mb-xl-0">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="/">Home</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Cookies</a>
						</li>
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="/admin/cookie/addCookie">addCookie</a></li>
						<li class="btn btn-link">
						<form:form id="logoutForm" method="POST" action="/logout">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" /> <input type="submit" value="Logout!" />
						</form:form>
						</li>
					</ul>
					<form class="d-flex">
						<input class="form-control me-2" type="search"
							placeholder="Search" aria-label="Search">
						<button class="btn btn-outline-secondary" type="submit">Search</button>
					</form>
				</div>
				<a href="#"><img class="navbarIcons"
					src="https://d29fhpw069ctt2.cloudfront.net/icon/image/38239/preview.svg"
					alt="shopping cart icon"></a>
				<p class="crtCount rounded-circle">+</p>
				<a href="#"><img class="navbarIcons"
					src="https://us.123rf.com/450wm/tuktukdesign/tuktukdesign1608/tuktukdesign160800043/61010830-user-icon-man-profile-businessman-avatar-person-glyph-vector-illustration.jpg?ver=6"
					alt="User Icon"></a>
			</div>
		</nav>
		<div class="d-flex flex-column justify-content-center text-center pt-3">
		<h1 class="text-center">Edit Cookie</h1>
	<form:form action="/admin/cookie/edit/{id}" method="post"
		modelAttribute="product">
		<input type="hidden" name="_method" value="put">
		<p>
			<form:label path="name">Product Name:</form:label>
			<form:input path="name" value="${product.name }"/>
			<form:errors path="name" />
		</p>
		<p>
			<form:label path="cookieQuantity">Quantity:</form:label>
			<form:input path="cookieQuantity" type="number" min="0" value="${product.cookieQuantity }"/>
			<form:errors path="cookieQuantity" />
		</p>
		<p>
			<form:label path="cookiePrice">Price:</form:label>
			<form:input path="cookiePrice" type="number" min="0" step=".01" value="${product.cookiePrice }"/>
			<form:errors path="cookiePrice" />
		</p>
		<p>
			<form:label path="description">Description:</form:label>
			<form:input path="description" value="${product.description }"/>
			<form:errors path="description" />
		</p>
		<p>
			<form:label path="photo">Link to image:</form:label>
			<form:input path="photo" value="${product.photo }"/>
			<form:errors path="photo" />
		</p>
		<button>Submit</button>
	</form:form>
	<div class="pt-3"></div>
	</div>
	</div>
</body>
</html>