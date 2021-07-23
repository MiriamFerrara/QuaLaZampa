<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="pacchetto.model.ProdottiBean"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="icon" type="image/x-icon" href="./image/icona_utente.jpg">
<link rel="stylesheet" type="text/css" href="./css/Login.css">
<link rel="stylesheet" type="text/css" href="./css/Struttura.css">
<title>Modifica</title>
</head>
<body>
<%@ include file = "../fragments/headerAmministratore.jsp" %>
<% ProdottiBean prod= (ProdottiBean) request.getAttribute("modifica"); %>
<div align="center">
<h1>Modifica del Prodotto<br><br>
<%= prod.getNome() %></h1>
</div>
<div class="container">
<form action="Modifica"  method="get">
<input type="hidden" name="id" value="<%= prod.getId() %>" >
<p>Modifica Prodotto</p><br>

<label><b>Nome:</b></label><br>
<input type="text" name="nome" placeholder="Inserisci nome" required>

<label><b>Descrizione:</b></label><br>
<input type="text" name="descrizione" placeholder="Inserisci descrizione" required>

<label><b>Quantità:</b></label><br>
<input type="text" name="quantita" placeholder="Inserisci quantita" required>

<label><b>Iva:</b></label><br>
<input type="text" name="iva" placeholder="Inserisci iva" required>

<label><b>Prezzo:</b></label><br>
<input type="text" name="prezzo" placeholder="Inserisci prezzo" required>

<label><b>Disponibilità:</b></label><br> 
<input type="text" name="disponibilita" placeholder="Inserisci disponibilita" required>

<input type="submit" class="login" value="modifica">
</form>
</div>

</body>
</html>