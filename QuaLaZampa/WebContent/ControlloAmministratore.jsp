<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="pacchetto.model.*"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="icon" type="image/x-icon" href="./image/icona_utente.jpg">
<link rel="stylesheet" type="text/css" href="./css/Bottone.css">
<title>Home Amministratore</title>
</head>

<body>
<%@ include file = "../fragments/headerAmministratore.jsp" %>
<%
ClienteBean cerca= (ClienteBean)request.getAttribute("admin");

if (cerca == null){
response.sendRedirect("./ControlloAdmin");
return ;
}
%>

<div align="center">
<h1> Benvenuto Amministratore <%= cerca.getUsername() %></h1>
<div class="conteiner">
<a class="a" href="ControlloAdmin?azione=controllo">
<input type="button" class="button" value="Controlla il catalogo"> 
</a>

<a class="a" href="ControlloAdmin?azione=ordiniNominativo">
<input type="button"  class="button" value="Controlla gli ordini per cliente"> 
</a>

<a class="a" href="ControlloAdmin?azione=ordiniData">
<input type="button"  class="button" value="Controlla gli ordini per Data">
</a>
</div>
</div>
</body>
</html>