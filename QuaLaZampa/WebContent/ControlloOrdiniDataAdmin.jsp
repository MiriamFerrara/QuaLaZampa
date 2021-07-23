<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="icon" type="image/x-icon" href="./image/icona_utente.jpg">
<link rel="stylesheet" type="text/css" href="./css/Bottone.css">
<title>lista ordini Data </title>
</head>
<body>
<%@ include file = "../fragments/headerAmministratore.jsp" %>
<div align="center">
<h1>Visualizza ordini per data</h1>
<h2>Seleziona la data desiderata per visualizzare tutti gli ordini effettuati nell'intervallo di date scelto</h2>
</div>
<form action="CercaClienteData" method="post">
<div align="center">
Inserisci la data di inizio:<br><input type="date" name="dataInizio"><br><br>
Inserisci la data di fine:<br><input type="date" name="dataFine"><br><br>

<input type="submit" value="Cerca" class="small" style=" height:50px; width:180px;">
</div>
</form>

</body>
</html>