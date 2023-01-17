<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Area Riservata</title>
<link rel="stylesheet" type= "text/css" href="../../css/style.css" />
<link rel="stylesheet" type= "text/css" href="../../css/customstyle.css" />
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;500;600;700&display=swap" rel="stylesheet"> 
<script src="https://kit.fontawesome.com/3352ada0d1.js" crossorigin="anonymous"></script>
</head>
<body>
	<h1>Area Riservata</h1>
		<form class="form" action="j_security_check" name="Registrazione" method="POST">
			<label for="username">Username:</label>
			<input type="text" name="j_username" placeholder="Inserisci Username" required="required"/> <br />
			<label for="password">Password:</label>
			<input type="password" name="j_password" placeholder="Inserisci Password" required="required"/> <br /> <br >
			
			<input id="login" class="button" type="submit" value="Accedi" /> 
			
			Non sei registrato? <a href="../../registrazione.html">Registrati</a> 	
	<%
			String show = request.getParameter("show");
			if (show != null && show.equals("logerror"))
				out.println("<div><p>Username o password errata</p></div>");
	%>	
	</form>
	
	<p><i class="fas fa-arrow-left"></i><a href="../../index.html">Torna alla home page</a></p>
	
	
	
</body>
</html>