$(document).ready(
	function(){
		$("#stockForm").submit(
				function(event){
					$("#productsToSave").html("");
					//event.preventDefault();
					$("#productsList").find('tr').each (function(i,tds) {
						if(i!=0){
							var productId = $($(tds).find('td')[0]).text();
							var quantity = $($(tds).find('td')[2]).text();
							$("#productsToSave").append("<input type='text' name='stockEntries["+(i-1)+"].product.id' value='"+productId+"' />")
							$("#productsToSave").append("<input type='text' name='stockEntries["+(i-1)+"].quantity' value='"+quantity+"' />")
						}
					});
					
				}
		);
		$("#addProduct").click(
				function(){
					var tr=$("<tr><td>"+$("#productChooser option:selected").val()
							+"</td><td>"+$("#productChooser option:selected").text()
							+"</td><td>"+$("#stockEntryQuantity").val()
							+"</td></tr>");
					var td=$("<td></td>");
					
					var removeButton = $("<button type='button' class='btn btn-primary btn-sm btn-danger' id='removeProduct'>remove</button>");
					td.append(removeButton)
					tr.append(td)
					removeButton.click(removeProduct)
					$("#productsList").append(tr);
					//alert($("#productChooser option:selected").val() + " "+ $("#productChooser option:selected").text() + " " +$("#stockEntryQuantity").val())
				}
		);
		function removeProduct(event){
			var tr = $(event.target).closest("tr");
			$(tr).remove();
		}
	}
)
		