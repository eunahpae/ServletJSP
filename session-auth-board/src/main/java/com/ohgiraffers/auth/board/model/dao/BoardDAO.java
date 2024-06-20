package com.ohgiraffers.auth.board.model.dao;

import java.util.List;

import com.ohgiraffers.auth.board.model.dto.BoardDTO;

public interface BoardDAO {

	// TODO 완료 LV.2 > ST.1 > 4. BoardList 조회하는 메소드 선언
	List<BoardDTO> selectBoardList();
	// TODO 완료 LV.2 > ST.1 > 5. main의 resources 폴더 하위에 해당 인터페이스와 매핑되는 xml 파일을 만들어 쿼리 작성
	// TODO 완료 LV.2 > ST.1 > 5+. 이때, 해당 xml 파일은 mybatis-config 하위에 등록해야 함
	
	// TODO 완료 LV.2 > ST.2 > 7. BoardDTO를 등록하는 메소드 선언
	int insertBoard(BoardDTO registBoard);
	// TODO 완료 LV.2 > ST.2 > 8. 위에서 선언한 메소드와 매핑되는 쿼리를 xml 파일에 작성

	// TODO 완료 LV.2 > ST.3 > 6. boardNo를 이용하여 BoardDTO를 조회하는 메소드 선언
	BoardDTO selectBoardDetail(int boardNo);
	// TODO 완료 LV.2 > ST.3 > 7. 위에서 선언한 메소드와 매핑되는 쿼리를 xml 파일에 작성

	// TODO 완료 LV.2 > ST.4 > 7. BoardDTO를 수정하는 메소드 선언
	int updateBoard(BoardDTO updateBoard);
	// TODO 완료 LV.2 > ST.4 > 8. 위에서 선언한 메소드와 매핑되는 쿼리를 xml 파일에 작성

	// TODO LV.2 > ST.5 > 6. boardNo를 이용하여 board_status를 수정하는 메소드 선언
	int deleteBoard(int boardNo);
	// TODO LV.2 > ST.5 > 7. 위에서 선언한 메소드와 매핑되는 쿼리를 xml 파일에 작성

}
