package com.ohgiraffers.listener.section03.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/request")
public class RequestListenerTestServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("username", "squirrel");
		request.setAttribute("height", 900);
		
		request.setAttribute("height", 1000);
		
		request.removeAttribute("height");
	}

}
