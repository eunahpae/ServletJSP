package com.ohgiraffers.auth.member.controller;

import java.io.IOException;

import com.ohgiraffers.auth.member.model.dto.BoardDTO;
import com.ohgiraffers.auth.member.model.service.BoardService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/board/detail")
public class BoardDetailServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		BoardDTO boardDetail = new BoardService().selectBoardDetail(boardNo);
		
		request.setAttribute("boardDetail", boardDetail);
		request.getRequestDispatcher("/WEB-INF/views/member/boardDetail.jsp").forward(request, response);
	}

}
