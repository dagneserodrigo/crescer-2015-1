package mestrecuca;

public class ReceitaNaoEncontradaException extends RuntimeException {
	public ReceitaNaoEncontradaException() {
		super("receita n�o encontrada");
	}
}
