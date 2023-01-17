<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Area Amministrativa</title>
	<link rel="stylesheet" type= "text/css" href="../../css/customstyle.css" />
	<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;500;600;700&display=swap" rel="stylesheet"> 
	<script src="https://kit.fontawesome.com/3352ada0d1.js" crossorigin="anonymous"></script>
</head>

<body>
	
	<h1>Benvenuto <%= request.getRemoteUser() %></h1>
	<div class="option">
		<ul>
			<li><p><a href="personale.jsp" id="personale">Aggiungi/Rimuovi personale</a></p></li>
			<li><p><a href="guadagni.jsp" id="guadagni">Riepilogo guadagni</a></p></li>
			<li><p><a href="annullaprenotazione.jsp" id="annullapren">Annulla Prenotazione</a></p></li>
		</ul>
		
		

	</div>
	
	<p><a href="../../logout.jsp">Logout</a></p>
</body>
</html>