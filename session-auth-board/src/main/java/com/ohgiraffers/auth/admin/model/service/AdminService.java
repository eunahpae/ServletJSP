package com.ohgiraffers.auth.admin.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ohgiraffers.auth.admin.model.dao.AdminDAO;
import com.ohgiraffers.auth.member.model.dto.MemberDTO;
import static com.ohgiraffers.auth.common.mybatis.Template.getSqlSession;


public class AdminService {

	
	// TODO 완료 3. AdminDAO를 필드로 선언
	private AdminDAO adminDAO;
	
	// TODO 완료 4. SqlSession을 얻어 AdminDAO를 통해 MemberDTO 리스트 반환받기
	public List<MemberDTO> selectMemberList() {
		SqlSession session = getSqlSession();
		adminDAO = session.getMapper(AdminDAO.class);
		List<MemberDTO> memberList = adminDAO.selectMemberList();
		session.close();
		
		// TODO 완료 7. 반환받은 memberList를 컨트롤러에게 반환하기
		return memberList;
	}
	
		
	
	

}
