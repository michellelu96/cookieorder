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
							aria-current="page" href="#">Home</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Cookies</a>
						</li>
						<c:if test="${user.id}">
						<li>
						<form:form id="logoutForm" method="POST" action="/logout">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" /> <input  class="btn btn-link" type="submit" value="Logout!" />
						</form:form>
							</li>
						<li>
							Hello <c:out value="${user.name }"/>
						</li>
						</c:if>
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
				<div class="carousel-item">
					<img
						src="https://www.bakefromscratch.com/wp-content/uploads/2021/05/Snickerdoodle332SWSheader-696x391.jpg"
						class="d-block w-100 carouselImages" alt="Slide 2">
					<div class="carousel-caption d-none d-sm-block">
						<h5>Snickerdoodle Cookie</h5>
						<p>Sugar cookies that are coated in sugar and cinnamon</p>
					</div>
				</div>
				<div class="carousel-item">
					<img
						src="https://www.shugarysweets.com/wp-content/uploads/2021/06/oreo-cheesecake-cookies-recipe.jpg"
						class="d-block w-100 carouselImages" alt="Slide 3">
					<div class="carousel-caption d-none d-sm-block">
						<h5>Oreo Cheesecake Cookies</h5>
						<p>Cookies based off of oreo cheesecakes</p>
					</div>
				</div>
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
				class="d-flex flex-row bd-highlight justify-content-around mt-3 flex-wrap">
				<div class="card " style="width: 18rem;">
					<img src="..." class="card-img-top" alt="...">
					<div class="card-body">
						<p class="card-text">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p>
					</div>
				</div>
				<div class="card" style="width: 18rem;">
					<img src="..." class="card-img-top" alt="...">
					<div class="card-body">
						<p class="card-text">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p>
					</div>
				</div>
				<div class="card" style="width: 18rem;">
					<img src="..." class="card-img-top" alt="...">
					<div class="card-body">
						<p class="card-text">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p>
					</div>
				</div>
			</div>
		</div>
		</div>
</body>
</html>