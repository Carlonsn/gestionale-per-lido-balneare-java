<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Area Cucina</title>
	<link rel="stylesheet" type= "text/css" href="../../css/customstyle.css" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>		
	<script type="text/javascript" src="../../js/cuoco/viewOrdinazioni.js"></script>
	<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;500;600;700&display=swap" rel="stylesheet"> 
	<script src="https://kit.fontawesome.com/3352ada0d1.js" crossorigin="anonymous"></script>
</head>

<body>

	<h2> Benvenuto <%= request.getRemoteUser() %></h2>
	

	<div id="response" class="form"></div>
	
	<p><a href="../../logout.jsp">Logout</a></p>
</body>
</html>