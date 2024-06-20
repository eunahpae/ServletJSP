<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>🎠🎠 사용자 전용 페이지 입니다! 🎠🎠</h3>
	<hr>
	<h1>사용자 자유게시판</h1>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
		<!-- (LV.2 > ST.1) 1. EL, JSTL 활용해서 목록 현출되게 하기  -->
		<c:forEach items="${ boardList }" var="board">
			<tr>
				<td>${ board.boardNo }</td>
				<td onclick="showDetail(${ board.boardNo })" style="cursor: pointer;">${ board.boardTitle }</td>
				<td>${ board.boardWriter }</td>
				<td>${ board.createdDate }</td>
			</tr>
		</c:forEach>
	</table>

	<!-- (LV.2 > ST.2) 2. 등록 버튼을 추가하여 게시글 등록 페이지로 이동하게 하기 (servlet get요청) -->
	<button onclick="regist()">등록하기</button>
	<!-- (LV.2 > ST.3) 3. script로 onclick 이벤트를 걸어 상세조회 요청하게 하기 -->
    <script>
        function showDetail(boardNo) {
            const contextPath = '${ pageContext.servletContext.contextPath }';
            location.href = contextPath + "/board/detail?boardNo=" + boardNo;
        }

        function regist(){
            const contextPath = '${ pageContext.servletContext.contextPath }';
            location.href = contextPath + "/board/regist";
        }
    </script>

</body>
</html>