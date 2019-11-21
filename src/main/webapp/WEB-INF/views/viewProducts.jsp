<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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





        </div>

        <div class="container">

            <div align="center">
                <table border="1" cellpadding="5">
                    <caption><h2>List of product</h2></caption>
                    <tr>
                        <th>Product Name</th>
                        <th>Serial Number</th>
                        <th>Price</th>
                        <th>Status</th>
                        <th>Category</th>
                    </tr>


                    <c:forEach var="product" items="${products}">
                        <tr>
                            <td>${product.productName}</td>
                            <td>${product.serialNumber}</td>
                            <td>${product.price}</td>
                            <td>${product.activity}</td>
                            <td>${product.category} </td>
                            <td><a href="<spring:url value="/addProduct?id=${product.id}"/>">Edit Product</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>






        </div>
    </div>
</section>

</body>
</html>
