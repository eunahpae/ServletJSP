package com.eunah.project.common.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

public class EncodingFilter implements Filter {
	
	private String encodingType;
	
	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest hrequest = (HttpServletRequest) request;
		if("POST".equals(hrequest.getMethod())) {
			request.setCharacterEncoding(encodingType);
			System.out.println("변경된 인코딩 타입 : " + request.getCharacterEncoding());
		}
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		/* xml에 설정한 init-param의 key를 이용하여 fConfig에서 값을 꺼내올 수 있다. */
		encodingType = fConfig.getInitParameter("encoding-type");
	}

}
