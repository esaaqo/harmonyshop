<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
	<title>harmony shop</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
	<script	src="<c:url value="/resources/js/base.js" />"></script>
	<script	src="<c:url value="/resources/js/products.js" />"></script>
    <style>
		.product-container{
			width: 400px;
			margin: auto;
		}
		.input-group-addon{
			width:150px;
		}  
		.form-control{
			width:300px;
		}
    </style>
</head>
<body>
    <section>
		<div class="jumbotron">
			<div class="container">
				<h3>harmony shopping</h3>
				<p>Welcome <strong><sec:authentication property="principal.username" /></strong><br />
			</div>
			<a href="<c:url value="stock/save" />" class="btn btn-default pull-right">Stock</a>
			<a href="<c:url value="products/save" />" class="btn btn-default pull-right">Add product</a>
			<a href="<c:url value="logout" />" class="btn btn-default pull-right">logout</a	>
		</div>
	</section>
</body>
</html>