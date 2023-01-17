<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Access Denied</title>
<link rel="stylesheet" type= "text/css" href="../../css/style.css" />
<link rel="stylesheet" type= "text/css" href="../../css/customstyle.css" />
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;500;600;700&display=swap" rel="stylesheet"> 
<script src="https://kit.fontawesome.com/3352ada0d1.js" crossorigin="anonymous"></script>
</head>
<body>
<h1>NON HAI IL PERMESSO DI ACCEDERE A QUESTA RISORSA</h1>
<p><p><i class="fas fa-arrow-left"></i><a href="../../index.html">Torna alla Home Page</a></p>
<%request.logout();%>
</body>
</html>