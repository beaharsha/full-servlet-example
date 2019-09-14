package com.wallet.paybill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myapp.firstservlet.model.User;
import com.myapp.firstservlet.repo.UserDetailsRepo;

@WebServlet(urlPatterns = "/saveuser")
public class UserRegistrationServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("username");
		String userId = req.getParameter("userid").toUpperCase();
		String password = req.getParameter("userpassword");

		User user = new User(userId, name, password);

		UserDetailsRepo detailsRepo = UserDetailsRepo.getInstane();

		boolean flag = detailsRepo.saveUser(user);

		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		if (flag) {
			writer.append("User saved successfully").append("<br>")
			.append("<a href=\"login.html\" >").append("Login Here</a>");
			
		} else {
			writer.append("User already existed. Try with another user id");
		}
		
	}
}
