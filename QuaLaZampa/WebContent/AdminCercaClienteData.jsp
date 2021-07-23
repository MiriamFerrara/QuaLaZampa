<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="java.util.*, pacchetto.model.*"
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
<h1 align="center">Gli ordini effettuati trovati per Data sono:</h1>

<% 
ArrayList<?> utente = (ArrayList<?>) request.getAttribute("ordine");
if (utente.size() == 0) {
%>

<h3 align="center"> Nell'intervallo di tempo selezionato non c'è alcun acquisto </h3>

<%
}
else {
%>
<div class="f">
<table>
<tr>
<th> Id dell'ordine </th>
<th> Stato dell'ordine </th>
<th> Data dell'ordine </th>
<th> Prezzo dell'ordine </th> 
</tr>

<%
if (utente != null && utente.size() != 0) {
	Iterator<?> it= utente.iterator();
	while (it.hasNext()) {
		OrdineBean ben= (OrdineBean) it.next();
%>

<tr>
<td> <%= ben.getIdOrdine() %> </td>
<td> <%= ben.getStatoOrdine() %> </td>
<td> <%= ben.getDataOrdine() %> </td>
<td> <%= String.format("%.2f",ben.getPrezzoTot()) %> </td>
</tr>

<%
}
}
}
%>

</table>
</div>
</body>
</html>