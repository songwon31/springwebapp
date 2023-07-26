<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ include file="/WEB-INF/views/common/header.jsp"%>


<div class="card m-2">
	<div class="card-header">스프링 태그 라이브러리</div>
	<div class="card-body">
		<form:form method="post" modelAttribute="member">
			<div class="form-group">
				<label for="mid">ID</label>
				<form:input path="mid" class="form-control"/>
			</div>
			<div class="form-group">
				<label for="mname">Name</label>
				<form:input path="mname" class="form-control"/>
			</div>
			<div class="form-group">
				<label for="mpassword">Password</label>
				<form:password path="mpassword" class="form-control"/>
			</div>
			<form:hidden path="mnation"/>
			<button class="btn btn-info btn-sm">Submit</button>
		</form:form>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>
