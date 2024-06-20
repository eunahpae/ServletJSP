package com.ohgiraffers.auth.admin.model.dao;

import java.util.List;

import com.ohgiraffers.auth.member.model.dto.MemberDTO;

public interface AdminDAO {

	// TODO 완료 5. memberList를 조회하여 반환할 메소드 선언
	List<MemberDTO> selectMemberList();
		
	// TODO 완료 6. main의 resources 폴더 하위에 해당 인터페이스와 매핑되는 xml 파일을 만들어 쿼리 작성
	
	// TODO 완료 6+ 이때, 해당 xml 파일은 mybatis-config 하위에 등록해야 함

}
