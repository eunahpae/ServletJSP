package com.ohgiraffers.parameter.section01.querystring;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/querystring")
public class QueryStringTestServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		System.out.println("이름: " + name);
		
		int age = Integer.parseInt(request.getParameter("age"));
		System.out.println("나이: " + age);
		
		java.sql.Date birthday = java.sql.Date.valueOf(request.getParameter("birthday"));
		System.out.println("생일: " + birthday);
		
		String gender = request.getParameter("gender");
		System.out.println("성별: " + gender);
		
		String national = request.getParameter("national");
		System.out.println("국적: " + national);
		
		String[] hobbies = request.getParameterValues("hobbies");
		System.out.print("취미: ");
		for(String hobby : hobbies) {
			System.out.println(hobby + " ");
		}
	}

}
