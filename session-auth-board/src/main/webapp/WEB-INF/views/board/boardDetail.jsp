<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	$("#goBackList").click(function(){
		location.href = contextPath + "/board/boardList";
	})
});
</script>
</head>
<body>
	<table>
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
	<button id="goBackList">목록으로</button>

	<!-- 1. 상세 조회 페이지 완성하기 -->

	<!-- 2. 수정 버튼 추가하고 기능 추가하기 (본인이 쓴 게시물이면 수정 페이지로 이동하게 하기) -->

	<!-- 3. 삭제 버튼 추가하고 기능 추가하기 (본인이 쓴 게시물이면 삭제할건지 confirm으로 물어보고 삭제하게 하기) -->


</body>
</html>