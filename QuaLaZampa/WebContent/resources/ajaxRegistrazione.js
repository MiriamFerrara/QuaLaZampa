$(document).ready(function(){
	var errNome= 0;
	var errCognome= 0;
	var errUsername= 0;
	var errEmail= 0;
	var errPassword= 0;
	var errRipPassword= 0;
	var errTelefono= 0;
	var errCodice= 0;
	var errProvincia= 0;
	var errCap= 0;
	var errCitta= 0;
	var errVia= 0;
	
	$('#submit').click(function(){
		var nome = $('#nome').val();
		var cognome = $('#cognome').val();
		var username = $('#username').val();
		var email = $('#email').val();
		var password = $('#password').val();
		var ripPassword = $('#ripPassword').val();
		var telefono = $('#telefono').val();
		var codice = $('#codice').val();
		var provincia = $('#provincia').val();
		var cap = $('#cap').val();
		var citta = $('#citta').val();
		var via = $('#via').val();
		
		var expNomeCognomeUser= /^[A-Za-z]+$/;
		var expEmail= /^([a-z1-9.-])*@([a-z])+(.com)$/;
		var expTelefono= /^([0-9]{3} [0-9]{3} [0-9]{4})$/;
		var expCodice= /^([A-Z0-9])+$/;
		var expProvincia= /^[A-Za-z]+$/;
		var expCap= /^([0-9]{5})$/;
		var expCitta= /^[A-Za-z]+$/;
		var expVia= /^[A-Za-z0-9\W]+$/;
		
		if (!(nome.match(expNomeCognomeUser)) && errNome < 1){
		errNome= errNome + 1;
		$('#nome').after("<b><p id=erroreNome style='color: red;'>Errore nell'inserimento del nome</p></b> <br>");
	}
	
	if (!(cognome.match(expNomeCognomeUser)) && errCognome < 1){
		errCognome= errCognome + 1;
		$('#cognome').after("<b><p id=erroreCognome style='color: red;'>Errore nell'inserimento del cognome</p></b> <br>");
	}
	
	if (!(username.match(expNomeCognomeUser)) && errUsername < 1){
		errUsername= errUsername + 1;
		$('#username').after("<b><p id=erroreUsername style='color: red;'>Errore nell'inserimento dell'username</p></b> <br>");
	}
	
	if (!(email.match(expEmail)) && errEmail < 1){
		errEmail= errEmail + 1;
		$('#email').after("<b><p id=erroreEmail style='color: red;'>Errore nell'inserimento dell'email</p></b> <br>");
	}
	
	if (!(telefono.match(expTelefono)) && errTelefono < 1){
		errTelefono= errTelefono + 1;
		$('#telefono').after("<b><p id=erroreTelefono style='color: red;'>Errore nell'inserimento del telefono</p></b> <br>");
	}
	
	if (!(codice.match(expCodice)) && errCodice < 1){
		errCodice= errCodice + 1;
		$('#codice').after("<b><p id=erroreCodice style='color: red;'>Errore nell'inserimento del codice fiscale</p></b> <br>");
	}
	
	if (!(provincia.match(expProvincia)) && errProvincia < 1){
		errProvincia= errProvincia + 1;
		$('#provincia').after("<b><p id=erroreProvincia style='color: red;'>Errore nell'inserimento della provincia</p></b> <br>");
	}
	
	if (!(cap.match(expCap)) && errCap < 1){
		errCap= errCap + 1;
		$('#cap').after("<b><p id=erroreCap style='color: red;'>Errore nell'inserimento del cap</p></b> <br>");
	}
	
	if (!(citta.match(expCitta)) && errCitta < 1){
		errCitta= errCitta + 1;
		$('#citta').after("<b><p id=erroreCitta style='color: red;'>Errore nell'inserimento della citta</p></b> <br>");
	}
	
	if (!(via.match(expVia)) && errVia < 1){
		errVia= errVia + 1;
		$('#via').after("<b><p id=erroreVia style='color: red;'>Errore nell'inserimento della via</p></b> <br>");
	}
	
	//eliminazione errori
	
	if (nome.match(expNomeCognomeUser)){
		errNome= errNome + 1;
		$('#erroreNome').remove();
	}
	
	if (cognome.match(expNomeCognomeUser)){
		errCognome= errCognome + 1;
		$('#erroreCognome').remove();
	}
	
	if (username.match(expNomeCognomeUser)){
		errUsername= errUsername + 1;
		$('#erroreUsername').remove();
	}
	
	if (email.match(expEmail)){
		errEmail= errEmail + 1;
		$('#erroreEmail').remove();
	}
	
	if (telefono.match(expTelefono)){
		errTelefono= errTelefono + 1;
		$('#erroreTelefono').remove();
	}
	
	if (codice.match(expCodice)){
		errCodice= errCodice + 1;
		$('#erroreCodice').remove();
	}
	
	if (provincia.match(expProvincia)){
		errProvincia= errProvincia + 1;
		$('#erroreProvincia').remove();
	}
	
	if (cap.match(expCap)){
		errCap= errCap + 1;
		$('#erroreCap').remove();
	}
	
	if (citta.match(expCitta)){
		errCitta= errCitta + 1;
		$('#erroreCitta').remove();
	}
	
	if (via.match(expVia)){
		errVia= errVia + 1;
		$('#erroreVia').remove();
	}
	
	//utilizzo di ajax
	
	if ((nome.match(expNomeCognomeUser)) && (cognome.match(expNomeCognomeUser)) && (username.match(expNomeCognomeUser)) && (email.match(expEmail)) && (telefono.match(expTelefono)) && (codice.match(expCodice)) && (provincia.match(expProvincia)) && (cap.match(expCap)) && (citta.match(expCitta)) && (via.match(expVia))){
		$.ajax({
			type: 'POST',
			data: {nome: nome, cognome: cognome, username: username, email: email, password: password, ripPassword: ripPassword, telefono: telefono, codice: codice, provincia: provincia, cap: cap, citta: citta, via: via},
			url: 'Registrazione',
			success: function(result){
				window.location.href= result;
			}
		})
	}
	
	})
})