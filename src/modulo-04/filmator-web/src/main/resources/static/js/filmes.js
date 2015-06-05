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
})