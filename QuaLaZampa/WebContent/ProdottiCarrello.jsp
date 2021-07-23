<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="pacchetto.model.* , java.util.* "
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="icon" type="image/x-icon" href="./image/icona_carrello.png">
<link rel="stylesheet" type="text/css" href="./css/Struttura.css">
<link rel="stylesheet" type="text/css" href="./css/Bottone.css">
<title> Carrello del cliente </title>
</head>
<body>
<%@ include file = "../fragments/header.jsp" %>

<h1>Carrello</h1>

<%
Carrello car= (Carrello) session.getAttribute("carrello");

if ((car==null) || (car.getDimensione()==0)) {
%>

<p align="center">
Spiacenti ma il carrello è vuoto.
</p>
<div align="center">
<a href="ProdottiView.jsp">
<input type="button" class="pulsante-small" value="Torna alla lista prodotti">
</a>
</div>
<%
}
else {
	for (int i=0; i<car.getDimensione(); i++) {
%>
<div class="row">
 <div class="col">
<div class="card">
<script type="text/javascript" src="./resources/imageZoom.js"></script>
<img onmouseover="bigImg(this)" onmouseout="normalImg(this)" border="0" src="./image/<%= car.getCarrello().get(i).getPat().substring(car.getCarrello().get(i).getPat().lastIndexOf("image")+6) %>" height="180" width="180">
<br>
<b><%= car.getCarrello().get(i).getNome() %> <br>
Codice prodotto: <%= car.getCarrello().get(i).getId() %> <% request.setAttribute("iden", car.getCarrello().get(i).getId()); %></b><br>
<b>Prezzo singolo prodotto: <%= String.format("%.2f",car.getCarrello().get(i).getPrezzo()) %>&euro;</b> <br>

<form action="Controllo2" method="get">
<input type="hidden" value="<%= car.getCarrello().get(i).getId() %>" name="nascosto">
Quantità desiderata: <input type="number" name="scelta" value="1" min="1" max="<%= car.getCarrello().get(i).getQuantita()%>" >
<input type="submit"  value="Aggiorna"  style="background-color: #ffd963; text-align: center;color:black; font-weight:bold; border: 2px solid black;">
</form>
<br>

<b>Prezzo totale: <%= String.format("%.2f",car.getCarrello().get(i).getTotPrezzo()) %>&euro;</b>
<br>

<form action="EliminaProdotto" method="get">
<input type="hidden" value="<%= car.getCarrello().get(i).getId() %>" name="nascosto2">
<input type="submit" class="pulsante-small" value="Elimina Prodotto"><br><br>
</form>
</div>
</div>
<%
}
%>
</div>

<div class="container" align="center">
<a style="color: white" href="Ordini?action=effettuaPagamento">
<input type="button" class="small" value="Effettua pagamento">
</a>
<a style="color: white" href="ProdottiView.jsp">
<input type="button" class="small" value="Torna alla lista prodotti">
</a>
</div>
<%
}
%>
<br><br>
<%@ include file="../fragments/footer.jsp" %>

</body>
</html>