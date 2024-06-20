<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Session Authentication</h1>
	
	<c:if test="${ sessionScope.loginMember.memberRole eq 'ROLE_ADMIN' }">
		<h1>=== 관리자 페이지 ===</h1>
		<a href="${ pageContext.servletContext.contextPath }/admin/page">관리자 전용 페이지</a>
	</c:if>
	<c:if test="${ sessionScope.loginMember.memberRole eq 'ROLE_MEMBER' }">
		<h1>=== 회원 페이지 ===</h1>
		<a href="${ pageContext.servletContext.contextPath }/board/boardList">게시판 페이지</a>
	</c:if>
	
	<div>
		<c:if test="${ empty sessionScope.loginMember }">
			<a href="${ pageContext.servletContext.contextPath }/member/login">로그인</a>
			<a href="${ pageContext.servletContext.contextPath }/member/regist">회원가입</a>
		</c:if>
		<c:if test="${ !empty sessionScope.loginMember }">
			<h3>${ sessionScope.loginMember.memberName }님, 좋은 하루 되세요 :)</h3>
			<a href="${ pageContext.servletContext.contextPath }/member/logout">로그아웃</a>
		</c:if>
	</div>	
	
</body>
</html>