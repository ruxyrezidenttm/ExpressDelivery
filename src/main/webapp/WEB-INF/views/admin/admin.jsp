<!DOCTYPE html>
<html>
<head>
<title>ExpressDelivery</title>
<meta charset="UTF-8">
</head>
<link rel="stylesheet" href="main.css">
<body class="body">
	<div class="toolbar">
		<div id="logo">ExpressDelivery</div>
		<div class="menu">
			<div class="link">Log Out</div>
		</div>
	</div>
	
	<% for(int i = 1; i < 10; i++) { %>
	
	<div class="order">
		<div class="item" id="id">#0<%=i %></div>
		<div class="item" id="fullName">Davit Buniatyan</div>
		<div class="item" id="date">Right Now</div>
		<div class="item" id="TransportationType">Bicycle</div>
		<div class="item" id="Size">Big Box</div>
		<div class="item">
			<select id="selectlist">
				<option value="All Journals" selected="selected">Select 1</option>
				<option value="All Journals" selected="selected">Select 2</option>
			</select>
		</div>

		<div class="item" id="buttonCancell">Cancel</div>
		<div class="item" id="buttonDone">Done</div>

		<div class="item" id="pickup">
			<div class="headline">PickUp</div>
			<div>28 New Oxford Str. London, UK WE5N 5HB +44 (0) 77 134
				34312M</div>
		</div>
		<div class="item" id="delivery">
			<div class="headline">Address</div>
			<div>28 New Oxford Str.London, UKWE5N 5HB+44 (0) 77 134 34312M</div>
		</div>
	</div>
	
	<% } %>


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