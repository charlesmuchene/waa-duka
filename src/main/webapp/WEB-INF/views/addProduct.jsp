<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="<spring:url value="/resources/css/main.css"/>">
    <title>Add Product</title>
</head>
<body>
<div id="product_bid_div">
    <div class="row justify-content-center">
        <div class="card" style="width: 300px; margin-top: 5%">
            <img src="<spring:url value="/resources/images/sample_product.jpg"/>" class="card-img-top"
                 alt="Product" width="200px">
            <div class="card-body">
                <h5 class="card-title">Add Product</h5>

                <hr>
                <div class="row align-items-center">
                    <form:form action="product/save" modelAttribute="newProduct" method="post">
                        <p>
                            <label for="name">Product Name </label>
                            <form:input class="form-control" path="name"/>
                        </p>
                        <p>
                            <label for="number">Product Number </label>
                            <form:input class="form-control" path="number"/>
                        </p>
                        <p>
                            <label for="serialNumber">SerialNumber </label>
                            <form:input class="form-control" path="serialNumber"/>
                        </p>
                        <p>
                            <label for="price">Price </label>
                            <form:input class="form-control" path="price"/>
                        </p>
                        <p>
                            <label for="activity">Status </label>
                            <form:select path="activity" class="form-control" id="activity">
                                <form:option  value=" " label="Select Status"/>
                                <form:options  items="${enums}"/>
                            </form:select>
                        </p>
<%--                        <p>--%>
<%--                            <label for="category">Category </label>--%>
<%--                            <form:select path="category" itemLabel="name" itemValue="id" items="${categories}" class="form-control" id="category">--%>
<%--                            </form:select>--%>
<%--                        </p>--%>
                        <label for="productUrlImage">Upload Photo </label>
                        <form:input type="text" class="form-control" path="productUrlImage"/>
                        </br>
                        <p id="buttons">
                            <input id="submit" type="submit" class="btn btn-primary"  value="Add Product">
                        </p>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
<script type="text/javascript" src="<spring:url value="/resources/js/stomp.js"/>"></script>
<script type="text/javascript" src="<spring:url value="/resources/js/bid.js"/>"></script>
</body>
</html>
