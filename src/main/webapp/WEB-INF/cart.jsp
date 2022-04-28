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
							aria-current="page" href="/">Home</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Cookies</a>
						</li>
						<c:if test="${userId != null}">
							<li><form:form id="logoutForm" method="POST"
									action="/logout">
									<input type="hidden" name="${_csrf.parameterName}"
										value="${_csrf.token}" />
									<input class="btn btn-link" type="submit" value="Logout!" />
								</form:form></li>
						</c:if>
					</ul>
				</div>
				<c:if test="${ userId != null}">
				<a href="/cart"><img class="navbarIcons"
					src="https://d29fhpw069ctt2.cloudfront.net/icon/image/38239/preview.svg"
					alt="shopping cart icon"></a>
				<p class="crtCount rounded-circle">+</p>
				</c:if>
			</div>
		</nav>
		<div class="row">
			<div class="col">
				<c:forEach var="cart" items="${carts }">
					<c:out value="${cart.products.name }"/>
				</c:forEach>
			</div>
			<div class="col">
				<h1>Hello</h1>
			</div>
		</div>
		</div>
</body>
</html>