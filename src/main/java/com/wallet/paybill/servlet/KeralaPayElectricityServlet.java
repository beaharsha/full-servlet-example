package com.wallet.paybill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class KeralaPayElectricityServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String type = req.getParameter("type");
		Integer ratePerUnit = 0;
		ratePerUnit = Integer.valueOf(getServletConfig().getInitParameter("ratePerUnit")); // reading config values

		if (req.getParameter("type").equalsIgnoreCase("commercial")) {
			ratePerUnit = Integer.valueOf(getServletContext().getInitParameter("ratePerUnitCommericial"));
		}
		req.setAttribute("rate", ratePerUnit);

		RequestDispatcher dispatcher = req.getRequestDispatcher("calculate");
		dispatcher.include(req, resp);

		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();

		writer.append("Please pay ").append(type).append(" bill online or offiline before 20th of this month");
	}
}
