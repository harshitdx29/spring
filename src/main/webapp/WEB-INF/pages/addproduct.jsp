<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1><fmt:message key="addproduct.heading"/></h1>
<form:form method="post">
    <table width="95%" bgcolor="f8f8ff" border="0" cellspacing="0" cellpadding="5">
        <tr>
            <td>Price:</td>
            <td><form:input path="price"></form:input></td>
        </tr>
        <tr>
            <td>Description:</td>
            <td><form:input path="description"></form:input></td>
        </tr>
    </table>
    <br>
    <input type="submit" align="center" value="Execute">
</form:form>