<%@page import="com.niit.entity.ProductDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<body>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="topnav" align="right">
		<a class="btn btn-primary btn-md" href="getAllCart">Cart</a>&nbsp;&nbsp;
		<a class="btn btn-primary btn-md" href="About.jsp">AboutUs</a>&nbsp;&nbsp;
		<a class="btn btn-primary btn-md" href="index.jsp">Log Out</a>&nbsp;&nbsp;
	</div>
	<h1 align="left"
		style="background-color: silver; color: navy; font-style: italic; font-size: 30px">
		Hello,
		<%=request.getAttribute("name")%><center>HOME Page</center>
	</h1>
	<center>
		<h1 align="center"
			style="color: green; font-style: italic; font-size: 30px">
			<%=request.getAttribute("message")%>
		</h1>
	</center>
	<div class="container">
		<div class="row">
			<c:forEach items="${products}" var="p">
				<form action="addToCart" method="post">
					<div class="col-sm-4">
						<div class="panel panel-primary">
							<div class="panel-heading">${p.productName}</div>
							<div class="panel-body">
								<center>
									<img src="images/${p.productName}.jpg"
										style="width: 170px; height: 150px;" />
								</center>
								<p>Price : ${p.productPrice}</p>
								<p>Seller : ${p.productSeller}</p>
							</div>
							<div class="panel-footer">
								<!-- <button type="button" name="browse"
									class="btn btn-primary btn-md">Browse</button> -->
								<input type="hidden" name="cartProdnm" value="${p.productName}">
								<input type="hidden" name="cartProdtyp" value="${p.productType}">
								<input type="hidden" name="cartProdprs"
									value="${p.productPrice}"> <input type="hidden"
									name="cartProdslr" value="${p.productSeller}"><input
									type="submit" value="Add to Cart"
									class="btn btn-primary btn-md">
							</div>
						</div>
					</div>
				</form>
			</c:forEach>
		</div>
	</div>
</body>
</html>