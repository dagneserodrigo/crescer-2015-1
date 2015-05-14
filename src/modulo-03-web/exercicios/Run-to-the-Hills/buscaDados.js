'use strict';

var albums = [];
function obtemDadosPorAjax() {
	$.ajax({
		type: "GET",
		url: 'https://api.spotify.com/v1/artists/6mdiAmATAx73kdxrNrnlao/albums?limit=50',
		dataType: 'json'
	}).done(function(data){
		albums = $.extend({}, data.items);
		gerarHtml();
	});
}

function gerarHtml() {
	$.each(albums, function(i, album){
		$('.albums').append($('<img>', {src: album.images[1].url}));
	});
}

$(function() {
  obtemDadosPorAjax();
});