package filmator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Netflox {
	private ArrayList<Filme> listaFilmes = new ArrayList<Filme>();
	private HashMap<Genero, AtomicInteger> visualizacoes = new HashMap<>();
	
	public void reproduzirFilme(Filme filme) {
		if (listaFilmes.contains(filme)) {
			System.out.println("Reproduzindo filme...");
			if(visualizacoes.containsKey(filme.getGenero())) {
				visualizacoes.get(filme.getGenero()).incrementAndGet();
			} else {
				visualizacoes.put(filme.getGenero(), new AtomicInteger(1));
			}
		}
	}
	
	public void gerarRelatorio() {
		StringBuilder construtor = new StringBuilder();

		for (Genero key : visualizacoes.keySet()) {
			construtor.append("\nG�nero : ");
			construtor.append(key);
			construtor.append(" Quantidade de visualiza��es : ");
			construtor.append(visualizacoes.get(key));
		}
		System.out.println(construtor.toString());
	}
	
	public void adicionarFilme(Filme filme) {
		listaFilmes.add(filme);
	}
	
	public ArrayList<Filme> getListaFilmes() {
		return this.listaFilmes;
	}
	
	public HashMap<Genero, AtomicInteger> getVisualizacoes() {
		return this.visualizacoes;
	}
}