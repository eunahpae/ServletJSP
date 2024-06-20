package com.eunah.project.board.model.service;

import static com.eunah.project.common.mybatis.Template.getSqlSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.eunah.project.board.model.dao.BoardDAO;
import com.eunah.project.board.model.dto.BoardDTO;
import com.eunah.project.common.paging.SelectCriteria;

public class BoardService {
	
	private BoardDAO boardDAO;
	
	/* 페이징 처리를 위한 전체 게시물 수 조회용 메소드 */
	public int selectTotalCount(Map<String, String> searchMap) {
		
		SqlSession session = getSqlSession();
		boardDAO = session.getMapper(BoardDAO.class);
		
		int totalCount = boardDAO.selectTotalCount(searchMap);
		
		session.close();
		
		return totalCount;
	}
	
	/* 게시물 전체 조회용 메소드 */
	public List<BoardDTO> selectBoardList(SelectCriteria selectCriteria) {
		
		SqlSession session = getSqlSession();
		boardDAO = session.getMapper(BoardDAO.class);
		
		selectCriteria.setStartRow(selectCriteria.getStartRow() - 1);
		
		List<BoardDTO> boardList = boardDAO.selectBoardList(selectCriteria);
		
		session.close();
		
		return boardList;
	}
	
	/* 신규 게시물 등록용 메소드 */
	public int insertBoard(BoardDTO newBoard) {
		
		SqlSession session = getSqlSession();
		boardDAO = session.getMapper(BoardDAO.class);
		
		int result = boardDAO.insertBoard(newBoard);
		
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result;
	}
	
	public BoardDTO selectBoardDetail(int no) {
	    try (SqlSession session = getSqlSession()) {
	        BoardDAO boardDAO = session.getMapper(BoardDAO.class);
	        System.out.println(no);
	        return boardDAO.selectBoardDetail(no);
	    } catch (Exception e) {
	        e.printStackTrace(); // Log the exception
	        throw new RuntimeException("게시물 조회 중 오류 발생", e); // Or handle the exception appropriately
	    }
	}
	
}
