<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 소스 복사/붙여넣기 --%>
<%--@ include file="/WEB-INF/views/common/header.jsp"--%>
<%-- header.jsp로 이동해서 실행하고, 그 결과를 삽입 --%>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>

<div class="card m-2">
	<div class="card-header">forward1</div>
	<div class="card-body">
		<c:if test="${loginStatus}">
			<%-- forward1.jsp에서 완전히 forward2.jsp로 이동 --%>
			<jsp:forward page="/WEB-INF/views/ch06/forward2.jsp"/>
		</c:if>
	</div>
</div>

<%-- footer.jsp로 이동해서 실행하고, 그 결과를 삽입 --%>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
