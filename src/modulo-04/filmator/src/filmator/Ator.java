package filmator;

public class Ator {
	private String nome;
	private int idade;
	
	public Ator(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String toString() {
		StringBuilder construtor = new StringBuilder();
		
		construtor.append("Nome do Ator: ");
		construtor.append(this.nome);
		construtor.append(" idade: ");
		construtor.append(this.idade);

		return construtor.toString();
	}
}
