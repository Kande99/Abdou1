<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<form:form method="post" modelAttribute="fa">
<form:hidden path="id"/>
<form:errors path="make" cssClass="text-danger"/><br>
<form:input type="text" path="make" placeholder="make"/><br><br>
<form:input type="text" path="image" placeholder="image"/><br><br>
<input type="submit" value="add"/>
</form:form>
<%@ include file="common/footer.jspf"%>