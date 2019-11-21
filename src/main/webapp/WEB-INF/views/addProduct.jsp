<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE HTML>
<html>
<head>
    <title>Add Product Form</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

<div id="global">
    <form:form action="addProduct" modelAttribute="product" method="post">
        <form:input type="hidden" path="id" name="id" />
        <p>
            <label for="productName">Product Name </label>
            <form:input type="text" path="productName" name="productName" />
        </p>

        <p>
            <label for="serialNumber">SerialNumber </label>
            <form:input type="text" path="serialNumber" name="serialNumber" />
        </p>
        <p>
            <label for="price">Price </label>
            <form:input type="text" path="price" name="price" />
        </p>
        <p>
            <label for="activity">Status </label>
            <form:select path="activity" id="activity">
                <form:option  value=" " label="Select Status"/>
                <form:options  items="${enums}"/>
            </form:select>
        </p>
        <p>
            <label for="category">Category </label>
            <form:select path="category" id="category">
                <form:option  value=" " label="Select Category"/>
                <form:options  items="${categories}"/>

            </form:select>
        </p>


        <p id="buttons">
            <input id="submit" type="submit"   value="Add Product">
        </p>

    </form:form>
</div>

</body>
</html>

