package com.mantiso;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/home", "*.do" })
public class SimpleServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");

		if (name != null) {
			resp.getWriter().printf("Hello %s", name);
		} else {
			resp.getWriter().write("Please enter name.");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");

		if (name != null && name.trim() != "") {
			resp.getWriter().printf("Hello %s", name);
		} else {
			//resp.getWriter().write("Please enter name.");
			resp.sendRedirect("index.jsp");
		}
	}
}
