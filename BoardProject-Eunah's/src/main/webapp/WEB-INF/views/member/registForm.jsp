<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		
		<!-- 회원 가입 폼 -->
		<form id="joinForm" action="${ pageContext.servletContext.contextPath }/member/regist" method="post">
			<table align="center">
				<tr>
					<td width="200px">* 아이디 </td>
					<td><input type="text" maxlength="13" name="memberId" id="memberId" required>
					<input type="button" value="중복확인" class="btn" id="duplicationCheck"></td>
				</tr>
				<tr>
					<td>* 비밀번호</td>
					<td><input type="password" maxlength="13" name="memberPwd" required></td>
					<td></td>
				</tr>
				<tr>
					<td>* 비밀번호 확인</td>
					<td><input type="password" maxlength="13" name="memberPwd2"></td>
					<td></td>
				</tr>
				<tr>
					<td>* 닉네임</td>
					<td><input type="text" maxlength="5" name="nickname" required></td>
					<td></td>
				</tr>
				<tr>
					<td>연락처 </td>
					<td><input type="tel" name="phone"></td>
					<td></td>
				</tr>
				<tr>
					<td>이메일 </td>
					<td><input type="email" name="email"></td>
					<td></td>
				</tr>
				<tr>
					<td>우편번호</td>
					<td><input type="text" name="zipCode" id="zipCode" readonly>
					<input type="button" value="검색" class="btn" id="searchZipCode"></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="address1" id="address1" readonly></td>
					<td></td>
				</tr>
				<tr>
					<td>상세주소</td>
					<td><input type="text" name="address2" id="address2"></td>
					<td></td>
				</tr>
			</table>
			
			<br>
			
			<div class="btns" align="center">
				<input type="reset" value="메인으로"  class="btn btn-yg" id="goMain">
				<input type="submit" value="회원등록" class="btn btn-or">
			</div>
		</form>
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
		
		$doDuplicationCheck.onclick = function() {
            let memberId = $("#memberId").val().trim();
            console.log(memberId);

            $.ajax({
                url: "${ pageContext.servletContext.contextPath }/member/checkid",
                type: "post",
                data: {memberId: memberId},
                success: function(data){
                	if(data === 'pass') {
                		alert('사용 가능한 ID 입니다.');
                	} else {
                		alert('이미 존재하는 ID 입니다.');
                		$("#memberId").val('');
                	}
                },
                error: function(error) {
                	alert('처리 중 예외가 발생하였습니다. 관리자에게 문의해 주세요.');
                    console.log(error);
                }
            });
		}
	</script>
</body>
</html>
