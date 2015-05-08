//1
var clubes = [
				arsenal = {
				  nome: 'Arsenal Football Club',
				  titulos: [
				    { desc: 'Nacionais', qtd: 13 },
				    { desc: 'Continentais', qtd: 0 },
				    { desc: 'Mundiais', qtd: 0 }
				  ]
				},


				chelsea = {
				  nome: 'Chelsea Football Club',
				  titulos: [
				    { desc: 'Nacionais', qtd: 5 },
				    { desc: 'Continentais', qtd: 1 },
				    { desc: 'Mundiais', qtd: 0 }
				  ]
				},

				liverpool = {
				  nome: 'Liverpool Football Club',
				  titulos: [
				    { desc: 'Nacionais', qtd: 18 },
				    { desc: 'Continentais', qtd: 5 },
				    { desc: 'Mundiais', qtd: 0 }
				  ]
				},

				manchester = {
				  nome: 'Manchester United Football Club',
				  titulos: [
				    { desc: 'Nacionais', qtd: 20 },
				    { desc: 'Continentais', qtd: 3 },
				    { desc: 'Mundiais', qtd: 1 }
				  ]
				}
			];


//2.A
function ordenaPorNacionais(clubes) {
	clubes.sort(function(a,b) { 
		return (a.titulos[0].qtd < b.titulos[0].qtd); 
	})
}

//2.B
function ordenaPorContinentais(clubes) {
	clubes.sort(function(a,b) { 
		return (a.titulos[1].qtd < b.titulos[1].qtd); 
	})
}

//2.C
function ordenaPorMundiais(clubes) {
	clubes.sort(function(a,b) { 
		return (a.titulos[2].qtd < b.titulos[2].qtd); 
	})
}

//3.A
function somarPorNacionais(clubes) {
	var total = clubes.map(function(i) {
		return i.titulos[0].qtd;
	});

	return total.reduce(function(a,b) {
		return a + b;
	});
}

//3.B
function somarPorContinentais(clubes) {
	var total = clubes.map(function(i) {
		return i.titulos[1].qtd;
	});

	return total.reduce(function(a,b) {
		return a + b;
	});
}

//3.C
function somarPorTodosOsTitulos(clubes) {
	
	var nacionais = clubes.map(function(i) {
		return i.titulos[0].qtd;
	});

	var continentais = clubes.map(function(i) {
		return i.titulos[1].qtd;
	});

	var mundiais = clubes.map(function(i) {
		return i.titulos[2].qtd;
	});

	total = nacionais.concat(continentais).concat(mundiais);

	return total.reduce(function(a,b) {
		return a + b;
	})
}

function somarPorTodosOsTitulos(clubes) {
	var total = 0;
	clubes.forEach(function(i){
		total = total + parseInt(i.titulos[0].qtd);
		total = total + parseInt(i.titulos[1].qtd);
		total = total + parseInt(i.titulos[2].qtd);
	});
	return total;
}

//4
function apenasOsMelhores(clubes) {
	var campeoes = new Array();
	clubes.forEach(function(i){
		if ( i.titulos[0].qtd > 18 ) {
			campeoes.push(i);
		}
	})
	return campeoes;
}

function apenasOsMelhoresParaJSON(clubes) {
	var campeoes = new Array();
	clubes.forEach(function(i){
		if ( i.titulos[0].qtd > 18 ) {
			campeoes.push(i);
		}
	})
	return JSON.stringify(campeoes);
}

function apenasOsMelhoresRecebendoJSON(clubes) {
	return obj = JSON.parse(clubes);
}