package com.ohgiraffers.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/session")
public class SessionHandleServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		System.out.println(firstName + lastName);
		
		HttpSession session = request.getSession();
		
		System.out.println("session 유지 시간 default : " + session.getMaxInactiveInterval());
		session.setMaxInactiveInterval(60 * 10);
		
		System.out.println("session id : " + session.getId());
		
		session.setAttribute("firstName", firstName);
		session.setAttribute("lastName", lastName);
		
		response.sendRedirect("redirect");		
		
	}

}
