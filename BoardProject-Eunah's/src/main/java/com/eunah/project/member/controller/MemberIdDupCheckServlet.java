package com.eunah.project.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.javassist.bytecode.Descriptor.Iterator;

import com.eunah.project.member.model.service.MemberService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/member/checkid")
public class MemberIdDupCheckServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memberId = request.getParameter("memberId");

		int result = new MemberService().checkDupMemberId(memberId);
        
        String output = "";

        if(result > 0) {
        	output = "duplication";
        } else {
        	output = "pass";
        }

        response.setContentType("text/plain; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(output);

        out.flush();
        out.close();
	}

}
