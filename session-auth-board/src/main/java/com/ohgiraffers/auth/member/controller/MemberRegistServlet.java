package com.ohgiraffers.auth.member.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.ohgiraffers.auth.member.model.dto.MemberDTO;
import com.ohgiraffers.auth.member.model.service.MemberService;

@WebServlet("/member/regist")
public class MemberRegistServlet extends HttpServlet {

	// 회원가입 버튼 클릭 시 get 요청으로 받아 회원가입 form 으로 포워딩하는 메소드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/WEB-INF/views/member/regist.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

	// 회원가입 form 작성 후 post 요청으로 받아 회원가입을 처리하는 메소드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("memberId");
		String memberPwd = request.getParameter("memberPwd");
		String memberName = request.getParameter("memberName");
		String memberRole = request.getParameter("memberRole");
		
		MemberDTO requestMember = new MemberDTO();
		requestMember.setMemberId(memberId);
		requestMember.setMemberPwd(memberPwd);
		requestMember.setMemberName(memberName);
		requestMember.setMemberRole(memberRole);
		System.out.println("[MemberRegistController] requestMember: " + requestMember);
		
		int result = new MemberService().registMember(requestMember);
		
		String page = "";
		
		if(result > 0) {
			page = "/WEB-INF/views/main/main.jsp";
		} else {
			page = "/WEB-INF/views/auth/fail.jsp";
			request.setAttribute("code", "regist");
			request.setAttribute("message", "회원가입에 실패하였습니다 :(");
		}
		
		request.getRequestDispatcher(page).forward(request, response);
	}

}
