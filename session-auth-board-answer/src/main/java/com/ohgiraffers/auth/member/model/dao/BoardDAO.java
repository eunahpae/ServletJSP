package com.ohgiraffers.auth.member.model.dao;

import java.util.List;

import com.ohgiraffers.auth.member.model.dto.BoardDTO;

public interface BoardDAO {

	List<BoardDTO> selectBoardList();

	int insertBoard(BoardDTO registBoard);

	BoardDTO selectBoardDetail(int boardNo);

	int updateBoard(BoardDTO modifyBoard);

	int deleteBoard(int boardNo);

}
