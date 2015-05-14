package filmator;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

public class NetfloxTest {
	@Test
	public void adicionarFilme() throws Exception {
		Netflox streaming = new Netflox();
		Filme filmeAcao = new Filme("Filme acao", Genero.ACAO);
		ArrayList<Filme> esperado = new ArrayList<>();
		
		esperado.add(filmeAcao);
		streaming.adicionarFilme(filmeAcao);
		
		assertEquals(esperado, streaming.getListaFilmes());
	}
	
	@Test
	public void reproduzirFilme() throws Exception {
		Netflox streaming = new Netflox();
		Filme filmeAcao = new Filme("Filme acao", Genero.ACAO);
		 HashMap<Genero, AtomicInteger> esperado = new HashMap<>();
		
		esperado.put(filmeAcao.getGenero(), new AtomicInteger(1));
		streaming.adicionarFilme(filmeAcao);
		streaming.reproduzirFilme(filmeAcao);
		
		assertEquals(esperado.toString(), streaming.getVisualizacoes().toString());
	}
	
	@Test
	public void reproduzirDuasVezesUmFilme() throws Exception {
		Netflox streaming = new Netflox();
		Filme filmeAcao = new Filme("Filme acao", Genero.ACAO);
		 HashMap<Genero, AtomicInteger> esperado = new HashMap<>();
		
		esperado.put(filmeAcao.getGenero(), new AtomicInteger(2));
		streaming.adicionarFilme(filmeAcao);
		streaming.reproduzirFilme(filmeAcao);
		streaming.reproduzirFilme(filmeAcao);
		
		assertEquals(esperado.toString(), streaming.getVisualizacoes().toString());
	}
}
