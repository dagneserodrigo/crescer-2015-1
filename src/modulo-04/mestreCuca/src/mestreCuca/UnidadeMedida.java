package mestreCuca;

public enum UnidadeMedida {
	KG("Kg"),
	GRAMA("g"),
	XICARA("x�cara(s)"),
	COLHER_DE_SOPA("colher(es) (sopa)"),
	COLHER_DE_CHA("colher(es) (ch�)"),
	ML("ml"),
	UNIDADE("unidade"),
	LITRO("L");
	
	String nome;

	private UnidadeMedida( String nome ){
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
}
