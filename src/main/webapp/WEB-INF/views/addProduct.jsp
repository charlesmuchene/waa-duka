<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Welcome</title>
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
                <a href="<spring:url value='/login' />" class="btn btn-default pull-right"> Login</a> - <a href="#" class="btn btn-default pull-right" id="bid_link">Register</a>


            </security:authorize>

            <p> <security:authorize access="isAuthenticated()">
                <a href="<spring:url  value="/dologout" />" class="btn btn-danger btn-mini pull-right">Logout</a>
                </security:authorize>



                <a href="#" class="btn btn-default">
                    <span class="glyphicon-hand-left glyphicon"></span> Go to Company
                </a>
        </div>

        <div id="global">
            <form:form action="addProduct" modelAttribute="product" method="post">
<%--                <form:input type="hidden" path="id" name="id" />--%>
                <p>
                    <label for="name">Product Name </label>
                    <form:input type="text" path="name" name="name" />
                </p>

                <p>
                    <label for="number">SerialNumber </label>
                    <form:input type="text" path="number" name="number" />
                </p>
                <p>
                    <label for="price">Price</label>
                    <form:input type="text" path="price" name="price" />
                </p>
                <p>
<%--                    <label for="activity">Status </label>--%>
<%--                    <form:select path="activity" id="activity">--%>
<%--                        <form:option  value=" " label="Select Status"/>--%>
<%--                        <form:options  items="${enums}"/>--%>
<%--                    </form:select>--%>
                </p>
                <p>
<%--                    <label for="category">Category </label>--%>
<%--&lt;%&ndash;                    <form:select path="category" id="category">&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <form:option  value=" " label="Select Category"/>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <form:options  items="${categories}"/>&ndash;%&gt;--%>

<%--&lt;%&ndash;                    </form:select>&ndash;%&gt;--%>
                </p>


                <p id="buttons">
                    <input id="submit" type="submit"   value="Add Product">
                </p>

            </form:form>
        </div>



    </div>
</section>

    </div>
</section>

</body>
</html>




<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>--%>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>--%>
<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>--%>

<%--<!DOCTYPE HTML>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Add Product Form</title>--%>
<%--    <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>--%>
<%--    <script type="text/javascript" src="<spring:url value="/js/ajax.js"/>"></script>--%>
<%--    <style type="text/css">@import url(css/main.css);</style>--%>
<%--    <style type="text/css">@import url(css/rest.css);</style>--%>
<%--</head>--%>
<%--<body>--%>

<%--<div id="global">--%>
<%--    <form action="OneToManyUniJoinTable" method="post">--%>
<%--        <fieldset>--%>
<%--            <legend>Add Product</legend>--%>
<%--            <p>--%>
<%--                <label for="number">Product Number </label>--%>
<%--                <input type="text" id="number" name="number" >--%>
<%--            </p>--%>

<%--            <p>--%>
<%--                <label for="name">Product Name </label>--%>
<%--                <input type="text" id="name" name="name" >--%>
<%--            </p>--%>

<%--            <p>--%>
<%--                <label for="serialNumber">SerialNumber </label>--%>
<%--                <input type="text" id="serialNumber" name="serialNumber" >--%>
<%--            </p>--%>
<%--            <p>--%>
<%--                <label for="category">Category </label>--%>
<%--                <input type="radio" name="onBid" value="onBid"> On Bid<br>--%>
<%--                <input type="radio" name="rental" value="rental"> Rental<br>--%>
<%--            </p>--%>
<%--            <input type="button" value="Add Description" onclick="make_visible('addDescription');return false;">--%>

<%--            <div id=description>--%>
<%--                Description:--%>

<%--            </div>--%>

<%--            <p id="buttons">--%>
<%--                <input id="submit" type="submit"   value="Add Product">--%>
<%--            </p>--%>
<%--        </fieldset>--%>
<%--    </form>--%>
<%--</div>--%>

<%--<div id="addDescription'" style="display:none" >--%>

<%--    <form  id="descriptionForm" method="post">--%>
<%--        <p>--%>
<%--            <label for="color">Color</label>--%>
<%--            <input type="text" id="color" name="color" size="16">--%>
<%--        </p>--%>

<%--        <p>--%>
<%--            <label for="condition">Condition</label>--%>
<%--        </p>--%>

<%--        <input type="button" value="Submit" onclick="descriptionSubmit();return false;">--%>
<%--        <div align="center">--%>
<%--            <a href="#" onclick="make_hidden('addDescription');resetForm('descriptionForm');"> <b>EXIT</b> </a>--%>
<%--        </div>--%>

<%--    </form>--%>
<%--</div>--%>


<%--</body>--%>
<%--</html>--%>

