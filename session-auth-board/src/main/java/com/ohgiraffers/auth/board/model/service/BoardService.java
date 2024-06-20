package com.ohgiraffers.auth.board.model.service;

import static com.ohgiraffers.auth.common.mybatis.Template.getSqlSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ohgiraffers.auth.board.model.dao.BoardDAO;
import com.ohgiraffers.auth.board.model.dto.BoardDTO;

public class BoardService {

	// TODO 완료 LV.2 > ST.1 > 2. BoardDAO 필드 선언
	private BoardDAO boardDAO;

	// TODO 완료 LV.2 > ST.1 > 3. BoardList를 조회하는 서비스 로직 작성
	public List<BoardDTO> selectBoardList() {
		// 3-1) SqlSession 얻기
		SqlSession session = getSqlSession();
		// 3-2) mapper 얻기
		boardDAO = session.getMapper(BoardDAO.class);
		// 3-3) 메소드 호출해서 BoardList 반환받기
		List<BoardDTO> boardList = boardDAO.selectBoardList();
		// 3-4) 자원 반납
		session.close();
		// 3-5) boardList 반환하기
		return boardList;
	}

	// TODO 완료 LV.2 > ST.2 > 6. BoardDTO를 등록하는 서비스 로직 작성
	public int insertBoard(BoardDTO registBoard) {
		// 6-1) SqlSession 얻기
		SqlSession session = getSqlSession();
		// 6-2) mapper 얻기
		boardDAO = session.getMapper(BoardDAO.class);
		// 6-3) 메소드 호출해서 BoardDTO 등록하기
		int result = boardDAO.insertBoard(registBoard);
		// 6-4) 등록 결과에 따른 commit, rollback 처리 후 자원 반납
		if (result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		// 6-5) 자원 반납
		session.close();
		// 6-6) 결과 int로 반환하기
		return result;
	}

	// TODO 완료 LV.2 > ST.3 > 5. BoardDTO를 조회하는 서비스 로직 작성
	public BoardDTO selectBoardDetail(int boardNo) {
		// 5-1) SqlSession 얻기
		SqlSession session = getSqlSession();
		// 5-2) mapper 얻기
		boardDAO = session.getMapper(BoardDAO.class);
		// 5-3) 메소드 호출해서 BoardDTO 조회하기
		BoardDTO boardDetail = boardDAO.selectBoardDetail(boardNo);
		// 5-4) 자원 반납
		session.close();
		// 5-5) 결과 반환하기
		return boardDetail;
	}

	// TODO 완료 LV.2 > ST.4 > 6. 대상 게시글 정보를 수정하는 서비스 로직 작성
	public int updateBoard(BoardDTO modifyBoard) {
		// 6-1) SqlSession 얻기
		SqlSession session = getSqlSession();
		// 6-2) mapper 얻기
		boardDAO = session.getMapper(BoardDAO.class);
		// 6-3) 메소드 호출해서 BoardDTO 넘겨주며 대상 정보 수정하기
		int result = boardDAO.updateBoard(modifyBoard);
		// 6-4) 수정 결과에 따른 commit, rollback 처리 후 자원 반납
		if (result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		// 6-5) 결과 int로 반환하기
		return result;
	}

	// TODO LV.2 > ST.5 > 5. 대상 게시글을 삭제 (board_status를 N으로 update) 서비스 로직 작성
	public int deleteBoard(int boardNo) {
		// 5-1) SqlSession 얻기
		SqlSession session = getSqlSession();
		// 5-2) mapper 얻기
		boardDAO = session.getMapper(BoardDAO.class);
		// 5-3) 메소드 호출해서 boardNo 넘겨주며 board_status 수정하게 하기
		int result = boardDAO.deleteBoard(boardNo);
		// 5-4) 수정 결과에 따른 commit, rollback 처리 후 자원 반납
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
		// 5-5) 결과 int로 반환하기
	}
}
