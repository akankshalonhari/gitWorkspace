<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>	
	<c:url value="/css/main.css" var="jstlCss" />
	<link href="${jstlCss}" rel="stylesheet" />

</head>
<body>
	<div class="container">
		<div class="starter-template">
			<h1>Current Weather Details</h1>
			<h2>City : ${response.cityname}</h2>
			<h2>Weather conditions : ${response.weatherCondition}</h2>
			<h2>Weather Description : ${response.description}</h2> 
			<h2>Temperature : ${response.temperature}</h2>
			<h2>Temperature Min : ${response.temperatureMin}</h2>
			<h2>Temperature Max : ${response.temperatureMax}</h2>
			<h2>Humidity : ${response.humidity}</h2>
		</div>
	</div>
	<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>