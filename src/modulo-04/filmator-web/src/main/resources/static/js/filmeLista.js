'use strict'
$(function(){
	$('td[nota]').each(function(i){

		var nota = $( this ).attr('nota');

		if(nota === 0.0 ){
			$( this ).find('img[value]').attr('nota');
		}

		$( this ).find('img[value="'+nota+'"]')
		.attr('src', '/img/star1.png')
		.prevAll().attr('src', '/img/star1.png');
	});

	$('.star').click(function(){
		$(this).prevAll().attr('src', '/img/star1.png');
		$(this).nextAll().attr('src', '/img/star0.png');
		$(this).attr('src', '/img/star1.png');

		var nota = $( this ).attr('value');

		var filme = $( this ).parent().attr('value');
		$.ajax({
			url: '/avaliacaoCadastro?nota=' + nota + '&idFilme=' + filme,
			type: 'POST'	
		});
	});
})