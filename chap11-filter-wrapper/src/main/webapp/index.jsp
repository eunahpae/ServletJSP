<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Filter & Wrapper</title>
</head>
<body>
	<h1>Filter</h1>
	
	<h3>Filter LifeCycle</h3>
	<a href="first/filter">Filter 사용하기</a>
	
	<hr>
	
	<h3>Filter 활용</h3>
	<form action="member/regist" method="post">
		<label>ID: </label>
		<input type="text" name="userId">
		<br>
		<label>비밀번호: </label>
		<input type="password" name="password">
		<br>
		<label>이름: </label>
		<input type="text" name="name">
		<br>
		<button type="submit">회원가입</button>
	</form>
</body>
</html>