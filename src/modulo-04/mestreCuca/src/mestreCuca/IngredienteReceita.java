package mestreCuca;

public class IngredienteReceita {
	private String nome;
	private double quantidade;
	private UnidadeMedida unidadeMedida;
	private double preco;
	
	public IngredienteReceita(String nome, Double quantidade, UnidadeMedida unidadeMedida, double valor) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.unidadeMedida = unidadeMedida;
		this.preco = valor;
	}

	public String getNome() {
		return nome;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public UnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}
	
	public double getPreco() {
		return this.preco;
	}
	
}
