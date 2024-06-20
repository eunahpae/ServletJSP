package com.ohgiraffers.auth.board.controller;

import java.io.IOException;

import com.ohgiraffers.auth.board.model.service.BoardService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//TODO LV.2 > ST.5 > 1. 요청 매핑하기 
@WebServlet("/board/delete")
public class BoardDeleteServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO LV.2 > ST.5 > 3. request의 파라미터로 받은 boardNo 가져오기
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		//TODO LV.2 > ST.5 > 4. 받아온 boardNo를 넘겨주며 BoardService 삭제 메소드를 호출하기
		int result = new BoardService().deleteBoard(boardNo);
		
		//TODO LV.2 > ST.5 > 8. 목록조회 servlet으로 리다이렉트
		response.sendRedirect(request.getContextPath() + "/board/boardList");
	}

}
