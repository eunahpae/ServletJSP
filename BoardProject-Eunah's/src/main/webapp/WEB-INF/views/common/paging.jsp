<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="pagingArea" align="center">
		<!-- 맨 앞으로 이동 버튼 -->
	    <button id="startPage"><<</button>
		
		<!-- 이전 페이지 버튼 -->
		<c:if test="${ requestScope.selectCriteria.pageNo <= 1 }">
			<button disabled><</button>
		</c:if>
		<c:if test="${ requestScope.selectCriteria.pageNo > 1 }">
			<button id="prevPage"><</button>
		</c:if>
		
		<!-- 숫자 버튼 -->
		<c:forEach var="p" begin="${ requestScope.selectCriteria.startPage }" end="${ requestScope.selectCriteria.endPage }" step="1">
			<c:if test="${ requestScope.selectCriteria.pageNo eq p }">
				<button disabled><c:out value="${ p }"/></button>
			</c:if>
			<c:if test="${ requestScope.selectCriteria.pageNo ne p }">
				<button onclick="pageButtonAction(this.innerText);"><c:out value="${ p }"/></button>
			</c:if>
		</c:forEach>
		
		<!-- 다음 페이지 버튼 -->
		<c:if test="${ requestScope.selectCriteria.pageNo >= requestScope.selectCriteria.maxPage }">
			<button disabled>></button>
		</c:if>
		<c:if test="${ requestScope.selectCriteria.pageNo < requestScope.selectCriteria.maxPage }">
			<button id="nextPage">></button>
		</c:if>
		
		<!-- 마지막 페이지로 이동 버튼 -->
		<button id="maxPage">>></button> 
	</div>
	
	<script>
	
		const link = "${ pageContext.servletContext.contextPath }/board/list";
		let searchText = "";
		
		if(${ !empty requestScope.selectCriteria.searchCondition? true: false }) {
			searchText += "&searchCondition=${ requestScope.selectCriteria.searchCondition }";
		}
		
		if(${ !empty requestScope.selectCriteria.searchValue? true: false }) {
			searchText += "&searchValue=${ requestScope.selectCriteria.searchValue }";
		}
			
		if(document.getElementById("startPage")) {
			const $startPage = document.getElementById("startPage");
			$startPage.onclick = function() {
				location.href = link + "?currentPage=1" + searchText;
			}
		}
		
		if(document.getElementById("prevPage")) {
			const $prevPage = document.getElementById("prevPage");
			$prevPage.onclick = function() {
				location.href = link + "?currentPage=${ requestScope.selectCriteria.pageNo - 1 }" + searchText;
			}
		}
		
		if(document.getElementById("nextPage")) {
			const $nextPage = document.getElementById("nextPage");
			$nextPage.onclick = function() {
				location.href = link + "?currentPage=${ requestScope.selectCriteria.pageNo + 1 }" + searchText;
			}
		}
		
		if(document.getElementById("maxPage")) {
			const $maxPage = document.getElementById("maxPage");
			$maxPage.onclick = function() {
				location.href = link + "?currentPage=${ requestScope.selectCriteria.maxPage }" + searchText;
			}
		}
		
		function pageButtonAction(text) {
			location.href = link + "?currentPage=" + text + searchText;
		}
	</script>
</body>
</html>