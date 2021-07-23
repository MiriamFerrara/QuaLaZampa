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

<title>Login</title>
</head>

<body>
<img src="./image/logo.png" class="img-logo" width="200" height="200" >
<div class="container">
<h1 align="center">Accedi</h1>

<p>Inserisci i tuoi dati per Accedere</p><br>

<label><b>Email:</b></label><br>
<input type="text" name="email" id="email1" placeholder="Inserisci email" required>

<label><b>Password:</b></label><br> 
<input type="password" name="password" id="password1" placeholder="Inserisci password" required>

<input type="button" class="login" id="submit" value="Accedi"><br>


<br>
<div class="clicca">
Se non sei ancora Registrato? <a href="LoginRegistrazione.jsp"><input type="button" value="clicca qui" style="background-color: #ffd963; text-align: center;color:black; font-weight:bold; border: 2px solid black;"></a>
<br><br>
Per procedere come ospite invece <a href="ProdottiView.jsp"><input type="button" value="clicca qui" style="background-color: #ffd963; text-align: center;color:black; font-weight:bold; border: 2px solid black;"></a>
</div>
</div>

<%@ include file = "../fragments/footerSemplice.jsp" %>
<script src="./resources/ajaxLogin.js"></script>

</body>
</html>