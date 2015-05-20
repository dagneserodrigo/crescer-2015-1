package mestreCuca;

public class ReceitaNulaException extends RuntimeException {
	public ReceitaNulaException() {
		super("receita inválida");
	}
}
