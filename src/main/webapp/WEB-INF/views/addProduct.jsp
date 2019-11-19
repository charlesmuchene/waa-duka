<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE HTML>
<html>
<head>
    <title>Add Product Form</title>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
    <script type="text/javascript" src="<spring:url value="/js/ajax.js"/>"></script>
    <style type="text/css">@import url(css/main.css);</style>
    <style type="text/css">@import url(css/rest.css);</style>
</head>
<body>

<div id="global">
    <form action="OneToManyUniJoinTable" method="post">
        <fieldset>
            <legend>Add Product</legend>
            <p>
                <label for="number">Product Number </label>
                <input type="text" id="number" name="number" >
            </p>

            <p>
                <label for="name">Product Name </label>
                <input type="text" id="name" name="name" >
            </p>

            <p>
                <label for="serialNumber">SerialNumber </label>
                <input type="text" id="serialNumber" name="serialNumber" >
            </p>
            <p>
                <label for="category">Category </label>
                <input type="radio" name="onBid" value="onBid"> On Bid<br>
                <input type="radio" name="rental" value="rental"> Rental<br>
            </p>
            <input type="button" value="Add Description" onclick="make_visible('addDescription');return false;">

            <div id=description>
                Description:

            </div>

            <p id="buttons">
                <input id="submit" type="submit"   value="Add Product">
            </p>
        </fieldset>
    </form>
</div>

<div id="addDescription'" style="display:none" >

    <form  id="descriptionForm" method="post">
        <p>
            <label for="color">Color</label>
            <input type="text" id="color" name="color" size="16">
        </p>


        <input type="button" value="Submit" onclick="descriptionSubmit();return false;">
        <div align="center">
            <a href="#" onclick="make_hidden('addDescription');resetForm('descriptionForm');"> <b>EXIT</b> </a>
        </div>

    </form>
</div>


</body>
</html>

