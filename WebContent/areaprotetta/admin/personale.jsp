<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Personale</title>
	<link rel="stylesheet" type= "text/css" href="../../css/customstyle.css" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>		
	<script type="text/javascript" src="../../js/admin/personale.js"></script>
	<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;500;600;700&display=swap" rel="stylesheet"> 
	<script src="https://kit.fontawesome.com/3352ada0d1.js" crossorigin="anonymous"></script>
</head>

<body>
	<h1> Gestione Personale</h1><br />
	<form id= "addpersonale" class="form" name="aggiungipersonale" method="POST">
			<h2>Aggiungi Personale</h2>
			<label for="username">Username:</label>
			<input id="username" type="text" name="username" required="required" placeholder="Inserisci Username" 
			pattern="[a-zA-Z0-9_-]{3,}" title="Minimo 3 caratteri, Lettere maiuscole, minuscole, numeri o _-"/> <br />
			<label for="nome">Nome:</label>
			<input id="nome" type="text" name="nome" required="required" placeholder="Inserisci Nome" pattern="[A-Z]{1}[a-zA-Z]{2,}" 
				title="Inserire solo lettere, minimo 3 caratteri e prima lettera maiuscola. Se avete piu' nomi, inseritene solo uno" /> <br />
			<label for="cognome">Cognome:</label>
			<input id="cognome" type="text" name="cognome" required="required" placeholder="Inserisci Cognome" pattern="[A-Z]{1}[a-zA-Z]{2,}" 
				title="Inserire solo lettere, minimo 3 caratteri e prima lettera maiuscola. Se avete piu' nomi, inseritene solo uno" /> <br />
			<label for="email">Email:</label>
			<input id ="email" type="email" name="email" required="required" placeholder="esempio@abc.com" 
			pattern="[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}" /> <br />
			<label for="pwd">Password:</label>
			<input id ="pwd" type="password" name="pwd" required="required" placeholder="Inserisci Password" pattern ="[a-zA-Z0-9_-]{3,}" 
				title="Minimo 3 caratteri. Inserire solo lettere maiuscole, minuscole, numeri o _-"/> <br />
			<label for="cpwd">Conferma Password:</label>
			<input id ="cpwd" type="password" name="cpwd" required="required" placeholder="Conferma Password" /> <br /> <br />
			<fieldset class="fieldset">
				<legend>Seleziona Ruolo:</legend>
  				<label for="amministratore">Amministratore</label>
  				<input id="amministratore" type="radio" name="ruolo" value="A" checked="checked">
  				<label for="bagnino">Bagnino</label>
  				<input id="bagnino" type="radio" name="ruolo" value="B">
  				<label for="cuoco">Cuoco</label>
				<input id="cuoco" type="radio" name="ruolo" value="C"> <br /> <br />
			</fieldset>
			<input id="add" class="button" type="submit" value="Aggiungi personale" /> 
			<div id="response"></div>
		</form>
		
		<!-- DIV per stampare la risposta della servlet Aggiungi Bagnino -->
		
		 <br /> <br />
	
	<div class="option">
		<form id= "rempersonale" class="form" name="rimuovipersonale" method="POST">
		<h2>Rimuovi Personale</h2>
		<label for="user">Digita l'username</label>
		<input id="user" type="text" name="user" required="required" placeholder="Inserisci Username" /> 
		<input id="listapersonale" class="button" type="button" name="lista" value="Mostra Personale">
		<fieldset class="fieldset">
			<legend>Seleziona Ruolo:</legend>
  			<label for="admin">Amministratore</label>
  			<input id="admin" type="radio" name="ruolo1" value="A" checked ="checked">
  			<label for="bagn">Bagnino</label>
  			<input id="bagn" type="radio" name="ruolo1" value="B"> 
  			<label for="cuoc">Cuoco</label>
  			<input id="cuoc" type="radio" name="ruolo1" value="C"> <br /> <br />
		</fieldset>
	  <input id="remove" class="button" type="submit" name="remove" value="Rimuovi personale">
	  <div id="response1"></div>
		</form>
	</div>
	
	<p><i class="fas fa-arrow-left"></i><a href="index.jsp">Torna all'area amministrativa</a></p>
</body>
</html>