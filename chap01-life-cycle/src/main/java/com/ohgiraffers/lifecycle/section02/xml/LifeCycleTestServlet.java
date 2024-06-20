package com.ohgiraffers.lifecycle.section02.xml;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LifeCycleTestServlet extends HttpServlet {
	
	private int initCount = 1;
	private int serviceCount = 1;
	private int destroyCount = 1;
	
	public LifeCycleTestServlet() {
		// 기본 생성자
		System.out.println("xml mapping 생성자 호출");
	}
	
	public void init(ServletConfig config) throws ServletException {
		// 서블릿 컨테이너에 의해 호출되며, 최초 요청 시 한 번만 실행하고 두 번째 요청부터는 호출하지 않음
		System.out.println("xml mapping init() 메소드 호출 : " + initCount++);
	}

	public void destroy() {
		// 서블릿 컨테이너가 종료될 때 호출되는 메소드이며, 주로 자원 반납 용도로 사용함
		System.out.println("xml mapping destroy() 메소드 호출 : " + destroyCount++);
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 서블릿 컨테이너에 의해 호출되며 최초 요청 시에는 init() 이후에 동작하고,
		// 두 번째 요청부터는 init() 호출 없이 service() 메소드가 바로 호출됨
		System.out.println("xml mapping service() 메소드 호출 : " + serviceCount++);
	}

}
