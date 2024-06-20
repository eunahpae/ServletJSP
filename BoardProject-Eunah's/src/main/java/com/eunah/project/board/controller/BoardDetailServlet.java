package com.eunah.project.board.controller;

import java.io.IOException;

import com.eunah.project.board.model.dto.BoardDTO;
import com.eunah.project.board.model.service.BoardService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/board/detail")
public class BoardDetailServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String no = request.getParameter("no");
    	if (no == null || no.isEmpty()) {
    	    response.sendRedirect(request.getContextPath() + "/board/list");
    	    return;
    	}

    	BoardService boardService = new BoardService();
    	BoardDTO board = boardService.selectBoardDetail(Integer.parseInt(no));

        String path = "";
        if (board != null) {      
            path = "/WEB-INF/views/board/boardDetail.jsp";
            request.setAttribute("board", board);
        } else {
            path = "/WEB-INF/views/common/failed.jsp";
            request.setAttribute("message", "게시물 조회 실패!");
        }

        request.getRequestDispatcher(path).forward(request, response);
    }
}
