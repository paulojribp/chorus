$(document).ready(function() {
	$('#btn-modal-cadastrar').click(function() {
		$('#modal-cadastro').modal('show');
	});
	
	$('#btn-criar-usuario').click(function() {
		Chorus.newUser();
	});
	$('#btn-cancel-usuario').click(function() {
		$('#modal-cadastro').modal('hide');
	});
});

var Chorus = {};
Chorus.newUser = function() {
	var usuario = {
		"usuario.username": $('#inputUsername').val(),
		"usuario.email": $('#inputEmail').val(),
		"usuario.senha": $('#inputSenha').val(),
		"usuario.confirmaSenha": $('#inputConfirmaSenha').val()
	};
	
	$.ajax({
		url: '../usuario/salvar',
		method: 'POST',
		data: usuario,
		success: function(data) {
			console.log(data);
			$('#modal-cadastro').modal('hide');
		},
		error: function(err) {
			console.log(err);
		}
	});
	
};