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
	
	private void validaReceita(Receita receita) {
		if(receita == null || receita.getNome() == null || receita.getNome().isEmpty()) {
			throw new ReceitaNulaException();			
		}
	}
	public void inserir(Receita receita) {
		validaReceita(receita);
		receitas.add(receita);
	}
	
	public void atualizar(String nome, Receita receitaAtualizada) {
		 validaReceita(receitaAtualizada);
		 Receita receita = buscaReceitaPeloNome(nome);
		 receitas.set(receitas.indexOf(receita), receitaAtualizada);
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
		List<Receita> receitasSemIngrediente = new ArrayList<>();
		for(Receita receitaAtual : receitas) {
			for (IngredienteReceita ingrediente : ingredientes) {
				if(!receitaAtual.getIngredientesDaReceita().contains(ingrediente))
					receitasSemIngrediente.add(receitaAtual);
			}
		}
		return receitasSemIngrediente;
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
