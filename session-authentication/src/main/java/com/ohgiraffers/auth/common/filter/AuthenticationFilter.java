package com.ohgiraffers.auth.common.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ohgiraffers.auth.member.model.dto.MemberDTO;

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

@WebFilter(urlPatterns = {"/member/*", "/admin/*"})
public class AuthenticationFilter implements Filter {
	
	Map<String, List<String>> permitURIList;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		permitURIList = new HashMap<>();
		List<String> adminPermitList = new ArrayList<>();
		List<String> memberPermitList = new ArrayList<>();
		List<String> allPermitList = new ArrayList<>();
		
		adminPermitList.add("/admin/page");
		
		memberPermitList.add("/member/page");
		
		allPermitList.add("/member/regist");
		allPermitList.add("/member/login");
		allPermitList.add("/member/logout");
		
		permitURIList.put("adminPermitList", adminPermitList);
		permitURIList.put("memberPermitList", memberPermitList);
		permitURIList.put("allPermitList", allPermitList);
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest hrequest = (HttpServletRequest) request;
		String uri = hrequest.getRequestURI();
		String intent = uri.replace(hrequest.getContextPath(), "");
		
		HttpSession requestSession = hrequest.getSession();
		MemberDTO loginMember = (MemberDTO) requestSession.getAttribute("loginMember");
		boolean isAuthorized = false;
		
		if(loginMember != null) {
			
			boolean isPermitAdmin = permitURIList.get("adminPermitList").contains(intent);
			boolean isPermitMember = permitURIList.get("memberPermitList").contains(intent);
			boolean isPermitAll = permitURIList.get("allPermitList").contains(intent);
			
			if("ROLE_ADMIN".equals(loginMember.getMemberRole())) {
				if((isPermitAdmin || isPermitAll) && !isPermitMember) {
					isAuthorized = true;
				}
			} else if("ROLE_MEMBER".equals(loginMember.getMemberRole())) {
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
				request.setAttribute("message", "로그인이 필요한 서비스입니다. 로그인 후 이용해 주세요!");
				request.setAttribute("code", "login");
				request.getRequestDispatcher("/WEB-INF/views/auth/fail.jsp").forward(request, response);
			}
			
		}
		
	}

}
