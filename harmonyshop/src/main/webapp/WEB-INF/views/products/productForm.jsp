<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
	<title>Product, Brand, Category</title>
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
				<h1>Product</h1>
			</div>
			<a href="#" class="btn btn-default pull-right" data-toggle="modal" data-target="#brandModal" id="addBrandForm">Add Brand</a>
			<a href="#" class="btn btn-default pull-right" data-toggle="modal" data-target="#categoryModal" id="addCategoryForm">Add Category</a	>
		</div>
	</section>
	<section class="container"> 
        <div class="product-container">
            <div class="login-card">
                <div class="login-form">
                    <c:url var="productSave" value="/products/save" />
                    <form:form modelAttribute="newProduct" class="form-horizontal" method="post" action="${productSave }" enctype="multipart/form-data">
                    	<legend>Add product</legend>                                                                                                             
						<div class="input-group input-sm">
							<label class="input-group-addon" for="name"><spring:message code="product.name.label"/></label>
							<form:input id="name" path="name" type="text" class="form-control" value="shalom"/>
							<form:errors path="name" cssClass="text-danger"/>
						</div>
						<div class="input-group input-sm">
							<label class="input-group-addon" for="model"><spring:message code="product.model.label"/></label>
							<form:input id="model" path="model" type="text" class="form-control" value="Afewerki"/>
							<form:errors path="model" cssClass="text-danger"/>
						</div>
						<div class="input-group input-sm">
							<label class="input-group-addon" for="price"><spring:message code="product.price.label"/></label>
							<form:input id="price" path="price" type="text" class="form-control" value="shalom"/>
							<form:errors path="price" cssClass="text-danger"/>
						</div>
						<div class="input-group input-sm">
							<label class="input-group-addon" for="specification"><spring:message code="product.specification.label"/></label>
							<form:input id="specification" path="specification" class="form-control" value="1234"/>
							<form:errors path="specification" cssClass="text-danger"/>
						</div>				
						<div class="input-group input-sm">
							<label class="input-group-addon" for="brand"><spring:message code="product.brand.label"/></label>
							<form:select id="brand" path="brand.id" class="form-control">
				 				<form:option value="0" label="Select Brand"/>
				 				<form:options items="${brands}" itemLabel="name" itemValue= "id"/> 								
							</form:select>
							<form:errors path="brand.id" cssClass="text-danger"/>
						</div>
						<div class="input-group input-sm">
							<label class="input-group-addon" for="category"><spring:message code="product.category.label"/></label>
							<form:select id="category" path="category.id" class="form-control">
				 				<form:option value="0" label="Select Category"/>
				 				<form:options items="${categories}" itemLabel="name" itemValue= "id"/> 								
							</form:select>
							<form:errors path="category.id" cssClass="text-danger"/>
						</div>	
						<div class="input-group input-sm">
							<label class="input-group-addon" for="imageFile"><spring:message code="product.image.label"/></label>
							<form:input id="imageFile" path="imageFile" type="file" class="form-control" />
							<form:errors path="imageFile" cssClass="text-danger"/>
						</div>	

                       <div class="form-actions">
                           <input type="submit" class="btn btn-primary btn-default" value="Add Product">
                       </div>                                                                              
                    </form:form>
                </div>
            </div>
        </div>
    </section>
   <!-- brand Modal -->
	<div id="brandModal" class="modal fade" role="dialog">
	<form id="brandForm" class="form-horizontal" method="post">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	        <h4 class="modal-title">Add Brand	</h4>
	      </div>
	      <div class="modal-body">
           <div class="product-container">
               <div class="login-card">
                   <div class="login-form">
                   <div class="text-danger" id="brandError"></div>
						<div class="input-group input-sm">
							<label class="input-group-addon" for="name"><spring:message code="brand.name.label"/></label>
							<input type="text" id="name" name="name" class="form-control" value="shalom"/>
						</div>
						<div class="input-group input-sm">
							<label class="input-group-addon" for="details"><spring:message code="brand.details.label"/></label>
							<input type="text" id="details" name="details"  class="form-control" value="Afewerki"/>
						</div>				                                                                                                      
                   </div>
               </div>
           </div>
	      </div>
	      <div class="modal-footer">
	        <button type="button" id="addBrand" class="btn btn-primary btn-default">Add Brand</button><button type="button" class="btn btn-primary btn-default" data-dismiss="modal">Close</button>
	      </div>
	    </div>
	  </div>
	  </form>
	  </div>
   <!-- Category Modal -->
	<div id="categoryModal" class="modal fade" role="dialog">
	<form id="categoryForm" class="form-horizontal" method="post">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	        <h4 class="modal-title">Add Category	</h4>
	      </div>
	      <div class="modal-body">
           <div class="product-container">
               <div class="login-card">
                   <div class="login-form">
                   <div class="text-danger" id="categoryError"></div>
						<div class="input-group input-sm">
							<label class="input-group-addon" for="name"><spring:message code="category.name.label"/></label>
							<input type="text" id="name" name="name" class="form-control" value="shalom"/>
						</div>
						<div class="input-group input-sm">
							<label class="input-group-addon" for="description"><spring:message code="category.description.label"/></label>
							<input type="text" id="description" name="description"  class="form-control" value="Afewerki"/>
						</div>				                                                                                                      
                   </div>
               </div>
           </div>
	      </div>
	      <div class="modal-footer">
	        <button type="button" id="addCategory" class="btn btn-primary btn-default">Add Category</button><button type="button" class="btn btn-primary btn-default" data-dismiss="modal">Close</button>
	      </div>
	    </div>
	  </div>
	  </form>
	  </div>
		  
	  
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
