package mestreCuca;

import static org.junit.Assert.*;

import org.junit.Test;

public class IngredienteReceitaTest {
	@Test
	public void criarIngredienteReceita() throws Exception {
		IngredienteReceita cafeDoNunes = new IngredienteReceita("Café do Nunes", 100.0, UnidadeMedida.KG, 2.0);
		
		String nomeEsperado = "Café do Nunes";
		Double quantidadeEsperada = 100.0;
		UnidadeMedida unidadeMedidaEsperada = UnidadeMedida.KG;
		
		assertEquals(nomeEsperado, cafeDoNunes.getNome());
		assertEquals(quantidadeEsperada, cafeDoNunes.getQuantidade(), 0.01);
		assertEquals(unidadeMedidaEsperada, cafeDoNunes.getUnidadeMedida());
	}
}
