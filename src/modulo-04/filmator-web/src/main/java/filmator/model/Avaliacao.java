package filmator.model;

public class Avaliacao {
	private Integer idAvaliacao;
	private Integer idFilme;
	private Integer idUsuario;
	private Double nota;
	
	public Avaliacao() {}
	
	public Avaliacao(Integer idFilme, Integer idUsuario, Double nota) {
		this.idFilme = idFilme;
		this.idUsuario = idUsuario;
		this.nota = nota;
	}

	public Integer getIdAvaliacao() {
		return idAvaliacao;
	}
	public void setIdAvaliacao(Integer idAvaliacao) {
		this.idAvaliacao = idAvaliacao;
	}
	public Integer getIdFilme() {
		return idFilme;
	}
	public void setIdFilme(Integer idFilme) {
		this.idFilme = idFilme;
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Double getNota() {
		return nota;
	}
	public void setNota(Double nota) {
		this.nota = nota;
	}
}
