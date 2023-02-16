<%@page import="com.jspiders.train.pojo.TrainPOJO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="Nav.jsp" />
<%
TrainPOJO train = (TrainPOJO) request.getAttribute("train");
List<TrainPOJO> trains = (List<TrainPOJO>) request.getAttribute("trains");
String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Train</title>
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
	<%
	if (train != null) {
	%>
	<fieldset>
		<legend>:::Update Train:::</legend>
		<form action="./updateData" method="post">
			<table>
				<tr hidden="true">
					<td>ID</td>
					<td><input type="text" value="<%=train.getId()%>" name="id"></td>
				</tr>
				<tr hidden="true">
					<td>Train Number :</td>
					<td><input type="text" value="<%=train.getTrain_number() %>" name="train_number"></td>
				</tr>		
				<tr>
					<td>Train Name :</td>
					<td><input type="text" value="<%=train.getTrain_name() %>" name="train_name"></td>
				</tr>
				<tr>
					<td>From :</td>
					<td><input type="text" value="<%=train.getFrom_station() %>" name="from"></td>
				</tr>
				<tr>
					<td>To :</td>
					<td><input type="text"value="<%=train.getTo_station() %>" name="to"></td>
				</tr>
				<tr>
					<td>Total KMS :</td>
					<td><input type="text"value="<%=train.getTotal_kms() %>" name="total_kms"></td>
				</tr>
				<tr>
					<td>Depart Time :</td>
					<td><input type="text"value="<%=train.getDepart_time()%>" name="depart_time"></td>
				</tr>
				<tr>
					<td>Arrival Time :</td>
					<td><input type="text" value="<%=train.getArrival_time() %>"name="arrival_time"></td>
				</tr>
				<tr>
					<td>Total Travelling Hours :</td>
					<td><input type="text" value="<%=train.getTotal_travelling_hours() %>"name="total_travelling_hours"></td>
				</tr>
				<tr>
					<td><input type="submit" value="UPDATE"></td>
				</tr>
				
			</table>
		</form>
	</fieldset>
	<%
	} else {
	%>
	<fieldset>
		<legend>:::Select Train:::</legend>
		<form action="./update" method="post">
			<table>
				<tr>
					<td>Enter Train_Number</td>
					<td><input type="text" name="train_number"></td>
				</tr>
				<tr>
					<td><input type="submit" value="SELECT"></td>
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
	<%
	if (trains != null) {
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
			<th>Total_Travelling_KMS</th>
		</tr>
		<%
		for (TrainPOJO trainData : trains) {
		%>
		<tr>
			<td><%=trainData.getTrain_number()%></td>
			<td><%=trainData.getTrain_name()%></td>
			<td><%=trainData.getFrom_station()%></td>
			<td><%=trainData.getTo_station()%></td>
			<td><%=trainData.getTotal_kms()%></td>
			<td><%=trainData.getDepart_time()%></td>
			<td><%=trainData.getArrival_time()%></td>
			<td><%=trainData.getTotal_travelling_hours()%></td>
		</tr>
		<%
		}
		%>
	</table>
	<%
	}
	}
	%>
</body>
</html>