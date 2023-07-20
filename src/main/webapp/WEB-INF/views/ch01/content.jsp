<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="card m-2">
	<div class="card-header">Ch01. 컨트롤러 생성과 뷰 이름 리턴</div>
	<div class="card-body">
		<a class="btn btn-info btn-sm" href="${pageContext.request.contextPath}/ch01/button1">버튼1</a>
		<a class="btn btn-info btn-sm" href="button2">버튼2</a>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>
