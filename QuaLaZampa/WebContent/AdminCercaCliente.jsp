<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="java.util.*, pacchetto.model.*"
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
<%ArrayList<?> utente = (ArrayList<?>) request.getAttribute("nome");
DatiAnagraficiBean dati= (DatiAnagraficiBean) request.getAttribute("dati");
%>
<h1> Visualizzazione degli ordini del cliete <%= dati.getNome() %> </h1>

<% 
if (utente.size() == 0){
%>

<h3 align="center"> L'utente non ha effettuato alcun acquisto </h3>

<%
}

else {
%>

<div class="f">
<table>
<tr>
<th> Id dell'ordine </th>
<th> Stao dell'ordine </th>
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
	}%>

</table>
</div>
</body>
</html>