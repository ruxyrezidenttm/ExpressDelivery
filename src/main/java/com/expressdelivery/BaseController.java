package com.expressdelivery;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class BaseController
 */

@WebServlet(name = "BaseController", urlPatterns = { "/index", "/order",
		"/payment", "/paymentresult", "/login", "/admin" })

public class BaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Connection database;

	public BaseController() {
		super();

	}

	@Override
	public void init() throws ServletException {
		super.init();
		
		ConnectToDB connector = new ConnectToDB();
		database = connector.getDatabase();

		
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

			/*
			 * size = request.getParameter("size");
			 * 
			 * transType = request.getParameter("transport");
			 * 
			 * pickUpNow = request.getParameter("pickupTimeNow");
			 * 
			 * pickUpTime = request.getParameter("pickupTime"); addressFrom =
			 * request.getParameter("address"); nameFrom =
			 * request.getParameter("fullName"); phoneFrom =
			 * request.getParameter("phoneNumber"); emailFrom =
			 * request.getParameter("email");
			 * 
			 * PrintWriter out = response.getWriter(); out.println(nameFrom);
			 */

			/*
			 * request.setAttribute("size", size);
			 * request.setAttribute("nameFrom", nameFrom);
			 */

			session = request.getSession(true);

			
			Address addressTo = new Address();
			Address addressFrom = new Address();
			Parcel parcel = new Parcel();
			
			parcel.setSize(request.getParameter("size"));
			parcel.setTransType(request.getParameter("transType"));
			
			session.setAttribute("size", request.getParameter("size"));
			session.setAttribute("transType", request.getParameter("transType"));
			
			if (request.getParameterValues("pickupTimeNow") != null)
				session.setAttribute("pickupTime", "now");
			else
				session.setAttribute("pickupTime",
					request.getParameter("pickupTime"));
			

			if (request.getParameterValues("pickupTimeNow") != null)
				session.setAttribute("pickupTime", "now");
			else
				session.setAttribute("pickupTime",
						request.getParameter("pickupTime"));
			
			addressFrom.setAddress(request.getParameter("addressFrom"));
			addressFrom.setFullName(request.getParameter("nameFrom"));
			addressFrom.setPhone(request.getParameter("phoneNumberFrom"));
			addressFrom.setEmail(request.getParameter("emailFrom"));
			

			session.setAttribute("addressFrom",
					request.getParameter("addressFrom"));
			session.setAttribute("nameFrom", request.getParameter("nameFrom"));
			session.setAttribute("phoneNumberFrom",
					request.getParameter("phoneNumberFrom"));
			session.setAttribute("emailFrom", request.getParameter("emailFrom"));
			
			addressTo.setAddress(request.getParameter("addressTo"));
			addressTo.setFullName(request.getParameter("nameTo"));
			addressTo.setPhone(request.getParameter("phoneNumberTo"));
			addressTo.setEmail(request.getParameter("emailTo"));

			session.setAttribute("addressTo", request.getParameter("addressTo"));
			session.setAttribute("nameTo", request.getParameter("nameTo"));
			session.setAttribute("phoneNumberTo",
					request.getParameter("phoneNumberTo"));
			session.setAttribute("emailTo", request.getParameter("emailTo"));
			session.setAttribute("database", database);
			
			delivery = new Delivery();
			delivery.setAddressFrom(addressFrom);
			delivery.setAddressTo(addressTo);
			delivery.setParcel(parcel);
			
			session.setAttribute("delivery", delivery);

			getServletContext().getRequestDispatcher(
					"/WEB-INF/views/payment.jsp").forward(request, response);

			break;

		case "/paymentresult":

			getServletContext().getRequestDispatcher(
					"/WEB-INF/views/paymentresult.jsp").forward(request,
					response);
			
			session = request.getSession(true);
			delivery = (Delivery) session.getAttribute("delivery");

			break;

		case "/login":

			getServletContext().getRequestDispatcher(
					"/WEB-INF/views/admin/login.jsp")
					.forward(request, response);
			
			
			
			break;
			
		case "/admin":
			
		/*	ConnectToDB connector = new ConnectToDB();
			Connection database = connector.getDatabase();*/
			
			AdminQueries queries = new AdminQueries(database);
			
			session = request.getSession(true);
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			//TODO Check with session variable if logged in
			//response.getWriter().println(username + " " + password);
			
			if(queries.checkLoginCred(username,password))

			getServletContext().getRequestDispatcher(
					"/WEB-INF/views/admin/admin.jsp")
					.forward(request, response);
			
			else
				getServletContext().getRequestDispatcher("/login").forward(request, response);

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

		case "/login":
			doGet(request, response);
			break;
			
		case "/admin":
			doGet(request, response);
			break;

		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		try {
			database.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
