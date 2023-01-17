<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout</title>
<link rel="stylesheet" type= "text/css" href="css/style.css" />
<link rel="stylesheet" type= "text/css" href="css/customstyle.css" />
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;500;600;700&display=swap" rel="stylesheet"> 
<script src="https://kit.fontawesome.com/3352ada0d1.js" crossorigin="anonymous"></script>
</head>
<body>
Ciao <%= request.getRemoteUser() %> <br />
<%request.logout(); %>
<p>Logout effettuato con successo</p>
<p><i class="fas fa-arrow-left"></i><a href="index.html">Torna alla home page</a></p>
</body>
</html>