<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	
	<!-- 회원 가입 양식 outer 영역 -->
	<div class="outer outer-member-insert">
		<br>
		<h2 align="center">회원가입</h2>
		
		<!-- 정보 수정 폼 -->
		<form id="joinForm" action="${ pageContext.servletContext.contextPath }/member/update" method="post">
			<table align="center">
				<tr>
					<td width="200px">* 아이디 </td>
					<td><input type="text" maxlength="13" name="memberId" id="memberId" value="${ sessionScope.loginMember.id }" readonly></td>
				</tr>
				<tr>
					<td>* 비밀번호</td>
					<td><input type="password" maxlength="13" name="memberPwd" disabled></td>
					<td></td>
				</tr>
				<tr>
					<td>* 비밀번호 확인</td>
					<td><input type="password" maxlength="13" name="memberPwd2" disabled></td>
					<td></td>
				</tr>
				<tr>
					<td>* 닉네임</td>
					<td><input type="text" maxlength="5" name="nickname" value="${ sessionScope.loginMember.nickname }" required></td>
					<td></td>
				</tr>
				<tr>
					<td>연락처 </td>
					<td><input type="tel" name="phone" value="${ sessionScope.loginMember.phone }"></td>
					<td></td>
				</tr>
				<tr>
					<td>이메일 </td>
					<td><input type="email" name="email" value="${ sessionScope.loginMember.email }"></td>
					<td></td>
				</tr>
				<tr>
					<td>우편번호</td>
					<td><input type="text" name="zipCode" id="zipCode" value='${ fn:split(sessionScope.loginMember.address, "$")[0] }' readonly>
					<input type="button" value="검색" class="btn" id="searchZipCode"></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="address1" id="address1" value='${ fn:split(sessionScope.loginMember.address, "$")[1] }' readonly></td>
					<td></td>
				</tr>
				<tr>
					<td>상세주소</td>
					<td><input type="text" name="address2" id="address2" value='${ fn:split(sessionScope.loginMember.address, "$")[2] }'></td>
					<td></td>
				</tr>
			</table>
			
			<br>
			
			<div class="btns" align="center">
				<input type="reset" value="메인으로"  class="btn" id="goMain">
				<input type="submit" value="저장" class="btn">
			</div>
		</form>
		<br>
		
		<c:if test="${ sessionScope.loginMember.role eq 'ROLE_MEMBER' }">
			<div class="btn" style="text-align:right">
				<a href="${ pageContext.servletContext.contextPath }/member/delete">회원탈퇴</a>
			</div>
		</c:if>
	</div>	<!-- outer end -->
	
	<!-- 다음 우편번호 api -->
	<!-- key 발급 없이 무제한으로 이용이 가능하다. -->
	<!-- 아래 스크립트를 불러온 후 사용해야 한다. -->
	<!-- 참고 링크 : http://postcode.map.daum.net/guide -->
	<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
		const $searchZipCode = document.getElementById("searchZipCode");
		const $goMain = document.getElementById("goMain");
		const $doDuplicationCheck = document.getElementById("duplicationCheck");
		
		$searchZipCode.onclick = function() {
		
			//다음 우편번호 검색 창을 오픈하면서 동작할 콜백 메소드를 포함한 객체를 매개변수로 전달한다.
			new daum.Postcode({
				oncomplete: function(data){
					//팝업에서 검색결과 항목을 클릭했을 시 실행할 코드를 작성하는 부분
					document.getElementById("zipCode").value = data.zonecode;
					document.getElementById("address1").value = data.address;
					document.getElementById("address2").focus();
				}
			}).open();
		}
		
		$goMain.onclick = function() {
			location.href = "${ pageContext.servletContext.contextPath }";
		}
	</script>
</body>
</html>
