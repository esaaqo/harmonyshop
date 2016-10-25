<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<li><a href="<spring:url value="/welcome"/>">Home</a></li>

<li><a href="<spring:url value="/products/"/>">Products</a></li>
<security:authorize access="hasRole('ROLE_EMPLOYEE')">
  	<li><a href="<spring:url value="/products/save"/>">Add Product</a></li>		
  	<li><a href="<spring:url value="/stock/save"/>">Stock</a></li>				
</security:authorize>
<security:authorize access="hasRole('ROLE_USER')">
	<li><a href="<spring:url value="/cart/"/>">Cart</a></li>
</security:authorize>
<security:authorize access="isAnonymous()">
	<li><a href="<spring:url value="/login"/>">login</a></li>
</security:authorize>
<security:authorize access="isAuthenticated()">
	<li><a href="<spring:url value="/logout"/>">logout</a></li>
</security:authorize>
