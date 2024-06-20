package com.ohgiraffers.auth.member.controller;

import java.io.IOException;

import com.ohgiraffers.auth.member.model.dto.BoardDTO;
import com.ohgiraffers.auth.member.model.service.BoardService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/board/regist")
public class BoardRegistServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/member/boardRegist.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardTitle = request.getParameter("boardTitle");
		String boardWriter = request.getParameter("boardWriterMemberNo");
		String boardBody = request.getParameter("boardBody");
		
		BoardDTO registBoard = new BoardDTO();
		registBoard.setBoardTitle(boardTitle);
		registBoard.setBoardWriter(boardWriter);
		registBoard.setBoardBody(boardBody);
		
		int result = new BoardService().insertBoard(registBoard);
		
		response.sendRedirect(request.getContextPath() + "/member/page");
	}

}
