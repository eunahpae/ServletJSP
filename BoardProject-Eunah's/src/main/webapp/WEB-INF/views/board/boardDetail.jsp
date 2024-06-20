<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 상세보기</title>
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/common.css">
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/board.css">
</head>
<body>
	<jsp:include page="../common/menubar.jsp" />
	<main class="main-content">
		<div class="container">
			<div class="question-box">
				<p class="boardTitle">
					<span style="font-weight: 900;">댕댕스쿨</span>에서는<br> 무엇을 할까요?
				</p>
				<div class="search-section">
					<div class="search-input-container">
						<input type="text" id="searchInput" class="search-input"
							placeholder="Search..."><a onclick="search()"
							class="search-button">🔎</a>
					</div>
					<a href="${pageContext.servletContext.contextPath}/modify"
						id="write-post-button">수정하기</a>
				</div>
			</div>

			<div class="outer-board-detail">
				<div class="author-date">
					<div class="author">
						<u>작성자 : <c:out value="${board.writer.nickname}" /></u>
					</div>
					<div class="date">
						<u><c:out value="${board.createdDate}" /></u>
					</div>
				</div>
				<h2 class="title">제목 : ${board.title}</h2>
				<div class="content-box">
					<c:out value="${board.body}" />
				</div>
				<div class="comments-section">
					<h3>댓글</h3>
					<!-- Comments list here -->
					<div class="comment-form">
						<textarea placeholder="댓글을 작성하세요"></textarea>
						<button class="btn">댓글 작성</button>
					</div>
				</div>
				<button class="comment-btn">
					<a href="${pageContext.servletContext.contextPath}/board/list">목록으로</a>
				</button>
			</div>
		</div>
	</main>
</body>
</html>
