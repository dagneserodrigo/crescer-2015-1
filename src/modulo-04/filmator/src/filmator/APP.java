package filmator;

public class APP {
	public static void main(String[] args) {
		Ator teste = new Ator("Teste", 33);
		
		Filme filmeTeste = new Filme("As aventuras de teste", Genero.ACAO);
		Filme filmeComedia = new Filme("A comédia teste", Genero.COMEDIA);
		Filme filmeTerror = new Filme("O terror teste", Genero.TERROR);
		
		filmeTeste.adicionarAtor(teste);
		
		System.out.println(filmeTeste.getNome());
		System.out.println(filmeTeste.getAtores());
		System.out.println(filmeTeste.toString());
		System.out.println(teste.toString());
		
		System.out.println(filmeTeste.buscaAtorPorNome("Teste"));
		
		Netflox streaming = new Netflox();
		streaming.adicionarFilme(filmeTeste);
		streaming.reproduzirFilme(filmeTeste);
		streaming.adicionarFilme(filmeComedia);
		streaming.reproduzirFilme(filmeComedia);
		streaming.adicionarFilme(filmeTerror);
		streaming.reproduzirFilme(filmeTerror);
		streaming.reproduzirFilme(filmeTerror);
		streaming.gerarRelatorio();
		
		
	}
}
