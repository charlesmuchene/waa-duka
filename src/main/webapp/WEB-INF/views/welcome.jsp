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
				<img src="<spring:url value="/resources/images/geeks.jpg"/>" class="card-img-top"
					 alt="Product" height="150px"/>
<%--				<h1> ${greeting} </h1>--%>
<%--				<p> ${tagline} </p>--%>
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
		</div>	
	</section>
	<section style="margin-left: auto;margin-right: auto;width: 70%">
		<div>
	<security:authorize access="isAnonymous()">

<%--		<div>--%>

<%--			Search by Category :--%>
<%--	<spring:url value="/searchByCategory" var="results"/>--%>
<%--	<form:form modelAttribute="product" action="results" method="get">--%>

<%--		<form:select path="product.category_id" items="${categories}" itemValue="id" itemLabel="name"/>--%>
<%--		<input type="submit" value="update"/>--%>
<%-- 	</form:form>--%>

<%--		</div>--%>
		<spring:url var="search" value="/search"/>
		<form:form action="${search}" method="get">
			<input name="search" id="search" type="text" class="form-control" />
			<input type="submit" value="Search" class="btn btn-primary form-control" />
		</form:form>
		<c:forEach items="${products}" var="product">
			<div style="border:1px solid #f2f3f3;padding:2px;float:left;width:30%;text-align:center;overflow: hidden;margin: 5px">
				<h2>${product.name}</h2>

				<img src="<spring:url value="/resources/images/geeks.jpg"/>" class="card-img-top"
					 alt="Product" width="200px">



				<p>Price: <span id="price_span">${product.price}</span></p>

				Current bid: <span id="price_span">${product.price}</span>
				<hr>
				<div class="row align-items-center">
					<div class="col-sm-9">
						<input type="number" placeholder="Enter amount"
							   class="form-control" value="00" required id="bid_amount">
						<a href="#" class="btn btn-primary" id="bid_link">Bid</a>
					</div>
				</div>
			</div>

		</c:forEach>
	</security:authorize>
		</div>
	</section>
</body>
</html>
