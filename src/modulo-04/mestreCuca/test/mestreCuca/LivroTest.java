package mestreCuca;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class LivroTest {
	@Test
	public void criaLivro() throws Exception {
		List<Receita> receitaEsperada = new ArrayList<>();
		Livro receitasRuins = new Livro("Receitas ruins");
		IngredienteReceita massaMiojo = new IngredienteReceita("miojo", 1.0, UnidadeMedida.UNIDADE, 2.0);
		Instrucao modoPreparo = new Instrucao("3 minuto t� pronto!");
		Receita miojo = new Receita("Miojo how to");
		miojo.adicionarIngredientesNaReceita(massaMiojo);
		miojo.adicionarInstrucao(modoPreparo);
		receitaEsperada.add(miojo);
		receitasRuins.inserir(miojo);
		
		String nomeEsperado = "Receitas ruins";
		
		assertEquals(nomeEsperado, receitasRuins.getNome());
		assertEquals(receitaEsperada, receitasRuins.getTodasReceitas());
		
	}
	
	@Test
	public void atualizaReceita() throws Exception {
		List<Receita> receitaEsperada = new ArrayList<>();
		Livro receitasRuins = new Livro("Receitas ruins");
		IngredienteReceita massaMiojo = new IngredienteReceita("miojo", 1.0, UnidadeMedida.UNIDADE, 2.0);
		Instrucao modoPreparo = new Instrucao("3 minuto t� pronto!");
		Receita miojo = new Receita("Miojo how to");
		miojo.adicionarIngredientesNaReceita(massaMiojo);
		miojo.adicionarInstrucao(modoPreparo);
		//receita atualizada
		Receita miojoAtualizado = new Receita("Miojo Atualizado");
		miojo.adicionarIngredientesNaReceita(massaMiojo);
		miojo.adicionarInstrucao(modoPreparo);
		
		receitaEsperada.add(miojoAtualizado);
		receitasRuins.inserir(miojo);
		receitasRuins.atualizar("Miojo how to", miojoAtualizado);

		assertEquals(receitaEsperada, receitasRuins.getTodasReceitas());
		
	}
	
	
	@Test
	public void buscaReceitaPeloNome() throws Exception {
		Livro receitasRuins = new Livro("Receitas ruins");
		IngredienteReceita massaMiojo = new IngredienteReceita("miojo", 1.0, UnidadeMedida.UNIDADE, 2.0);
		Instrucao modoPreparo = new Instrucao("3 minuto t� pronto!");
		Receita miojo = new Receita("Miojo how to");
		miojo.adicionarIngredientesNaReceita(massaMiojo);
		miojo.adicionarInstrucao(modoPreparo);
		
		Receita receitaEsperada = new Receita("Miojo how to");
		miojo.adicionarIngredientesNaReceita(massaMiojo);
		miojo.adicionarInstrucao(modoPreparo);
		
		receitasRuins.inserir(miojo);
		
		Receita receitaObtida = receitasRuins.buscaReceitaPeloNome("Miojo how to");
		
		if (receitaEsperada == null && receitaObtida == null) {
	        assert(true);
	    } else if (receitaEsperada != null && receitaEsperada.equals(receitaObtida)) {
	        assert(true);
	    } else {
	    	assert(false);
	    }
	}
	
	@Test
	public void getValorReceita() throws Exception {
		Livro receitasRuins = new Livro("Receitas ruins");
		Receita miojo = new Receita("Miojo how to");
		miojo.adicionarIngredientesNaReceita(new IngredienteReceita("miojo", 1.0, UnidadeMedida.UNIDADE, 2.0));
		miojo.adicionarIngredientesNaReceita(new IngredienteReceita("agua", 200.0, UnidadeMedida.ML, 5.0));
		miojo.adicionarInstrucao(new Instrucao("3 minuto t� pronto!"));
		receitasRuins.inserir(miojo);
		
		double valorEsperado = 7.0;
		List<Receita> receitas = new ArrayList<>();
		receitas.add(miojo);

		assertEquals(valorEsperado, receitasRuins.getValorTotal(receitas), 0.01);
	}
	
	@Test
	public void protecaoAosAlergicos() throws Exception {
		Livro receitasRuins = new Livro("Receitas ruins");
		Receita arroz = new Receita("Arroz how to");
		Receita lactose = new Receita("Receita para intolerantes a lactose");
		Receita mistura = new Receita("Receita aleatoria");
		
		IngredienteReceita xicaraArroz = new IngredienteReceita("arroz", 1.0, UnidadeMedida.XICARA, 2.0);
		IngredienteReceita agua = new IngredienteReceita("agua", 200.0, UnidadeMedida.ML, 5.0);
		IngredienteReceita queijo = new IngredienteReceita("queijo", 1.0, UnidadeMedida.UNIDADE, 20.0);
		IngredienteReceita sorvete = new IngredienteReceita("sorvete", 2.0, UnidadeMedida.LITRO, 10.0);
		IngredienteReceita pizza = new IngredienteReceita("pizza 4 queijos", 2.0, UnidadeMedida.UNIDADE, 20.0);
		
		arroz.adicionarIngredientesNaReceita(xicaraArroz);
		arroz.adicionarIngredientesNaReceita(agua);
		arroz.adicionarInstrucao(new Instrucao("10 minuto t� pronto!"));
		receitasRuins.inserir(arroz);
		
		lactose.adicionarIngredientesNaReceita(queijo);
		lactose.adicionarIngredientesNaReceita(sorvete);
		lactose.adicionarIngredientesNaReceita(pizza);
		lactose.adicionarInstrucao(new Instrucao("Boa para intolerantes a lactose"));
		receitasRuins.inserir(lactose);
		
		mistura.adicionarIngredientesNaReceita(xicaraArroz);
		mistura.adicionarIngredientesNaReceita(sorvete);
		mistura.adicionarIngredientesNaReceita(agua);
		mistura.adicionarInstrucao(new Instrucao("Mistura"));
		receitasRuins.inserir(mistura);
		
		List<IngredienteReceita> ingredienteAlergico = new ArrayList<>();
		ingredienteAlergico.add(sorvete);
		
		List<Receita> receitasEsperadas = new ArrayList<>();
		receitasEsperadas.add(lactose);
		receitasEsperadas.add(mistura);
		
		assertEquals(receitasEsperadas, receitasRuins.protecaoAosAlergicos(ingredienteAlergico));
	}
	
	@Test
	public void listaDeCompras() {
		List<Receita> receitas = new ArrayList<>();
		Livro receitasRuins = new Livro("Receitas ruins");
		Receita arrozDeForno = new Receita("Arroz de forno");
		Receita arrozDoce = new Receita("Arroz Doce");
		Receita carneDePanela = new Receita("Carne de panela");
		
		IngredienteReceita tresXicarasDeArroz = new IngredienteReceita("arroz", 3.0, UnidadeMedida.XICARA, 1.0);
		IngredienteReceita umaXicaraDeArroz = new IngredienteReceita("arroz", 1.0, UnidadeMedida.XICARA, 1.0);
		IngredienteReceita salArroz = new IngredienteReceita("sal", 1.0, UnidadeMedida.COLHER_DE_SOPA, 1.0);
		IngredienteReceita salCarne = new IngredienteReceita("sal", 1.0, UnidadeMedida.COLHER_DE_SOPA, 1.0);
		IngredienteReceita leiteCondensado = new IngredienteReceita("leite condensado", 1.0, UnidadeMedida.UNIDADE, 1.0);
		IngredienteReceita carne = new IngredienteReceita("carne", 1.0, UnidadeMedida.KG, 1.0);
		
		arrozDeForno.adicionarIngredientesNaReceita(tresXicarasDeArroz);
		arrozDeForno.adicionarIngredientesNaReceita(salArroz);
		receitasRuins.inserir(arrozDeForno);
		
		arrozDoce.adicionarIngredientesNaReceita(umaXicaraDeArroz);
		arrozDoce.adicionarIngredientesNaReceita(leiteCondensado);
		receitasRuins.inserir(arrozDoce);
		
		carneDePanela.adicionarIngredientesNaReceita(carne);
		carneDePanela.adicionarIngredientesNaReceita(salCarne);
		receitasRuins.inserir(carneDePanela);
		
		receitas.add(arrozDeForno);
		receitas.add(arrozDoce);
		receitas.add(carneDePanela);
		
		List<String> listaEsperada = new ArrayList<>();
		listaEsperada.add("1.0 unidade leite condensado");
		listaEsperada.add("1.0 Kg carne");
		listaEsperada.add("4.0 x�cara(s) arroz");
		listaEsperada.add("2.0 colher(es) (sopa) sal");

		System.out.println(receitasRuins.listaDeCompras(receitas));
		assertEquals(listaEsperada, receitasRuins.listaDeCompras(receitas));
		
	}
}
