package mestreCuca;

public class ReceitaNaoEncontradaException extends RuntimeException {
	public ReceitaNaoEncontradaException() {
		super("receita não encontrada");
	}
}
