<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="pacchetto.model.ProdottiBean"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="icon" type="image/x-icon" href="./image/icona_catalogo.png">
<link rel="stylesheet" type="text/css" href="./css/Bottone.css">
<title> Dettagli del prodotto </title>
</head>
<body>
<%@ include file = "../fragments/header.jsp" %>
<h1 align="center"> Dettagli del prodotto </h1>

<%
ProdottiBean prod= (ProdottiBean) request.getAttribute("descrizione");
String nome = prod.getPat().substring(prod.getPat().lastIndexOf("image")+6);
%>


<div class="card">
<p>
<script type="text/javascript" src="./resources/imageZoom.js"></script>
<img onmouseover="bigImg(this)" onmouseout="normalImg(this)" border="0" src="./image/<%= nome %>" height="180" width="180">
<br><b> <%= prod.getNome() %> </b></p>
<p>Descrizione:<br> <%= prod.getDescrizione() %><br>
Disponibilita: <%= prod.getDisponibilita() %><br>
Quantita: <%= prod.getQuantita() %><br>
Codice Prodotto: <%= prod.getId() %><br>
<b>Prezzo: <%= String.format("%.2f",prod.getPrezzo()) %> &euro; </b> </p>
</div>

<div class="container"  align="center">
<a class="a" href="Controllo?action=aggiungi&id=<%= prod.getId() %>">
<input type="button" class="small" value="Aggiungi al carrello">
</a>
<a class="a" href="ProdottiCarrello.jsp">
<input type="button" class="small" value="Visualizza carrello">
</a>
</div>
<br><br>
<%@ include file="../fragments/footer.jsp" %>
</body>
</html>