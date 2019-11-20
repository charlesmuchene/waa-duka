<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="<spring:url value="/resources/css/main.css"/>">
    <title>Bid Product</title>
</head>
<body>
<div id="product_bid_div">
    <div class="row justify-content-center">
        <div class="card" style="width: 300px; margin-top: 5%">
            <img src="<spring:url value="/resources/images/sample_product.jpg"/>" class="card-img-top"
                 alt="Product" width="200px">
            <div class="card-body">
                <h5 class="card-title">Village Kitchen Table</h5>
                <p class="card-text">
                    This is the best product you can ever bid on.
                    Customers
                    all over the world enjoy this kind.
                    You are one in a thousand if you own it.
                </p>
                Current bid: <span id="price_span">Kes. 14,500</span>
                <hr>
                <div class="row align-items-center">
                    <div class="col-sm-9">
                        <input type="number" placeholder="Enter amount"
                               class="form-control" value="20000" required id="bid_amount">
                    </div>
                    <div class="col-sm-2">
                        <a href="#" class="btn btn-primary" id="bid_link">Bid</a>
                    </div>
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
