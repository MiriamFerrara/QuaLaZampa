<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="icon" type="image/x-icon" href="./image/icona_utente.jpg">
<link rel="stylesheet" type="text/css" href="./css/Login.css">
<link rel="stylesheet" type="text/css" href="./css/Struttura.css">
<script src="./resources/Ajax.js"></script>

<title>Registrazione</title>
</head>
<body>
<img src="./image/logo.png" class="img-logo" width="200" height="200" >
<h1 align="center">Registrazione</h1>

<div class="container">
<p>Compila questo modulo per creare un account.</p><br>

<label><b>Nome:</b></label>    
<input type="text" name="nome" id="nome" placeholder="Inserisci nome" required>

<label><b>Cognome:</b></label>
<input type="text" name="cognome" id="cognome" placeholder="Inserisci cognome" required>

<label><b>Username:</b></label>
<input type="text" name="username" id="username" placeholder="Inserisci username" required>

<label><b>Email:</b></label>   
<input type="email" name="email" id="email" placeholder="Inserisci email" required>

<label><b>Nuova Password:</b></label>
<input type="password" name="new password" id="password" placeholder="Inserisci password" required>

<label><b>Ripeti Password:</b></label>
<input type="password" name="rip password" id="ripPassword" placeholder="Reinserisci password" required>

<label><b>Telefono:</b></label>
<input type="text" name="telefono" id="telefono" placeholder="Inserisci num.Telefono: 123 123 1234" required>

<label><b>Codice Fiscale:</b></label>
<input type="text" name="codice" id="codice" placeholder="Inserisci codice fiscale" required>

<label><b>Provincia:</b></label>
<input type="text" name="provincia" id="provincia" placeholder="Inserisci la provincia" required>

<label><b>Cap:</b></label>
<input type="text" name="cap" id="cap" placeholder="Inserisci il cap" required>

<label><b>Città:</b></label>
<input type="text" name="citta" id="citta" placeholder="Inserisci la città" required>

<label><b>Via:</b></label>
<input type="text" name="via" id="via" placeholder="Inserisci la via" required> <br><br>

<input type="button" class="login" id="submit" value="Registrati">
</div>

<script src="./resources/ajaxRegistrazione.js"></script>

<br>
<div class="clicca">
Hai gia un account? <a href="PageLogin.jsp"><input type="button" value="clicca qui" style="background-color: #ffd963; text-align: center;color:black; font-weight:bold; border: 2px solid black;"></a>
</div>

<%@ include file = "../fragments/footerSemplice.jsp" %>
</body>
</html>