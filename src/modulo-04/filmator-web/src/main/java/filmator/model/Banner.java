package filmator.model;

public class Banner {
	private Integer idBanner;
	private String nome;
	
	public Banner() {}
	
	public Banner(String nome) {
		this.nome = nome;
	}
	
	public Integer getIdBanner() {
		return idBanner;
	}

	public void setIdBanner(Integer idBanner) {
		this.idBanner = idBanner;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
