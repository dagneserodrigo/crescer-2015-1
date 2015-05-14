package filmator;

public enum Genero {
	COMEDIA("Com�dia"),
	ACAO("A��o"),
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
