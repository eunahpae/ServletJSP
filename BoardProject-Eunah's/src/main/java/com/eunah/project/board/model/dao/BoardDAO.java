package com.eunah.project.board.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.eunah.project.board.model.dto.AttachmentDTO;
import com.eunah.project.board.model.dto.BoardDTO;
import com.eunah.project.common.paging.SelectCriteria;

public interface BoardDAO {
	
	public int selectTotalCount(Map<String, String> searchMap);

	public List<BoardDTO> selectBoardList(SelectCriteria selectCriteria);

	public int insertBoard(BoardDTO newBoard);
	
	/* Attachment 테이블에 insert */
	public int insertAttachment(AttachmentDTO file);
	
	public int incrementBoardCount(int no);
	
	public BoardDTO selectBoardDetail(int no);
	
}
