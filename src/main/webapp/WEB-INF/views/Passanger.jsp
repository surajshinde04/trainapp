<%@page import="com.jspiders.train.pojo.TrainPOJO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
TrainPOJO train = (TrainPOJO) request.getAttribute("train");
String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Train</title>
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

#data {
	background-color: white;
	border: 1px solid black;
	width: 100%;
	border: 1px solid black;
}

#data td {
	border: 1px solid black;
	text-align: center;
}
</style>
</head>
<body>
	<fieldset>
		<legend>:::Search Details:::</legend>
		<form action="./searchtrain" method="post">
			<table>
				<tr>
					<td>Enter Train Number</td>
					<td><input type="text" name="train_number"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Search"></td>
				</tr>
			</table>
		</form>
	</fieldset>
	<%
	if (train != null) {
	%>
	<table id="data">
		<tr>
			<th>Train_Number</th>
			<th>Train_Name</th>
			<th>From_Station</th>
			<th>To_Station</th>
			<th>Total_KMS</th>
			<th>Depart_Time</th>
			<th>Arrival_Time</th>
			<th>Total_Travelling_Hours</th>
		</tr>
		<tr>
			<td><%=train.getTrain_number()%></td>
			<td><%=train.getTrain_name()%></td>
			<td><%=train.getFrom_station()%></td>
			<td><%=train.getTo_station()%></td>
			<td><%=train.getTotal_kms()%></td>
			<td><%=train.getDepart_time()%></td>
			<td><%=train.getArrival_time()%></td>
			<td><%=train.getTotal_travelling_hours()%></td>
		</tr>
	</table>
	<%
	}
	%>
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