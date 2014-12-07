package com.expressdelivery.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.expressdelivery.database.AdminQueries;
import com.expressdelivery.database.DeliveryQueries;
import com.expressdelivery.model.Admin;
import com.expressdelivery.model.Delivery;
import com.expressdelivery.model.businesslogic.LogIn;

/**
 * Servlet implementation class AdminController
 */
@WebServlet(name = "AdminController", urlPatterns = { "/login", "/admin" })
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String userPath = request.getServletPath();
		HttpSession session;

		switch (userPath) {

		case "/login":

			getServletContext().getRequestDispatcher(
					"/WEB-INF/views/admin/login.jsp")
					.forward(request, response);

			break;

		case "/admin":		

			session = request.getSession(true);			
			
			boolean loggedIn = LogIn.checkLogIn(request) ;

			if (loggedIn)

			{
				DeliveryQueries query = new DeliveryQueries();

				ArrayList<Delivery> deliveries;

				deliveries = query.getAllDeliveries();

				session.setAttribute("deliveries", deliveries);

				getServletContext().getRequestDispatcher(
						"/WEB-INF/views/admin/admin.jsp").forward(request,
						response);

			}

			else {

					getServletContext().getRequestDispatcher("/login").forward(
							request, response);
			}

			break;

		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String userPath = request.getServletPath();
		HttpSession session;

		switch (userPath) {

		case "/login":

			doGet(request, response);
			break;

		case "/admin":

			if (request.getParameter("orderInList") != null) {
				int id = Integer.parseInt(request.getParameter("orderInList"));
				session = request.getSession(true);

				ArrayList<Delivery> deliveries;
				deliveries = (ArrayList<Delivery>) session
						.getAttribute("deliveries");

				int databaseId = deliveries.get(id).getDatabaseId();

				DeliveryQueries query = new DeliveryQueries();
				query.deleteDelivery(databaseId);

			}

			doGet(request, response);

			break;

		}

	}
	
	

}
