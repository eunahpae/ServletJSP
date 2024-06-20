package com.ohgiraffers.auth.admin.model.dto;

import java.sql.Date;

public class MemberDTO implements java.io.Serializable {
	
	private int memberNo;
	private String memberId;
	private String memberName;
	private Date enrollDate;
	
	public MemberDTO() {
		super();
	}
	
	public MemberDTO(int memberNo, String memberId, String memberName, Date enrollDate) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberName = memberName;
		this.enrollDate = enrollDate;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	@Override
	public String toString() {
		return "MemberDTO [memberNo=" + memberNo + ", memberId=" + memberId + ", memberName=" + memberName
				+ ", enrollDate=" + enrollDate + "]";
	}
	
}
