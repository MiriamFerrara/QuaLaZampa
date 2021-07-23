<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="java.util.*, pacchetto.model.*"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Amministratore</title>
<link rel="icon" type="image/x-icon" href="./image/icona_utente.jpg">
<link rel="stylesheet" type="text/css" href="./css/Bottone.css">
<link rel="stylesheet" type="text/css" href="./css/Struttura.css">

</head>
<body>
<%
ArrayList<?> prod= (ArrayList<?>) request.getAttribute("prodotti");
if (prod == null){
	response.sendRedirect("./Amministratore");
	return;
}

ClienteBean cerca= (ClienteBean)request.getAttribute("admin");
%>
<%@ include file = "../fragments/headerAmministratore.jsp" %>

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
<img src="./image/<%= nome %>" height="180" width="180">
<br><b> <%= ben.getNome() %> </b></p>
<p>Descrizione:<br> <%= ben.getDescrizione() %><br>
Codice Prodotto: <%= ben.getId() %><br>
<b>Prezzo: <%= ben.getPrezzo() %> &euro; </b> </p>
 
 
 <p class="card button1">
<a href="Amministratore?action=dettagli&id=<%= ben.getId() %>">
<input type="button" class="pulsante-small" value="Dettagli prodotto">
</a>
<a href="Amministratore?action=modifica&id=<%= ben.getId() %>">
<input type="button" class="pulsante-small" value="Modifica">
</a>
</p>

<form action="EliminaProdAdmin" method="get">
<p class="card button1"><input type="hidden" name="id" value="<%= ben.getId()%>">
<input type="submit" class="pulsante-small" value="Elimina">
</p>
</form>

</div></div>
<%
	}
}
%>
</div>
<br>
<div align="center">
<a href="Amministratore?action=aggiungi">
<input type="button" class="small"  style="background-color: #f7b657;height:80px;width:400px;" value="Aggiungi prodotto al catalogo">
</a>
</div>
<br><br>
</body>
</html>