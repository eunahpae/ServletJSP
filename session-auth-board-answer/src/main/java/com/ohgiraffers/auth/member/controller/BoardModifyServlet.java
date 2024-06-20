package com.ohgiraffers.auth.member.controller;

import java.io.IOException;

import com.ohgiraffers.auth.member.model.dto.BoardDTO;
import com.ohgiraffers.auth.member.model.service.BoardService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/board/modify")
public class BoardModifyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		BoardDTO boardDetail = new BoardService().selectBoardDetail(boardNo);
		
		request.setAttribute("boardDetail", boardDetail);
		request.getRequestDispatcher("/WEB-INF/views/member/boardModify.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String boardTitle = request.getParameter("boardTitle");
		String boardBody = request.getParameter("boardBody");
		
		BoardDTO modifyBoard = new BoardDTO();
		modifyBoard.setBoardNo(boardNo);
		modifyBoard.setBoardTitle(boardTitle);
		modifyBoard.setBoardBody(boardBody);
		
		int result = new BoardService().updateBoard(modifyBoard);
		
		response.sendRedirect(request.getContextPath() + "/board/detail?boardNo=" + boardNo);
	}

}
