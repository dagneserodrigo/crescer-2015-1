package filmator.model;

public enum Genero {
	COMEDIA("Comédia"),
	ACAO("Ação"),
	SUSPENSE("Suspense"),
	TERROR("Terror"),
	ANIMACAO("Animação"),
	DRAMA("Drama"),
	FICCAO("Ficçao Científica"),
	AVENTURA("Aventura");
	
	String nome;

	private Genero( String nome ){
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
}
