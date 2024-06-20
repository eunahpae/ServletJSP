<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
	<form action="${ pageContext.servletContext.contextPath }/member/regist" method="post">
		ID: <input type="text" name="memberId"><br>
		비밀번호: <input type="password" name="memberPwd"><br>
		이름: <input type="text" name="memberName"><br>
		권한 : 
		<select name="memberRole">
			<option value="ROLE_MEMBER">일반회원</option>
			<option value="ROLE_ADMIN">관리자</option>
		</select><br>
		<input type="submit" value="가입하기">
	</form>
</body>
</html>