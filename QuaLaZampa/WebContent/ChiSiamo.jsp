<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="icon" type="image/x-icon" href="./image/icona_catalogo.png">
<title>Chi Siamo</title>
<style>
.p1{
margin: 1px;
width: 100%;
}


.imge{
	border-radius: 50%;
	width:100%;
	width:180px;
	height:180px;
}

.card {
  box-shadow: 0 5px 10px 0 white;
  border-color: white;
  max-width: 300px;
  margin: auto;  
  text-align: left;
}
.col{
  float: left;
  width: 20%;
  padding: 10px;
  border-color: white;
}

.row:after {
  content: "";
  display: table;
  clear: both;
  border-color: white;
}

@media screen and (max-width: 600px) {
  .col {
    width: 100%;
  }
}

.container {
  position: relative;
  width: 100%;
  }
  
.overlay {
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  height: 100%;
  width: 100%;
  opacity: 0;
  transition: .5s ease;
}

.container:hover .overlay {
  opacity: 1;
}

.imge1 {
  width: 100%;
  position: absolute;
}
</style>
</head>
<body>
<%@ include file = "../fragments/header.jsp" %>
<h1 align="center">Chi Siamo</h1>

<p class="p1"> 
QuaLaZampa nasce nel 2021 da un gruppo di studenti dell'Università degli Studi di Salerno che 
hanno pensato di realizzare un e-commerce finalizzato alla vendita di prodotti per gli animali. 
E' stato realizzato per chi come noi ama gli amici a quattro zampe.
<br>Conosciamo meglio gli sviluppatori:</p>

<div class="row">
 <div class="col">
<div class="card">

<div class="container"> 
<img src="./image/ChiSiamoSabrina.jpeg" class="imge"><br><br>
 <div class="overlay">
    <div class="imge1"><img src="./image/ChiSiamoZelda.jpeg" style="width:180px; height:180px; border-radius: 50%;">
    </div></div></div>
    
<p><b>Sabrina Ceccarelli</b><br>
Studentessa di Informatica all'Università degli Studi di Salerno.<br>
Sabrina ha una gattina <b>Zelda</b> dal manto bianco e grigio.
Zelda è molto dolce e socievole e ama stare sdraiarsi accanto a Sabrina quando gioca ai videogame.<br><br>
</p>
<p><img src="./image/cat.png" style="width:30px; height:30px; float: center;">
<br>Contatti:<br>s.ceccarelli1@studenti.unisa.it<br>
<a href="https://github.com/SabCecc97">Github.com/SabCecc97</a></p>
</div></div>

 <div class="col">
<div class="card">
<div class="container">
<img src="./image/ChiSiamoMiriam.jpg" class="imge"><br><br>
<div class="overlay">
    <div class="imge1"><img src="./image/ChiSiamoMarilyn.jpeg" style="width:180px; height:180px; border-radius: 50%;"></div></div></div>
<p><b>Miriam Ferrara</b><br>
Studentessa di Informatica all'Università degli Studi di Salerno.<br>
Miriam ha una gattina <b>Merilyn</b> dal manto rosso tigrato.
Merilyn è molto timida ma una grande giocherellona e ama dormire su morbidi cuscini.
Di nome e di fatto una vera Principessa.
</p>

<p><img src="./image/coniglio.png" style="width:30px; height:30px; float: center;">
<br>Contatti:<br>
M.Ferrara115@studenti.unisa.it<br>
<a href="https://github.com/MiriamFerrara">Github.com/MiriamFerrara</a></p>
  	 </div></div>

<div class="col">
<div class="card">
<div class="container">
<img src="./image/ChiSiamoAlfonso.jpeg" class="imge"><br><br>
<div class="overlay">
<div class="imge1"><img src="./image/ChiSiamoGigi.jpeg" style="width:180px; height:180px; border-radius: 50%;"></div></div></div>
<p><b>Alfonso Schettino</b><br>
Studente di Informatica all'Università degli Studi di Salerno.<br>
Alfonso ha un canarino <b>Gigi</b> dai colori vivaci giallo-verde.
Gigi è un giocherellone e socievole e ama cantichiera tutto il giorno.<br><br>
</p>
<p><img src="./image/pappagallo.png" style="width:30px; height:30px; float: center;">
<br>Contatti:<br>
a.schettino23@studenti.unisa.it <br>
<a href="https://github.com/Alfonso-hub">Github.com/Alfonso-hub</a></p>
</div></div>
</div><br><br>

<%@ include file="../fragments/footer.jsp" %>
</body>
</html>