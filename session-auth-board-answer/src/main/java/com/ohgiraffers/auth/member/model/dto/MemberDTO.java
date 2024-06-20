package com.ohgiraffers.auth.member.model.dto;

public class MemberDTO implements java.io.Serializable {
	
	private int memberNo;
	private String memberId;
	private String memberPwd;
	private String memberName;
	private String memberRole;
	
	public MemberDTO() {
		super();
	}

	public MemberDTO(int memberNo, String memberId, String memberPwd, String memberName, String memberRole) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
		this.memberRole = memberRole;
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

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberRole() {
		return memberRole;
	}

	public void setMemberRole(String memberRole) {
		this.memberRole = memberRole;
	}

	@Override
	public String toString() {
		return "MemberDTO [memberNo=" + memberNo + ", memberId=" + memberId + ", memberPwd=" + memberPwd
				+ ", memberName=" + memberName + ", memberRole=" + memberRole + "]";
	}
	
}
