package com.ohgiraffers.auth.member.controller;

import java.io.IOException;
import java.util.List;

import com.ohgiraffers.auth.member.model.dto.BoardDTO;
import com.ohgiraffers.auth.member.model.service.BoardService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/member/page")
public class MemberPageServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<BoardDTO> boardList = new BoardService().selectBoardList();
		
		request.setAttribute("boardList", boardList);
		request.getRequestDispatcher("/WEB-INF/views/member/page.jsp").forward(request, response);
	}

}
