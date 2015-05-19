package mestreCuca;

import java.util.ArrayList;
import java.util.List;

public class Receita {
	private String nome;
	private List<IngredienteReceita> ingredientesDaReceita = new ArrayList<>();
	private List<Instrucao> instrucao = new ArrayList<>();
	private double precoTotal = 0;
	
	public Receita(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public List<IngredienteReceita> getIngredientesDaReceita() {
		return ingredientesDaReceita;
	}

	public List<Instrucao> getInstrucao() {
		return instrucao;
	}
	

	public void adicionarIngredientesNaReceita(IngredienteReceita ingrediente) {
		this.ingredientesDaReceita.add(ingrediente);
		this.precoTotal += ingrediente.getPreco();
	}
	
	public void adicionarInstrucao(Instrucao modoDePreparo) {
		this.instrucao.add(modoDePreparo);
	}
	
	public double getValorTotalDaReceita() {
		return precoTotal;
	}
}
