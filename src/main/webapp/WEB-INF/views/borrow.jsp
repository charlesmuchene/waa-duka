<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 11/18/19
  Time: 11:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Borrow Page</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/custom.css" type="text/css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-lg-6">
            <div id="form-div" class="row">
                <div class="col-lg-12 header-title">
                    <h5 class="title">Product borrowing</h5>
                </div>
                <div class="col-lg-6">
                    <form:form modelAttribute="newBorrow" method="POST" action="/duka/borrow">
                        <input id="rentPerHour" value="${productToRent.rentPerHour}" type="hidden"/>
                        <div class="form-group">
                            <label for="product">Product:
                                <input readonly id="product" value="${productToRent.name}" class="form-control"/>
                            </label>
                        </div>
                        <div class="form-group">
                            <label for="borrowedDate">From:</label>
                            <form:input path="borrowedDate" pattern="MM/dd/yyyy hh:mm" placeholder="MM/dd/yyyy hh:mm"
                                        type="datetime" name="borrowedDate" cssClass="form-control"/>
                            <form:errors path="borrowedDate" cssClass="error"/>
                        </div>
                        <div class="form-group">
                            <label for="returnDate">To:</label>
                            <form:input path="returnDate" pattern="MM/dd/yyyy hh:mm" placeholder="MM/dd/yyyy hh:mm"
                                        type="datetime" name="returnDate" cssClass="form-control"/>
                            <form:errors path="returnDate" cssClass="error"/>
                        </div>
                        <div class="form-group">
                            <label for="product">Total Payment ($):
                                <form:input readonly="true" path="amountPaid" value="0" class="form-control"/>
                            </label>
                        </div>
                        <div class="form-group">
                            <input type="submit" class="btn btn-success" id="procBtn" value="Proceed">
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
        <div class="col-lg-6">
            <div class="row">
                <div class="col-lg-12 header-title">
                    <h5 class="title">I can help you check <q><c:out value="${productToRent.name}"/></q> availability.</h5>
                    <form id="avail-form" class="row">
                        <div class="col-lg-5">
                            <label for="startDate" class="control-label">From:</label>
                            <input name="startDate" placeholder="MM/dd/yyyy hh:mm" pattern="MM/dd/yyyy hh:mm"
                                   type="datetime" id="startDate" class="form-control"/>
                        </div>
                        <div class="col-lg-5">
                            <label for="endDate">To:</label>
                            <input name="endDate" placeholder="MM/dd/yyyy hh:mm" pattern="MM/dd/yyyy hh:mm"
                                   type="datetime" id="endDate" class="form-control"/>
                        </div>
                        <div class="col-lg-2">
                            <input type="submit" value="Check" class="btn btn-success"/>
                        </div>
                    </form>
                </div>
            </div>
            <div class="row" id="availableTimeSlots">

            </div>
        </div>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/validations.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/custom.js"></script>
</body>
</html>
