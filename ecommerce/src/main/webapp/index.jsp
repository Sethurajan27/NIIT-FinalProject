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
		<a class="btn btn-primary btn-md" href="index.jsp">Login</a>&nbsp; <a
			class="btn btn-primary btn-md" href="Registration.jsp">Sign In</a>&nbsp;
		<a class="btn btn-primary btn-md" href="About.jsp">AboutUs</a>&nbsp;&nbsp;
	</div>
	<h1 align="center"
		style="background-color: silver; color: navy; font-style: italic; font-size: 100px">Welcome
		to RS Shopping</h1>
	<center>
		<form action="login" method="post">
			<table>
				<tr>
					<td>USER NAME :</td>
					<td><input type="text" name="u" placeholder="Enter User Name"></td>
				</tr>
				<tr>
					<td>PASSWORD :</td>
					<td><input type="password" name="p"
						placeholder="Enter Password"></td>
				</tr>

				<tr align="center">
					<td><input type="submit" value="Login"
						class="btn btn-primary btn-md"></td>
			</table>

		</form>
	</center>

</body>
</html>

<!-- CREATE TABLE `user_details` (`Reg_ID` int NOT NULL AUTO_INCREMENT
COMMENT 'College Registration Id',`name` varchar(10) NOT NULL COMMENT
'Student Name',`branch` varchar(20) NOT NULL COMMENT 'Student
Branch',`Contact` varchar(13) NOT NULL COMMENT 'Contact no of
Student',`Email` varchar(30) NOT NULL COMMENT 'Email Address',`userName`
varchar(25) NOT NULL COMMENT 'username',`password` varchar(25) NOT NULL
COMMENT 'Password',PRIMARY KEY (`Reg_ID`)); -->
