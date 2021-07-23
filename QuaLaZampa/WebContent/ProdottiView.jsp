<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="java.util.*, pacchetto.model.ProdottiBean"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" type="image/x-icon" href="./image/icona_catalogo.png">
<link rel="stylesheet" type="text/css" href="./css/Struttura.css">
<link rel="stylesheet" type="text/css" href="./css/Bottone.css">
<script src="./resources/Ajax.js"></script>

<title>Catalogo</title>
</head>
<body>

<%
ArrayList<?> prod= (ArrayList<?>) request.getAttribute("prodotti");

if (prod == null){
	response.sendRedirect("./Controllo");
	return;
}
%>
<%@ include file = "../fragments/header.jsp" %>

<div class="content">
  <img class="mySlides"src="./image/Benvenuto.png">
  <img class="mySlides" src="./image/0scorrimento.jpg">
  <img class="mySlides" src="./image/1scorrimento.jpeg">
  <img class="mySlides" src="./image/2scorrimento.jpeg">
  <img class="mySlides" src="./image/3scorrimento.jpeg">
  <img class="mySlides" src="./image/4scorrimento.jpeg">
</div>

<script src="./resources/imageScorrimento.js"></script>

<%@ include file="../fragments/menu.jsp" %>
<h1> Catalogo Prodotti </h1>

<%
if (prod != null && prod.size() != 0) {
	Iterator<?> it= prod.iterator();
	while (it.hasNext()) {
		ProdottiBean ben= (ProdottiBean) it.next();
		String nome= ben.getPat().substring(ben.getPat().lastIndexOf("image")+6);
%>
<div class="row">
 <div class="col">
<div class="card">
<p>
<script type="text/javascript" src="./resources/imageZoom.js"></script>
<img onmouseover="bigImg(this)" onmouseout="normalImg(this)" border="0" src="./image/<%= nome %>" height="180" width="180">
<br><b> <%= ben.getNome() %> </b></p>
<p>Descrizione:<br> <%= ben.getDescrizione() %><br>
Codice Prodotto: <%= ben.getId() %><br>
<b>Prezzo: <%= String.format("%.2f", ben.getPrezzo()) %> &euro; </b> </p>
 
 <p class="card button1">
<a href="Controllo?action=dettagli&id=<%= ben.getId() %>">
<input type="button" class="pulsante-small" value="Dettagli prodotto">
</a>
<a href="Controllo?action=aggiungi&id=<%= ben.getId() %>">
<input type="button" class="pulsante-small" value="Aggiungi al carrello">
</a><br><br>
</p>
</div>
</div>
<%
	}
}
%>
</div>
<br><br>
<%@ include file="../fragments/footer.jsp" %>
</body>
</html>