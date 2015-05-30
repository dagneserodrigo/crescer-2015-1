$(function(){
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