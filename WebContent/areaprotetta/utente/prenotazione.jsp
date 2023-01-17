<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Prenotazione</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>		
	<script type="text/javascript" src="../../js/utente/listaombrelloni.js"></script>
	<script type="text/javascript" src="../../js/utente/prenotazione.js"></script>
	<link rel="stylesheet" type= "text/css" href="../../css/customstyle.css" />
	<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;500;600;700&display=swap" rel="stylesheet"> 
	<script src="https://kit.fontawesome.com/3352ada0d1.js" crossorigin="anonymous"></script>
</head>

<body>
	<h1>Prenota l'ombrellone che desideri</h1>

	<form id="data" class="form" method ="POST">
  		<label for="data_pren">Inserisci la data di prenotazione:</label>
  		<input type="date" id="data_pren" name="data_pren" required="required">
  		<input class="button" type="submit" value="Invia">
  		<div id="response"></div>
	</form>

	<p><i class="fas fa-arrow-left"></i><a href="index.jsp">Torna all'area utente</a></p>
</body>
</html>