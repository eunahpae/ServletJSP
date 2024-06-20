package com.eunah.project.member.model.dao;

import com.eunah.project.member.model.dto.MemberDTO;

public interface MemberDAO {
	
	/* MEMBER TABLE 신규 회원 insert용 메소드 */
	public int insertMember(MemberDTO requestMember);
	
	/* 암호화 처리 된 비밀번호 조회용 메소드(로그인 확인용) */
	public String selectEncryptedPwd(MemberDTO requestMember);
	
	/* 패스워드 일치 시 회원 정보 조회용 메소드 */
	public MemberDTO selectLoginMember(MemberDTO requestMember);
	
	public int selectCountByMemberId(String id);

	public int updateMember(MemberDTO requestMember);

	public MemberDTO selectChangedMemberInfo(int no);

	public int deleteMember(MemberDTO requestMember);

}
