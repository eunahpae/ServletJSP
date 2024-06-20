package com.ohgiraffers.filterwrapper.section01.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

@WebFilter("/first/*")
public class FirstFilter implements Filter {
       
    public FirstFilter() {
    	// 필터는 톰캣을 start하는 시점부터 인스턴스를 미리 생성한다.
    	System.out.println("FirstFilter 기본 생성자 호출");
    }

	public void destroy() {
		// 필터 인스턴스 소멸 시(= 톰캣 서버 종료 시) 호출되는 메소드
		System.out.println("Filter destroy() 메소드 호출");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// Servlet으로 request가 전달되기 전에 요청을 가로채는 역할을 하는 메소드로, doFilter() 호출 전에 filter에서 처리할 코드 작성
		System.out.println("Filter doFilter() 메소드 호출 111");
		
		// filter 처리 이후 다음 필터 또는 Servlet의 doGet/doPost 호출
		chain.doFilter(request, response);
		
		// Servlet 처리 후 수행할 filter 코드 작성
		System.out.println("Filter doFilter() 메소드 호출 222");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// 필터 인스턴스 최초 생성 시 (= 톰캣 서버 start 시) 호출되는 메소드
		System.out.println("Filter init() 메소드 호출");
	}

}
