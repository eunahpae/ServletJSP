package com.eunah.project.member.controller;

import java.io.IOException;

import com.eunah.project.member.model.dto.MemberDTO;
import com.eunah.project.member.model.service.MemberService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/member/delete")
public class MemberDeleteServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDTO loginMember = (MemberDTO) request.getSession().getAttribute("loginMember");
		
		int result = new MemberService().removeMember(loginMember);
		
		String page = "";
		if(result > 0) {
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", null);
			
			page = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "deleteMember");
		} else {
			page = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "회원 탈퇴 실패!");
		}
		
		request.getRequestDispatcher(page).forward(request, response);
	}

}
