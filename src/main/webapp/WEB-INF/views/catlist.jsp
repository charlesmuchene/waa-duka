<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Category List</title>
</head>
<body>

<form:form modelAttribute="catlist" action="">

    <form:select path="name" items="${catlist}" itemValue="id" itemLabel="name"/>
    <%--			<form:options items="${categories}" itemValue="id" itemLabel="name"/>--%>
</form:form>

</body>
</html>
