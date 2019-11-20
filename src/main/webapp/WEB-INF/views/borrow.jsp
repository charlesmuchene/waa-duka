<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 11/18/19
  Time: 11:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Borrow Page</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link href="resources/css/custom.css" type="text/css" rel="stylesheet">
</head>
<body>
    <div class="col-lg-6">
        <div id="form-div">
            <div class="col-lg-6">
                <form:form modelAttribute="newBorrow" method="POST" action="borrow">
                    <form:input path="product.id" value="1" type="hidden"/>
                    <div class="form-group">
                        <label for="product">Product:
                            <input readonly id="product" value="Muchene's bike" class="form-control"/>
                        </label>
                    </div>
                    <div class="form-group">
                        <label for="borrowedDate">From:</label>
                        <form:input path="borrowedDate" type="datetime" name="borrowedDate" cssClass="form-control"/>
                        <form:errors path="borrowedDate" cssClass="error"/>
                    </div>
                    <div class="form-group">
                        <label for="returnDate">To:</label>
                        <form:input path="returnDate" type="datetime" name="returnDate" cssClass="form-control"/>
                        <form:errors path="returnDate" cssClass="error"/>
                    </div>
                    <div class="form-group">
                        <label for="product">Total Payment ($):
                            <input readonly id="amountPaid" value="0" class="form-control"/>
                        </label>
                    </div>
                    <div class="form-group">
                        <input type="submit" class="btn btn-success" id="procBtn" value="Proceed">
                    </div>
                </form:form>
            </div>
        </div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="resources/js/validations.js"></script>
    <script src="resources/js/custom.js"></script>
</body>
</html>
