package filmator.model;

public class Filme {

	private Integer idFilme;
	private String nome;
	private Genero genero;
	private int anoLancamento;
	private String sinopse;
	private String imagem;
	
	public Filme() {
	}
	
	public Filme(String nome, Genero genero, int anoLancamento, String sinopse, String imagem) {
		this.nome = nome;
		this.genero = genero;
		this.anoLancamento = anoLancamento;
		this.sinopse = sinopse;
		this.imagem = imagem;
	}
	
	public Integer getIdFilme() {
		return idFilme;
	}

	public void setIdFilme(Integer idFilme) {
		this.idFilme = idFilme;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public int getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
}
