$(document).ready(
		function(){
			$("#addBrandForm").click(
					function(){
						$('#brandError').html("");
					}
			)	
			$("#addCategoryForm").click(
					function(){
						$('#errorMessage').html("");
					}
			)			
			$("#addBrand").click(					
					function(){
						var data = serializeStringify("brandForm");						
						$.ajax({
							url:"../brands/save",
							method:"post",
							datatype:"json",
							data:data,
							contentType: 'application/json',
							success:addBrand,
							error:errorHandle
						});
						function addBrand(brand){
							$("#brand").append("<option value="+brand.id+">"+brand.name+"</option>");
							$("#brandModal").modal("hide");
							$("#savedStatusTitle").text("Brand saved.")
							$("#savedStatusMessage").text(brand.name + " saved.")							
							$("#statusModal").modal("show");
						}
						function errorHandle(errorObject ){	
							if (errorObject.responseJSON.errorType == "ValidationError") {
					 			$('#brandError').html("");
					 			$("#brandError").append( '<H4 align="center"> Error(s)!! <H4>');                
					  			    $("#brandError").append( '<p>');					  	
					  			    var errorList = errorObject.responseJSON.errors;
					 	 	        $.each(errorList,  function(i,error) {		
					 		    		$("#brandError").append( (i+1) + ". " +error.message + '<br>');
							    	});
					 	 	        $("#brandError").append( '</p>');
							}
							else {
								alert(errorObject.responseJSON.errors(0));   // "non" Validation Error
							}
				 		}						
						
			})			
			$("#addCategory").click(					
					function(){
						var data = serializeStringify("categoryForm");						
						$.ajax({
							url:"../categories/save",
							method:"post",
							datatype:"json",
							data:data,
							contentType: 'application/json',
							success:addBrand,
							error:errorHandle
						});
						function addBrand(category){
							$("#category").append("<option value="+category.id+">"+category.name+"</option>");
							$("#categoryModal").modal("hide");
							$("#savedStatusTitle").text("Category saved.")
							$("#savedStatusMessage").text(category.name + " saved.")
							$("#statusModal").modal("show");
						}		
						function errorHandle(errorObject ){	
							if (errorObject.responseJSON.errorType == "ValidationError") {
					 			$('#categoryError').html("");
					 			$("#categoryError").append( '<H4 align="center"> Error(s)!! <H4>');                
					  			    $("#categoryError").append( '<p>');					  	
					  			    var errorList = errorObject.responseJSON.errors;
					 	 	        $.each(errorList,  function(i,error) {		
					 		    		$("#categoryError").append( (i+1) + ". " +error.message + '<br>');
							    	});
					 	 	        $("#categoryError").append( '</p>');
							}
							else {
								alert(errorObject.responseJSON.errors(0));   // "non" Validation Error
							}
				 		}						
			})
			function errorHandle(errorObject ){	
				alert("hmm")
				if (errorObject.responseJSON.errorType == "ValidationError") {
		 			$('#errorMessage').html("");
		 			$("#errorMessage").append( '<H4 align="center"> Error(s)!! <H4>');                
		  			    $("#errorMessage").append( '<p>');					  	
		  			    var errorList = errorObject.responseJSON.errors;
		 	 	        $.each(errorList,  function(i,error) {		
		 		    		$("#errorMessage").append( (i+1) + ". " +error.message + '<br>');
				    	});
		 	 	        $("#errorMessage").append( '</p>');
				}
				else {
					alert(errorObject.responseJSON.errors(0));   // "non" Validation Error
				}
	 		}
		}		
)