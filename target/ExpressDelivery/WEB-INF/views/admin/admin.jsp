<!DOCTYPE html>

<%@page import="java.util.ArrayList" %>
<%@page import="com.expressdelivery.model.bean.Delivery" %>

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
	
	<p><h1 class="title" style="margin-left: 20px">Admin Panel</h1></p>
	
	<% 
	
	ArrayList<Delivery> deliveries = new ArrayList<Delivery>();
	deliveries = (ArrayList<Delivery>) session.getAttribute("deliveries");
	
	for(int i = 1; i < deliveries.size(); i++) { %>
	
	<div class="order">
		<form action="admin" method="POST">
		<div class="item" id="id">#<%=i %></div>
		<div class="item" id="fullName"><%= deliveries.get(i).getAddressFrom().getFullName() %></div>
		<div class="item" id="date"><%= deliveries.get(i).getParcel().getPickupTime()%></div>
		<div class="item" id="TransportationType"><%= deliveries.get(i).getParcel().getTransType() %></div>
		<div class="item" id="Size"><%= deliveries.get(i).getParcel().getSize() %></div>
		
		<div class="item">
			<select name="selectStatus<%=i %>">
				<option value="booked" selected="selected">Booked</option>
				<option value="confirmed" >Confirmed</option>
				<option value="collected" >Collected</option>
				<option value="onitsway" >On its way</option>
				<option value="delivered" >Delivered</option>
			</select>
		</div>
	
		<!-- <div class="item" id="buttonCancell">Cancel</div>
		<div class="item" id="buttonDone">Done</div> -->		
		<div class="item"><input  class="submit" id="buttonCancel" type="button" value="Cancel" />
		<input  class="submit" id="buttonDone" type="submit" value="Done" /></div>
		<div class="item" id="pickup">
			<div class="headline">PickUp</div>
			<div><%= deliveries.get(i).getAddressFrom().getAddress() %></div>
		</div>
		<div class="item" id="delivery">
			<div class="headline">Address</div>
			<div><%= deliveries.get(i).getAddressTo().getAddress() %></div>
		</div>
		<input type="hidden" name="orderInList" value="<%=i %>" />
		</form>
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