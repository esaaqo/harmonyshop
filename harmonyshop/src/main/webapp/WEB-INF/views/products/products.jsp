<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
</head>
<body>
 	<section class="container">
		<div class="row">
			<c:forEach items="${products}" var="product">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
					<img src="<c:url value="/resources/images/products/" />${product.imageName}" alt="image"  style = "width:200px"/>
						<div class="caption">
							<h4><strong>${product.name}</strong></h4>
							<p><strong>Spec:</strong>${product.specification}</p>
							<p><strong>Price:</strong>${product.price}</p>
<%-- 							<p><spring:eval expression =  "product.unitPrice" /><spring:message code="currency.type"/></p>
							<p>Available ${product.unitsInStock} units in stock</p>
							<p><spring:eval expression =  "product.activeDate" /></p> --%>
							<p>
								<a
									href=" <spring:url value="/products/show?productId=${product.id}" /> "
									class="btn btn-primary"> <span
									class="glyphicon-info-sign glyphicon" /></span> Details
								</a>
							</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
</body>
</html>
