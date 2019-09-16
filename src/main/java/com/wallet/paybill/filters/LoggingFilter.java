package com.wallet.paybill.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myapp.firstservlet.model.User;

@WebFilter(urlPatterns = {"/tspayelectricity", "/keralapayelectricity"})
public class LoggingFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println();

		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		HttpSession session = httpServletRequest.getSession();
		Object object = session.getAttribute("user");
		User user = (User) object;
		System.out.println("request from ");
		chain.doFilter(httpServletRequest, httpServletResponse);
		System.out.println("Request completed ");
	}
}
