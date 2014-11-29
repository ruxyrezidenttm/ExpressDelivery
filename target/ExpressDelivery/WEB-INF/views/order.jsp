<!DOCTYPE html>
<html>
	<head>
		<title> ExpressDelivery</title>
		<meta charset="UTF-8">
		
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
		
		<script type="text/javascript">
		var selectedSize;
		$( document ).ready(function() {
			selectedSize = 'paper';
			$('#paper').addClass('picWeightSelected');
			$('#size').attr('value',selectedSize);
			
			selectedTrans = 'bicycle';
			$('#bicycle').addClass('picWeightSelected');
			$('#transport').attr('value',selectedTrans);
			
			$('.picWeight').click(function() {
				var currentObj = $(this);
				if(currentObj.attr('type') == 'transport') {
					$('#'+selectedTrans).removeClass('picWeightSelected');
					selectedTrans = currentObj.attr('id');
					$('#transport').attr('value',selectedTrans);
				}
				else {
					$('#'+selectedSize).removeClass('picWeightSelected');
					selectedSize = currentObj.attr('id');
					$('#size').attr('value',selectedSize);
				}
				currentObj.addClass('picWeightSelected');
			});
			
			$('#pickupTimeNow').change(function() {
				if($(this).is(":checked")) {
					$('#pickupTime').fadeOut(function() {
						$('#pickupTime').attr('value','now');
					});
				}
				else {
				$('#pickupTime').attr('value','');
					$('#pickupTime').fadeIn();
				}
			});
		});
		</script>
	</head>
	<link rel="stylesheet" href="main.css">
	<body class="body">
		<div class="toolbar">
			<div id="logo">ExpressDelivery</div>
			<div class="menu">
				<div class="link">About</div>
				<div class="link">FAQ</div>
				<div class="link">Contact</div>
			</div>
		</div>
		<div class="content">
			<form action="payment">
			<div class="registration">
				<div class="orderBox">
					<div id="weight">
						<div id="headline">Size</div>
						<div class="picWeight" id="paper"></div>
						<div class="picWeight" id="smallbox"></div>
						<div class="picWeight" id="mediumbox"></div>
						<div class="picWeight" id="bigbox"></div>
						<input type='hidden' id='size'></input>
					</div>
					<div id="transportation">
						<div id="headline">Transportation</div>
						<div class="picWeight" type="transport" id="bicycle"></div>
						<div class="picWeight" type="transport" id="trail2"></div>
						<input type='hidden' id='transport'></input>
					</div>
				</div>
				<div class="orderBox" >
					<div id="headline">Time</div>
					<input type="checkbox" id='pickupTimeNow' name="c" value="pickup"> Right Now</input>
					<input class="input" type="input" id="pickupTime" placeholder="Today at (12:00)"> </input>
				</div>
				<div class="orderBox" >
					<div id="headline">Pick Up</div>
					<input class="input" type="input" id="address" placeholder="Address"> </input>
					<input class="input" type="input" id="fullName" placeholder="Full name"> </input>
					<input class="input" type="input" id="phoneNumber" placeholder="Phone #"> </input>
					<input class="input" type="input" id="email" placeholder="Email"> </input>
	
				</div>
				<div class="orderBox">
					<div id="headline">Delivery</div>
					<input class="input" type="input" id="address" placeholder="Address"> </input>
					<input class="input" type="input" id="fullName" placeholder="Full name"> </input>
					<input class="input" type="input" id="phoneNumber" placeholder="Phone #"> </input>
					<input class="input" type="input" id="email" placeholder="Email"> </input>
				</div>
			</div>
			<input  class="submit" type="submit" value="Order 7$" /></form>
		</div>
		<div class="footer">
			<div class="title">
				<div id="contacts">Contact Address</div>
				<div id="about">About</div>
				<div id="jobs">Jobs</div>
				<div id="faq">FAQ</div>
			</div>
			<div id="address">
				<p>28 New Oxford Str.</p>
				<p>London, UK</p>
				<p>WE5N 5HB</p>
				<p>+44 (0) 77 134 34312M</p>

			</div>
			
		</div>

	</body>
</html>