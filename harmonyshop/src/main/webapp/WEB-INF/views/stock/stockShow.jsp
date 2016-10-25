<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
	<title>Stock</title>
</head>
<body>
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
