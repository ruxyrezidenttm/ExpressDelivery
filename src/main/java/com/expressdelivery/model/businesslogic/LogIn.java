package com.expressdelivery.model.businesslogic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.expressdelivery.model.bean.Admin;
import com.expressdelivery.model.dao.AdminDao;
import com.expressdelivery.model.database.AdminQueries;

public class LogIn {

	public static boolean checkLogIn(HttpServletRequest request) {

		HttpSession session = request.getSession(true);

		if (session.getAttribute("loggedIn") == null) {

			String username = request.getParameter("username");
			String password = request.getParameter("password");

			AdminDao queries = new AdminQueries();
			Admin admin = queries.getAdmin(username);

			if (admin.getPassword() == null)
				return false;
			else {

				if (admin.getPassword().equals(password)) {
					session.setAttribute("loggedIn", true);
					return true;
				} else {
					session.setAttribute("loggedIn", null);
					return false;
				}
			}
		}

		return true;

	}

}
