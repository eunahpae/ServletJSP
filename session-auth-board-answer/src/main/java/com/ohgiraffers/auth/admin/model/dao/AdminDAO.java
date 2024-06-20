package com.ohgiraffers.auth.admin.model.dao;

import java.util.List;

import com.ohgiraffers.auth.admin.model.dto.MemberDTO;

public interface AdminDAO {

	List<MemberDTO> selectMemberList();

}
