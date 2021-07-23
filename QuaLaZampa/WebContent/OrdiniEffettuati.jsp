<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="java.util.*, pacchetto.model.OrdineBean, pacchetto.model.OrdineBean"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="icon" type="image/x-icon" href="./image/icona_checkout.png">
<link rel="stylesheet" type="text/css" href="./css/Bottone.css">
<title> Ordini effettuati </title>
</head>
<body>

<%@ include file = "../fragments/header.jsp" %>
<h1 align="center">Lista dei tuoi Ordini </h1>

<%
ArrayList<?> ord= (ArrayList<?>) request.getAttribute("ordiniEffettuati");
if (ord.size() == 0){
%>

<h3 align="center"> Spiacente ma non hai ancora effettuato alcun ordine </h3>

<%
}
else {
%>

<table class="f">
<tr>
<th> id_ordine </th>
<th> prezzo_totale </th>
<th> stato ordine </th>
<th> data ordine </th>
<th> Azione </th>
</tr>


<%
if (ord != null && ord.size() != 0){
	Iterator<?> it= ord.iterator();
	while(it.hasNext()){
		OrdineBean or= (OrdineBean) it.next();
%>

<tr>
<td> <%= or.getIdOrdine() %> </td>
<td> <%= or.getPrezzoTot() %> </td>
<td> <%= or.getStatoOrdine() %> </td>
<td> <%= or.getDataOrdine() %> </td>
<td> <a href="InformazioniProdotto?id=<%=or.getIdOrdine() %>" ><input type="button" value="dettaglio" style="background-color: #ffd963;text-align: center;color: black;font-weight:bold;padding: 8px;">  </a>
</tr>

<%
}
}
}
%>

</table><br>
<br>
<%@ include file="../fragments/footer.jsp" %>
</body>
</html>