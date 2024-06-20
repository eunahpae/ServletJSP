package com.ohgiraffers.auth.admin.controller;

import java.io.IOException;
import java.util.List;

import com.ohgiraffers.auth.admin.model.service.AdminService;
import com.ohgiraffers.auth.member.model.dto.MemberDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// TODO 완료 1. 요청 처리를 위한 url-mapping
@WebServlet("/admin/memberList")
public class MemberListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO 완료 2. AdminService의 메소드를 호출하여 MemberList 반환받는 코드
		List<MemberDTO> memberList = new AdminService().selectMemberList();

		// TODO 완료 8. 서비스로부터 반환받은 memberList를 request attribute로 추가하고
		// views/admin/memberList.jsp 페이지로 포와딩
		request.setAttribute("memberList", memberList);
		request.getRequestDispatcher("/WEB-INF/views/admin/memberList.jsp").forward(request, response);

		// TODO 완료 8+. 포와딩 받은 페이지에서 el, jstl 활용하여 화면에 출력되게끔 작성
	}

}
