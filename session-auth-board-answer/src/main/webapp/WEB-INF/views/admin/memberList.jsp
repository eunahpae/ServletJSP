<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/common.css">
</head>
<body>
	<h1>우리 홈페이지 회원 현황</h1>
	<table class="mlist">
		<tr>
			<th>회원코드</th>
			<th>회원ID</th>
			<th>회원명</th>
			<th>가입일자</th>
		</tr>
		<c:forEach items="${ memberList }" var="member">
			<tr>
				<td>${ member.memberNo }</td>
				<td>${ member.memberId }</td>
				<td>${ member.memberName }</td>
				<td>${ member.enrollDate }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>