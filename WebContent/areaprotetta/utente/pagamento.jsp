<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.Ombrellone" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Pagamento</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>		
	<script type="text/javascript" src="../../js/utente/pagamento.js"></script>
	<link rel="stylesheet" type= "text/css" href="../../css/customstyle.css" />
	<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;500;600;700&display=swap" rel="stylesheet"> 
	<script src="https://kit.fontawesome.com/3352ada0d1.js" crossorigin="anonymous"></script>
</head>

<body>
	
	<% 	
		Ombrellone o = (Ombrellone) session.getAttribute("ombrellone"); 
	%>
	
	
	<h1>Riepilogo Prenotazione</h1>
	
	<form id="pagamento" class="form" name="pagamento" method="POST">
	<table>
		<tr>
			<th>ID</th>
			<th>Riga</th>
 			<th>Posto</th>
 			<th>Prezzo</th>
 		</tr>
		<tr>
			<td><%= o.getId() %></td>
			<td><%= o.getRiga() %></td>
			<td><%= o.getPosto() %></td>
			<td><%= o.getPrezzo() %></td>
		</tr>
	</table>	
	<fieldset class="fieldset">
	<legend>Seleziona metodo di pagamento:</legend>
	<label for="carta">Carta di credito</label>
	<input id="carta" type="radio" name="metodo" value="carta" checked="checked">
  	<label for="paypal">Paypal</label>
  	<input id="paypal" type="radio" name="metodo" value="paypal">
  	<label for="bonifico">Bonifico</label>
  	<input id="bonifico" type="radio" name="metodo" value="bonifico"> <br /> <br />
	</fieldset>
	<p>Totale: <%= o.getPrezzo() %> </p>
	<input class="button" type="submit" value="Paga"/>
	
	<div id="response"></div>
	</form>
	<p><i class="fas fa-arrow-left"></i><a href="prenotazione.jsp">Torna a prenota ombrellone</a></p>
	<p><i class="fas fa-arrow-left"></i><a href="index.jsp">Torna all'area utente</a></p>
</body>
</html>