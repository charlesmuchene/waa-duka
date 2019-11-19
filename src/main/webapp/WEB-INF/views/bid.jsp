<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Bid Product</title>
</head>
<body>
<div class="container">

    <a href="#" id="bid_link">Bid sample product</a>
    <span id="bid_span">No bid</span>

</div>
<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
<script type="text/javascript" src="<spring:url value="/resources/js/stomp.js"/>"></script>
<script type="text/javascript" src="<spring:url value="/resources/js/bid.js"/>"></script>
</body>
</html>
