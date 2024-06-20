package com.ohgiraffers.auth.board.controller;

import java.io.IOException;

import com.ohgiraffers.auth.board.model.dto.BoardDTO;
import com.ohgiraffers.auth.board.model.service.BoardService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//TODO 완료 LV.2 > ST.4 > 1. 요청 매핑하기 
@WebServlet("/board/modify")
public class BoardModifyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
        BoardDTO boardDetail = new BoardService().selectBoardDetail(boardNo);
        request.setAttribute("boardDetail", boardDetail);
		// TODO 완료 LV.2 > ST.4 > 3. 수정 페이지로 포와딩 시키기 (views/member/boardModify.jsp)
		request.getRequestDispatcher("/WEB-INF/views/board/boardModify.jsp").forward(request, response);
		// TODO 완료 LV.2 > ST.4 > 3+. 수정 페이지(views/board/boardModify.jsp) 완성시키기
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO 완료 LV.2 > ST.4 > 4. request에서 수정 파라미터를 꺼내서 DTO로 뭉쳐주기
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String boardTitle = request.getParameter("boardTitle");
		String boardBody = request.getParameter("boardBody");

		BoardDTO modifyBoard = new BoardDTO();
		modifyBoard.setBoardNo(boardNo);
		modifyBoard.setBoardTitle(boardTitle);
		modifyBoard.setBoardBody(boardBody);

		// TODO 완료 LV.2 > ST.4 > 5. BoardService의 메소드를 호출하여 게시글 수정하기
		int result = new BoardService().updateBoard(modifyBoard);

		// TODO 완료 LV.2 > ST.4 > 9. 상세 조회 서블릿 호출로 redirect 시키기
		if (result > 0) {
            response.sendRedirect(request.getContextPath() + "/board/detail?boardNo=" + boardNo);
        } else {
            // Handle the case where the update fails
            request.setAttribute("message", "게시물 수정에 실패했습니다.");
            request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
        }
	}
}
