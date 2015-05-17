'use strict';

var artistId;
var albums;

$(function() {
	buscaArtista();
	abreModal();
});

function abreModal() {
	$('.searchFixed').click(function() {
		$('.searchFixed').hide();
		$('.modalDialog').show();
		$(".albums").html("");
	});
}

function buscaArtista() {
	$('.buscaArtista').submit(function() {
		$.ajax({
			url: 'https://api.spotify.com/v1/search?q=' + $('#artista').val() + '&type=artist',
			type: 'get',
			dataType: 'json',
		}).done(function(data) {
			if(data.artists.items[0]) {
				$('.modalDialog').hide('fast');
				artistId = data.artists.items[0].id;
				buscaAlbums();
			} else {
				$('.error').show().fadeOut(3000);
			}
		})
	});
}

function buscaAlbums() {

	if ($('#artista').val().toLowerCase() === 'justin bieber') {
		if ((Math.random() * 100) <= 80) {
			artistId = 'douchebag';
		}
	}

	$.ajax({
		url: 'https://api.spotify.com/v1/artists/' + artistId + '/albums?limit=50',
		type: 'get',
		dataType: 'json',
	}).done(function(data) {
		albums = $.extend({}, data.items);
		gerarHtml();
	}).fail(function(data){
		$('body').append('<h2>Caro usuário, devido a um erro ' + data.status + ', não foi possível pesquisar por <span>' + $('#artista').val() + '</span></h2>')
				 .append('<img src="img/marlon.jpg" alt="marlon"/>');
	});
};

function gerarHtml() {
	$.each(albums, function(i, album){
		if (album.images[1]) {
			$('.albums').append($('<img>', {src: album.images[1].url}));
		}
	});

	$('.searchFixed').show();
};