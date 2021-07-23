<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="pacchetto.model.ClienteBean, pacchetto.model.IndirizzoSpedizioneBean, pacchetto.model.DatiAnagraficiBean"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="icon" type="image/x-icon" href="./image/icona_utente.jpg">
<link rel="stylesheet" type="text/css" href="./css/Bottone.css">
<title>Area Utente</title>
</head>
<body>
<%@ include file = "../fragments/header.jsp" %>
<%
String email = (String)request.getAttribute("email"); 
DatiAnagraficiBean dati = (DatiAnagraficiBean) request.getAttribute("indirizzo"); 
IndirizzoSpedizioneBean  utentibean = (IndirizzoSpedizioneBean) request.getAttribute("telefono"); 
%>
<h1>Dati Personali</h1>
<fieldset>
<legend><b>Informazioni Personali</b></legend>
	Nome: <b><%= dati.getNome() %></b> Cognome: <b><%= dati.getCognome() %></b>
            <br>Indirizzo: <b><%= utentibean.getVia() %></b>  
            <br>Città: <b><%= utentibean.getCittà() %></b> Cap:<b> <%= utentibean.getCap() %></b>
              	in Provincia di <b><%= utentibean.getProvincia()%></b>
            <br>Telefono:	<b><%= dati.getTelefono() %></b>
            <br>Email: <b><%= email %></b></fieldset>
            
<div class="container" align="center">      
<a style="color: white" href="Ordini?action=ordiniEffettuati">
<input type="button" class="small" value="Visualizza Ordini effettuati">
</a></div>
<br><br>

<%@ include file="../fragments/footer.jsp" %>
</body>
</html>