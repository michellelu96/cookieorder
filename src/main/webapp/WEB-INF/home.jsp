<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>Cookie Monsters Bakery</title>
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
							aria-current="page" href="#">Home</a></li>
						<li class="nav-item"><a class="nav-link" href="/allCookies">All
								Cookies</a> </li>
						<c:if test="${ user.id == null}">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="/login">Login</a></li>
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="/registration">Register</a></li>
						</c:if>
						<c:if test="${user.id != null}">
							<li><form:form id="logoutForm" method="POST"
									action="/logout">
									<input type="hidden" name="${_csrf.parameterName}"
										value="${_csrf.token}" />
									<input class="btn btn-link" type="submit" value="Logout!" />
								</form:form></li>
						</c:if>
					</ul>
				</div>
				<c:if test="${ user.id != null}">
					<a href="/cart"><img class="navbarIcons"
						src="https://d29fhpw069ctt2.cloudfront.net/icon/image/38239/preview.svg"
						alt="shopping cart icon"></a>
					<p class="crtCount rounded-circle">+</p>
				</c:if>
				</div>
		</nav>
		<div id="carouselCrossfade" class="carousel slide carousel-fade"
			data-bs-ride="carousel">
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img
						src="https://assets.bonappetit.com/photos/58e2844b65366d7ba90812ea/master/pass/0417-Brown-Butter-Toffee-ChocolateChip%20Cookie-group.jpg"
						class="d-block w-100 carouselImages" alt="Slide 1">
					<div class="carousel-caption d-none d-sm-block">
						<h5>Brown Butter Toffee Chocolate Chip Cookie</h5>
						<p>Yummy Cookie!</p>
					</div>
				</div>
				<c:forEach var="product" items="${products}">
					<div class="carousel-item">
						<img src="${product.photo }" class="d-block w-100 carouselImages"
							alt="Slide 1">
						<div class="carousel-caption d-none d-sm-block">
							<h5>
								<c:out value="${product.name }" />
							</h5>
							<p>
								<c:out value="${product.description }" />
							</p>
						</div>
					</div>
				</c:forEach>
			</div>
			<a class="carousel-control-prev" href="#carouselCrossfade"
				role="button" data-bs-slide="prev"> <span
				class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Previous</span>
			</a> <a class="carousel-control-next" href="#carouselCrossfade"
				role="button" data-bs-slide="next"> <span
				class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Next</span>
			</a>
			<div
				class="d-flex flex-row justify-content-evenly bd-highlight mt-3 flex-wrap p-2">
				<c:forEach var="product" items="${products}">
					<div class=" p-2 bd-highlight">
						<div class="card " style="width: 18rem;">
							<img src="${product.photo }" class="card-img-top cardImages"
								alt="cookie photo">
							<div class="card-body">
								<p class="card-text text-center">
									<a href="/oneCookie/${product.id }">${product.name}</a> <br>
									${product.description}
								</p>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>