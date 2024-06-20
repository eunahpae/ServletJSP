package com.ohgiraffers.auth.member.controller;

import java.io.IOException;

import com.ohgiraffers.auth.member.model.service.BoardService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/board/delete")
public class BoardDeleteServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		int result = new BoardService().deleteBoard(boardNo);

		response.sendRedirect(request.getContextPath() + "/member/page");
	}

}
