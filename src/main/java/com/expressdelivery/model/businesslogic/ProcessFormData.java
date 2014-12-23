package com.expressdelivery.model.businesslogic;

import javax.servlet.http.HttpServletRequest;

import com.expressdelivery.model.bean.Address;
import com.expressdelivery.model.bean.CardDetails;
import com.expressdelivery.model.bean.Delivery;
import com.expressdelivery.model.bean.Parcel;

public class ProcessFormData {

	
	
	public static Delivery processOrderForm(HttpServletRequest request) {
		
		Delivery delivery;	
		
		Address addressTo = new Address();
		Address addressFrom = new Address();
		Parcel parcel = new Parcel();

		parcel.setSize(request.getParameter("size"));
		parcel.setTransType(request.getParameter("transType"));

		if (request.getParameterValues("pickupTimeNow") != null) {
			parcel.setPickupNow(true);
		} else {

			parcel.setPickupTime(request.getParameter("pickupTime"));

		}

		addressFrom.setAddress(request.getParameter("addressFrom"));
		addressFrom.setFullName(request.getParameter("nameFrom"));
		addressFrom.setPhone(request.getParameter("phoneNumberFrom"));
		addressFrom.setEmail(request.getParameter("emailFrom"));

		addressTo.setAddress(request.getParameter("addressTo"));
		addressTo.setFullName(request.getParameter("nameTo"));
		addressTo.setPhone(request.getParameter("phoneNumberTo"));
		addressTo.setEmail(request.getParameter("emailTo"));

		delivery = new Delivery();
		delivery.setAddressFrom(addressFrom);
		delivery.setAddressTo(addressTo);
		delivery.setParcel(parcel);
		
		return delivery;	

	}
	
	public static CardDetails processPaymentForm(HttpServletRequest request) {

		Address addressBill = new Address();

		addressBill.setAddress(request.getParameter("addressBill"));
		addressBill.setFullName(request.getParameter("nameBill"));
		addressBill.setPhone(request.getParameter("phoneBill"));
		addressBill.setEmail(request.getParameter("emailBill"));

		CardDetails cardDetails = new CardDetails();
		cardDetails.setAddressBilling(addressBill);
		cardDetails.setCardNumber(request.getParameter("cardNumber"));
		cardDetails.setDateExpiry(request.getParameter("expiryDate"));
		cardDetails.setSecurityCode(request.getParameter("securityCode"));
		cardDetails.setNameOnCard(request.getParameter("nameCard"));
		
		return cardDetails;
	}

}
