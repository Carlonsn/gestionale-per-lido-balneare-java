<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.CarrelloBean" %>
<%@ page import="model.Prodotto" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Carrello</title>
	<link rel="stylesheet" type= "text/css" href="../../css/customstyle.css" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>		
	<script type="text/javascript" src="../../js/utente/ordine.js"></script>
	<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;500;600;700&display=swap" rel="stylesheet"> 
	<script src="https://kit.fontawesome.com/3352ada0d1.js" crossorigin="anonymous"></script>
</head>

<body>

	<% 	
		CarrelloBean c = (CarrelloBean) session.getAttribute("carrello");
		
	%>
	<h1>Riepilogo Ordinazioni</h1>
		<form id="pagamento" class="form" name="pagamento" method="POST">
			
			<div id="response" ></div>
			<div id="response2" ></div>		
			
			<input id="ordina" class="button" type="submit" value="Ordina">
		</form>
		<p><i class="fas fa-arrow-left"></i><a href="menulido.jsp">Torna al menu'</a></p>
		<p><i class="fas fa-arrow-left"></i><a href="index.jsp">Torna all'area utente</a></p>
</body>
</html>