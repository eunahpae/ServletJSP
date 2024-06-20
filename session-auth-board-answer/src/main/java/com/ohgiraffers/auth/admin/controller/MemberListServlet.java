package com.ohgiraffers.auth.admin.controller;

import java.io.IOException;
import java.util.List;

import com.ohgiraffers.auth.admin.model.dto.MemberDTO;
import com.ohgiraffers.auth.admin.model.service.AdminService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/memberList")
public class MemberListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<MemberDTO> memberList = new AdminService().selectMemberList();

		request.setAttribute("memberList", memberList);
		request.getRequestDispatcher("/WEB-INF/views/admin/memberList.jsp").forward(request, response);
	}

}
