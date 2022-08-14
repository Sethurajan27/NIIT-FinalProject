<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<head>
<meta charset="ISO-8859-1">
<title>Message</title>
</head>
<body>
	<div class="topnav" align="right">
		<a class="btn btn-primary btn-md" href="getAllCart">Cart</a>&nbsp;&nbsp;
		<a class="btn btn-primary btn-md" href="About.jsp">AboutUs</a>&nbsp;&nbsp;
		<a class="btn btn-primary btn-md" href="index.jsp">Log Out</a>&nbsp;&nbsp;
	</div>
	<h1 align="center"
		style="background-color: teal;; color: activeborder; font-style: italic; font-size: 50px">
		<%=request.getAttribute("messagePage")%></h1>
</body>
</html>