<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>


<div class="card m-2">
	<div class="card-header">재고 없음 처리(Ch10SoldOutException 처리)</div>
	<div class="card-body">
		사유: ${message}
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>
