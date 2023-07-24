<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 소스 복사/붙여넣기 --%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>

<div class="card m-2">
	<div class="card-header">forward2</div>
	<div class="card-body">
		<p><%=request.getAttribute("userName") %></p>
		<p>${userName}</p>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>
