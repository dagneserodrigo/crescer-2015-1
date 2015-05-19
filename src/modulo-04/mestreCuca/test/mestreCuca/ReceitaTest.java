package mestreCuca;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ReceitaTest {
	
	@Test
	public void criaReceitaComUmIngrediente() throws Exception {
		List<IngredienteReceita> ingredienteEsperado = new ArrayList<>();
		List<Instrucao> instrucaoEsperada = new ArrayList<>();
		IngredienteReceita arroz = new IngredienteReceita("Arroz", 1.0, UnidadeMedida.XICARA, 2.0);
		Instrucao modoDePreparo = new Instrucao("Colocar o arroz na panela...");
		ingredienteEsperado.add(arroz);
		instrucaoEsperada.add(modoDePreparo);
		
		Receita arrozHowTo = new Receita("Arroz how to");
		arrozHowTo.adicionarIngredientesNaReceita(arroz);
		arrozHowTo.adicionarInstrucao(modoDePreparo);
		
		String nomeEsperado = "Arroz how to";
		
		assertEquals(nomeEsperado, arrozHowTo.getNome());
		assertEquals(ingredienteEsperado, arrozHowTo.getIngredientesDaReceita());
		assertEquals(instrucaoEsperada, arrozHowTo.getInstrucao());
		
	}
	
	@Test
	public void valorTotal() throws Exception {
		IngredienteReceita arroz = new IngredienteReceita("Arroz", 1.0, UnidadeMedida.XICARA, 2.0);
		Instrucao modoDePreparo = new Instrucao("Colocar o arroz na panela...");
		
		Receita arrozHowTo = new Receita("Arroz how to");
		arrozHowTo.adicionarIngredientesNaReceita(arroz);
		arrozHowTo.adicionarInstrucao(modoDePreparo);
		
		Double valorEsperado = 2.0;
		
		assertEquals(valorEsperado, arrozHowTo.getValorTotalDaReceita(), 0.01);
	}

}
