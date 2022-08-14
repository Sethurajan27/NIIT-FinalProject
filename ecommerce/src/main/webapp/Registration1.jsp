<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="topnav" align="right">
		<a class="btn btn-primary btn-md" href="index.jsp">Login</a>&nbsp;&nbsp;
		<a class="btn btn-primary btn-md" href="About.jsp">AboutUs</a>&nbsp;&nbsp;
	</div>
	<h1 align="center" style="color: green;">Sign In</h1>
	<h3 align="center" style="color: red;">
		<%=request.getAttribute("message")%>
	</h3>
	<center>
		<form action="register" method="post">
			<table>
				<tr align="center">
					<td align="center">Full Name :</td>
					<td align="center"><input type="text" name="name"
						placeholder="Enter your Full-Name"></td>
				</tr>
				<tr align="center">
					<td align="center">Address :</td>
					<td align="center"><input type="text" name="address"
						placeholder="Enter your Address"></td>
				</tr>
				<tr align="center">
					<td align="center">Contact :</td>
					<td align="center"><input type="text" name="contact"
						placeholder="Enter your Contact"></td>
				</tr>
				<tr align="center">
					<td align="center">Email :</td>
					<td align="center"><input type="email" name="email"
						placeholder="Enter your Email"></td>
				</tr>
				<tr align="center">
					<td align="center">User Name :</td>
					<td align="center"><input type="text" name=userName
						placeholder="Enter your User Name"></td>
				</tr>
				<tr align="center">
					<td align="center">Password :</td>
					<td align="center"><input type="password" name="password"
						placeholder="Enter your Password"></td>
				</tr>
				<center>
					<tr align="center">
						<td align="center"><input type="submit" value="Sign in"
							class="btn btn-primary btn-md"></td>
					</tr>
				</center>
			</table>
		</form>
	</center>

</body>
</html>