package mestreCuca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Livro implements LivroReceitas{
	private String nome;
	private List<Receita> receitas = new ArrayList<>();
	
	public Livro(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void inserir(Receita receita) {
		if(receita.getNome().isEmpty() || receita.getIngredientesDaReceita().isEmpty() || receita.getInstrucao().isEmpty()) {
			throw new ReceitaNulaException();
		} else {
			receitas.add(receita);
		}
	}
	
	public void atualizar(String nome, Receita receitaAtualizada) {
		if(receitaAtualizada.getNome().isEmpty() || receitaAtualizada.getIngredientesDaReceita().isEmpty() || receitaAtualizada.getInstrucao().isEmpty()) {
			throw new ReceitaNulaException();			
		} else {
			for(Receita receitaAtual : receitas) {
				if(receitaAtual.getNome() == nome) {
					receitas.set(receitas.indexOf(receitaAtual), receitaAtualizada);
				}
			}
		}
	}
	
	public void excluir(String nome) {
		if(receitas.contains(nome))
			receitas.remove(nome);
	}
	
	public List<Receita> getTodasReceitas() {
		return receitas;
	}
	
	public Receita buscaReceitaPeloNome(String nome) {
		Receita receitaEncontrada = null;
		for (Receita receitaAtual : receitas) {
			if(receitaAtual.getNome() == nome)
				receitaEncontrada = receitaAtual;
		}
		
		if(receitaEncontrada != null) {
			return receitaEncontrada;
		} else {
			throw new  ReceitaNaoEncontradaException();
		}
	}
	
	public double getValorTotal(List<Receita> receitas) {
		Double valorTotal = 0.0;
		for (Receita receitaAtual : receitas) {
			valorTotal += receitaAtual.getValorTotalDaReceita();
		}
		return valorTotal;
	}
	
	public List<Receita> protecaoAosAlergicos(List<IngredienteReceita> ingredientes) {
		List<Receita> receitaSemIngrediente = new ArrayList<>();
		for(Receita receitaAtual : receitas) {
			for(IngredienteReceita ingredienteAtual : receitaAtual.getIngredientesDaReceita()) {
				if(ingredientes.contains(ingredienteAtual))
					receitaSemIngrediente.add(receitaAtual);
			}
		}
		return receitaSemIngrediente;
	}
	
	public List<String> listaDeCompras(List<Receita> receitas) {
		List<String> listaCompras = new ArrayList<>();
		Map<String, IngredienteReceita> ingredientesDasReceitas = new HashMap<>();
		for(Receita receitaAtual : receitas) {
			for(IngredienteReceita ingredienteAtual : receitaAtual.getIngredientesDaReceita()) {
				String key = (ingredienteAtual.getNome() + " " + ingredienteAtual.getUnidadeMedida().getNome());
				if(ingredientesDasReceitas.containsKey(key)) {
					double quantidade = ingredienteAtual.getQuantidade() + ingredientesDasReceitas.get(key).getQuantidade();
					double valor = ingredienteAtual.getPreco() + ingredientesDasReceitas.get(key).getPreco();
					IngredienteReceita ingredienteIncremetado = new IngredienteReceita(ingredienteAtual.getNome(), quantidade, ingredienteAtual.getUnidadeMedida(), valor);
					ingredientesDasReceitas.put(key, ingredienteIncremetado);
				} else {
					ingredientesDasReceitas.put(key, ingredienteAtual);
				}
			}
		}

		for (IngredienteReceita value : ingredientesDasReceitas.values()) {
			listaCompras.add(value.getQuantidade() + " " + value.getUnidadeMedida().getNome() + " "  +   value.getNome());
		}
		
		return listaCompras;
	}
}
