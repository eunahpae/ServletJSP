package com.ohgiraffers.listener.section02.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/session")
public class SessionListenerTestServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		System.out.println("발급받은 session id : " + session.getId());
		
		session.setAttribute("username", "squirrel");
		session.setAttribute("job", "teacher");
		session.setAttribute("height", 900);
		
		session.setAttribute("username", "Squirrel");
		
		session.removeAttribute("height");
		
		session.setAttribute("member", new MemberDTO("squirrel", "teacher", 900));
		
		session.invalidate();
	}

}
