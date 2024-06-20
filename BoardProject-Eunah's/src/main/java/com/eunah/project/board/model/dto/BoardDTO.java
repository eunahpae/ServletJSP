package com.eunah.project.board.model.dto;

import java.sql.Date;
import java.util.List;

import com.eunah.project.member.model.dto.MemberDTO;

public class BoardDTO implements java.io.Serializable {
	
	private int no;
	private Integer type;
	private int categoryCode;
	private CategoryDTO category;
	private String title;
	private String body;
	private int writerMemberNo;
	private MemberDTO writer;
	private int count;
	private Date createdDate;
	private Date modifiedDate;
	private String status;
	private List<AttachmentDTO> attachmentList;
	
	public BoardDTO() {
		super();
	}

	public BoardDTO(int no, Integer type, int categoryCode, CategoryDTO category, String title, String body,
			int writerMemberNo, MemberDTO writer, int count, Date createdDate, Date modifiedDate, String status,
			List<AttachmentDTO> attachmentList) {
		super();
		this.no = no;
		this.type = type;
		this.categoryCode = categoryCode;
		this.category = category;
		this.title = title;
		this.body = body;
		this.writerMemberNo = writerMemberNo;
		this.writer = writer;
		this.count = count;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.status = status;
		this.attachmentList = attachmentList;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public int getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(int categoryCode) {
		this.categoryCode = categoryCode;
	}

	public CategoryDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public int getWriterMemberNo() {
		return writerMemberNo;
	}

	public void setWriterMemberNo(int writerMemberNo) {
		this.writerMemberNo = writerMemberNo;
	}

	public MemberDTO getWriter() {
		return writer;
	}

	public void setWriter(MemberDTO writer) {
		this.writer = writer;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<AttachmentDTO> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<AttachmentDTO> attachmentList) {
		this.attachmentList = attachmentList;
	}

	@Override
	public String toString() {
		return "BoardDTO [no=" + no + ", type=" + type + ", categoryCode=" + categoryCode + ", category=" + category
				+ ", title=" + title + ", body=" + body + ", writerMemberNo=" + writerMemberNo + ", writer=" + writer
				+ ", count=" + count + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + ", status="
				+ status + ", attachmentList=" + attachmentList + "]";
	}

}
