package com.expressdelivery.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.expressdelivery.Address;
import com.expressdelivery.CardDetails;
import com.expressdelivery.Delivery;
import com.expressdelivery.Parcel;
import com.expressdelivery.UserQueries;

/**
 * Servlet implementation class BaseController
 */

@WebServlet(name = "BaseController", urlPatterns = { "/index", "/order",
		"/payment", "/paymentresult" })
public class BaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BaseController() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String userPath = request.getServletPath();
		HttpSession session;
		Delivery delivery;

		switch (userPath) {

		case "/index":

			getServletContext()
					.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(
							request, response);

			break;

		case "/order":
			getServletContext()
					.getRequestDispatcher("/WEB-INF/views/order.jsp").forward(
							request, response);

			break;

		case "/payment":

			session = request.getSession(true);

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

			session.setAttribute("delivery", delivery);

			getServletContext().getRequestDispatcher(
					"/WEB-INF/views/payment.jsp").forward(request, response);

			break;

		case "/paymentresult":

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

			session = request.getSession(true);
			
			delivery = (Delivery) session.getAttribute("delivery");
			
			session.setAttribute("size", delivery.getParcel().getSize());
			session.setAttribute("transType", delivery.getParcel().getTransType());
			session.setAttribute("pickupTime", delivery.getParcel().getPickupTime());
			session.setAttribute("addressFrom", delivery.getAddressFrom().getAddress());
			session.setAttribute("addressTo", delivery.getAddressTo().getAddress());
			
			delivery.setAddressBilling(addressBill);

			UserQueries query = new UserQueries();
			query.addDelivery(delivery);

			getServletContext().getRequestDispatcher(
					"/WEB-INF/views/paymentresult.jsp").forward(request,
					response);

			/*
			 * request.setAttribute("size", delivery.getParcel().getSize());
			 * request.setAttribute(", o);
			 */

			

			break;

		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String userPath = request.getServletPath();

		switch (userPath) {

		case "/index":

			break;

		case "/order":

			break;

		case "/payment":

			doGet(request, response);

			break;

		case "/paymentresult":

			doGet(request, response);

			break;

		}

	}
	
	public void displayFormData(HttpServletResponse response, Delivery delivery, CardDetails cardDetails) throws ServletException, IOException {
		   
		 PrintWriter out = response.getWriter();
		 out.println(delivery.getAddressTo().getAddress());
		 out.println(delivery.getAddressTo().getEmail());
		 out.println(delivery.getAddressTo().getFullName());
		 out.println(delivery.getAddressTo().getPhone());
		  
		 out.println(delivery.getAddressFrom().getAddress());
		 out.println(delivery.getAddressFrom().getEmail());
		 out.println(delivery.getAddressFrom().getFullName());
		 out.println(delivery.getAddressFrom().getPhone());
		  
		 
		 out.println(delivery.getAddressBilling().getAddress());
		 out.println(delivery.getAddressBilling().getEmail());
		 out.println(delivery.getAddressBilling().getFullName());
		 out.println(delivery.getAddressBilling().getPhone());
		 
		 out.println(delivery.getParcel().getPickupTime());
		 out.println(delivery.getParcel().isPickupNow());
		  
		 out.println(delivery.getParcel().getPrice());
		 out.println(delivery.getParcel().getSize());
		 out.println(delivery.getParcel().getTransType());
		  
		 out.println(cardDetails.getCardNumber());
		 out.println(cardDetails.getDateExpiry());
		 out.println(cardDetails.getNameOnCard());
		 out.println(cardDetails.getSecurityCode());
		 
		
	}


}
