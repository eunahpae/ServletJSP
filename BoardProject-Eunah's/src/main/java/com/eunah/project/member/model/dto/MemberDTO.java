package com.eunah.project.member.model.dto;

import java.sql.Date;

public class MemberDTO implements java.io.Serializable {
	
	private int no;
	private String id;
	private String pwd;
	private String nickname;
	private String phone;
	private String email;
	private String address;
	private Date enrollDate;
	private String role;
	private String status;
	
	public MemberDTO() {}

	public MemberDTO(int no, String id, String pwd, String nickname, String phone, String email, String address,
			Date enrollDate, String role, String status) {
		super();
		this.no = no;
		this.id = id;
		this.pwd = pwd;
		this.nickname = nickname;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.enrollDate = enrollDate;
		this.role = role;
		this.status = status;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "MemberDTO [no=" + no + ", id=" + id + ", pwd=" + pwd + ", nickname=" + nickname + ", phone=" + phone
				+ ", email=" + email + ", address=" + address + ", enrollDate=" + enrollDate + ", role=" + role
				+ ", status=" + status + "]";
	}
	
}
