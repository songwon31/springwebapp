<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="card m-2">
	<div class="card-header">
		국제화를 적용한 폼
	</div>
	<div class="card-body">
		<form method="post" action="form5">
		  <div class="form-group">
		    <label for="mid"><spring:message code="join.form.mid"/></label>
		    <input type="text" class="form-control"/>
		  </div>
		  <div class="form-group">
		    <label for="mname"><spring:message code="join.form.mname"/></label>
		    <input type="text" class="form-control"/>
		  </div>
		  <div class="form-group">
		    <label for="mpassword"><spring:message code="join.form.mpassword"/></label>
		    <input type="password" class="form-control"/>
		  </div>
		  <div class="form-group">
		    <label for="mnation"><spring:message code="join.form.mnation"/></label>
		    <input type="text" class="form-control"/>
		  </div>
		  <button type="submit" class="btn btn-primary"><spring:message code="join.form.submit"/></button>
		</form>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>