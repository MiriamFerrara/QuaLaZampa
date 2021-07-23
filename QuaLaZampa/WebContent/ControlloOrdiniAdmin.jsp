<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="icon" type="image/x-icon" href="./image/icona_utente.jpg">
<link rel="stylesheet" type="text/css" href="./css/Bottone.css">
<title>lista ordini nome cliente </title>
</head>
<body>
<%@ include file = "../fragments/headerAmministratore.jsp" %>
<div align="center">
<h1> Inserisci il nome del cliente per visualizzare i suoi ordini </h1>
<form action="CercaCliente" method="post">
<input type="search" name="nome" placeholder="Inserisci nome cliente">
<input type="submit" value="Cerca" class="small" style=" font-size: 14px; padding:0px 2px;height:20px; width:100px;">
</form>
</div>
</body>
</html>