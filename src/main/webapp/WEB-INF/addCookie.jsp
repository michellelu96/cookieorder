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

<title>Cookie Monsters Bakery</title>
</head>
<body class="container">
	<form:form action="/admin/cookie/addCookie" method="post"
		modelAttribute="product">
		<p>
			<form:label path="name">Product Name:</form:label>
			<form:input path="name" />
			<form:errors path="name" />
		</p>
		<p>
			<form:label path="cookieQuantity">Quantity:</form:label>
			<form:input path="cookieQuantity" type="number" min="0"/>
			<form:errors path="cookieQuantity" />
		</p>
		<p>
			<form:label path="cookiePrice">Price:</form:label>
			<form:input path="cookiePrice" type="number" min="0" step=".01"/>
			<form:errors path="cookiePrice" />
		</p>
		<p>
			<form:label path="description">Description:</form:label>
			<form:input path="description" />
			<form:errors path="description" />
		</p>
		<p>
			<form:label path="photo">Link to image:</form:label>
			<form:input path="photo" />
			<form:errors path="photo" />
		</p>
	</form:form>
</body>
</html>