package com.ohgiraffers.exceptionhandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletMapping;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/showErrorPage")
public class ExceptionHandlerServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Enumeration<String> attrNames = request.getAttributeNames();
		while(attrNames.hasMoreElements()) {
			System.out.println(attrNames.nextElement());
		}
		
        String forwardRequestURI = (String) request.getAttribute("jakarta.servlet.forward.request_uri");
        String forwardContextPath = (String) request.getAttribute("jakarta.servlet.forward.context_path");
        String forwardServletPath = (String) request.getAttribute("jakarta.servlet.forward.servlet_path");
        HttpServletMapping mapping = request.getHttpServletMapping();
        String errorServletName = (String) request.getAttribute("jakarta.servlet.error.servlet_name");
        String errorRequestURI = (String) request.getAttribute("jakarta.servlet.error.request_uri");

        System.out.println(forwardRequestURI);
        System.out.println(forwardContextPath);
        System.out.println(forwardServletPath);
        System.out.println(mapping.getMappingMatch());
        System.out.println(mapping.getPattern());
        System.out.println(mapping.getServletName());
        System.out.println(mapping.getMatchValue());
        System.out.println(errorServletName);
        System.out.println(errorRequestURI);
		
		String errorMessage = (String) request.getAttribute("jakarta.servlet.error.message");
		Integer errorStatusCode = (Integer) request.getAttribute("jakarta.servlet.error.status_code");
		
		StringBuilder responseBuilder = new StringBuilder();
		responseBuilder.append("<!doctype html>\n")
						.append("<html>\n")
						.append("<head>\n")
						.append("</head>\n")
						.append("<body>\n")
						.append("<h1>Error Page</h1>\n")
						.append("<h3>ErrorCode : " + errorStatusCode + "</h3>\n")
						.append("<h3>ErrorMessage : " + errorMessage + "</h3>\n")
						.append("</body>\n")
						.append("</html>");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.print(responseBuilder.toString());
		out.close();
	}

}
