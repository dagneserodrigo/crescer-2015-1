package filmator.model;

public class Filme {

	private String nome;
	private Genero genero;
	private int anoLancamento;
	private String sinopse;
	private String imagem;
	
	public Filme() {
	}
	
	public Filme(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
}
