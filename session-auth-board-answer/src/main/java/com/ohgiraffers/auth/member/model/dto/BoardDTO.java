package com.ohgiraffers.auth.member.model.dto;

import java.sql.Date;

public class BoardDTO implements java.io.Serializable {
	
	private int boardNo;
	private String boardTitle;
	private String boardBody;
	private String boardWriter;
	private Date createdDate;
	private Date modifiedDate;
	private String boardStatus;
	
	public BoardDTO() {
		super();
	}

	public BoardDTO(int boardNo, String boardTitle, String boardBody, String boardWriter, Date createdDate,
			Date modifiedDate, String boardStatus) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardBody = boardBody;
		this.boardWriter = boardWriter;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.boardStatus = boardStatus;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardBody() {
		return boardBody;
	}

	public void setBoardBody(String boardBody) {
		this.boardBody = boardBody;
	}

	public String getBoardWriter() {
		return boardWriter;
	}

	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getBoardStatus() {
		return boardStatus;
	}

	public void setBoardStatus(String boardStatus) {
		this.boardStatus = boardStatus;
	}

	@Override
	public String toString() {
		return "BoardDTO [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardBody=" + boardBody
				+ ", boardWriter=" + boardWriter + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate
				+ ", boardStatus=" + boardStatus + "]";
	}
	
}
