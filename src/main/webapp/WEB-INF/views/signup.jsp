<%--
  Created by IntelliJ IDEA.
  User: Honore
  Date: 11/20/2019
  Time: 12:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Products</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Welcome Kimosabe!! </h1>
        </div>
    </div>
</section>
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Please sign in</h3>
                </div>
                <div class="panel-body">
                    <c:if test="${not empty error}">
                        <div class="alert alert-danger">
                            <spring:message code="AbstractUserDetailsAuthenticationProvider.badCredentials"/><br />
                        </div>
                    </c:if>

                    <spring:url value="/postSignUp" var="action"/>

                    <form:form action="${action}"  method="post" modelAttribute="newParticipant" >
                        <security:csrfInput/>
                        <fieldset>
                            <div class="form-group">
                                <form:errors path="username"  cssStyle="color : red;" />
                                <form:input class="form:input-large" placeholder="Surname" name="username" type="text" path="surname"/>
                            </div>
                            <div class="form-group">
                                <form:errors path="otherNames" cssStyle="color : red;" />
                                <form:input class=" form:input-large" placeholder="otherNames" name="othernames"  type="text" path="otherNames"/>
                            </div>
                            <div class="form-group">

                                <form:input class=" form:input-large" placeholder="email" name="email"  type="email" path="email"/>
                            </div>
                            <div class="form-group">

                                <form:input class="form:input-large" placeholder="User Name" name="username" type="text" path="username"   />
                            </div>
                            <div class="form-group">
                                <form:errors path="password" cssStyle="color : red;" />
                                <form:input class=" form:input-large" placeholder="Password" name="password"  type="password" path="password"/>
                            </div>

                            <input class="btn btn-lg btn-success btn-mini" type="submit" value="signup"/>

                        </fieldset>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
