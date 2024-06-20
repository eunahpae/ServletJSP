<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/common.css">

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
					
						<a href="${pageContext.servletContext.contextPath}/insert"
							id="write-post-button">글 작성하기</a>
					
				</div>
			</div>
			<div class="posts">
				<!-- Example post cards -->
				<c:forEach var="board" items="${requestScope.boardList}">
					<div class="post-card">
						<div class="post-thumbnail">
							<a
								href="${pageContext.servletContext.contextPath}/board/detail?no=${board.no}"><img
								src="../resources/image/dogs.jpg" alt="Post Thumbnail 1">
						</div>
						<div class="post-content">
							<h2>
								<a
									href="${pageContext.servletContext.contextPath}/board/detail?no=${board.no}">
									<c:out value="${board.title}" />
								</a>
							</h2>
							<span style="text-align: right">
								<p>
									<c:out value="${board.createdDate}" />
								</p>
								<p>
									<c:out value="${board.writer.nickname}" />
								</p>
							</span>
						</div>
					</div>
				</c:forEach>
			</div>
			<br>
		</div>
	</main>

	<jsp:include page="../common/paging.jsp" />

	<script>
		function search() {
			var searchValue = document.getElementById('searchInput').value
					.trim();
			// Perform search logic with 'searchValue', e.g., redirect to search page or handle AJAX search
			// Example: window.location.href = '${pageContext.servletContext.contextPath}/search?query=' + encodeURIComponent(searchValue);
		}
	</script>
</body>
</html>
