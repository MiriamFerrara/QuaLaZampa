<link rel="stylesheet" type="text/css" href="./css/Struttura.css">
<style>
.icone1{
	margin-top:20px;
	margin-right:50px;
	float:right;
	width:40px;
	height:40px;
}
.dropbtn1 {
    color: black;
    padding: 1px;
  	font-size: 10px;
    border: none;
    cursor: pointer;
}

.dropdown1 {
   position: relative;
  display: inline-block;
} 

.dropdown-content1 {
  display: none;
  position: absolute;
  right: 20px;
   top: 60px;
  background-color: #ffd963;
  z-index: 1;
}
.dropdown-content1 a {
  color: black;
  padding: 6px 10px;
  text-decoration: none;
  display: block;
}

.dropdown-content1 a:hover {background-color: #ffd963;}

.dropdown1:hover .dropdown-content1 {
  display: block;
}
.dropdown1:hover .dropbtn1 {
  background-color: #78c0A8;
}
</style>
<header>

<div class="header">
<a href="ProdottiView.jsp"><img src="./image/logo.png" class="logo" width="110" height="110"></a>

<a href="ProdottiCarrello.jsp"><img src="./image/icona_carrello.png" class="icone"></a>
<div class="dropdown1" style="float:right;">
<a><img src="./image/account.png" class="icone1"></a>
<div class="dropdown-content1">
	  <a href="AreaUtente">AreaUtente</a>
      <a href="Logout">Logout</a>
   </div>
</div>
</div>

</header>