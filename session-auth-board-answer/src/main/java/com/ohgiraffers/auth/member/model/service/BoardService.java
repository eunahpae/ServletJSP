package com.ohgiraffers.auth.member.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ohgiraffers.auth.member.model.dao.BoardDAO;
import com.ohgiraffers.auth.member.model.dto.BoardDTO;

import static com.ohgiraffers.auth.common.mybatis.Template.getSqlSession;

public class BoardService {
	
	private BoardDAO boardDAO;

	public List<BoardDTO> selectBoardList() {
		SqlSession session = getSqlSession();
		boardDAO = session.getMapper(BoardDAO.class);
		
		List<BoardDTO> boardList = boardDAO.selectBoardList();
		
		session.close();
		return boardList;
	}

	public int insertBoard(BoardDTO registBoard) {
		SqlSession session = getSqlSession();
		boardDAO = session.getMapper(BoardDAO.class);
		
		int result = boardDAO.insertBoard(registBoard);
		
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result;
	}

	public BoardDTO selectBoardDetail(int boardNo) {
		SqlSession session = getSqlSession();
		boardDAO = session.getMapper(BoardDAO.class);
		
		BoardDTO boardDetail = boardDAO.selectBoardDetail(boardNo);
		
		session.close();
		
		return boardDetail;
	}

	public int updateBoard(BoardDTO modifyBoard) {
		SqlSession session = getSqlSession();
		boardDAO = session.getMapper(BoardDAO.class);
		
		int result = boardDAO.updateBoard(modifyBoard);
		
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result;
	}

	public int deleteBoard(int boardNo) {
		SqlSession session = getSqlSession();
		boardDAO = session.getMapper(BoardDAO.class);
		
		int result = boardDAO.deleteBoard(boardNo);
		
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result;
	}
	
}
