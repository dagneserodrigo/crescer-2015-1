package mestreCuca;

public class APP {
	public static void main(String[] args) {
		IngredienteReceita arroz = new IngredienteReceita("arroz", 2.0, UnidadeMedida.XICARA);
		Instrucao modoPreparo = new Instrucao("Faça o arroz");
		Receita receita = new Receita("Arroz how to");
		
		receita.adicionarIngredientesNaReceita(arroz);
		receita.adicionarInstrucao(modoPreparo);
		
		Livro receitasRuins = new Livro("Receitas Ruins");
		
		receitasRuins.inserir(receita);
	}	
}
