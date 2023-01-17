<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Riepilogo Guadagni</title>
<link rel="stylesheet" type= "text/css" href="../../css/customstyle.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>		
<script type="text/javascript" src="../../js/admin/guadagni.js"></script>
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;500;600;700&display=swap" rel="stylesheet"> 
<script src="https://kit.fontawesome.com/3352ada0d1.js" crossorigin="anonymous"></script>
</head>
<body>
	
	<h1>Riepilogo Guadagni</h1>
	
	<span>Totale Guadagni: </span> <span id="totale"></span>
	
	<input id="totPren" class="button" type="button" value="Guadagni da Prenotazioni">
	<input id="totOrd" class="button" type="button" value="Guadagni da Ordinazioni">
	
	<div id="periodoguadagni" style="display:none" >
		<form id="inviadata" class="form" method ="POST">
  			<label for="dataInizio">Inserisci la data inizio:</label>
  			<input type="date" id="dataInizio" name="dataInizio" required>
  			<label for="dataFine">Inserisci la data fine:</label>
  			<input type="date" id="dataFine" name="dataFine" required >
  			<input class="button" type="submit" value="Invia">
  		</form>
	</div>
	<div class="form" id="response"></div>
	<p><i class="fas fa-arrow-left"></i><a href="index.jsp">Torna all'area amministrativa</a></p>
</body>
</html>