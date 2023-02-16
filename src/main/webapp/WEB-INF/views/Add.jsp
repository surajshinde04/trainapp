<%@page import="com.jspiders.train.pojo.TrainPOJO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="Nav.jsp" />
<%
TrainPOJO train = (TrainPOJO) request.getAttribute("train");
String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Train</title>
<style type="text/css">
form {
	margin-top: 10px;
}

form table {
	margin: auto;
	width: 100%;
}

tr {
	text-align: center;
}

fieldset table {
	margin: auto;
	text-align: left;
}

fieldset {
	margin: 15px 520px;
	text-align: center;
}

legend {
	color: white;
	background-color: #333;
}

body {
	background-image:
		url('https://www.xmple.com/wallpaper/linear-blue-white-highlight-gradient-1920x1080-c2-ffffff-e0ffff-l-50-a-165-f-21.svg');
	background-size: 100%;
}
</style>
</head>
<body>
	<fieldset>
		<legend>:::Add Train Details:::</legend>
		<form action="./add" method="post">
			<table>
				<tr>
					<td>Train Number :</td>
					<td><input type="text" name="train_number"></td>
				</tr>
				<tr>
					<td>Train Name :</td>
					<td><input type="text" name="train_name"></td>
				</tr>
				<tr>
					<td>From :</td>
					<td><input type="text" name="from"></td>
				</tr>
				<tr>
					<td>To :</td>
					<td><input type="text" name="to"></td>
				</tr>
				<tr>
					<td>Total KMS :</td>
					<td><input type="text" name="total_kms"></td>
				</tr>
				<tr>
					<td>Depart Time :</td>
					<td><input type="text" name="depart_time"></td>
				</tr>
				<tr>
					<td>Arrival Time :</td>
					<td><input type="text" name="arrival_time"></td>
				</tr>
				<tr>
					<td>Total Travelling Hours :</td>
					<td><input type="text" name="total_travelling_hours"></td>
				</tr>
				<tr>
					<td>Username</td>
					<td><input type="text" name="username"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="text" name="password"></td>
				</tr>
				<tr>
				<td><input type="submit" value="Add"></td>
				</tr>
			</table>
		</form>
	</fieldset>
	<%
	if (msg != null) {
	%>
	<h3 align="center">
		<%=msg%>
	</h3>
	<%
	}
	%>
</body>
</html>