package com.ohgiraffers.response.section01.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/response")
public class ResponseTestServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	      /*
	       * [ Servlet의 역할 ]
	       * 1. 요청 받기 : HTTP method GET/POST 요청에 따라 parameter로 전달받은 데이터 꺼낼 수 있다.
	       * 2. 비즈니스 로직 처리 = DB 접속 및 CRUD 로직 처리 -> Service를 호출하는 쪽으로 해결(MVC)한다.
	       * 3. 응답하기 : 문자열로 동적인 웹(HTML 태그)페이지를 만들고 Stream을 이용해 내보낸다.
	       * */
		
		PrintWriter out = response.getWriter();
		
		System.out.println("default response type: " + response.getContentType());
		System.out.println("default response encoding: " + response.getCharacterEncoding());
		
		response.setContentType("text/html; charset=UTF-8");
		
		StringBuilder responseBuilder = new StringBuilder();
		responseBuilder.append("<!doctype html>\n")
						.append("<html>\n")
						.append("<head>\n")
						.append("</head>\n")
						.append("<body>\n")
						.append("<h1>안녕 Servlet Response!</h1>\n")
						.append("</body>\n")
						.append("</html>");
		
		out.print(responseBuilder.toString());
		
		out.close();
		
	}

}
