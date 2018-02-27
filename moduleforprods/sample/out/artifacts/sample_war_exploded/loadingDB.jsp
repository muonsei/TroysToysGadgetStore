<html>
	<head>
		<title>Loading from the Database</title>
		<style>
			.divProduct{
				font-family: arial narrow;
				font-size:12px;
				margin:0 auto;
				margin-left: 5px;
				-webkit-box-shadow: 6px 7px 4px 0px rgba(0,0,0,0.75);
				-moz-box-shadow: 6px 7px 4px 0px rgba(0,0,0,0.75);
				box-shadow: 6px 7px 4px 0px rgba(0,0,0,0.75);
			}
			.divProduct .prodName{
				color:black;
			}
			.divProduct .prodPrice{
				color:blue;
			}
			.divProduct .prodImage{
				height:150px;
				width:150px;
			}
			.divProduct button{
				background-color:#1b2468;
				color:white;
				text-align: center;
			}

		</style>
		  <script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous">	
		  </script>
        <script>
        	$(document).ready(function() {
	    			$.post("someservlet", function(responseJson) {          // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response JSON...
	        		var $divH = $("<div>").addClass("divProduct").appendTo($("#holdingDiv")); 
	        		$.each(responseJson, function(index, product) {    // Iterate over the JSON array.
	        			$divH.append($("<img>").attr("src", "images/" + product.id + ".jpg").addClass("prodImage"))
	        			$divH.append($("<p>").addClass("prodName").text(product.name))
	        			$divH.append($("<p>").addClass("prodPrice").text(product.price))
	        			$divH.append($("<button>").addClass("btnAddCart").text("ADD TO CART"))
	        			$divH.append($("<button>").addClass("btnDetails").text("VIEW DETAILS"))
	        		});
   			});
		});
        </script>
	</head>
	<body>
		<div id = "holdingDiv">
			<div class = "divProduct">
				/* Picture, Name, Price*/
			</div>
		</div>
	</body>
</html>