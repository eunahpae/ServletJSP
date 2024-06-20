package com.ohgiraffers.auth.admin.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ohgiraffers.auth.admin.model.dao.AdminDAO;
import com.ohgiraffers.auth.admin.model.dto.MemberDTO;

import static com.ohgiraffers.auth.common.mybatis.Template.getSqlSession;

public class AdminService {
	
	private AdminDAO adminDAO;

	public List<MemberDTO> selectMemberList() {
		SqlSession session = getSqlSession();
		adminDAO = session.getMapper(AdminDAO.class);
		
		List<MemberDTO> memberList = adminDAO.selectMemberList();
		
		session.close();
		
		return memberList;
	}
	
}
