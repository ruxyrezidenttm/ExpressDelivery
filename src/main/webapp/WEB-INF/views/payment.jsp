<!DOCTYPE html>
<html>
	<head>
		<title> ExpressDelivery</title>
		<meta charset="UTF-8">
		
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
		
		<script type="text/javascript">
		/* var address = 'PICKUP ADDRESS HERE';
		var name = 'PICKUP NAME HERE';
		var phone = 'PICKUP PHONE HERE';
		var email = 'PICKUP EMAIL HERE'; */
		$( document ).ready(function() {
			$('#usePickup').change(function() {
				if($(this).is(":checked")) {
					$('#billingInfo').fadeOut(function() {
						/* $('#address').attr('value',address);
						$('#fullName').attr('value',name);
						$('#phoneNumber').attr('value',phone);
						$('#email').attr('value',email); */
					});
				}
				else {
					console.log("yeey");
					$('#address').attr('value','');
					$('#fullName').attr('value','');
					$('#phoneNumber').attr('value','');
					$('#email').attr('value','');
					$('#billingInfo').fadeIn();
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
			<form action="paymentresult" method="POST">
	
			<div class="registration" >
					<div id="headline">Billing Address</div>
					<input type="checkbox" id='usePickup' name="c" value="pickup" > Use PickUp Address</input>
					
					<div id='billingInfo' type="hidden">
					<input class="input" type="text" id="address" name="addressBill" placeholder="Address" /> 
					<input class="input" type="text" id="fullName" name="nameBill" placeholder="Full Name" /> 
					<input class="input" type="text" id="phoneNumber" name="phoneBill" placeholder="Phone #"  /> 
					<input class="input" type="email" id="email" name="emailBill" placeholder="Email" />
					</div>
			</div>
			<div class="registration">
					<div id="headline">Payment Method</div>
					<input class="input" type="text" id="fullNamePay" name="nameCard" placeholder="Name on the Card" /> 
					<input class="input" type="text" id="CardNumber" name="cardNumber" placeholder="Card Number" /> 
					<input class="input" type="text" id="Expires" name="expiryDate" placeholder="Expires (05/2001)" />
					<input class="input" type="text" id="SecurityCode" name="securityCode" placeholder="Security Code" />
			</div>
			<div id="order"><input  class="submit" type="submit" value="Pay 7$" /></div></form>
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