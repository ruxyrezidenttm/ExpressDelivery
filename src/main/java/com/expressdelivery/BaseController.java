package com.expressdelivery;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BaseController
 */
@WebServlet(name = "BaseController", urlPatterns = { "/index", "/order",
		"/payment", "/paymentresult", "/login" })
public class BaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BaseController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String userPath = request.getServletPath();
		
		switch(userPath) {
		
		case "/index":
			
			getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request,
					response);
			
			break;
			
		case "/order":
			getServletContext().getRequestDispatcher("/WEB-INF/views/order.jsp").forward(request,
					response);
			
			break;
		
		case "/payment":
			
			getServletContext().getRequestDispatcher("/WEB-INF/views/payment.jsp").forward(request,
					response);
			
			break;
			
		case "/paymentresult":
			
			getServletContext().getRequestDispatcher("/WEB-INF/views/paymentresult.jsp").forward(request,
					response);
			
			break;
			
		case "/login":
			
			getServletContext().getRequestDispatcher("/WEB-INF/views/admin/login.jsp").forward(request,
					response);
			
			break;
			
		}
		

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
