package filmator;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

public class EmpresaTest {
	@Test
	public void adicionarFilme() throws Exception {
		Empresa streaming = new Empresa("Netflox");
		Filme filmeAcao = new Filme("Filme acao", Genero.ACAO);
		ArrayList<Filme> esperado = new ArrayList<>();
		
		esperado.add(filmeAcao);
		streaming.adicionarFilme(filmeAcao);
		
		assertEquals(esperado, streaming.getListaFilmes());
	}
	
	@Test
	public void reproduzirFilme() throws Exception {
		Empresa streaming = new Empresa("IItube");
		Filme filmeAcao = new Filme("Filme acao", Genero.ACAO);
		 HashMap<Genero, Integer> esperado = new HashMap<>();
		
		esperado.put(filmeAcao.getGenero(), new Integer(1));
		streaming.adicionarFilme(filmeAcao);
		streaming.reproduzirFilme(filmeAcao);
		
		assertEquals(esperado.toString(), streaming.getVisualizacoes().toString());
	}
	
	@Test
	public void reproduzirDuasVezesUmFilme() throws Exception {
		Empresa streaming = new Empresa("Netflox");
		Filme filmeAcao = new Filme("Filme acao", Genero.ACAO);
		 HashMap<Genero, Integer> esperado = new HashMap<>();
		
		esperado.put(filmeAcao.getGenero(), new Integer(2));
		streaming.adicionarFilme(filmeAcao);
		streaming.reproduzirFilme(filmeAcao);
		streaming.reproduzirFilme(filmeAcao);
		
		assertEquals(esperado.toString(), streaming.getVisualizacoes().toString());
	}
}
