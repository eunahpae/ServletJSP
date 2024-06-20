<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Eunah's Board</title>
</head>
<body>

	<jsp:forward page="../common/menubar.jsp" />
	
	<div class="login-area">
        <div class="login-form">
            <c:if test="${empty sessionScope.loginMember}">
                <form id="loginForm" action="${pageContext.servletContext.contextPath}/member/login" method="post">
                    <table>
                        <tr>
                            <td><label class="text">ID : </label></td>
                            <td><input type="text" name="memberId"></td>
                        </tr>
                        <tr>
                            <td><label class="text">PWD : </label></td>
                            <td><input type="password" name="memberPwd"></td>
                        </tr>
                    </table>
                    <div class="btns">
                        <input type="button" class="btn" value="회원가입" id="regist">
                        <input type="submit" class="btn" value="로그인" id="login">
                    </div>
                </form>
            </c:if>

            <c:if test="${!empty sessionScope.loginMember}">
                <h3>
                    <c:out value="${sessionScope.loginMember.nickname}" />
                    님, 환영합니다.
                </h3>
                <div class="btns">
                    <input type="button" class="btn" value="정보수정" id="updateMember">
                    <input type="button" class="btn" value="로그아웃" id="logout">
                </div>
            </c:if>
        </div>
    </div>

</body>
</html>
