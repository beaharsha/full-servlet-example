package com.wallet.paybill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myapp.firstservlet.model.User;
import com.myapp.firstservlet.repo.UserDetailsRepo;

@WebServlet("/login")
public class UserLoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("userid").toUpperCase();
		String password = req.getParameter("password");
		
		UserDetailsRepo detailsRepo = UserDetailsRepo.getInstane();
		
		User user = detailsRepo.getUser(userId, password);
		
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		
		if(user == null) {
			writer.append("User Not found. Please Register").append("<br>")
			.append("<a href=\"user-registration.html\" >").append("Register Here</a>");
		}
		else {
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			writer.append("Welcome "+user.getName());
			writer.append("<a href= \"current_bill.html \" > ").append("Ts Electricity Bill click  Here</a>");
		}
	}
}
