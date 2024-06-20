package com.eunah.project.member.model.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.eunah.project.member.model.dao.MemberDAO;
import com.eunah.project.member.model.dto.MemberDTO;

import static com.eunah.project.common.mybatis.Template.getSqlSession;

public class MemberService {

	/* 의존 관계에 있는 객체가 불변을 유지할 수 있도록 final 필드로 선언한다. */
	private MemberDAO memberDAO;

	/* 회원 가입용 메소드 */
	public int registMember(MemberDTO requestMember) {

		SqlSession session = getSqlSession();
		memberDAO = session.getMapper(MemberDAO.class);

		int result = memberDAO.insertMember(requestMember);
		if (result > 0) {
			session.commit();
		} else {
			session.rollback();
		}

		session.close();

		return result;
	}

	/* 로그인 처리용 메소드 */
	public MemberDTO loginCheck(MemberDTO requestMember) {

		SqlSession session = getSqlSession();
		memberDAO = session.getMapper(MemberDAO.class);

		MemberDTO loginMember = null;

		String encPwd = memberDAO.selectEncryptedPwd(requestMember);

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		/* 로그인 요청한 원문 비밀번호화 저장되어있는 암호화된 비밀번호가 일치하는지 확인한다. */
		if (passwordEncoder.matches(requestMember.getPwd(), encPwd)) {
			/* 비밀번호가 일치하는 경우에만 회원 정보를 조회해온다. */
			loginMember = memberDAO.selectLoginMember(requestMember);
		}

		session.close();

		return loginMember;
	}

	public int checkDupMemberId(String memberId) {

		SqlSession session = getSqlSession();
		memberDAO = session.getMapper(MemberDAO.class);

		int result = memberDAO.selectCountByMemberId(memberId);

		session.close();

		return result;
	}

	public MemberDTO modifyMember(MemberDTO requestMember) {

		SqlSession session = getSqlSession();
		memberDAO = session.getMapper(MemberDAO.class);

		MemberDTO changedMemberInfo = null;

		int result = memberDAO.updateMember(requestMember);
		if (result > 0) {
			session.commit();
			changedMemberInfo = memberDAO.selectChangedMemberInfo(requestMember.getNo());
		} else {
			session.rollback();
		}

		session.close();

		return changedMemberInfo;
	}

	public int removeMember(MemberDTO requestMember) {

		SqlSession session = getSqlSession();
		memberDAO = session.getMapper(MemberDAO.class);

		int result = memberDAO.deleteMember(requestMember);
		if (result > 0) {
			session.commit();
		} else {
			session.rollback();
		}

		session.close();

		return result;
	}

}
