'use strict'
$(function(){
	$('.login').click(function() {
		$.ajax({
			url: '/login',
			type: 'POST',
			dataType: 'json',
			data: $('#form-login').serialize(),
		})
		.done(function(data) {
			if(data) {
				window.location = "/";
			} else {
				$('.form-group').addClass('has-error');
			}
		})
		.fail(function(data) {
			$('.form-signin').append('<p>Erro ao efetuar login</p>');
		});
	});
});