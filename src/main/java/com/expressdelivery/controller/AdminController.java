package com.expressdelivery.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.expressdelivery.AdminQueries;

/**
 * Servlet implementation class AdminController
 */
@WebServlet(name = "/AdminController", urlPatterns = { "/login", "/admin" })
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

			AdminQueries queries = new AdminQueries();

			session = request.getSession(true);
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			// TODO Check with session variable if logged in
			// response.getWriter().println(username + " " + password + " " +
			// queries.checkLoginCred(username, password));

			if (queries.checkLoginCred(username, password))

				getServletContext().getRequestDispatcher(
						"/WEB-INF/views/admin/admin.jsp").forward(request,
						response);

			else
				getServletContext().getRequestDispatcher("/login").forward(
						request, response);

			break;

		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String userPath = request.getServletPath();

		switch (userPath) {

		case "/login":
			doGet(request, response);
			break;

		case "/admin":
			doGet(request, response);
			break;

		}

	}

}
