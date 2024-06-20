<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/common.css">
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script>
$(function(){
	$("#registBtn").click(function(){
		const contextPath = '${ pageContext.servletContext.contextPath }';
		location.href = contextPath + "/board/regist";
	});
});
</script>
</head>
<body>
	<h3>🎠🎠 사용자 전용 페이지 입니다! 🎠🎠</h3>
	<hr>
	<h1>사용자 자유게시판</h1>
	<table class="blist">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
		<c:forEach items="${ boardList }" var="board">
			<tr onclick='location.href="${ pageContext.servletContext.contextPath }/board/detail?boardNo=${ board.boardNo }"'>
				<td>${ board.boardNo }</td>
				<td>${ board.boardTitle }</td>
				<td>${ board.boardWriter }</td>
				<td>${ board.createdDate }</td>
			</tr>
		</c:forEach>
	</table>
	
	<button id="registBtn" class="btn-1">게시물 등록</button>
</body>
</html>