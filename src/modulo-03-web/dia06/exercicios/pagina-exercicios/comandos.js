// 1A
var tags = $('.module');

// 1B
var li = $('#myListItem');

// 1C
var label = $('label[for=q]');

// 1D
var number = $('*[alt]').length;

// 1E
var rows = $('tr:even').not('tr:nth-child(1)');

// 1F
var h2 = $('h2:contains("B"):contains("e")').length;

// 1G
var li = $('#myList > li').not('.current');

// 1H
$('img:last, h3:last');

// 1I
var caracteres = $('#myList .current ~ li').text().length;

//-----------------------------------------------------------------//

// 2A
console.log($('img[alt]')); //?

// 2B
$('input[type=text]').closest('form').addClass('template');

// 2C
$('#myList > .current').removeClass('current').next().addClass('current');

// 2D
$('#specials > h2').text('Promoções').parent().find('option[value=friday]').text('Dimitri'); 

// 2E
$('#slideshow > li').first().addClass('current').siblings().addClass('disabled');

//---------------------------------------------------------------------------------//

// 3A
for(var i = 8; i <= 12; i++ ) {
	$('#myList').append('<li>List item ' + i +'</li>');
}

// 3B
$('#myList > li:nth-child(even)').remove()

// 3C
$('<div class="module"></div>').insertAfter($('div .module').last()).append($( "img:first" ).clone());

