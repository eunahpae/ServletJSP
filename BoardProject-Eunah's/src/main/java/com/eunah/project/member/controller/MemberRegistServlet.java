package com.eunah.project.member.controller;

import java.io.IOException;

import com.eunah.project.member.model.dto.MemberDTO;
import com.eunah.project.member.model.service.MemberService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/member/regist")
public class MemberRegistServlet extends HttpServlet {
	
	/* 회원가입 버튼 클릭 시 get요청이 들어오기 때문에 회원가입 하는 form으로 포워딩 해주는 역할 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/WEB-INF/views/member/registForm.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

	/* 회원 가입 폼을 작성 후 post 요청을 할 경우 처리하는 역할 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memberId = request.getParameter("memberId");
		String memberPwd = request.getParameter("memberPwd");
		String nickname = request.getParameter("nickname");
		/*사용자가 '-'기호를 이용하여 전화번호를 입력하는 경우 통일시키기 위해서 replace 이용함 */
		String phone = request.getParameter("phone").replace("-", "");
		String email = request.getParameter("email");
		/* 우편번호와 주소, 상세주소를 하나의 문자열로 저장하는데 주소에 보통 사용하지 않는 문자를 기준으로 합치기를 해야 나중에 split 할 수 있다. */
		String address = request.getParameter("zipCode") + "$" + request.getParameter("address1") + "$" + request.getParameter("address2");
		
		MemberDTO requestMember = new MemberDTO();
		requestMember.setId(memberId);
		requestMember.setPwd(memberPwd);
		requestMember.setNickname(nickname);
		requestMember.setPhone(phone);
		requestMember.setEmail(email);
		requestMember.setAddress(address);
		
		System.out.println("memberController requestMember : " + requestMember);
		
		int result = new MemberService().registMember(requestMember);
		
		System.out.println("memberController result : " + result);
		
		String page = "";
		
		if(result > 0) {
			
			page = "/WEB-INF/views/common/success.jsp";
			
			request.setAttribute("successCode", "insertMember");
			
		} else {
			
			page = "/WEB-INF/views/common/failed.jsp";
			
			request.setAttribute("message", "회원 가입 실패!");
		}
		
		request.getRequestDispatcher(page).forward(request, response);
	}

}
