package com.ohgiraffers.auth.board.controller;

import java.io.IOException;
import java.util.List;

import com.ohgiraffers.auth.board.model.dto.BoardDTO;
import com.ohgiraffers.auth.board.model.service.BoardService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/board/boardList")
public class BoardPageServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO 완료 LV.2 > ST.1 > 1. BoardService의 메소드를 호출하여 boardList를 반환받기
		// TODO 완료 LV.2 > ST.1 > 1+. boardList를 반환받기 위한 BoardDTO 작성하기
		List<BoardDTO> boardList = new BoardService().selectBoardList();
		
		// TODO 완료 LV.2 > ST.1 > 6. boardList를 request의 attribute로 추가하여 포와딩하기 
		request.setAttribute("boardList", boardList);
		request.getRequestDispatcher("/WEB-INF/views/board/boardList.jsp").forward(request, response);
		
		// TODO 완료 LV.2 > ST.1 > 7. views/board/boardList.jsp 를 수정하여 조회한 게시판 목록이 보여지게 하기
	}

}
