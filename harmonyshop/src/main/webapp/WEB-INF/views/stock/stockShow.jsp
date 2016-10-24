<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
	<title>Stock</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
	<script	src="<c:url value="/resources/js/base.js" />"></script>
	<script	src="<c:url value="/resources/js/stock.js" />"></script>
</head>
<body>
    <section>
		<div class="jumbotron">
			<div class="container">
				<h1>Product</h1>
			</div>
			<a href="<c:url value="save" />" class="btn btn-default pull-right" data-toggle="modal" data-target="#brandModal" id="addBrandForm">Add another stock</a>			
		</div>
	</section>
	<section class="container"> 
		Stock id: ${newStock.id}<br>
		Date: ${newStock.date}<br>
		type: ${newStock.stockType.stockType}
		<table class="table-striped" style="width:200px">
			<tr><th>Product</th><th>Quantity</th></tr>
			<c:forEach items="${ newStock.stockEntries}" var="stockEntry">
				<tr><td>${stockEntry.product.name }</td><td>${stockEntry.quantity }</td></tr>
			</c:forEach>
		</table>
    </section>
	  
</body>
</html>
