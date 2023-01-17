<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Annulla Prenotazione</title>
	<link rel="stylesheet" type= "text/css" href="../../css/customstyle.css" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>		
	<script type="text/javascript" src="../../js/admin/annullaprenotazione.js"></script>
	<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;500;600;700&display=swap" rel="stylesheet"> 
	<script src="https://kit.fontawesome.com/3352ada0d1.js" crossorigin="anonymous"></script>
</head>

<body>
	
	<div class="option">
	<form id="annullapren" class="form" name="annullapren" method="POST">
		<label for="id">Digita ID Ombrellone</label>
		<input id="id" type="text" name="id" required="required" placeholder="Inserisci ID Ombrellone" /> <br /><br />
		<label for="data">Seleziona la data:</label>
		<input id="data" type="date" required="required">
		<input id="listaprenotazioni" class="button" type="button" name="lista" value="Mostra Prenotazioni">
		<input class="button" type="submit" name="annullapren" value="Annulla Prenotazione"> 
		<div id="response"></div>
	</form>
	</div>
		
		<p><i class="fas fa-arrow-left"></i><a href="index.jsp">Torna all'area amministrativa</a></p>
</body>
</html>