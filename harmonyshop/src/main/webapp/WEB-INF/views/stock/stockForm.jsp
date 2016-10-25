<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
	<title>Stock</title>
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	<script	src="<c:url value="/resources/js/base.js" />"></script>
	<script	src="<c:url value="/resources/js/stock.js" />"></script>
    <style>
		.product-container .container{
			width: 600px;
			margin: auto;
		}
		.input-group-addon{
			width:150px;
		}
		.label-p{
			width:90px;
		} 
    </style>
</head>
<body>
	<section class="container"> 
        <div class="product-container">
            <c:url var="stockSave" value="/stock/save" />
            <form:form id="stockForm" modelAttribute="newStock" class="form-horizontal" method="post" action="${stockSave }">
	            <form:errors path="*" cssClass="text-danger"/>                                                                                                           
				<div class="input-group input-sm">
					<label class="input-group-addon" for="date"><spring:message code="stock.date.label"/></label>
					<form:input id="date" path="date" type="text" class="form-control" value="10/10/2010"/>
					<form:errors path="date" cssClass="text-danger"/>
				</div>
				<div class="input-group input-sm">
					<label class="input-group-addon" for="description"><spring:message code="stock.description.label"/></label>
					<form:input id="description" path="description" type="text" class="form-control" value="Afewerki"/>
					<form:errors path="description" cssClass="text-danger"/>
				</div>
				<div class="input-group input-sm">
					<label class="input-group-addon" for="stockType"><spring:message code="stock.stockType.label"/></label>
					<form:select id="stockType" path="stockType.id" class="form-control">
		 				<form:option value="0" label="Select Type"/>
		 				<form:options items="${stockTypes}" itemLabel="stockType" itemValue= "id"/> 								
					</form:select>
					<form:errors path="stockType.id" cssClass="text-danger"/>
				</div>
    <div class="row">
        <label class="col-sm-1" for="productChooser"><spring:message code="stockEntry.product.label"/></label>
        <div class="col-sm-1">
        			<select id="productChooser" class="form-control">
						<c:forEach items="${products}" var="product">
		 					<option value= "${product.id }">${product.name }</option> 
		 				</c:forEach>
					</select>
		</div>
        <label class="col-sm-1"><spring:message code="stockEntry.quantity.label"/></label>
        <div class="col-sm-1"><input type="text" id="stockEntryQuantity" class="form-control" /></div>
        <button type="button" class="btn btn-primary btn-default" id="addProduct">Add</button>
    </div>				
				<div class="table-responsive">
				
				<table id="productsList" class="table-striped" width="100%">
	          		<tr><th>Product Id</th><th>Product Name</th><th>Quantity</th><th>remove</th></tr>
	          	</table>
	          	<div style="display:none" id="productsToSave"></div>
	          	</div>
                 <div class="form-actions">
                     <input type="submit" class="btn btn-primary btn-default" id="saveStock" value="Save"><!-- Save</button> -->
                 </div>
                 <form:input type="hidden" path="user.id" value="1" />
	          </form:form>
        </div>
    </section>
	  
	<!-- status Modal -->
	<div id="statusModal" class="modal fade" role="dialog">
	  <div class="modal-dialog modal-sm">
	
	    <!-- Modal content-->
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	        <h4 class="modal-title" id="savedStatusTitle"></h4>
	      </div>
	      <div class="modal-body">
	        <p id="savedStatusMessage"></p>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	      </div>
	    </div>
	  </div>
</div>
</body>
</html>
