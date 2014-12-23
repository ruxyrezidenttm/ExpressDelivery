package com.expressdelivery.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.expressdelivery.model.bean.CardDetails;
import com.expressdelivery.model.bean.Delivery;
import com.expressdelivery.model.businesslogic.CardPayment;
import com.expressdelivery.model.businesslogic.CardPaymentInterface;
import com.expressdelivery.model.businesslogic.PriceCalculator;
import com.expressdelivery.model.businesslogic.ProcessFormData;
import com.expressdelivery.model.dao.DeliveryDao;
import com.expressdelivery.model.database.DeliveryQueries;

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
			
			delivery = ProcessFormData.processOrderForm(request);
			
			delivery.getParcel().setPrice(PriceCalculator.price(delivery));			
			
			session.setAttribute("delivery", delivery);	
			
			getServletContext().getRequestDispatcher(
					"/WEB-INF/views/payment.jsp").forward(request, response);

			break;

		case "/paymentresult":
		
			session = request.getSession(true);

			delivery = (Delivery) session.getAttribute("delivery");

		    CardDetails cardDetails = ProcessFormData.processPaymentForm(request);
		    
		    CardPaymentInterface pay = new CardPayment();
		    
		    pay.payWithCard(cardDetails);
			
			delivery.setAddressBilling(cardDetails.getAddressBilling());
			
			DeliveryDao query = new DeliveryQueries();
			query.addDelivery(delivery);
			displayFormData(response, delivery, cardDetails);
			
			BackgroundServicesController.getSendEmail().sendEmail(delivery);
			BackgroundServicesController.getTracking().addTrack(delivery);
			
			session.setAttribute("size", delivery.getParcel().getSize());
			session.setAttribute("transType", delivery.getParcel().getTransType());
			session.setAttribute("pickupTime", delivery.getParcel().getPickupTime());
			session.setAttribute("addressFrom", delivery.getAddressFrom()
					.getAddress());
			session.setAttribute("addressTo", delivery.getAddressTo().getAddress());
			
			

			getServletContext().getRequestDispatcher(
					"/WEB-INF/views/paymentresult.jsp").forward(request,
					response);

			
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
	
	
	
	/* Test function used to check if data is coming from the forms */
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		BackgroundServicesController.startSendEmail();
		BackgroundServicesController.startTracking();
	}

	private void displayFormData(HttpServletResponse response, Delivery delivery, CardDetails cardDetails) throws ServletException, IOException {
		   
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
