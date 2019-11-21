<%--
  Created by IntelliJ IDEA.
  User: bikino
  Date: 18/11/2019
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<html lang="en_US">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Welcome</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <img src="<spring:url value='/resource/images/loneRanger.jpg' />" />
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

        <security:authorize access="isAnonymous()">
            <div class="search">
<%--                <form action="add" method="get">--%>
<%--                    <input id="search" type="text" name="search"/>--%>
<%--                    <input type="submit" value="Search">--%>
<%--                </form>--%>

    <spring:url var="search" value="/search"/>
    <form:form action="${search}" method="get">
        <input name="search" id="search" type="text"/>
        <input type="submit" value="Search">
    </form:form>


                    <table>
                        <tr style="width: 100%;">
                            <th style="width: 20%;">Name</th>
                            <th style="width: 20%;">Number</th>
                            <th style="width: 40%;">Description</th>
                            <th style="width: 40%;"> </th>

                        </tr>
                        <c:forEach items="${searchResults}" var="product">
                            <tr>
                                <td>${product.name}</td>
                                <td>${product.number}</td>
                                <td>${product.description}</td>
                                <td><a href="/edit/${product.id}">Edit</a></td>

                            </tr>
                        </c:forEach>
                    </table>
                    <c:forEach items="${searchResults}" var="product">
                        <div class="border:1px solid red;padding:5px;float:left;width:40%">
                            <h2>${product.name}</h2>
                            <span>${product.number}</span>
                            <p>${product.description}</p>
                            <span><a href="#">More Details</a> </span>
                        </div>

                    </c:forEach>


            </div>
        </security:authorize>
    </div>
</section>



</body>
</html>

