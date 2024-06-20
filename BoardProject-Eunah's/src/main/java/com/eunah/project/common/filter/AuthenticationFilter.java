package com.eunah.project.common.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.eunah.project.member.model.dto.MemberDTO;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/member/*", "/board/*"})
public class AuthenticationFilter implements Filter {
	
	Map<String, List<String>> permitURIList;
	
	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest hrequest = (HttpServletRequest) request;
		String uri = hrequest.getRequestURI();
		String intent = uri.replace(hrequest.getContextPath(), "");
		
		System.out.println("intent : " + intent);
		
		/* 세션에 권한이 있는지 확인하여 허용된 url에만 접근 가능하도록 설정한다. */
		HttpSession requestSession = hrequest.getSession();
		MemberDTO loginMember = (MemberDTO) requestSession.getAttribute("loginMember");
		
		boolean isAuthorized = false;
		if(loginMember != null) {
			boolean isPermitAdmin = permitURIList.get("adminPermitList").contains(intent);
			boolean isPermitMember = permitURIList.get("memberPermitList").contains(intent);
			boolean isPermitAll = permitURIList.get("allPermitList").contains(intent);
			
			if("ROLE_ADMIN".equals(loginMember.getRole())) {
				if(isPermitAdmin || isPermitMember || isPermitAll) {
					isAuthorized = true;
				}
			} else if("ROLE_MEMBER".equals(loginMember.getRole())) {
				if((isPermitMember || isPermitAll) && !isPermitAdmin) {
					isAuthorized = true;
				}
			}
			
			if(isAuthorized) {
				chain.doFilter(request, response);
			} else {
				((HttpServletResponse) response).sendError(403);
			}
			
		} else {
			
			if(permitURIList.get("allPermitList").contains(intent)) {
				chain.doFilter(request, response);
			} else {
				request.setAttribute("message", "로그인이 필요한 서비스 입니다.");
				request.getRequestDispatcher("/WEB-INF/views/common/failed.jsp").forward(hrequest, response);
			}
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
		permitURIList = new HashMap<>();
		List<String> adminPermitList = new ArrayList<>();
		List<String> memberPermitList = new ArrayList<>();
		List<String> allPermitList = new ArrayList<>();
		
		memberPermitList.add("/notice/list");
		memberPermitList.add("/notice/detail");
		memberPermitList.add("/board/list");
		memberPermitList.add("/board/insert");
		memberPermitList.add("/board/search");
		memberPermitList.add("/board/detail");
		memberPermitList.add("/thumbnail/list");
		memberPermitList.add("/thumbnail/insert");
		memberPermitList.add("/thumbnail/detail");
		memberPermitList.add("/member/update");
		memberPermitList.add("/member/delete");

		allPermitList.add("/member/regist");
		allPermitList.add("/member/login");
		allPermitList.add("/member/logout");
		allPermitList.add("/member/checkid");
		
		permitURIList.put("adminPermitList", adminPermitList);
		permitURIList.put("memberPermitList", memberPermitList);
		permitURIList.put("allPermitList", allPermitList);
		
	}

}
