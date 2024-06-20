<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/common.css">
</head>
<body>
	<h1>📢📢 관리자 전용 페이지 입니다! 📢📢</h1>
	
	<div class="divmenu">
		<div><a href="${ pageContext.servletContext.contextPath }/admin/memberList">회원목록</a></div>
		<div><a href="">신고관리</a></div>
		<div><a href="">메뉴관리</a></div>
	</div>
</body>
</html>