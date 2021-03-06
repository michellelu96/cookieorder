<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
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
						<li class="btn btn-link"><form:form id="logoutForm"
								method="POST" action="/logout">
								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />
								<input type="submit" value="Logout!" />
							</form:form></li>
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
		<div
			class="d-flex flex-row justify-content-evenly bd-highlight mt-3 flex-wrap p-2">
			<c:forEach var="product" items="${products}">
				<div class=" p-2 bd-highlight">
					<div class="card " style="width: 18rem;">
						<img src="${product.photo }" class="card-img-top cardImages"
							alt="cookie photo">
						<div class="card-body">
							<p class="card-text text-center">
								${product.name} <br> ${product.description}
							</p>
							<div class="d-flex justify-content-center">
								<a href="/admin/cookie/edit/${product.id}"
									class="btn btn-primary">Edit</a>
								<form action="/admin/cookie/delete/${product.id}" method="post">
									<input type="hidden" name="_method" value="delete"> <input
										type="submit" value="Delete" class="btn btn-danger">
										</form>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>