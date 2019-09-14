package com.wallet.paybill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalclulateElectricityBillServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer previousReading = Integer.valueOf(req.getParameter("previous"));
		Integer currentReading = Integer.valueOf(req.getParameter("current"));
		String state = req.getParameter("state");
		String type = req.getParameter("type");

		Integer rate = (Integer) req.getAttribute("rate");
		int reading = currentReading - previousReading;

		Integer amount = reading * rate;

		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();

		writer.append("Previous reading is = ").append(previousReading.toString()).append("<br>")
				.append("Current reading is = ").append(currentReading.toString()).append("<br>")
				.append("State is = ").append(state).append("<br>")
				.append("Rate for unit = ").append(rate.toString()).append("<br>").append("Bill per this month is = ")
				.append(amount.toString()).append("<br>");
		;

	}
}
