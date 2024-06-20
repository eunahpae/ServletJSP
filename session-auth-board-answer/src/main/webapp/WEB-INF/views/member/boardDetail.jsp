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
	const contextPath = '${ pageContext.servletContext.contextPath }';
	
	$("#modifyBtn").click(function(){
		location.href = contextPath + "/board/modify?boardNo=" + '${ boardDetail.boardNo }';
	});
	
	$("#deleteBtn").click(function(){
		if(confirm("정말 삭제하시겠습니까?")) {
			$("form").submit();
		}
	});
});
</script>
</head>
<body>
	<h1>게시물 상세조회</h1>
	<table class="boardForm boardDetail">
		<tr>
			<td>제목</td>
			<td>${ boardDetail.boardTitle }</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${ boardDetail.boardWriter }</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${ boardDetail.boardBody }</td>
		</tr>
	</table>
	
	<c:if test="${ sessionScope.loginMember.memberNo eq boardDetail.boardWriter }">
		<button id="modifyBtn" class="btn-1">수정</button>
		<button id="deleteBtn" class="btn-2">삭제</button>
		
		<form action="${ pageContext.servletContext.contextPath }/board/delete" method="post">
			<input type="hidden" name="boardNo" value="${ boardDetail.boardNo }">
		</form>
	</c:if>
</body>
</html>