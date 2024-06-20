package com.ohgiraffers.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/delete")
public class DeleteSessionServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Enumeration<String> sessionNames = session.getAttributeNames();
		while(sessionNames.hasMoreElements()) {
			System.out.println(sessionNames.nextElement());
		}
		
		/*
		 * [ 세션 데이터 지우는 법 ]
		 * 1. 설정한 만료 시간이 지나면 세션이 만료된다.
		 * 2. removeAttribute()로 session의 Attribute를 지운다.
		 * 3. invalidate()를 호출하면 세션의 모든 데이터가 제거된다.
		 * */
		
		System.out.println("----------------------------------------");
		session.removeAttribute("firstName");
		
		sessionNames = session.getAttributeNames();
		while(sessionNames.hasMoreElements()) {
			System.out.println(sessionNames.nextElement());
		}
		
		System.out.println("----------------------------------------");
		// invalidate()를 호출하면 세션 자체를 무효화하는 것이므로 이후 세션을 이용하려고 하면 에러가 발생한다.
		// 즉, 세션 내 데이터를 지울 뿐 아니라 세션 자체를 강제로 만료시켰다고 볼 수 있다.
		session.invalidate();
		
		sessionNames = session.getAttributeNames();
		while(sessionNames.hasMoreElements()) {
			System.out.println(sessionNames.nextElement());
		}
	}

}
