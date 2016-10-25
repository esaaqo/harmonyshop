<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
</html>
