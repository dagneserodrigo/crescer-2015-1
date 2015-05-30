package filmator.model;

public class Ator {
	private Integer idAtor;
	private String nome;
	private String informacao;
	private String imagem;
	
	public Ator(){}
	
	public Ator(String nome, String informacao) {
		this.nome = nome;
		this.informacao = informacao;
	}

	public Integer getIdAtor() {
		return idAtor;
	}

	public void setIdAtor(Integer idAtor) {
		this.idAtor = idAtor;
	}	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getInformacao() {
		return informacao;
	}
	public void setInformacao(String informacao) {
		this.informacao = informacao;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}	
}
