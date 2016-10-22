<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
	<title>Sign Up</title>
	<link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
	<script	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
    <style>
		.signup-container{
			width: 400px;
			margin: auto;
		}
		.input-group-addon{
			width:150px;
		}   
    </style>
</head>
<body>
    <section>
		<div class="jumbotron">
			<div class="container">
				<h1>Signup</h1>
			</div>
		</div>
	</section>
	<section class="container"> 
        <div id="mainWrapper">
           <div class="signup-container">
               <div class="login-card">
                   <div class="login-form">
                       <c:url var="loginUrl" value="/login" />
                       <form:form modelAttribute="newUser" class="form-horizontal" method="post" action="${signup }">
                       		<legend>Sign up</legend>                                                                                                             
							<div class="input-group input-sm">
								<label class="input-group-addon" for="firstName"><spring:message code="users.firstName.label"/></label>
								<form:input id="firstName" path="firstName" type="text" class="form-control" value="shalom"/>
								<form:errors path="firstName" cssClass="text-danger"/>
							</div>
							<div class="input-group input-sm">
								<label class="input-group-addon" for="lastName"><spring:message code="users.lastName.label"/></label>
								<form:input id="lastName" path="lastName" type="text" class="form-control" value="Afewerki"/>
								<form:errors path="lastName" cssClass="text-danger"/>
							</div>
							<div class="input-group input-sm">
								<label class="input-group-addon" for="userName"><spring:message code="users.userName.label"/></label>
								<form:input id="userName" path="userName" type="text" class="form-control" value="shalom"/>
								<form:errors path="userName" cssClass="text-danger"/>
							</div>
							<div class="input-group input-sm">
								<label class="input-group-addon" for="password"><spring:message code="users.password.label"/></label>
								<form:password id="password" path="password" class="form-control" value="1234"/>
								<form:errors path="password" cssClass="text-danger"/>
							</div>				
							<div class="input-group input-sm">
								<label class="input-group-addon" for="email"><spring:message code="users.email.label"/></label>
								<form:input id="email" path="email" type="text" class="form-control" value="shalom@gmail.com"/>
								<form:errors path="email" cssClass="text-danger"/>
							</div>					
                           <div class="form-actions">
                               <input type="submit" class="btn btn-block btn-primary btn-default" value="Sign up">
                           </div>                                                                               
                       </form:form>
                   </div>
               </div>
           </div>
       </div>
    </section>
</body>
</html>
