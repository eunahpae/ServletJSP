package com.ohgiraffers.auth.board.controller;

import java.io.IOException;

import com.ohgiraffers.auth.board.model.dto.BoardDTO;
import com.ohgiraffers.auth.board.model.service.BoardService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//TODO 완료 LV.2 > ST.2 > 1. 요청 매핑하기 
@WebServlet("/board/regist")
public class BoardRegistServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO 완료 LV.2 > ST.2 > 3. 등록 페이지로 포와딩 시키기 (views/board/boardRegist.jsp)
		request.getRequestDispatcher("/WEB-INF/views/board/boardRegist.jsp").forward(request, response);
		//TODO 완료 LV.2 > ST.2 > 3+. 등록 페이지(views/board/boardRegist.jsp) 완성시키기
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO 완료 LV.2 > ST.2 > 4. request에서 등록 파라미터를 꺼내서 DTO로 뭉쳐주기
		String boardTitle = request.getParameter("boardTitle");
		String boardWriter = request.getParameter("boardWriter");
		String boardBody = request.getParameter("boardBody");
		
		BoardDTO registBoard = new BoardDTO();	
		registBoard.setBoardTitle(boardTitle);
		registBoard.setBoardWriter(boardWriter);
		registBoard.setBoardBody(boardBody);
				
		//TODO 완료 LV.2 > ST.2 > 5. BoardService의 메소드를 호출하여 게시글 등록하기
		int result = new BoardService().insertBoard(registBoard);
		
		//TODO 완료 LV.2 > ST.2 > 9. 목록 조회 서블릿 호출로 redirect 시키기
		response.sendRedirect(request.getContextPath() + "/board/boardList");
	}

}
