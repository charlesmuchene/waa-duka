<%--
  Created by IntelliJ IDEA.
  User: bikino
<<<<<<< HEAD
  Date: 18/11/2019
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Search Results</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <img src="<spring:url value='/resource/images/sample_product.jpg' />" class="card-img-top"
                 alt="Product" height="150px"/>
            <h1> ${greeting} </h1>
            <p> ${tagline} </p>

        </div>

        <div class="container">

            <security:authorize access="isAnonymous()">
                <!-- WHICH ONE? depends on basic form OR CUSTOM -->
                <!--a href="<spring:url value='/spring_security_login' />" class="btn btn-default pull-right"> Login</a-->
                <a href="<spring:url value='/login' />" class="btn btn-default pull-right"> Login</a>
            </security:authorize>

            <p> <security:authorize access="isAuthenticated()">
                <a href="<spring:url  value="/dologout" />" class="btn btn-danger btn-mini pull-right">Logout</a>
                </security:authorize>



                <a href="<spring:url value='/employees/list' />" class="btn btn-default">
                    <span class="glyphicon-hand-left glyphicon"></span> Go to Company
                </a>
        </div>


    </div>
</section>
<section style="margin-left: auto;margin-right: auto;width: 70%">

    <div>

        <security:authorize access="isAnonymous()">
            <div class="search">
                <spring:url var="search" value="/search"/>
                <form:form action="${search}" method="get">
                    <input name="search" id="search" type="text" class="form-control" />
                    <input type="submit" value="Search" class="btn btn-primary" />
                </form:form>



                <c:forEach items="${searchResults}" var="product">
                    <div class="border:1px solid red;padding:5px;float:left;width:40%;text-align:center">
                        <h2>${product.name}</h2>
                        <img src="<spring:url value="/resources/images/sample_product.jpg"/>" class="card-img-top"
                             alt="Product" width="200px">

                        <p>${product.price}</p>

                        <span><a href="<spring:url value="/borrow/${product.serialNumber}"/>">Borrow</a> </span>
                    </div>

                </c:forEach>
            </div>
        </security:authorize>
    </div>
</section>



</body>
</html>
