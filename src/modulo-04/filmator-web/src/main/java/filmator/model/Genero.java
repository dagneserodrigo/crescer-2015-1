package filmator.model;

public enum Genero {
	COMEDIA("Comédia"),
	ACAO("Ação"),
	SUSPENSE("Suspense"),
	TERROR("Terror");
	
	String nome;

	private Genero( String nome ){
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
}
