<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="icon" type="image/x-icon" href="./image/icona_utente.jpg">
<link rel="stylesheet" type="text/css" href="./css/Login.css">
<link rel="stylesheet" type="text/css" href="./css/Struttura.css">
<title> Aggiungi prodotto </title>
</head>
<body>
<%@ include file = "../fragments/headerAmministratore.jsp" %>
<h1>Aggiungi Prodotti</h1>
<div class="container">
<p>Aggiungi le informazioni richieste per aggiungere un nuovo prodotto al catalogo </p>
<form action="AggiungiProdAdmin" method="post" enctype="multipart/form-data">
<label><b>Nome prodotto:</b></label> <br>
<input type="text" name="nomeProd" placeholder="Inserisci il nome del prodotto"  size="40px" required> <br>
<label><b>Disponibilità:</b></label> <br>
<input type="text" name="disponibilitaProd" placeholder="Inserisci la disponibilità (SI o NO)" size="40px" required> <br>
<label><b>Quantità:</b></label> <br>
<input type="text" name="quantitaProd" placeholder="Inserisci la quantita del prodotto" size="40px" required> <br>
<label><b>IVA del prodotto:</b></label> <br>
<input type="text" name="ivaProd" placeholder="Inserisci l'iva del prodotto (0.22)" size="40px" required> <br>
<label><b>Descrizione:</b></label> <br>
<input type="text" name="descrizioneProd" placeholder="Inserisci la descrizione del prodotto" size="40px" required> <br>
<label><b>Prezzo base:</b></label> <br>
<input type="text" name="prezzoBaseProd" placeholder="Inserisci il prezzo base del prodotto" size="40px" required> <br>
<label><b>Tipologia prodotto:</b></label>
<select name="tipologia">
<option value="cane"> Cane </option>
<option value="gatto"> Gatto </option>
<option value="animali piccola taglia"> Animali piccola taglia </option>
<option value="uccelli"> Uccelli </option>
</select> 
<div style="float:right;">
<label><b> Aggiungi un immagine:</b></label>
<input type="file"  name="fileProd" accept=".jpg, .jpeg, .png"> <br> <br>
</div>
<input type="submit" class="login" value="Conferma aggiunta">
</form>
</div>
</body>
</html>