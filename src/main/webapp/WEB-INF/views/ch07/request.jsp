<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="/WEB-INF/views/common/header.jsp"%>

<div class="card m-2">
	<div class="card-header">request에서 모델 찾아 사용하기</div>
	<div class="card-body">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>내용</th>
					<th>글쓴이</th>
					<th>날짜</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="board" items="${boardList}">
					<tr>
						<td>${board.bno}</td>
						<td>${board.btitle}</td>
						<td>${board.bcontent}</td>
						<td>${board.bwriter}</td>
						<td><fmt:formatDate value="${board.bdate}" pattern="yyyy-MM-dd"/></td>
					</tr>
				</c:forEach>
				
				<c:if test="${ch07Board != null}">
					<tr>
						<td>${ch07Board.bno}</td>
						<td>${ch07Board.btitle}</td>
						<td>${ch07Board.bcontent}</td>
						<td>${ch07Board.bwriter}</td>
						<td><fmt:formatDate value="${ch07Board.bdate}" pattern="yyyy-MM-dd"/></td>
					</tr>
				</c:if>
				
				<c:if test="${newBoard != null}">
					<tr>
						<td>${newBoard.bno}</td>
						<td>${newBoard.btitle}</td>
						<td>${newBoard.bcontent}</td>
						<td>${newBoard.bwriter}</td>
						<td><fmt:formatDate value="${newBoard.bdate}" pattern="yyyy-MM-dd"/></td>
					</tr>
				</c:if>
			</tbody>
		</table>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>
