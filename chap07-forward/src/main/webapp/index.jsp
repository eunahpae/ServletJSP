<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forward</title>
</head>
<body>
	<h1>Forward</h1>
	
	<form action="forward" method="post">
		<table>
			<tr>
				<td>ID: </td>
				<td><input type="text" name="userId"></td>
				<td rowspan="2">
					<button type="submit" style="height:50px;">Login</button>
				</td>
			</tr>
			<tr>
				<td>비밀번호: </td>
				<td><input type="password" name="password"></td>
			</tr>
		</table>		
	</form>
</body>
</html>