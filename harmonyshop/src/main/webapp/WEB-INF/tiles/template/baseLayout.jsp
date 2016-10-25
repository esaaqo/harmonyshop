<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title><tiles:insertAttribute name="title" /></title>
<link href="http://getbootstrap.com/dist/css/bootstrap.css"	rel="stylesheet">
<link href="http://getbootstrap.com/examples/jumbotron/jumbotron.css"	rel="stylesheet">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>	
<style>
.jumbotron {
    padding-top: 1px;
    padding-bottom: 1px;
    padding-right: 0;
}
</style>
</head>

<body>

	<div class="container">
		<div class="header">
			<ul class="nav nav-pills pull-right">
				<tiles:insertAttribute name="navigation" />
			</ul>
			<h3 class="text-muted">iShop</h3>
		</div>


		<div class="jumbotron">
			<h3>
				<tiles:insertAttribute name="heading" />
			</h3>
			<p>
				<tiles:insertAttribute name="tagline" />
			</p>
			<div class="form-group">
				<form action="<c:url value="/products/search"/>" >
  					<label for="search">Search</label>
 					<input type="text" class="form-control" id="search" name="searchTerm">
 					<input type="submit" class="btn btn-default" value="search">
 				</form>
 				
			</div>
			<div>
				<tiles:insertAttribute name="contextMenu" />	
			</div>		
		</div>

		<div class="row">
			<tiles:insertAttribute name="body" />
		</div>

		<div class="footer">
			<tiles:insertAttribute name="footer" />
		</div>

	</div>
</body>
</html>
