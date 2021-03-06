package filmator;

import java.util.ArrayList;

public class Filme {
	private String nome;
	private ArrayList<Ator> elenco = new ArrayList<>();
	private Genero genero;
	
	public Filme(String nome, Genero genero){
		this.nome = nome;
		this.genero = genero;
	}

	public String getNome() {
		return this.nome;
	}
	
	public Genero getGenero() {
		return this.genero;
	}
	
	public ArrayList<Ator> getAtores() {
		return this.elenco;
	}
	
	public void adicionarAtor(Ator ator) {
		this.elenco.add(ator);
	}

	public String toString() {
		StringBuilder construtor = new StringBuilder();
		
		construtor.append("Nome do filme: ");
		construtor.append(this.nome);
		construtor.append(" Atores: ");
		for(Ator ator : this.elenco) {
			construtor.append(ator.getNome());
			construtor.append(", ");
		}
		return construtor.delete(construtor.length()-2, construtor.length()).toString();
	}
	
	public ArrayList<Ator> buscaAtorPorNome(String nome) {
		ArrayList<Ator> atorComNomeBuscado = new ArrayList<>();
		
		for (Ator atorAtual : elenco) {
			if (atorAtual.getNome().toLowerCase().contains(nome.toLowerCase())) {
				atorComNomeBuscado.add(atorAtual);
			}
		}
		
		return atorComNomeBuscado;
	}
}
