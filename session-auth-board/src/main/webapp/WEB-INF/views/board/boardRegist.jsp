<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${ pageContext.servletContext.contextPath }/resources/css/common.css">
</head>
<body>
	<h1>게시물 등록</h1>
	<form action="${ pageContext.servletContext.contextPath }/board/regist"
		method="post">
		<table>
			<tr>
				<td>제목</td>
				<td><input type="text" name="boardTitle"></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${ sessionScope.loginMember.memberName }</td>
				<input type="hidden" name="boardWriter"
					value="${ sessionScope.loginMember.memberNo }">
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="50" cols="100" name="boardBody"
						maxlength="1000"></textarea></td>
			</tr>
			<tr>
				<td><button>저장</button></td>
			</tr>
		</table>
	</form>
</body>
</html>