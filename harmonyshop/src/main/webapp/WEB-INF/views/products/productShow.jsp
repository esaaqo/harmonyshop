<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
	<title>Stock</title>
</head>
<body>
	<section class="container"> 
	<h2>Product</h2>
		id: ${newProduct.id}<br>
		Name: ${newProduct.name}<br>
		Specification: ${newProduct.specification}		
		<br>
		<img src="<c:url value="/resources/images/products/" />${newProduct.imageName}" width="200px"/>
    </section>
</body>
</html> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
 	<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
	<script type="text/javascript" src="<spring:url value="/resource/js/cart.js"/>"></script>
	
<title>Products</title>
</head>
<body>
 	<section class="container" >
	
		<div class="row">
		<div class="col-md-5">
	<img src="<c:url value="/resources/images/products/" />${newProduct.imageName}" width="300px"/>
</div>
		
			<div class="col-md-5">
				<h3>${newProduct.name}</h3>
				<p>${newProduct.specification}</p>
				<p>
					<strong>Item Code : </strong><span class="label label-warning">${newProduct.id}</span>
				</p>
				<p>
					<strong>manufacturer</strong> : ${newProduct.brand.name}
				</p>
				<p>
					<strong>category</strong> : ${newProduct.category.name}
				</p>

				<p ng-controller="cartCtrl">
 					<a href="cart/add/${newProduct.id}" class="btn btn-warning btn-large" > 
<span class="glyphicon-shopping-cart glyphicon"></span> Order Now </a>
<a href="<spring:url value="/cart" />" class="btn btn-default">
	<span class="glyphicon-hand-right glyphicon"></span> View Cart
</a>

 <a href="<spring:url value="/products" />" class="btn btn-default">
						<span class="glyphicon-hand-left glyphicon"></span> back
					</a>
				</p>
			</div>
		</div>
<!--/div-->
	</section>
	<div></div>
</body>
</html>
