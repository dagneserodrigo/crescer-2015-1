package filmator.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import filmator.model.Filme;

public class FilmeDao {
	private List<Filme> filmes = new ArrayList<>();

	public List<Filme> buscaTodosFilmes(){
		//Imagina que estes dados estao vindo do banco
		return Arrays.asList(new Filme(),
			new Filme(),
			new Filme());
	}
	
	public void salvarFilme(Filme filme) {
		filmes.add(filme);
	}
	
	public List<Filme> consultaFilmes() {
		return filmes;
	}
}
 