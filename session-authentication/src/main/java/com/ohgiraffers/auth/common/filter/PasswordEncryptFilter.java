package com.ohgiraffers.auth.common.filter;

import java.io.IOException;

import com.ohgiraffers.auth.common.wrapper.EncryptRequestWrapper;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;

@WebFilter("/member/*")
public class PasswordEncryptFilter extends HttpFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest hrequest = (HttpServletRequest) request;
		
		String uri = hrequest.getRequestURI();
		System.out.println("[Filter] requestURI : " + uri);
		
		String intent = uri.substring(uri.lastIndexOf("/"));
		System.out.println("[Filter] intent : " + intent);
		
		if(!"/login".equals(intent)) {
			EncryptRequestWrapper wrapper = new EncryptRequestWrapper(hrequest);
			chain.doFilter(wrapper, response);
		} else {
			chain.doFilter(request, response);		
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
