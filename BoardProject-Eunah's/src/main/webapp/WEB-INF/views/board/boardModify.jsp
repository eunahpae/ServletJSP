<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 작성</title>
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/common.css">
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/board.css">
<style>
</style>
</head>
<body>
	<jsp:include page="../common/menubar.jsp" />
	<main class="main-content">
		<div class="container">
			<div class="question-box">
				<p class="boardTitle">
					댕댕스쿨에서는<br> 무엇을 할까요?
				</p>
				<div class="search-section">
					<div class="search-input-container">
						<input type="text" id="searchInput" class="search-input"
							placeholder="Search..."> <a onclick="search()"
							class="search-button">🔎</a>
					</div>
					<button id="write-button" class="submit-button"
						onclick="submitForm()">등록하기</button>
				</div>
			</div>
			<div class="table-area">
				<form id="postForm"
					action="${pageContext.servletContext.contextPath}/board/modify"
					method="post">
					<div class="outer-board-insert">
						<div class="author">
							<u>작성자 : <c:out value="${sessionScope.loginMember.nickname}" /></u>
						</div>
						<div class="category">
							<u>카테고리 : <select name="category">
									<option value="1">공통</option>
									<option value="2">운동</option>
							</select>
							</u>
						</div>
						<h2 class="title">
							제목 :<input type="text" name="title" placeholder="제목을 입력하세요.">
						</h2>
						<div class="content-box">
							<textarea name="body" cols="60" rows="15"
								placeholder="내용을 입력하세요."></textarea>
						</div>
					</div>
				</form>
			</div>
		</div>
	</main>

	<script>
		function submitForm() {
			document.getElementById('postForm').submit();
		}
	</script>

</body>
</html>
