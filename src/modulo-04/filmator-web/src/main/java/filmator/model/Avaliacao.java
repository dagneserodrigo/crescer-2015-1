package filmator.model;

public class Avaliacao {
	private Integer idAvaliacao;
	private Integer idFilme;
	private Integer idUsuario;
	private int nota;
	
	public Avaliacao() {}
	
	public Avaliacao(Integer idFilme, Integer idUsuario, Integer nota) {
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
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota = nota;
	}
}
