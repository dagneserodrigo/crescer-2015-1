package filmator;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class FIlmeTest {
	@Test
	public void adicionaAtor() throws Exception {
		Filme filme = new Filme("Nome Filme", Genero.ACAO);
		Ator ator = new Ator("Ator", 33);
		ArrayList<Ator> esperado = new ArrayList<>();
		
		esperado.add(ator);
		filme.adicionarAtor(ator);
		
		assertEquals(esperado, filme.getAtores());
	}
	
	@Test
	public void buscaAtorPorNome() throws Exception {
		Filme filme = new Filme("Nome Filme", Genero.ACAO);
		Ator ator = new Ator("Ator", 33);
		ArrayList<Ator> esperado = new ArrayList<>();
		
		esperado.add(ator);
		filme.adicionarAtor(ator);
		
		assertEquals(esperado, filme.buscaAtorPorNome("Ator"));
	}

	@Test
	public void testeToString() throws Exception {
		Filme filme = new Filme("Nome Filme", Genero.ACAO);
		Ator ator = new Ator("Ator", 33);
		
		String esperado = "Nome do filme: Nome Filme Atores: Ator";
		filme.adicionarAtor(ator);
		
		assertEquals(esperado, filme.toString());
	}
}
